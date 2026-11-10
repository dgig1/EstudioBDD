# Plano executado até a Semana 4

Este pacote reúne a fundação, a API REST, a SPA React e os materiais de encerramento previstos no cronograma do enunciado. A equipe ainda deve executar os comandos e marcar as evidências reais no roteiro de verificação.

## Semana 1 — Fundação
- Entidades JPA e enums do domínio.
- Repositórios Spring Data JPA.
- Configuração de PostgreSQL por variáveis de ambiente.
- Dados fictícios iniciais para demonstração em banco vazio.
- Diagrama de classes, README e AGENTS.md.

## Semana 2 — Núcleo da API
- CRUD de projetos e histórias.
- Criação e consulta de cenários e passos, edição e exclusão de cenários/passos.
- DTOs, Bean Validation e tratamento de erros com ProblemDetail.
- Identidade simulada por `X-Usuario-Id` para operações protegidas por autoria.
- Validação da ordem/tipos dos passos e bloqueio de edição por não autor.

## Semana 3 — API completa e início da SPA
- Registro, aceitação e rejeição de sugestões.
- Bloqueio de rejeição sem motivo e de nova decisão após decisão final.
- Exportação Gherkin `.feature` com `# language: pt`.
- Consulta de histórias por projeto/prioridade e resumo do projeto.
- Testes de regras (três casos) e ArchUnit para impedir dependência direta Controller → Repository.
- SPA React com visão geral, projetos, usuários e lista de histórias.

## Semana 4 — SPA e fechamento
- Formulários para história, cenário e passos BDD.
- Registro e decisão de sugestões na interface.
- Download/exportação `.feature`.
- Resumo do projeto.
- Configuração CORS para a origem da SPA.
- Roteiro de verificação, roteiro de demonstração, registro de IA e README.

## Limites que devem ser conhecidos na apresentação
- A identidade é simulada por cabeçalho/campo de demonstração, não é autenticação real.
- O sistema registra sugestões de IA manualmente; não chama um provedor de IA.
- A equipe deve testar no próprio ambiente com seu Supabase/PostgreSQL e preencher evidências reais.
- A atividade bônus de fluxo configurável não foi incluída; o enunciado recomenda priorizar os itens obrigatórios.
