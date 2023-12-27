<h1 align="center">
  Control + Lab
</h1>


API para gerenciar agendamentos de laboratórios de uma instituição de ensino.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [PostgreSQL](https://dev.postgres.com/downloads/)

## Práticas adotadas

- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro
- Geração automática do Swagger com a OpenAPI 3

## Como Executar

- Clonar repositório git

- Entre na pasta ctrlab-java em sua IDE favorita e inicie o servidor.

A API poderá ser acessada em [localhost:8080](http://localhost:8080).
O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## API Endpoints

- Criar Laboratório
```
http://localhost:8080/laboratory

[
  {
    "name": "Eng. civil",
    "source": "link",
    "location": "Bloco A",
    "hourOpen": "20:00",
    "hourClose": "22:00"
  }
]
```

- Listar Laboratórios
```
http://localhost:8080/laboratory

[
  {
    "id": "0cd9783f-bf32-46a4-ba51-7043b6fe7214",
    "name": "Eng. civil",
    "source": "link",
    "location": "Bloco A",
    "hourOpen": "20",
    "hourClose": "22"
  }
]
```

- Pegar Laboratório pelo id
```
http://localhost:8080/laboratory/0cd9783f-bf32-46a4-ba51-7043b6fe7214

[
  {
    "id": "0cd9783f-bf32-46a4-ba51-7043b6fe7214",
    "name": "Eng. civil",
    "source": "link",
    "location": "Bloco A",
    "hourOpen": "20",
    "hourClose": "22"
  }
]
```

- Atualizar Tarefa
```
http://localhost:8080/laboratory/0cd9783f-bf32-46a4-ba51-7043b6fe7214

[
  {
    "name": "Eng. Mecânica",
    "source": "link",
    "location": "Bloco A",
    "hourOpen": "20",
    "hourClose": "22"
  }
]
```

- Remover Laboratório
```
http://localhost:8080/laboratory/0cd9783f-bf32-46a4-ba51-7043b6fe7214

[ ]
```