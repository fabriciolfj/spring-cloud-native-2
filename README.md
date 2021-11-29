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

## Observabiity e monitoramento
- Centralização de logs
- Coleta de métricas (utilizando micrometer do spring com prometheus)
- Rastreamento com spring sleuth, integrando com jaeger

## Gateway
- Funciona com um proxy reverso, ou seja, recebe as requisições e encaminha para o serviço correspondente, diante uma tabela de rotas.
- Ideal para centralizar a segurança da aplicação, uma vez que o mesmo é a porta de entrada
- Trabalhar com cache, ou seja, caso a resposta seja igual a uma segunda chamada, pode-se retornar os dados em cache em vez de bater no serviço responsável.
- Inserir cotas de requisição por client
- Limitar o número de requisições
- Efetuar loadbalance

## BDD (behavior driven development)
- Abordagem para efetuar/elaborar testes orientados ao comportamento do software
- Possui os seguintes componentes:
  - feature: arquivo que contens os cenários e passos para executação do teste (escrito em linhguagem Gherkin)
  - cenário: situação ou o que será testado, uma feature pode conter mais de um cenário
  - passos: etapas da execução, um cenário pode conter mais mais de uma step(passos)
    - dado: pre condição, exemplo: configuração de dados iniciais
    - quando: testando a condição, a ação que o usuário realiza
    - então: validando resultado  
