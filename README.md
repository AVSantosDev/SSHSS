# SSHSS - Sistema Simplificado de Histórico de Saúde e Serviços

## Visão Geral

Este projeto é um sistema backend simplificado para gerenciar históricos de saúde e serviços relacionados. Ele permite o cadastro e gerenciamento de pacientes, profissionais de saúde, prontuários, consultas, prescrições e exames. 
O objetivo é fornecer uma base para um sistema de informação de saúde, com foco na organização e acesso aos dados dos pacientes e seus atendimentos.

## Funcionalidades Principais

* **Pacientes:**
    * Cadastro de novos pacientes com informações pessoais (nome, CPF, data de nascimento, etc.).
    * Listagem de pacientes.
    * Busca de pacientes por ID, nome ou CPF.
    * Atualização e exclusão de pacientes.
* **Profissionais de Saúde:**
    * Cadastro de profissionais de saúde (nome, especialidade, etc.).
    * Listagem de profissionais.
    * Busca de profissionais por ID ou nome.
    * Atualização e exclusão de profissionais.
* **Prontuários:**
    * Criação de prontuários associados a pacientes e profissionais de saúde.
    * Listagem de prontuários com dados relacionados (pacientes, profissionais, consultas, prescrições).
    * Busca de prontuários por ID.
    * Atualização e exclusão de prontuários.
* **Consultas:**
    * Agendamento de consultas, associando pacientes e profissionais de saúde.
    * Listagem de consultas.
    * Cadastro, atualização e exclusão de informações de consultas.
* **Prescrições:**
    * Registro de prescrições médicas, associadas a pacientes e profissionais de saúde.
    * Listagem de prescrições.
    * Cadastro, atualização e exclusão de informações de prescrições.
* **Exames:**
    * Registro de informações sobre exames realizados por pacientes.
    * Listagem de exames.
    * Cadastro, atualização e exclusão de informações de exames.

## Tecnologias Utilizadas

* **Java:** Linguagem de programação principal.
* **Spring Boot:** Framework para desenvolvimento rápido de aplicações Java.
* **Spring Data JPA:** Simplifica o acesso e a persistência de dados com JPA (Java Persistence API).
* **Hibernate:** Implementação do JPA utilizada pelo Spring Data JPA.
* **PostgreSQL (ou outro banco de dados):** Banco de dados relacional para persistência dos dados.
* **Maven:** Ferramenta de gerenciamento de dependências e build.
* **Jakarta Bean Validation:** Para validação de dados.
* **JSON:** Formato para troca de dados na API.

## Pré-requisitos

* **Java Development Kit (JDK):** Versão 17 ou superior.
* **Maven:** Versão 3.6.x ou superior.
* **PostgreSQL (ou outro banco de dados configurado):** Um servidor de banco de dados em execução.
* **Uma IDE Java (opcional, mas recomendado):** IntelliJ IDEA, Eclipse, VS Code com extensões Java.

## Configuração e Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/AVSantosDev/SSHSS)
    cd SSHSS
    ```

2.  **Configure o banco de dados:**
    * Crie um banco de dados no seu servidor PostgreSQL (ou outro configurado).
    * Abra o arquivo `src/main/resources/application.properties` e configure as propriedades de acesso ao banco de dados:
        ```properties
        server.port=8083 você pode definir a porta local que deseja utilizar para o serviço
        spring.datasource.url= jdbc:postgresql://localhost:5432/SSHSS
        spring.datasource.username=[nome do banco de dados]
        spring.datasource.password=[senha do banco de dados]
        spring.jpa.show-sql=true // para visualizar o comando sql de criação de update no banco de dados
        spring.jpa.hibernate.ddl-auto=update // define que sempre vai atualizar o banco de dados
        ```
        * Certifique-se de ajustar a porta, nome do banco, usuário, senha e dialeto do Hibernate conforme a sua configuração. `spring.jpa.hibernate.ddl-auto=update` fará com que o Hibernate crie ou atualize o schema do banco de dados com base nas suas entidades JPA.
        *  **Em produção, considere usar um sistema de migrações de banco de dados.**

3.  **Execute a aplicação:**
    * Abra um terminal na raiz do projeto e execute o comando Maven:
        ```bash
        mvn spring-boot:run
        ```
    * A aplicação Spring Boot estará disponível (por padrão) em `http://localhost:8080 , você pode alterar a porta para evitar complito com outras aplicações`

