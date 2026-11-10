# AGENTS.md — Estúdio BDD

## Arquitetura
- `controller`: HTTP, DTOs e status; nunca acessar repositories diretamente.
- `service`: regras de negócio e `@Transactional`.
- `repository`: Spring Data JPA, sem regras de negócio.
- `model`: entidades e enums JPA.
- `dto`: contratos HTTP; não serializar entidades JPA diretamente.

## Convenções
- Java 21, Spring Boot 3.5, nomes em português e `PascalCase` para classes.
- Injeção por construtor; validação de entrada com Bean Validation.
- Respostas de erro via `ProblemDetail` em `ApiExceptionHandler`.
- Não incluir credenciais, tokens ou senhas no Git.
- Identidade atual é simulada via `X-Usuario-Id`; documentar a limitação.

## Regras BDD
- Cenário exige QUANDO e ENTAO; DADO antecede QUANDO; E/MAS continuam passo anterior.
- Somente autor edita/exclui história e seus cenários.
- Rejeição exige motivo; sugestão decidida é imutável.
- Exportação requer cenário e zero sugestões pendentes.

## Comandos
- API: `mvn test`, `mvn spring-boot:run`.
- SPA: `cd frontend && npm install && npm run dev`.
- SPA build: `cd frontend && npm run build`.
