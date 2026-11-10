# API REST — endpoints

Base URL: `http://localhost:8080/api`

| Método | Caminho | Descrição |
|---|---|---|
| GET | `/usuarios` | Lista usuários de demonstração |
| POST | `/usuarios` | Cadastra usuário |
| GET | `/projetos` | Lista projetos |
| POST | `/projetos` | Cadastra projeto |
| PUT | `/projetos/{id}` | Edita projeto |
| DELETE | `/projetos/{id}` | Exclui projeto |
| GET | `/historias?projetoId=&prioridade=` | Lista/filtra histórias |
| GET | `/historias/{id}` | Consulta história com cenários, passos e sugestões |
| POST | `/historias` | Cadastra história |
| PUT | `/historias/{id}` | Edita história; exige `X-Usuario-Id` do autor |
| DELETE | `/historias/{id}` | Exclui história; exige `X-Usuario-Id` do autor |
| POST | `/historias/{id}/cenarios` | Cria cenário e seus passos em uma operação |
| GET | `/cenarios/{id}` | Consulta cenário e passos |
| PUT | `/cenarios/{id}` | Edita título; exige `X-Usuario-Id` do autor |
| DELETE | `/cenarios/{id}` | Exclui cenário; exige `X-Usuario-Id` do autor |
| POST | `/cenarios/{id}/passos` | Acrescenta passo a cenário já válido |
| PUT | `/passos/{id}` | Edita passo; exige `X-Usuario-Id` do autor |
| DELETE | `/passos/{id}` | Exclui passo, desde que o cenário permaneça válido |
| POST | `/historias/{id}/sugestoes` | Registra sugestão manual de IA |
| PUT | `/sugestoes/{id}/decisao` | Aceita/rejeita sugestão |
| GET | `/historias/{id}/exportar` | Baixa arquivo `.feature` |
| GET | `/resumo?projetoId=` | Resumo agregado do projeto |

## Exemplo de história
```json
{
  "titulo": "Cadastrar requisito",
  "papel": "Analista de requisitos",
  "objetivo": "registrar uma história",
  "beneficio": "organizar o projeto",
  "prioridade": "ALTA",
  "projetoId": 1,
  "autorId": 1
}
```

## Exemplo de cenário com passos (criação atômica)
```json
{
  "titulo": "Cadastro válido",
  "posicao": 1,
  "origem": "HUMANO",
  "passos": [
    {"tipo":"DADO","texto":"que estou no sistema","posicao":1},
    {"tipo":"QUANDO","texto":"salvo o requisito","posicao":2},
    {"tipo":"ENTAO","texto":"o requisito aparece na lista","posicao":3}
  ]
}
```
