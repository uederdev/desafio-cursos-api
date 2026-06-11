# 📚 API de Gerenciamento de Cursos

API REST desenvolvida para gerenciamento de cursos, permitindo cadastro, consulta, atualização, remoção e ativação/desativação de cursos.

## 🚀 Funcionalidades

- Criar um novo curso
- Listar todos os cursos
- Buscar cursos por nome e categoria
- Atualizar um curso pelo ID
- Remover um curso pelo ID
- Ativar/Desativar um curso

---

## 🛠️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Bean Validation
- H2 Database
- Maven
- Flyway
- PostgreSQL
- Docker

---

## 📂 Estrutura da Entidade

| Campo     | Tipo          | Descrição                    |
|-----------|---------------|------------------------------|
| id        | UUID          | Identificador único          |
| name      | String        | Nome do curso                |
| category  | String        | Categoria do curso           |
| teacher   | String        | Nome do professor            |
| active    | Boolean       | Indica se o curso está ativo |
| createdAt | LocalDateTime | Data de criação              |
| updatedAt | LocalDateTime | Data da última atualização   |

## 💾 Scripts de Criação das Tabelas - Flyway (V001__create_table_cursos.sql)

# Endpoints

## ➕ Criar Curso

### POST `/cursos`

```json
{
  "name": "Java com Spring Boot",
  "category": "Programação",
  "professor": "João Silva"
}
```

### Response - 201 Created

```json
{
  "id": 1,
  "name": "Java com Spring Boot",
  "category": "Programação",
  "professor": "João Silva",
  "active": true
}
```

## 📋 Listar Cursos

### GET `/cursos`

## 🔍 Buscar Cursos

### GET `/cursos?name=Java`
### GET `/cursos?category=Programação`
### GET `/cursos?name=Java&category=Programação`

## ✏️ Atualizar Curso

### PUT `/cursos/{id}`

```json
{
  "name": "Java Avançado"
}
```

## 🔄 Ativar / Desativar Curso

### PATCH `/cursos/{id}/active`

```json
{}
```

## ❌ Remover Curso

### DELETE `/cursos/{id}`

### Response - 204 No Content

## ✅ Validações

Campos obrigatórios:

- name
- category
- professor

## 🗄️ Banco H2

```text
http://localhost:8080/h2-console
```

```text
JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```
