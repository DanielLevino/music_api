# 🎵 Music API - Spring Boot & Docker

Este projeto é uma API RESTful para gerenciamento de catálogos musicais, desenvolvida para colocar em prática conceitos de **Clean Code**, **Arquitetura em Camadas** e **Containerização**.

A aplicação segue a filosofia **"Stack and Mindset Evolving"**, focando em um desenvolvimento sustentável, código legível e infraestrutura moderna.

---

## 🚀 Tecnologias Utilizadas

- **Java 17** & **Spring Boot 3**
- **Spring Data JPA** (Persistência de dados)
- **PostgreSQL** (Banco de dados relacional)
- **Docker & Docker Compose** (Containerização)
- **Bean Validation** (Validação de dados)
- **Maven** (Gerenciamento de dependências)

---

## 🛠️ Funcionalidades (CRUD)

- [x] **Cadastro de Músicas:** Validação de campos obrigatórios e ano de lançamento (não permite datas futuras).
- [x] **Listagem Completa:** Retorna todas as músicas cadastradas.
- [x] **Consulta por ID:** Detalhes de uma música específica com tratamento de exceção.
- [x] **Atualização:** Edição de dados existentes com validação de integridade.
- [x] **Remoção:** Exclusão de registros do banco de dados.
- [x] **Validação de Negócio:** Impede o cadastro de músicas duplicadas (mesmo título e artista).

---

## 📦 Como rodar o projeto

Você precisará ter o **Docker** instalado em sua máquina.

1. Clone o repositório:
   ```bash
   git clone [https://github.com/daniel-levino/music-api.git](https://github.com/daniel-levino/music-api.git)

2. Na raiz do projeto, suba os containers:

    ```bash
    docker compose up -d
    ```
A API estará disponível em: http://localhost:8080/api/musics

---

## 📂 Organização do Projeto (Arquitetura)
O projeto foi organizado seguindo o padrão de Camadas, garantindo a separação de responsabilidades:

controller: Porta de entrada da API (Endpoints e Status Codes).
service: Camada de inteligência e regras de negócio.
repository: Comunicação com o banco de dados PostgreSQL.
model: Definição das entidades e validações.
exception: Centralização do tratamento de erros da aplicação.

---

## 🧠 Mindset de Desenvolvimento

Este projeto utiliza o Docker Compose Watch. Isso permite que as alterações feitas no código fonte sejam sincronizadas automaticamente com o container em tempo real, agilizando o ciclo de feedback durante o desenvolvimento. Além disso, a API utiliza um Global Exception Handler para garantir que todos os erros retornem um JSON padronizado e amigável.

---

### 👨‍💻 Autor
Daniel Levino

https://daniellevino.com

Full-stack Developer em constante evolução.