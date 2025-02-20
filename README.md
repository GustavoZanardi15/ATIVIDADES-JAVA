# Livraria - Aplicação de CRUD com Spring Boot

Este é um projeto simples de CRUD (Create, Read, Update, Delete) para uma livraria, desenvolvido com Spring Boot, H2 Database e Spring Data JPA.

## Tecnologias Utilizadas

- **Spring Boot** - Framework para criação de aplicações Java baseadas em Spring.
- **Spring Data JPA** - Para simplificar a integração com o banco de dados.
- **H2 Database** - Banco de dados em memória, utilizado para armazenar as informações da livraria.
- **Spring Web** - Para a construção de APIs RESTful.

## Funcionalidades

- Cadastro de livros
- Listagem de livros cadastrados
- Edição de informações de livros
- Exclusão de livros

## Instruções para Execução

### Pré-requisitos

- Java 17 ou superior
- Maven

### Passos para Rodar a Aplicação

1. Clone este repositório em sua máquina:

   ```bash
   git clone https://github.com/SEU_USUARIO/livraria.git](https://github.com/GustavoZanardi15/ATIVIDADES-JAVA.git


   Navegue até a pasta do projeto:


cd livraria
Compile o projeto com o Maven:

mvn clean install
Execute a aplicação:

mvn spring-boot:run
A aplicação estará disponível em http://localhost:8080.

Endpoints da API
GET /livros: Retorna todos os livros cadastrados.
POST /livros: Cria um novo livro.
GET /livros/{id}: Retorna um livro específico.
PUT /livros/{id}: Atualiza os dados de um livro.
DELETE /livros/{id}: Exclui um livro.
Banco de Dados
O projeto utiliza o banco de dados H2, que é uma solução em memória. Os dados não serão persistidos após a aplicação ser desligada. Para visualizar o banco de dados, você pode acessar o console web do H2 em:


http://localhost:8080/h2-console
Configure a URL do banco como jdbc:h2:mem:testdb e deixe o usuário e senha em branco.

Licença
Este projeto está licenciado sob a MIT License.
