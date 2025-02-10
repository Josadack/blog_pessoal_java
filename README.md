# Blog Pessoal 🚀  

## Descrição  
O **Blog Pessoal** é uma aplicação desenvolvida inicialmente em **NestJS** e agora reimplementada em **Java com Spring Boot**. O objetivo do projeto é permitir que usuários publiquem, visualizem e gerenciem postagens em um blog, garantindo uma experiência simples e intuitiva.  

## Tecnologias Utilizadas  
- **Java**  
- **Spring Boot**  
- **Spring Data JPA**  
- **PostgreSQL**  
- **Spring Security** (em desenvolvimento)  
- **HATEOAS** (em desenvolvimento)  
- **Postman** (para testar a API)  

## Funcionalidades  
- **Gerenciamento de Postagens**: Criação, leitura, atualização e exclusão de postagens.  
- **Validação de Dados**: Implementação de validações para garantir a integridade dos dados.  
- **Endpoints RESTful**: API projetada seguindo os princípios REST.  

## Estrutura do Projeto  
O projeto segue a arquitetura MVC com a seguinte estrutura:

src/main/java/com/seuusuario/blogpessoal/
├── controller/ # Controladores para gerenciar requisições
├── model/ # Modelos de dados
├── repository/ # Repositórios para acesso a dados
└── service/ # Lógica de negócio


## Como Rodar o Projeto  

### Pré-requisitos  
Certifique-se de ter os seguintes softwares instalados:  
- [Java 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)  
- [Maven](https://maven.apache.org/download.cgi)  
- [PostgreSQL](https://www.postgresql.org/download/)  

### Passos  
1. Clone o repositório:  
   ```bash  
   git clone https://github.com/seuusuario/blog-pessoal.git  
   cd blog-pessoal

Configure o banco de dados PostgreSQL:

Crie um banco de dados chamado blog_pessoal.
Altere as configurações de conexão no arquivo application.yml conforme necessário.
Compile e inicie a aplicação:

mvn spring-boot:run
