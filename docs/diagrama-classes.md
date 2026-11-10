# Diagrama de classes inicial

Diagrama baseado no modelo sugerido no enunciado. Pode ser renderizado por visualizadores Mermaid.

```mermaid
classDiagram
    class Usuario {
        Long id
        String nome
        String email
    }
    class Projeto {
        Long id
        String nome
        String descricao
        String contextoDominio
        LocalDateTime dataCriacao
    }
    class HistoriaUsuario {
        Long id
        String titulo
        String papel
        String objetivo
        String beneficio
        Prioridade prioridade
        LocalDateTime dataCriacao
        LocalDateTime dataAtualizacao
    }
    class Cenario {
        Long id
        String titulo
        Integer posicao
        OrigemCenario origem
    }
    class Passo {
        Long id
        TipoPasso tipo
        String texto
        Integer posicao
    }
    class Sugestao {
        Long id
        String ferramenta
        String promptUtilizado
        String conteudo
        DecisaoSugestao decisao
        MotivoRejeicao motivoRejeicao
        String justificativa
        LocalDateTime dataRegistro
        LocalDateTime dataDecisao
    }

    class Prioridade {
        <<enumeration>>
        ALTA
        MEDIA
        BAIXA
    }
    class OrigemCenario {
        <<enumeration>>
        HUMANO
        SUGESTAO_IA
    }
    class TipoPasso {
        <<enumeration>>
        DADO
        QUANDO
        ENTAO
        E
        MAS
    }
    class DecisaoSugestao {
        <<enumeration>>
        PENDENTE
        ACEITA
        REJEITADA
    }
    class MotivoRejeicao {
        <<enumeration>>
        INCORRETA
        GENERICA
        DUPLICADA
        FORA_DO_ESCOPO
        OUTRO
    }

    Projeto "1" --> "0..*" HistoriaUsuario : contém
    Usuario "1" --> "0..*" HistoriaUsuario : autor
    HistoriaUsuario "1" *-- "0..*" Cenario : cenários ordenados
    Cenario "1" *-- "1..*" Passo : passos ordenados
    HistoriaUsuario "1" --> "0..*" Sugestao : sugestões
    Usuario "1" --> "0..*" Sugestao : registradaPor
    Usuario "0..1" --> "0..*" Sugestao : decididaPor
```

Observações:
- `Cenario` e `Passo` foram modelados com composição via `cascade = ALL` e `orphanRemoval = true` para que a remoção do cenário remova seus passos.
- A validação da ordem dos passos é regra de negócio e ainda precisa ser implementada no service.
- A unicidade de título de história é composta por projeto + título; a unicidade de cenário é história + título.
