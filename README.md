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
