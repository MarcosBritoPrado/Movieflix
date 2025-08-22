API REST desenvolvida com Spring Boot para gerenciamento de filmes, categorias, plataformas de streaming e usuários.
O projeto inclui autenticação com JWT, boas práticas de arquitetura em camadas e versionamento do banco de dados com migrations.

🚀 Tecnologias

Java 17

Spring Boot (Web, Data JPA, Security)

JWT para autenticação

PostgreSQL

Flyway (migrations)

Docker (opcional para subir o banco localmente)

Estrutura do Projeto
src/main/java/br/com/movieflix
controller   # Camada de entrada da API (endpoints REST)
service      # Regras de negócio
repository   # Acesso ao banco de dados
entity       # Entidades JPA
dto/request  # Objetos de entrada
dto/response # Objetos de saída
mapper       # Conversão entre entidades e DTOs



Endpoints Principais

POST /auth/login → Autenticar usuário

POST /users → Criar novo usuário

GET /movies → Listar filmes

POST /movies → Cadastrar filme

GET /categories → Listar categorias

POST /categories → Criar categoria

GET /streamings → Listar streamings
