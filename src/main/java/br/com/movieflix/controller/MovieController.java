package br.com.movieflix.controller;

import br.com.movieflix.controller.request.MovieRequest;
import br.com.movieflix.controller.response.MovieResponse;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.mapper.MovieMapper;
import br.com.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movieflix/movie")
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest movieRequest) {
        Movie savedMovie = movieService.save(MovieMapper.toMovie(movieRequest));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll() {
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> MovieMapper.toMovieResponse(movie))
                .toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
       return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieRequest movieRequest) {
        return movieService.update(id, MovieMapper.toMovie(movieRequest))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }


@GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category) {
    return ResponseEntity.ok(movieService.findByCategory(category)
            .stream()
            .map(MovieMapper::toMovieResponse)
            .toList());
}
@DeleteMapping("/{id}")
    public ResponseEntity<MovieResponse> delete(@PathVariable Long id) {
    Optional<Movie> optMovie = movieService.findById(id);
    if(optMovie.isPresent()) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
}
}