# tasklist-api

Projeto criado com intuito de ser um gerenciador de tasks.

## O que foi utilizado:
- Java: 1.8
- Spring boot: v1.5.7.RELEASE
- Mysql: v8.0.18
- Lombok

## Como utilizar
Para utilizar o projeto virtualmente, você pode acessar o link: https://new-tasklist-api.herokuapp.com onde s e encontra a API. Foi feito deploy no Heroku.

## Como instalar em máquina local
Para instalar o projeto, você precisa ter instado o Java 8 e o Mysql.
Após isso, basta fazer o clone do projeto,e  subir a aplicação via Spring tools Suit.

Obs.: As versões utilizadas estão listadas acima.

# O projeto
O prejeto usa apenas uma entidade, e seus recursos para gerenciar as tasks.
Essas são as rotas disponiveis para o gerenciamento:
- getAll - GET: tasks
- getById:- GET: tasks/{id}
- post = POST: tasks
- put - PUT: tasks/{id}
- delete - DELETE: tasks/{id}
