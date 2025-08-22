package br.com.movieflix.mapper;

import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.UserResponse;
import br.com.movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest UserRequest){
    return User.builder()
            .name(UserRequest.name())
            .email(UserRequest.email())
            .password(UserRequest.password())
            .build();
    }
    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
