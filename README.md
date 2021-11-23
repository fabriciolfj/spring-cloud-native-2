# Aplicação java native

## Patterns microservices
##### Single responsibility
- para compor uma resposta ao cliente, faz uma chamada sincrona em cascata entre os serviços

##### Aggregate
- para compor uma resposta ao cliente, faz chamadas paralelas nos microservices

##### Gateway
- unica entrada a malha de serviços e estes podem ser chamados de forma paralela.

##### CQRS
- Um serviço tem responsabilidade apenas de salvar, atualizar e deletar informações
- Outro serviço efetua apenas consultas
- obs: 
  - para um contexto onde existe uma base de dados compartilhada entre os serviços
  - a consulta pode representar uma junção de tabelas.

##### SAGA
- Garante a consistência dos dados em vários microservices
- Existem 3 formas:
  - orquestrador (similar ao aggregate)
  - comunicação hybrida - parte assincrono / sincrona
  - coreografia entre os microservices: abordagem orientada a eventos, processo assíncrono.
