## Desafio 02 - Node - React - Next.js
 
 
### Obrigatorio
 
- Trabalhar em um FORK deste repositório em seu usuário;
- O projeto Web deve utilizar React.
- O Front-End deve utilizar Material UI: https://material-ui.com
- Não usar template completos com os recursos prontos;
- O projeto back-end poderá ser desenvolvido em Node.js.
- Os produtos disponíveis no projeto front-end devem ser recuperados através da API Rest back-end
 
## API / Back-End
 
- Criar um banco de dados no Mongo Atlas: https://www.mongodb.com/cloud/atlas
- Criar uma API REST usando Node.js com o seguintes endpoints:
 - `GET /`: Detalhes da API
 - `POST /products`: O endpoint irá processar o [products.json](products.json) que será enviado pelo Projeto Web
 - `PUT /products/:productId`: Será responsável por receber atualizações realizadas no Projeto Web
 - `DELETE /products/:productId`: Remover o produto da base
 - `GET /products/:productId`: Obter a informação somente de um produto da base de dados
 - `GET /products`: Listar todos os produtos da base de dados
- Integrar a API com o banco de dados MongoDB criado no Atlas para persistir os dados
- `Opcional` Criar os tests unitários para o endpoints
 
 
## Front-End
 
### Upload de produtos
 
    Seu objetivo é montar um tela para a equipe de produtos importar os arquivos JSON gerados pelo sistema de manufatura da empresa ao novo Dashboard. Nesta tela devemos adicionar um campo do tipo File que somente permite arquivos .json e tem faça a validação dos arquivos anexados antes de serem enviados a REST API, somente arquivos válidos podem ser subidos ao Dashboard. [Recomendado adicionar alertas de validações]
 
#### Listar produtos
 
    Criar um tela com um tabela para listar os produtos processados pela API, é importante ter os seguintes campos:
 
        - Title
        - Type
        - Rating
        - Price
        - Created (Data do upload do produto a nova base de datos)
        - Actions (Botões Editar e Excluir)
 
#### Editar produto
 
Na tela de editar produto, precisamos disponibilizar os formulários com todos os campos dos produtos para que a equipe possa editá-los. Fazer validação de alguns campos obrigatórios:
    - Title
    - Type
    - Price
 
#### Remover produto
 
    Antes de completar a ação de remover produto, devemos perguntar ao usuário se ele realmente quer realizar dita ação para evitar a remoção de produtos de maneira indesejada. Após remover com êxito, notificar o usuário com um alerta de sucesso.
 
## DevOps [Opcional]
 
    Depois de um árduo trabalho de desenvolvimento na API e no Front end chegou a hora mais esperada,
    o lançamento do projeto, é uma das partes mais motivadoras verdade? Então, a equipe de administração de
    sistemas precisará dos mínimos detalhes para configurar o projeto em produção,
    por isso é sua responsabilidade documentar todo o fluxo e facilitar a configuração dos dois projetos com
    tecnologias chaves para rodar em ambientes de Cloud Computing. 
 
## Readme do Repositório
 
- Deve conter o título de cada projeto
- Uma descrição de uma frase
- Como instalar e usar o projeto (instruções)
 

