# Tradução do READ.ME

[![Traduzir para Inglês](https://img.shields.io/badge/traduzir-Google%20Translate-blue)](https://translate.google.com/translate?sl=auto&tl=en&u=https://github.com/lazarocoder/interview-test-back-end)

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

1. Para realização de requests na API via swagger, faz se necessário uma autenticação antes, onde um usuário é cadastrado no seguintes endpoints:

![image](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/cf4b045b-42a4-4d12-97fd-2329208a3e87)

2. Cadastrar:
 ![image](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/6d7ccba4-c51e-45b7-a163-7e6ea6847791)

3. Realizar login:

![image](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/a1acb918-6be2-4cb5-b2ff-d9f46420279c)


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
 
    ![image](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/a6b8d398-22dd-4d30-9218-f488b9676383)

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
![image](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/a2b3da85-df54-42a2-967c-e120f729bbd5)



## Evidências de alguns testes no ambiente local:



![evidencia 01](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/3aad7511-db32-42ec-ae9c-7e5d0f5aaebd)



![evidencia  02](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/3a60fd20-9991-45b8-9f41-d063b108f9da)

![evidencia 03](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/2a65d942-7d21-40cb-84f3-2b05bb966b9b)


![evidencia 04](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/82418a69-d82c-4962-b53a-6c574e579012)

![evidencia 05](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/9334f3b2-b7e3-49f4-a0a8-ddc1183cbe3b)


![evidencia 06](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/bc61c8a7-1fb1-4977-a346-b00878b3edd5)

![evidencia 07](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/9815008e-f4e3-48a0-95f9-6dd6f1fb8db9)

![evidencia 08](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/ece7df28-5db9-48d9-90c4-097676b342ac)

![evidencia 09](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/4a9fbeb2-1a5c-4bfa-9b49-154f6dab4faf)

![evidencia 10](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/084f238a-2dcb-4e02-bb39-be4286b225e3)

![evidencia 11](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/9560125a-fc85-43b9-8fd6-eecfb0add35f)

![evidencia 12](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/6264b4ae-9bde-4e0d-ac32-97394c78efd6)

![evidencia 13](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/414ce4a2-8e9a-4f71-b89c-2532a87f5d2b)

![evidencia 14](https://github.com/lazarocoder/interview-test-back-end/assets/63754729/a88bdefe-4398-4f91-90c6-448ee43372d2)




## Observações e Sugestões de Melhorias para implementar
1.	Tratamento de Erros:
-	Implementar um tratamento abrangente de erros em toda a API para garantir que mensagens de erro significativas sejam retornadas ao cliente.
-	Melhorar mecanismos de tratamento de exceções para gerenciar diferentes tipos de erros, como erros de validação, erros de banco de dados e erros de autenticação/autorização.
2.	Aprimoramentos de Segurança:
-	Considerar a implementação de mecanismos de autenticação e autorização mais robustos, Utiliza certificados digitais para autenticar usuários e dispositivos.
3.	Documentação da API:
-	Expandir a documentação da API para incluir descrições detalhadas de todos os Endpoints, parâmetros e formatos de resposta.
4.	Testes:
-	Aumentar a cobertura dos testes, especialmente para a lógica de negócios crítica e recursos de segurança.
-	Melhorar testes de integração para garantir que diferentes componentes da aplicação funcionem juntos conforme esperado.
5.	Otimização de Desempenho:
-	Analisar e otimizar as consultas ao banco de dados para reduzir a latência e melhorar o desempenho.
-	Considerar a implementação de estratégias de cache para dados frequentemente acessados.
6.	Escalabilidade:
-	Melhorar a aplicação com uma maior escalabilidade em mente, garantindo que ela possa lidar com o aumento da carga à medida que a base de usuários cresce.
-	Utilizar ferramentas de orquestração de contêineres, como Kubernetes, para gerenciar e escalar a aplicação.
7.	Qualidade do Código:
-	Refatorar o código para melhorar a legibilidade, manutenibilidade e aderência às melhores práticas.
-	Implementar ferramentas de análise estática de código para identificar e corrigir possíveis problemas cedo no processo de desenvolvimento e realizar tratamentos de datas e serialização, incluir `´Handler para tratamento de responses´`. 



## Tecnico responsável

- **Nome:** Lázaro Daniel
- **E-mail:** Lazarodaniel80@gmail.com
- **LinkedIn:** [Perfil LinkedIn](https://www.linkedin.com/in/l%C3%A1zaro-silva-desenvolvedor/?locale=pt_BR)
