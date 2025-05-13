# 🌱 Monitoramento ESG

Sistema de monitoramento de consumo energético com foco em práticas ESG (Ambiental, Social e Governança). Desenvolvido com Java, Spring Boot, Oracle Database e integração via Docker.

---

## 📌 Visão Geral

O sistema permite:

- Registro de sensores e consumos de energia.
- Geração automática de alertas em caso de consumo elevado.
- Visualização paginada e ordenada dos dados via Swagger UI.
- Segurança nos endpoints com Spring Security.
- Gestão de versionamento do banco via Liquibase.

---

## 🧰 Tecnologias Utilizadas

- Java 21
- Spring Boot 3.2.5
    - Spring Web
    - Spring Data JPA
    - Spring Security
    - Spring Validation
- Oracle Database (via Docker)
- Liquibase (versionamento de schema)
- Swagger (documentação de API via `springdoc-openapi`)
- Maven
- Docker & Docker Compose

---

## ⚙️ Pré-requisitos

- Java JDK 21+
- Maven 3.8+
- Docker + Docker Compose
- Oracle JDBC Driver (`ojdbc11`) já adicionado ao repositório Maven local (ou no `pom.xml` via `<systemPath>` se necessário)

---

## 📄 Como acessar o swagger

### 1. Acessar a url http://localhost:8080/swagger-ui/index.html#/ após rodar o projeto

### 2. Utilizar as credenciais username: admin password: admin

## 🚀 Como Rodar

### 1. Subir o banco de dados Oracle via Docker

```bash
docker compose up -d
