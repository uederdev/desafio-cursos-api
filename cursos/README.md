<p align="center">
<picture>
<source media="(prefers-color-scheme: dark)" srcset="https://copilot.microsoft.com/th/id/BCO.f46071b5-e864-4fdc-b77b-974a00384f63.png">
<source media="(prefers-color-scheme: light)" srcset="https://copilot.microsoft.com/th/id/BCO.f46071b5-e864-4fdc-b77b-974a00384f63.png">
<img alt="Banner Cursos API" src="https://copilot.microsoft.com/th/id/BCO.f46071b5-e864-4fdc-b77b-974a00384f63.png" width="60%">
</picture>
</p>

# 📚 API de Gerenciamento de Cursos

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Maven](https://img.shields.io/badge/Maven-3.9-red)
![Build](https://img.shields.io/github/actions/workflow/status/seu-usuario/api-cursos/ci.yml)
![Coverage](https://img.shields.io/badge/Coverage-JaCoCo-success)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

---

# 🚀 Visão Geral

API REST para gerenciamento de cursos utilizando Spring Boot, JPA, H2 e boas práticas de arquitetura.

---

# 🏛️ Clean Architecture

```text
Controller
    ↓
Service
    ↓
Domain
    ↓
Repository
    ↓
Database
```

---

# 📁 Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   └── br/com/desafio/cursos
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── entity
│   │       ├── dto
│   │       ├── mapper
│   │       ├── exception
│   │       ├── config
│   │       └── util
│   └── resources
│       ├── application.yml
│       └── db/migration
|           └── V001__create_table_cursos.sql
└── test
    └── java
```

---

# 📖 Swagger/OpenAPI

## Dependência

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.9</version>
</dependency>
```

## URLs

http://localhost:8080/swagger-ui.html

http://localhost:8080/swagger-ui/index.html

http://localhost:8080/v3/api-docs

---

# 📬 Coleção Postman

A coleção pode ser encontrada em:

```text
docs/postman/API-Cursos.postman_collection.json
```

Importe a coleção diretamente no Postman.

---

# 🌐 Endpoints

| Método | Endpoint            |
|--------|---------------------|
| POST   | /cursos             |
| GET    | /cursos             |
| PUT    | /cursos/{id}        |
| PATCH  | /cursos/{id}/active |
| DELETE | /cursos/{id}        |

### POST `/cursos`

```json
{
  "name": "Java com Spring Boot",
  "category": "Programação",
  "teacher": "João Silva"
}
```

### Response - 201 Created

```json
{
  "id": 1,
  "name": "Java com Spring Boot",
  "category": "Programação",
  "professor": "João Silva",
  "active": true,
  "createdAt": "10/06/2026 10:30:00"
}
```

### GET `/cursos?name=Java`
### GET `/cursos?category=Programação`
### GET `/cursos?name=Java&category=Programação`

### PUT `/cursos/{id}`

```json
{
  "name": "Java Avançado"
}
```

### PATCH `/cursos/{id}/active`

```json
{}
```

### DELETE `/cursos/{id}`

### Response - 204 No Content

# 🐳 Docker

```dockerfile
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw clean package -DskipTests


FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
```

Build:

```bash
docker build -t api-cursos .
```

Run:

```bash
docker run -p 8080:8080 api-cursos
```
---

# ✅ Boas Práticas

- DTO para entrada e saída
- Bean Validation
- MapStruct para conversão
- Exceptions customizadas
- Controller enxuto
- Regras de negócio na camada Service
- Swagger/OpenAPI
- Clean Architecture
- Princípios SOLID
- Logs estruturados
- Dockerização da aplicação

---

# 📄 Licença

Projeto destinado para estudos e demonstração de conhecimento em Java e Spring Boot.
