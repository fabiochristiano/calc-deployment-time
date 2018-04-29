# Calculo de tempo de deployment
Aplicação para calcular o tempo de duração de deployments.

### API REST  
A API REST permite a inserção e consulta dos tempos dos deploy das aplicações.

#### /store
`GET /v1/store` - Retorna todos os tempos de deployments.
```javascript
Response body:
[
    {
        "id": integer,
        "component": string,
        "action": string,
        "status": string,
        "date": date,
        "version": string
    }
]    
```

`POST  /v1/store/component/action/version` - Registra o tempo inicial de um deploy.

| Parâmetro   | Descrição                           |
|:------------|:------------------------------------|
| `component` | ome do componente. Ex.: login-app   |
| `action`    | Ação do deployment, inicio ou fim.  |
| `version`   | Versão do componente. Ex.: 1.4.0-23 |

`POST /v1/store/component/action/buildNumber/status` - Registra o tempo final de um deploy.

| Parâmetro   | Descrição                                                     |
|:------------|:--------------------------------------------------------------|
| `component` | ome do componente. Ex.: login-app                             |
| `action`    | Ação do deployment, inicio ou fim.                            |
| `version`   | Versão do componente. Ex.: 1.4.0-23                           |
| `status`    | Status do fim do deploy. Ex.: sucesso ou algum código de erro |

### Docker
 - db - Mysql
 - app - Aplicação Spring Boot

### Tecnologias

* [Java] - Linguagem de programação interpretada orientada a objetos.
* [Spring Boot] - Framework eficiente e eficaz de criar uma aplicação em Spring e facilmente colocá-la no ar, funcionando sem depender de um servidor de aplicação.
* [REST] - Estilo de arquitetura que define um conjunto de restrições e propriedades baseados em HTTP.
* [Mysql] - SGBD que utiliza a linguagem SQL como interface.
* [Docker] - Plataforma aberta para desenvolvedores e administradores de sistema criarem, enviarem e executarem aplicativos distribuídos, seja em laptops, VMs de datacenter ou na nuvem.
* [Docker-Compose] - Ferramenta para definir e executar aplicativos Docker com vários contêineres.
* [Maven] - Ferramenta de automação de compilação.
* [GitHub] - Plataforma de hospedagem de código-fonte com controle de versão usando o Git.

### Instalação

TODO

### Development

TODO

#### Building for source

TODO

### Todos

TODO


**Thank you guys!**

   [Java]: <http://www.oracle.com/technetwork/java/index-138747.html>
   [Spring Boot]: <https://projects.spring.io/spring-boot/>
   [REST]: <http://www.restapitutorial.com/>
   [Mysql]: <https://www.mysql.com/>
   [Docker]: <https://www.docker.com/>
   [Docker-Compose]: <https://docs.docker.com/compose/>
   [Maven]: <https://maven.apache.org/>
   [GitHub]: <https://github.com/>

