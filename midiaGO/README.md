# MidiaGo

MidiaGO é um app focado no aluguel de mídias digitais, onde possuímos um acervo vasto de conteúdos como filmes, séries, documentários, realities shows, etc.

O app foi gerado através do JHipster 7.0.1 (documentação [https://www.jhipster.tech/documentation-archive/v7.0.1](https://www.jhipster.tech/documentation-archive/v7.0.1)).

## BPMN

O modelo BPMN inicial do nosso projeto ficou como na imagem abaixo:

![modelo BPMN antigo](https://github.com/AmandaACLucio/Qualidade-de-Software/blob/f98e01ea4264782d2cdf716b9e0880c3b1fa7c2d/imagens/Bpmn_antigo.jpeg)

Após uma remodelagem, onde foi retirada todos os elementos reduntantes e desnecessários, o modelo final ficou assim:

![modelo BPMN atual](https://github.com/AmandaACLucio/Qualidade-de-Software/blob/f98e01ea4264782d2cdf716b9e0880c3b1fa7c2d/imagens/Bpmn_novo.jpeg)

## Desenvolvimento

Requisitos mínimos:

1. Node.js
2. Java JDK

Para rodar o projeto, basta ir na pasta do app e rodar o seguinte comando:

```
./mvnw
```

## Entidades

- **Domain entity**

    O arquivo json que define a entidade de domínio do projeto pode ser visualizado no link abaixo:
    
    [Domain entity](https://github.com/AmandaACLucio/Qualidade-de-Software/blob/f98e01ea4264782d2cdf716b9e0880c3b1fa7c2d/midiaGO/.jhipster/MidiaGo.json)
    
- **Process-binding entity**

    O arquivo json que define a entidade de processo do projeto pode ser visualizado no link abaixo:
 
    [Process-binding entity](https://github.com/AmandaACLucio/Qualidade-de-Software/blob/f98e01ea4264782d2cdf716b9e0880c3b1fa7c2d/midiaGO/.jhipster/MidiaGoProcess.json)
    
- **Start-form entity**
 
    O arquivo json que define a entidade do formulário inicial do projeto pode ser visualizado no link abaixo:
 
    [Start-form entity](https://github.com/AmandaACLucio/Qualidade-de-Software/blob/f98e01ea4264782d2cdf716b9e0880c3b1fa7c2d/midiaGO/.jhipster/MidiaGoStartForm.json)
    
- **User-task entity**

    O arquivo json que define a entidade da tarefa do usuário do projeto, que no caso é a reserva de mídia, pode ser visualizado no link abaixo:
 
    [User-task entity](https://github.com/AmandaACLucio/Qualidade-de-Software/blob/f98e01ea4264782d2cdf716b9e0880c3b1fa7c2d/midiaGO/.jhipster/TaskBooking.json)
