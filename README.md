## Desafio 20200330 - Kotlin, MongoDB & Angular
 
### Descrição (Headline)

API para gerenciar produtos importados por arquivo JSON.

### Como instalar

No back-end:

O projeto foi desenvolvido usando Spring Boot 2.2.6, Java 1.8 e Kotlin 1.3.71 para uma API Rest.
Importe o back-end da pasta "challenge" para a sua IDE a partir do pom.xml (InteliJ)
Ou rode "mvn install" para executar a instalação dos pacotes. 

No front-end:

O projeto usa o angular 9.0.1. 
Na pasta do front-end (clienteweb/challenge), as seguintes instalações devem ser feitas com npm:

npm install -g @angular/cli
npm install angular
npm install @material-ui/core
npm install @material-ui/icons
npm install --save @angular/material @angular/animations @angular/cdk
npm install --save angular/material2-builds angular/cdk-builds
npm install --save hammerjs
npm install bootstrap@4.1.1

Rodando o projeto:

Execute o "ChallengeApplication.kt" no back-end.
Execute "npm start" no front-end.
 
## API / Back-End Kotlin
 
- Banco de dados no Mongo Atlas
- A API REST possui os seguintes endpoints:
 - `GET /`: Home
 - `POST /products`: O endpoint processa o um arquivo Json para upload de produtos conferindo campos e tipo de arquivo.
 - `PUT /products/:productId`: A partir do botão Edit é possível atualizar os dados do produto e enviar para a API.
 - `DELETE /products/:productId`: A partir do botão Delete é possível excluir um produto da base de dados.
 - `GET /products/:productId`: Esse endpoint retorna um produto específico a partir do id.
 - `GET /products`: Preenche a tabela com todos os produtos da base de dados.

### Upload de produtos
 
Ao fazer o upload dos arquivos o sistema confere o tipo e valida os campos no Json.
 
#### Editar produto

Os campos Title, Type e Price são obrigatórios e conferidos tanto na API quanto no formulário.
 
#### Remover produto
 
Ao remover um produto é pedida a confirmação do usuário para a ação.

