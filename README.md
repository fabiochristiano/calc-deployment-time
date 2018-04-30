# Calculo de tempo de deployment
Aplicação para calcular o tempo de duração de deployments.

### API REST  
A API REST permite a inserção e consulta dos tempos dos deploy das aplicações.

#### /stores
`GET /v1/stores` - Retorna todos os tempos de deployments.
```javascript
Response body:
[
    {
        "id": "integer",
        "component": "string",
        "action": "string",
        "status": "string",
        "date": "date",
        "version": "string"
    }
]    
```

`POST  /v1/stores/component/action/version` - Registra o tempo inicial de um deploy.

| Parâmetro   | Descrição                           |
|:------------|:------------------------------------|
| `component` | ome do componente. Ex.: login-app   |
| `action`    | Ação do deployment, inicio ou fim.  |
| `version`   | Versão do componente. Ex.: 1.4.0-23 |

`POST /v1/stores/component/action/version/status` - Registra o tempo final de um deploy.

| Parâmetro   | Descrição                                                     |
|:------------|:--------------------------------------------------------------|
| `component` | ome do componente. Ex.: login-app                             |
| `action`    | Ação do deployment, inicio ou fim.                            |
| `version`   | Versão do componente. Ex.: 1.4.0-23                           |
| `status`    | Status do fim do deploy. Ex.: sucesso ou algum código de erro |

### Docker
O projeto foi configurado para fácil deploy com o docker e docker-compose.

Foram utilizado as imagens:
  - mysql:5.6
  - openjdk:8-jdk-alpine
  
Por padrão, foram utilizado as mesmas portas do mysql e aplicação web, 3306 e 8080.
  
Para execução da aplicação, após criado a imagem, executar o comando abaixo na raiz do projeto.
```sh
 sudo docker-compose up -d
```

Mais detalhes da criação da imagem em [Instalação](#instalação)

### Instalação

Através do plugin dockerfile-maven-plugin do spotify, ao realizar o build da aplicação é gerado uma imagem da aplicação com base na imagem openjdk:8-jdk-alpine.

O projeto está utilizando o MySQL como banco de dados, para isso foi urilizado a imagem mysql:5.6.

Para realizar o build da imagem do projeto, é necessário executar os seguintes passos:

 - Subir banco de dados para realizar o mvn install
```sh 
sudo docker-compose up -d mysql
```
 - Realizar o build do projeto e gerar a imagem `springio/calc-deployment-time`.
```sh 
  sudo ./mvnw install dockerfile:build
```

 - Subir a aplicação e o banco.
```sh
sudo docker-compose up -d
```
A aplicação ficará disponivel em localhost:8080

Caso for necessário fazer o build novamente, antes de realizar o build da imagem, executar:
```sh
  sudo docker-compose stop
  sudo docker rm app
  sudo docker rmi springio/calc-deployment-time
```

### Development

Por questões de configuração de network do docker e localhost, foi criado o profile de produção no Spring Boot.

Para desenvolvimento, informar o profile local em:
Run > Run Configuration > Arguments > VM Arguments > Adicionar: -Dspring.profiles.active=local

O profile prod é informado no Dockerfile.

### Todos

Hoje, para registar o tempo de deployment do componente, é feito dois registros no banco através de dois recursos. O ideal seria realizar apemas um, da seguinte forma:
 - Ao iniciar o deploy, é realizado a chamada da API informando o COMPONENT e VERSION, e automaticamente a aplicação grava o horário de início do deploy. O retorno seria o ID do registro.
 - No termindo do deploy, é feito a chamada da API informando somente o ID retornado no início e STATUS, assim, a aplicação registra a data de termino no mesmo registro.
 - A entidade seria: ID, COMPONENT, VERSION, BEGIN, END, STATUS

No momento atual, não é retornado o tempo do deploy, somente os tempos registrados. Após a implementação proposta acima, poderia criar um recurso GET para obter os registros com base no COMPONENT e realizar a subtração das datas de início de fim, para obter o tempo de deploy.

Ainda há algumas questões técnicas para ser implemendadas, segue:
- Utilizar o @RequestBody do Srpting boot ao invês de informar os parâmetros via path.
- Criar a DTO e refatorar o fonte para a utilização do mesmo.
- Utilizar Spring Validation
- Implementar a documentação da API com o Swagger.
- Fazer o deploy da aplicação em dois servidores, e utilizar alguma ferramenta de gestão de configuração.
- Evoluir o deploy em Kubernetes.
- Realizar o deploy do conteiner em uma instância EC2.

### Tecnologias

* [Java] - Linguagem de programação interpretada orientada a objetos.
* [Spring Boot] - Framework eficiente e eficaz de criar uma aplicação em Spring e facilmente colocá-la no ar, funcionando sem depender de um servidor de aplicação.
* [REST] - Estilo de arquitetura que define um conjunto de restrições e propriedades baseados em HTTP.
* [Mysql] - SGBD que utiliza a linguagem SQL como interface.
* [Docker] - Plataforma aberta para desenvolvedores e administradores de sistema criarem, enviarem e executarem aplicativos distribuídos, seja em laptops, VMs de datacenter ou na nuvem.
* [Docker-Compose] - Ferramenta para definir e executar aplicativos Docker com vários contêineres.
* [Maven] - Ferramenta de automação de compilação.
* [GitHub] - Plataforma de hospedagem de código-fonte com controle de versão usando o Git.


**Thank you guys!**

   [Java]: <http://www.oracle.com/technetwork/java/index-138747.html>
   [Spring Boot]: <https://projects.spring.io/spring-boot/>
   [REST]: <http://www.restapitutorial.com/>
   [Mysql]: <https://www.mysql.com/>
   [Docker]: <https://www.docker.com/>
   [Docker-Compose]: <https://docs.docker.com/compose/>
   [Maven]: <https://maven.apache.org/>
   [GitHub]: <https://github.com/>


