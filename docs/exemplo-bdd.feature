# language: pt

Funcionalidade: Adicionar produto ao carrinho
  Como cliente
  Quero adicionar um produto ao carrinho
  Para reunir os produtos que desejo comprar

  Cenário: Adicionar um produto disponível ao carrinho
    Dado que o cliente está visualizando um produto disponível
    Quando adiciona o produto ao carrinho
    Então o produto deve aparecer no carrinho

  Cenário: Atualizar a quantidade de um produto no carrinho
    Dado que o cliente já adicionou um produto ao carrinho
    Quando aumenta a quantidade do produto
    Então o carrinho deve apresentar a nova quantidade

  Cenário: Não adicionar produto indisponível
    Dado que o produto está indisponível para compra
    Quando o cliente tenta adicioná-lo ao carrinho
    Então o sistema deve informar que o produto não está disponível
