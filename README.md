# API Star Wars Planets

Aplicação desenvolvida para realizar os testes desta prospecção simula um sistema de informações planetárias da franquia Star Wars.
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/c705d040-e727-4022-81ba-4439c8d85006)

Esta aplicação possui o MongoDB como seu Banco de Dados e conta com a implementação de TDD.
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/e5e7ad27-0216-4b03-a7a9-e6aa1dd4454f)

### Tecnologias Empregadas
- [Postgrees](https://www.postgresql.org/download/)
- [H2](https://www.h2database.com/html/main.html)
- [Java](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Testing](https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testing-introduction)
- [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito](https://site.mockito.org)
- [AssertJ](https://github.com/assertj/assertj)
- [Hamcrest](http://hamcrest.org/JavaHamcrest/)
- [Lombok](https://projectlombok.org/)
- [Jacoco](https://github.com/jacoco/jacoco)
- [Pitest](https://pitest.org)

Vale ressaltar que:
* JUnit - Responsável por registrar o Teste Automatizado (@Test) no framework do SpringBoot.
* AssertJ - Responsável por aferir os resultados dos Testes Automatizados.
* Mockito - Framework utilizado para automatizar a criação de Dublês de Teste. Dublês de Teste são utilizados pelos testes solitários para simular o comportamento das suas dependencias, aumentando a performace da execução dos testes.

## Testes de Função Create
![TestesFuncaoCreateEsquema.png](./Imagens/TestesFuncaoCreateEsquema.png)

## Testes de Função Get By Id
![TestesFuncaoGetByIdEsquema.png](./Imagens/TestesFuncaoGetByIdEsquema.png)

## Testes de Função Get By Name
![TestesFuncaoGetByNameEsquema.png](./Imagens/TestesFuncaoGetByNameEsquema.png)

## Testes de Função List By Terrain And Climate
![TestesFuncaoListByTerrainAndClimateEsquema.png](./Imagens/TestesFuncaoListByTerrainAndClimateEsquema.png)

## Testes de Função Delete
![TestesFuncaoDeleteEsquema.png](./Imagens/TestesFuncaoDeleteEsquema.png)

## Resultado dos Testes

### Teste Unidade
![ResultadosTestesDeUnidade.png](./Imagens/ResultadosTestesDeUnidade.png)

### Testes Integração
![ResultadosTestesDeIntegracaoRepositoryTest.png](./Imagens/ResultadosTestesDeIntegracaoRepositoryTest.png)
![ResultadosTestesDeIntegracaoControllerTest.png](./Imagens/ResultadosTestesDeIntegracaoControllerTest.png)

### Testes Componente
![ResultadosTestesDeComponentPlanetIT.png](./Imagens/ResultadosTestesDeComponentPlanetIT.png)

## Divisão de Execução dos Testes
A divisão da execução dos testes foi feita por meio do Plugin Surefire.
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/104e822c-317a-4e51-b7bc-c422c3450254)

### Execução Testes Leves (Unidade e Integração)
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/e1c00763-e75a-482d-aa3a-260926717c12)

### Execução Testes Pesados (Componente)
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/1bc7cfe6-3c38-4408-b853-1721b9015f40)

### Execução Todos Testes
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/cef74a90-ef21-4936-8df3-7fc32a8f4784)

### Jacoco: Análise de Cobertura de Testes
A cobertura de teste baseada em código mede a quantidade de códigos executada durante o teste, em comparação à quantidade de códigos com execução pendente. A cobertura de código pode se basear em fluxos de controle (instrução, ramificação ou caminhos) ou fluxos de dados.

#### Relatório de Cobertura
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/e45fdea4-98da-4cdd-b7f6-05ae335c0074)

#### Run Configuration
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/a3777afc-f140-45cb-96ad-5a0b7a7502ab)

### Pintest: Análise de Testes Mutantes
Os testes de mutante são feitos para avaliarem a qualidade da bateria de casos de testes automatizados. A ideia principal é modificar, ou melhor, mutar uma pequena parte de código a ser testado e verificar se o teste automatizado irá detectar esta mutação. Se não detectar a mutação se torna um teste em vão.

#### Relatório de Testes Mutantes
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/e9032a3a-417d-4e51-9329-90753e77eebf)

#### Runtime Statistics
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/0d5a7a78-d748-44ea-8e07-a7425f3aa627)

#### Run Configuration
![image](https://github.com/RodrigoCarvalho95/StarWarsPlanetsAPI/assets/12175629/19415a87-b98e-41a7-b003-cb70bb40984b)

## Configuração
O projeto requer um banco de dados Postgrees, então é necessário criar uma base de dados com os seguintes comandos:

```
$ sudo -u postgres psql

CREATE USER root WITH PASSWORD 'root';
GRANT ALL PRIVILEGES ON DATABASE postgres TO root;

\q

$ psql -U user -W

CREATE DATABASE starwars;

\q
```
Durante os testes, as tabelas de banco já serão criadas automaticamente no banco de dados.



