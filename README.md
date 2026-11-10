# Estúdio BDD — v4.0

Aplicação acadêmica para documentar requisitos com histórias de usuário, cenários BDD, registro/decisão humana de sugestões de IA e exportação Gherkin `.feature`.

## Stack
- API: Java 21, Spring Boot 3.5, Spring Web, Spring Data JPA, Bean Validation, PostgreSQL.
- SPA: React + Vite + Lucide.
- Testes: Spring Boot Test, H2 para teste isolado e ArchUnit.

## Executar API
1. Configure PostgreSQL (Supabase é aceito) e defina `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`. Para Supabase, use host/porta/usuário do pooler e `sslmode=require`.
2. Na raiz, execute `mvn test`.
3. Execute `mvn spring-boot:run`. API em `http://localhost:8080`; endpoints em `/api`.

Sem credenciais no repositório. `application.properties` lê variáveis de ambiente. O teste usa H2 em memória e não exige Supabase. Na primeira inicialização de um banco vazio, são criados dados fictícios de demonstração (usuário Ana Analista, projeto e uma história com cenário).

## Executar SPA
```bash
cd frontend
npm install
cp .env.example .env
npm run dev
```
Abra `http://localhost:5173`. Defina `VITE_API_URL` se a API estiver em outro endereço.

## Endpoints principais
- `GET/POST /api/usuarios`
- `GET/POST/PUT/DELETE /api/projetos`
- `GET/POST /api/historias`, `GET/PUT/DELETE /api/historias/{id}`
- `POST /api/historias/{id}/cenarios`
- `GET/PUT/DELETE /api/cenarios/{id}`
- `POST /api/cenarios/{id}/passos`
- `PUT/DELETE /api/passos/{id}`
- `POST /api/historias/{id}/sugestoes`
- `PUT /api/sugestoes/{id}/decisao`
- `GET /api/historias/{id}/exportar`
- `GET /api/resumo?projetoId=...`

A identidade é simulada por `X-Usuario-Id` nas operações de edição/exclusão de histórias e cenários. Isto não é autenticação.

## Regras contempladas
- Cenário exige ao menos um QUANDO e um ENTAO; DADO antecede QUANDO; E/MAS não iniciam cenário.
- Somente autor edita/exclui história e cria cenários/passos.
- Sugestões começam pendentes; rejeição exige motivo; decisão não pode ser refeita.
- Exportação exige cenário e nenhuma sugestão pendente.
- Resumo por projeto: histórias, cenários por origem, sugestões por decisão e motivos de rejeição.

## Limitações conhecidas / segurança acadêmica
- Identidade simulada por cabeçalho, sem Spring Security.
- A SPA usa usuário de demonstração; não é autenticação.
- Exclusão e atualizações avançadas de cenários/passos podem ser ampliadas.
- A integração com IA é manual: o usuário registra ferramenta, prompt e conteúdo; não há chamada automática a provedor de IA.
- `ddl-auto=update` é usado para laboratório; produção deve usar migrations.

## Fechamento Semana 4
Ver `docs/roteiro-verificacao.md`, `docs/registro-ia.md` e `docs/demo.md`. Marcar `api-completa` e `entrega-final` somente após executar os testes e a demonstração no ambiente do grupo.
