## Desafio 20200330 - Kotlin, MongoDB & Angular
 
 
### Obrigatório
 
- Trabalhar em um FORK deste repositório em seu usuário;
- O projeto Web deve utilizar Angular 7 ou versão mais recente;
- O projeto back-end deverá ser desenvolvido em Kotlin usando Spring Boot;
- O Front-End pode ser feito usando Material UI: https://material-ui.com;
- Não usar template completos com os recursos prontos;
- Os produtos disponíveis no projeto Front-End Angular devem ser recuperados através da API Rest Back-End Kotlin;
 
## API / Back-End Kotlin
 
- Criar um banco de dados no Mongo Atlas: https://www.mongodb.com/cloud/atlas
- Criar uma API REST usando Kotlin com o seguintes endpoints:
 - `GET /`: Detalhes da API
 - `POST /products`: O endpoint irá processar o [products.json](products.json) que será enviado pelo Projeto Web
 - `PUT /products/:productId`: Será responsável por receber atualizações realizadas no Projeto Web
 - `DELETE /products/:productId`: Remover o produto da base
 - `GET /products/:productId`: Obter a informação somente de um produto da base de dados
 - `GET /products`: Listar todos os produtos da base de dados
- Integrar a API com o banco de dados MongoDB criado no Atlas para persistir os dados
 
 
## Front-End Angular
 
![Home](assets/images/home.png)

### Upload de produtos
 
Seu objetivo é montar uma tela para a equipe de produtos importar os arquivos JSON gerados pelo sistema de manufatura da empresa ao novo Dashboard. 
Nesta tela devemos adicionar um campo do tipo File que somente permite arquivos .json e tem faça a validação dos arquivos anexados antes de serem enviados a REST API. 
Somente arquivos válidos podem ser enviados ao Dashboard. [Recomendado adicionar alertas de validações]. O PO do projeto deixou uma sugestão de mockup acima.


 
#### Listar produtos
 
Criar uma sessão na tela com uma tabela para listar os produtos processados pela API. É importante ter os seguintes campos:
 
        - Title
        - Type
        - Rating
        - Price
        - Created (Data do upload do produto a nova base de datos)
        - Actions (Botões Editar e Excluir)
 
#### Editar produto
 
Na tabela com os produtos precisamos disponibilizar os formulários com todos os campos dos produtos para que a equipe possa editá-los. 
Fazer validação de alguns campos obrigatórios:

        - Title
        - Type
        - Price
 
#### Remover produto
 
Antes de completar a ação de remover produto, devemos perguntar ao usuário se ele realmente 
quer realizar a ação. Para evitar a remoção de produtos de maneira indesejada. 
Após remover com êxito, notificar o usuário com um alerta de sucesso.
 

## Readme do Repositório
 
- Deve conter o título de cada projeto
- Uma descrição em uma frase (Headline)
- Como instalar e usar o projeto (instruções)
 

