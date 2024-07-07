# Tradução do READ.ME

[![Traduzir para Inglês](https://img.shields.io/badge/traduzir-Google%20Translate-blue)](https://translate.google.com/translate?sl=auto&tl=en&u=https://github.com/lazarocoder/interview-back-end)

# Introdução

O projeto de avaliação da “Projuris” consiste em um sistema de ordens de serviços,  O sistema inclui funcionalidades de cadastro, atualizações e criação de uma ordem de serviço e de monitoramento dos status.



A aplicação utiliza "JTW token para autenticação", requerendo que o usuário esteja autenticado antes de realizar qualquer requisição. O sistema usa o banco de dados PostgreSQL (versão 14.10), que é criado e gerenciado via Docker, com integração ao pgAdmin4.

## Pré-requisitos

- Java JDK 17.0.10
- Maven - A aprtir da versão 	3.5.1
- IntelliJ IDEA 
- Docker
- pgAdmin4 – Para realização de consultas de dados

## Como iniciar o projeto

1. Abra a IDE de sua preferência e carregue o projeto “projuris-backend-interview-api”.
2. Aguarde até que todas as dependências sejam resolvidas e baixadas automaticamente.
3. Após a conclusão do download das dependências, execute as tarefas “maven clean” e, em seguida, “maven install” para garantir uma compilação limpa e a instalação dos artefatos.
   - Em caso de erros durante o download dos artefatos, execute: `mvn dependency:purge-local-repository install`
4. Navegue até a pasta profiles, para iniciar o container, execute no seu terminal: `docker-compose up`. Para executar em segundo plano, adicione a flag `-d`: `docker-compose up -d`.
5. Navegue até a classe principal da aplicação, `ProjurisBackendInterviewApi1Application.java`, e inicie a aplicação.
6. Abra seu navegador e acesse: http://localhost:8080/swagger-ui/index.html para visualizar a documentação interativa (Swagger) da API.

## Dados de acesso do authentication no swagger


## Principais dependências utilizadas

- Spring Boot: Versão 3.3.1
- PostgreSQL
- Lombok
- Spring Boot Starter Test
- Spring Boot Starter Security
- Spring Boot Starter data JPA
- Springdoc Openapi Starter Webmvc Ui

## Da arquitetura

- **Config**
  - Foco: Armazenar classes de configuração.
  - Detalhes: Contém classes que configuram diversos aspectos da aplicação, como beans do Spring, configuração de segurança, propriedades de conexão com banco de dados, entre outros.
- **Controller**
  - Foco: Controladores da aplicação.
  - Detalhes: Contém classes que lidam com as requisições HTTP (GET, POST, PUT, DELETE), responsáveis por receber, processar e responder às requisições.
- **Dto**
  - Foco: Objetos de Transferência de Dados (DTO).
  - Detalhes: Utilizados para transferir dados entre diferentes camadas da aplicação, sem expor as entidades de domínio diretamente.
- **Enumerated**
  - Foco: Tipos Enumerados.
  - Detalhes: Contém enums que representam um conjunto fixo de constantes, como tipos de status etc.
- **Exception**
  - Foco: Tratamento de Exceções.
  - Detalhes: Armazena classes que lidam com a captura e tratamento de exceções específicas da aplicação.
- **Model**
  - Foco: Modelos de Dados.
  - Detalhes: Representam as entidades do domínio da aplicação, mapeadas para tabelas no banco de dados.
- **Security**
  - Foco: Configurações e Implementações de Segurança.
  - Detalhes: Gerencia aspectos de segurança da aplicação, como autenticação e autorização.
- **Service**
  - Foco: Lógica de Negócio.
  - Detalhes: Contém classes que realizam operações de banco de dados e processam requisições.
- **Util**
  - Foco: Utilitários.
  - Detalhes: Funções auxiliares utilizadas em várias partes da aplicação, incluindo manipulação de strings, datas, validações comuns, etc.

## Dos testes unitários

Segue os resultados da cobertura de testes. Para executar os testes, basta acessar a pasta raiz do projeto e clicar na opção "Run with coverage".


## Evidências de alguns testes no ambiente local:



## Observações e Sugestões de Melhorias para implementar
1.	Tratamento de Erros:
o	Implementar um tratamento abrangente de erros em toda a API para garantir que mensagens de erro significativas sejam retornadas ao cliente.
o	Melhorar mecanismos de tratamento de exceções para gerenciar diferentes tipos de erros, como erros de validação, erros de banco de dados e erros de autenticação/autorização.
2.	Aprimoramentos de Segurança:
o	Considerar a implementação de mecanismos de autenticação e autorização mais robustos, como OAuth2 ou JWT, pois a segurança hoje é básica.
o	Garantir que dados sensíveis, como senhas, sejam criptografados e armazenados de forma segura.
3.	Documentação da API:
o	Expandir a documentação da API para incluir descrições detalhadas de todos os endpoints, parâmetros e formatos de resposta.
4.	Testes:
o	Aumentar a cobertura dos testes, especialmente para a lógica de negócios crítica e recursos de segurança.
o	Melhorar testes de integração para garantir que diferentes componentes da aplicação funcionem juntos conforme esperado.
5.	Otimização de Desempenho:
o	Analisar e otimizar as consultas ao banco de dados para reduzir a latência e melhorar o desempenho.
o	Considerar a implementação de estratégias de cache para dados frequentemente acessados.
6.	Escalabilidade:
o	Melhorar a aplicação com uma maior escalabilidade em mente, garantindo que ela possa lidar com o aumento da carga à medida que a base de usuários cresce.
o	Utilizar ferramentas de orquestração de contêineres, como Kubernetes, para gerenciar e escalar a aplicação.
7.	Qualidade do Código:
o	Refatorar o código para melhorar a legibilidade, manutenibilidade e aderência às melhores práticas.
o	Implementar ferramentas de análise estática de código para identificar e corrigir possíveis problemas cedo no processo de desenvolvimento.



## Tecnico responsável

- **Nome:** Lázaro Daniel
- **E-mail:** Lazarodaniel80@gmail.com
- **LinkedIn:** [Perfil LinkedIn](https://www.linkedin.com/in/l%C3%A1zaro-silva-desenvolvedor/?locale=pt_BR)