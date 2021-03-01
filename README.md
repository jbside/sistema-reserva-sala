## sistema-reserva-sala
Projeto desenvolvido em Java, utilizando Spring Boot Framework

# Sistema de reserva de sala

## Descrição
O sistema de reserva de sala foi criado para facilitar os processos de gestão de um evento que uma escola irá realizar para seu parceiro,
uma empresa de tecnologia. O sistema tem funções de cadastro de aluno, salas e espaços de café, e também filtros de busca.

## Requisitos para compilar o projeto
- JDK e JRE 1.8 ou superior
- Banco de dados MySQL(recomendado Workbench 8)
- IDE Spring Tools Suite 4. [Esta vídeo aula de 6 minutos mostra passo a passo da instalação](https://www.youtube.com/watch?v=x9sGfYTNRf4) 

## Executando a compilação
- Realize o clone do repositório dentro da pasta do Workspace do Spring Tools. *git clone https://github.com/jbside/sistema-reserva-sala.git*
- Após realizar o clone, importe o projeto MAVEM para seu Workspace. [Neste tutorial mostra passo a passo como realizar a importação, considere a pasta do projeto](https://medium.com/@alex.girao/importar-um-projeto-maven-spring-boot-ea10078b2bde)
- Configure o acesso do JDBC ao seu banco de dados no arquivo src/main/resources/application.propietes:

*spring.datasource.url= jdbc:mysql://localhost:3306/reserva_salas?useTimezone=true&serverTimezone=UTC&createDatabaseIfNotExist=true*

*spring.datasource.username=* **USUARIO**

*spring.datasource.password=* **SENHA**

- Após salvar, execulte o servidor, no canto inferior esquerdo, no sistema-reserva-sala clique com o botao direito e depois em (Re)Start, o console terá que ficar desta forma:

![](https://i.ibb.co/JmHn3CH/rodarservidor.jpg)

- Pronto, a aplicação está rodando no servidor, você pode acessa-la no endereço http://localhost:8080/

## Utilizando o sistema

O sistema tem uma tela intuitiva, e simples de usar, através da navegação lateral você pode acessar as páginas:

![](https://i.ibb.co/PgSjmbH/tela-Inicial.jpg)

- Para cada categoria o sistema tem duas páginas, a de cadastro e a página com a listagem dos dados cadastrados

![](https://i.ibb.co/1QNrQhw/cadastro-Sala.jpg)

![](https://i.ibb.co/hZ4Z9cq/reserva-Espaco.jpg)

![](https://i.ibb.co/gwJq0DP/cadastra-Aluno.jpg)

1. As paginas de cadastro não podem ser salvar com campo vazio
2. Após o cadastro realizado o item será persistido no banco, e irá ser impresso na lista

![](https://i.ibb.co/PWL5B2B/lista-Aluno.jpg)

## Utilizando o filtro de busca

O filtro de busca do sistema Reserva Sala é feito **na página de listagem do aluno**, já que o objetivo final da consulta é filtrar quais alunos
estão tanto na sala, quando no espaço

![](https://i.ibb.co/D4FrPc7/filtro-Busca.jpg)

Após o filtro ser informado, a lista será atualizada de acordo com a consulta

## Exclusão e edição de dados

Tanto a exclusão quando a edição dos dados, podem ser acessadas pela página de listagem
  1. Não pode excluir uma sala que já está vinculada a um aluno, nem espaço de café vinculado a aluno(Erro 500)

![](https://i.ibb.co/pyB6tgR/edicae-Exclusao.jpg)

## Funções implementadas

1. A cada aluno que reserva a sala, a lotação da sala reservado é atualizada, a tela de cadastro de aluno não permite cadastrar em uma sala que esteja com a lotação cheia
2. Da mesma forma, quando algum aluno é excluido, ou muda de sala na edição, a lotação atual é atualizada


# Explorando um pouco do código

Para o desenvolvimento do projeto foi escolhido o padrão MVC, nativo do Spring. Todas funcionalidades foram organizadas em seus respectivos pacotes 

## VIEW
A parte da view está em src/resources/templates, todo o Front End está renderizado através do Thymeleaft

## MODEL
O model da aplicação está nos pacotes **BEANS, DAO E SERVICE**

- No pacote beans está contido separado por classes, a geração dos objetos Aluno, Sala e Espaço. O Spring se utiliza da notação *@Table* para através do bean solicitar ao hibernate para criar as tabelas no banco
- O pacote dao estão as regras de negocio das funções de CRUD da aplicação
- No pacote service estão implementadas as regras de negocio usadas pelo controller para implementar as funções do sistema

**Todas as classes da camada MODEL tem como parametrizador dos métodos INTERFACES criadas para regrar as classes**

## CONTROLLER
A camada controller se encontra no pacote controller

Todas as funções e implementações são administradas pelo controller, que chama as classes do MODEL e realiza comunicação com o VIEW da aplicação

![](https://i.ibb.co/gr5tkZf/controller.jpg)

Temos como exemplo esse metodo, que se processa os dados informados pelo usuario, condicionalmente realiza a persistência dos mesmo no banco, e envia uma resposta para
o front end


# Autor
Jesiel Borges

Email: jesyborges@gmail.com
