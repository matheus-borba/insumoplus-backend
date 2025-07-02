# 🧪 InsumoPlus Backend

Backend da aplicação **InsumoPlus**, voltada para gestão de insumos e integração com sistemas externos como o Pipedrive. Construído com **Quarkus**, com arquitetura organizada em camadas para facilitar manutenção, testes e escalabilidade.

---

## 🧰 Tecnologias Utilizadas

* Java 21
* Quarkus
* Maven
* REST Client (MicroProfile)
* MongoDB Panache
* Docker / Docker Compose
* Lombok

---

## 📁 Estrutura do Projeto

```
insumoplus-backend
├── src/
│   ├── main/
│   │   ├── java/br/edu/engsoft/
│   │   │   ├── client/         # Integrações externas (Pipedrive)
│   │   │   ├── controller/     # Endpoints REST
│   │   │   ├── dto/            # Data Transfer Objects
│   │   │   ├── model/          # Entidades (MongoDB Collections)
│   │   │   ├── repository/     # Acesso a dados
│   │   │   ├── scheduler/      # Configuração de Timers internos
│   │   │   └── service/        # Lógica de negócio
│   ├── resources/              # Configurações (application.properties, etc)
│   └── docker/                 # Imagens Docker para diferentes modos
├── docker-compose.yml          # Orquestração de serviços
└── pom.xml                     # Dependências e plugins Maven
```

---

## 🚀 Como Executar Localmente

### Pré-requisitos

* Java 21
* Maven 3.8+
* Docker (opcional, mas recomendado)

### Instalação

```bash
./mvnw clean install
```

### Usando Docker Compose

```bash
docker-compose up --build
```

### Rodando em modo de desenvolvimento

```bash
./mvnw quarkus:dev
```

Acesse o Dev UI:
[http://localhost:8080/q/dev/](http://localhost:8080/q/dev/)

---

## 📦 Build do Projeto

```bash
./mvnw clean package
```

Gera o JAR em:

```
target/quarkus-app/quarkus-run.jar
```

Rodar:

```bash
java -jar target/quarkus-app/quarkus-run.jar
```

---

## 🔁 Integrações Externas

### 🔗 Pipedrive

A aplicação se conecta à API do Pipedrive para:

* Buscar organizações
* Buscar produtos
* Buscar usuários

```properties
pipedrive.api.token=SEU_TOKEN_AQUI
pipedrive.api.url=SEU_ENDERECO_PIPEDRIVE
```

---

## 📌 Endpoints REST

| Recurso        | Caminho          | Descrição                             |
| -------------- | ---------------- | ------------------------------------- |
| `User`         | `/users`         | Gerenciamento de usuários             |
| `Product`      | `/products`      | Cadastro e listagem de produtos       |
| `Organization` | `/organizations` | Integração com organizações Pipedrive |

### 🏢 OrganizationController

| Método | Caminho                                 | Descrição                            |
|--------|------------------------------------------|----------------------------------------|
| `GET`  | `/api/organizations`                    | Lista todas as organizações           |
| `GET`  | `/api/organizations/{id}`               | Busca organização por ID              |
| `GET`  | `/api/organizations/search?name=...`    | Busca por nome via query param        |
| `GET`  | `/api/organizations/owner/{ownerId}`    | Lista por ID do responsável           |

### 📦 ProductController

| Método | Caminho                              | Descrição                             |
|--------|---------------------------------------|-----------------------------------------|
| `GET`  | `/api/products`                      | Lista todos os produtos                |
| `GET`  | `/api/products/{id}`                 | Busca produto por ID                   |
| `GET`  | `/api/products/search?name=...`      | Busca por nome via query param         |
| `GET`  | `/api/products/owner/{ownerId}`      | Lista por ID do responsável            |

### 👤 UserController

| Método | Caminho                            | Descrição                                |
|--------|-------------------------------------|-------------------------------------------|
| `GET`  | `/api/users`                       | Lista todos os usuários                   |
| `GET`  | `/api/users/{id}`                  | Busca usuário por ID                      |
| `GET`  | `/api/users/search?email=...`      | Busca por e-mail via query param          |

---

## 👨‍💻 Contribuindo

1. Fork este repositório
2. Crie uma branch: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m 'feat: minha nova feature'`
4. Push: `git push origin minha-feature`
5. Crie um Pull Request

---

## 🧠 Referências

* [Quarkus.io](https://quarkus.io/)
* [Pipedrive API Docs](https://developers.pipedrive.com/)
