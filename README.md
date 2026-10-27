
# 🚀 Estúdio BDD

Sistema de documentação de requisitos com apoio de Inteligência Artificial, desenvolvido para a disciplina de **Programação de Sistemas II**.

## 🛠️ Tecnologias
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- React (frontend planejado)

## 🎯 Funcionalidades
- Cadastro de projetos e histórias de usuário.
- Criação de cenários BDD (Dado, Quando, Então).
- Registro e avaliação de sugestões de IA.
- Exportação de cenários para arquivos `.feature`.
- Consulta e resumo dos projetos.

## 📁 Estrutura do Projeto

```text
estudio-bdd/
├── src/
│   ├── main/
│   │   ├── java/br/com/estudiobdd/
│   │   │   ├── config/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── controller/  # Futuro
│   │   │   ├── dto/         # Futuro
│   │   │   └── service/     # Futuro
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── docs/
│   ├── diagrama-classes.md
│   └── exemplo-bdd.feature
├── AGENTS.md
├── pom.xml
└── README.md
```

## 🏗️ Arquitetura
Aplicação organizada em camadas:
- **Controller:** recebe requisições HTTP.
- **Service:** aplica as regras de negócio.
- **Repository:** gerencia a persistência.
- **Model:** representa as entidades do sistema.
- **DTO:** define os dados de entrada e saída da API.

## 📌 Status do Projeto
Fundação inicial criada, com entidades JPA, enums, repositórios e configuração do banco. As demais funcionalidades serão implementadas progressivamente.

## 🎓 Informações Acadêmicas
- **Disciplina:** Programação de Sistemas II
- **Período:** 2026/2
- **Entrega prevista:** 17/11/2026
