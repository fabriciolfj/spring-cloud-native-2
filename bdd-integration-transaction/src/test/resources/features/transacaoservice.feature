Feature: Criar uma transação com sucesso

  Scenario Outline: Criar uma transação com sucesso
    Given uma transacao "<body>"
    When coletar consultar os dados
    Then teremos uma transação com id unico
    Examples:
      | body                                        |
      | src/test/resources/transacao/transacao.json |
