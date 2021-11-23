# Aplicação java native

## Patterns microservices
##### Single responsibility
- para compor uma resposta ao cliente, faz uma chamada sincrona em cascata entre os serviços

##### Aggregate
- para compor uma resposta ao cliente, faz chamadas paralelas nos microservices

##### Gateway
- unica entrada a malha de serviços e estes podem ser chamados de forma paralela.
