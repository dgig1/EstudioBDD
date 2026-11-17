# Estúdio BDD

### Sistema de documentação de requisitos com apoio de IA

**Disciplina:** Programação de Sistemas II  
**Ano:** 2026/2  
**Entrega:** 17/11/2026

**Danilo Gigliotti RA 10443431**
**Davi Portes RA 10417139** 

## 1. Sobre o projeto

O Estúdio BDD é uma aplicação web desenvolvida para organizar requisitos de software por meio de histórias de usuário e cenários BDD (Behavior Driven Development).

O sistema permite cadastrar projetos, criar histórias de usuário, documentar cenários utilizando Gherkin (Dado, Quando e Então), registrar sugestões geradas por ferramentas de Inteligência Artificial e decidir se serão aceitas ou rejeitadas.

Também permite exportar histórias revisadas para arquivos `.feature`.

## 2. Funcionalidades

- Cadastro e gerenciamento de projetos.
- Criação e edição de histórias de usuário.
- Cadastro de cenários e passos BDD.
- Registro de sugestões de Inteligência Artificial.
- Aceitação ou rejeição de sugestões com justificativa.
- Exportação de histórias no formato `.feature`.
- Consulta de resumo e indicadores dos projetos.

**Observação:** as sugestões de IA são geradas externamente e registradas manualmente no sistema.

## 3. Tecnologias utilizadas

| Backend | Frontend |
|---|---|
| Java 21 | React |
| Spring Boot 3.5.6 | JavaScript |
| Spring Data JPA | Vite |
| Hibernate | CSS |
| Maven | Lucide React |
| PostgreSQL / Supabase | Fetch API |

## 4. Arquitetura

O sistema utiliza arquitetura em camadas:

```text
Frontend (React)
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
PostgreSQL
```

Cada camada possui uma responsabilidade específica:

- **Controller:** recebe requisições HTTP.
- **Service:** executa as regras de negócio.
- **Repository:** realiza operações no banco.
- **Model:** representa as entidades do sistema.
- **Frontend:** disponibiliza a interface ao usuário.

## 5. Modelo de dados

Principais entidades:

- Usuario
- Projeto
- HistoriaUsuario
- Cenario
- Passo
- Sugestao

Os relacionamentos organizam projetos, histórias, cenários, passos e sugestões.

## 6. Como executar o projeto

### Pré-requisitos

- Java JDK 21
- Maven
- Node.js e npm
- Banco PostgreSQL configurado

### Backend

Na raiz do projeto, configure as variáveis de ambiente:

```powershell
$env:DB_URL = "SUA_URL_JDBC"
$env:DB_USERNAME = "SEU_USUARIO"
$env:DB_PASSWORD = "SUA_SENHA"
```

Execute:

```bash
mvn spring-boot:run
```

Backend disponível em:

`http://localhost:8080`

### Frontend

Em outro terminal:

```bash
cd frontend
npm install
npm run dev
```

Frontend disponível em:

`http://localhost:5173`

## 7. Testes

Os testes devem verificar as principais regras de negócio, incluindo:

- Rejeição de cenários inválidos.
- Bloqueio de rejeição de sugestões sem justificativa.
- Bloqueio da exportação com sugestões pendentes.
- Verificação da arquitetura com ArchUnit.

Para executar:

```bash
mvn test
```

## 8. Documentação e entrega

Os materiais complementares do projeto devem ser disponibilizados na pasta `docs/`:

- Diagrama de classes.
- Registro de utilização de IA.
- Roteiro e evidências de testes.
- Exemplo de arquivo `.feature` exportado.

## 9. Considerações finais

O Estúdio BDD aplica conceitos de Programação Orientada a Objetos, arquitetura em camadas, desenvolvimento de APIs REST, persistência de dados e documentação de requisitos com BDD.

O projeto demonstra a utilização de tecnologias modernas no desenvolvimento de aplicações web, mantendo a avaliação humana como parte fundamental do uso de sugestões produzidas por Inteligência Artificial.

---

**Integrantes:**  
- [Nome do integrante 1]
- [Nome do integrante 2]
- [Nome do integrante 3]

**Repositório:** [Inserir link do GitHub]
