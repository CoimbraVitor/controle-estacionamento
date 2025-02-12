# controle-estacionamento
API de controle de estacionamento utilizando Spring Boot


## Objetivo
API REST para gerenciar um estacionamento de carros e motos.

## Cadastro de estabelecimento
Criar um cadastro da empresa com os seguintes campos:
   - Nome;
   - CNPJ;
   - Endereço;
   - Telefone;
   - Quantidade de vagas para motos;
   - Quantidade de vagas para carros.

**Todos** os campos são de preenchimento obrigatório.

## Cadastro de veículos
Criar um cadastro de veículos com os seguintes campos:
   - Marca;
   - Modelo;
   - Cor;
   - Placa;
   - Tipo.

**Todos** os campos são de preenchimento obrigatório.

## Funcionalidades
   - **Estabelecimento:** CRUD;
   - **Veículos:** CRUD;
   - **Controle de entrada e saída de veículos.**

## Requisitos
   - Modelagem de dados;
   - O retorno deverá ser em formato JSON e XML;
   - Requisições GET, POST, PUT ou DELETE, conforme a melhor prática;
   - A persistência dos dados pode ser realizada da maneira que preferir;
   
## Bônus
   - Desenvolver utilizando TDD;
   - Criar API de relatório;
   - Sumário da quantidade de entrada e saída;
   - Sumário da quantidade de entrada e saída de veículos por hora;
   - Criar uma solução de autenticação.

## Questionário para Avaliação de Competências

### 1. GraphQL (Implementação BFF - Backend For Frontend)
   - **Implementação:** Crie um BFF com GraphQL localmente para permitir as operações de CRUD e controle de entrada e saída de veículos. O BFF deve expor as operações e lidar com as interações entre o front-end e o back-end.

### Projeto baseado nesse desafio técnico: https://github.com/fcamarasantos/backend-test-java
