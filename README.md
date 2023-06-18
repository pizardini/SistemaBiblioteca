# SistemaBiblioteca

Enunciado:

Entidades:

    entidade: editora

    atributos:

    id - Long

    nome - String - Máx 255 caracteres

    descricao - String - Não obrigatório

    entidade: categoria

    atributos:

    id - Long

    nome - String - Máx 100 caracteres

    entidade: livro

    atributos:

    id - Long

    editora_id - Long - relacionamento com a entidade editora

    categoria_id - Long - relacionamento com a entidade categoria

    nome - String

    isbn - String - Máx 13 caracteres

Com base nas entidades acima:

1 - Crie o CRUD de cada entidade, possuindo os controllers, services, repositories, entities e DTOs.

2 - Crie um endpoint especifico para buscar os livros por categoria.

3 - Crie um endpoint especifico para buscar os livros por editora.

4 - Crie um endpoint que possa buscar o livro pelo nome ou pelo número isbn ou pelos dois, utilizando criteria ou query dsl.

Melhorias futuras:

Criar a parte de autenticação de usuário e fazer endpoints para salvar e buscar os livros favoritos do usuário logado.