## Endpoints da API

A API RESTful fornece os seguintes endpoints (exemplos básicos, podem haver variações):

* **Pacientes:**
    * `GET /SSHSS/paciente`: Listar todos os pacientes.
    * `GET /SSHSS/paciente/{id}`: Buscar paciente por ID.
    * `GET /SSHSS/paciente/buscar?busca={nomeOuCpf}`: Buscar paciente por nome ou CPF.
    * `POST /SSHSS/paciente`: Cadastrar novo paciente (requer um objeto JSON no corpo).
    * `PUT /SSHSS/paciente/{id}`: Atualizar paciente (requer um objeto JSON no corpo).
    * `DELETE /SSHSS/paciente/{id}`: Deletar paciente.
* **Profissionais de Saúde:**
    * `GET /SSHSS/profissional`: Listar todos os profissionais.
    * `GET /SSHSS/profissional/{id}`: Buscar profissional por ID.
    * `GET /SSHSS/profissional/nome?nome={nome}`: Buscar profissional por nome.
    * `POST /SSHSS/profissional`: Cadastrar novo profissional (requer um objeto JSON no corpo).
    * `PUT /SSHSS/profissional/{id}`: Atualizar profissional (requer um objeto JSON no corpo).
    * `DELETE /SSHSS/profissional/{id}`: Deletar profissional.
* **Prontuários:**
    * `GET /SSHSS/Prontuario`: Listar todos os prontuários com dados relacionados.
    * `GET /SSHSS/Prontuario/{id}`: Buscar prontuário por ID.
    * `POST /SSHSS/Prontuario`: Criar novo prontuário (requer um objeto JSON no corpo).
    * `PUT /SSHSS/Prontuario/{id}`: Atualizar prontuário (requer um objeto JSON no corpo).
    * `DELETE /SSHSS/Prontuario/{id}`: Deletar prontuário.
* **Consultas:**
    * `POST /SSHSS/consulta`: Agendar nova consulta (requer um objeto JSON no corpo).
    * `GET /SSHSS/consulta`: Listar todas as consultas.
    * `GET /SSHSS/consulta/{id}`: Buscar consulta por ID.
    * `PUT /SSHSS/consulta/{id}`: Atualizar consulta (requer um objeto JSON no corpo).
    * `DELETE /SSHSS/consulta/{id}`: Cancelar consulta.
* **Prescrições:**
    * `POST /SSHSS/prescricao`: Registrar nova prescrição (requer um objeto JSON no corpo).
    * `GET /SSHSS/prescricao`: Listar todas as prescrições.
    * `GET /SSHSS/prescricao/{id}`: Buscar prescrição por ID.
    * `PUT /SSHSS/prescricao/{id}`: Atualizar prescrição (requer um objeto JSON no corpo).
    * `DELETE /SSHSS/prescricao/{id}`: Remover prescrição.
* **Exames:**
    * `POST /SSHSS/exame`: Registrar novo exame (requer um objeto JSON no corpo).
    * `GET /SSHSS/exame`: Listar todos os exames.
    * `GET /SSHSS/exame/{id}`: Buscar exame por ID.
    * `PUT /SSHSS/exame/{id}`: Atualizar exame (requer um objeto JSON no corpo).
    * `DELETE /SSHSS/exame/{id}`: Remover exame.

    Consulte o código dos Controllers para obter a lista completa e os detalhes dos parâmetros e corpos das requisições.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhoria, por favor, abra uma issue neste repositório ou envie um pull request com suas alterações.
