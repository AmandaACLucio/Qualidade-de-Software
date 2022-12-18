## Media GO

#### COS482 - Qualidade de Software
Amanda Lucio, Lucas Máximo, Nayara Gomes

# Documento de Visão

## **Objetivo**

O objetivo deste documento é apresentar todo o processo de construção de um software de aluguel de conteúdos de mídia, similar ao que existe na plataforma do Youtube e Amazon Prime Video, expondo todos os requisitos alinhados à necessidade do usuário final e as funcionalidades gerais que estão presentes no software.

## **Escopo**

Ao final do projeto, o sistema será capaz de permitir que o usuário realize o aluguel de uma mídia (filmes, séries, documentários, etc) através de um sistema web diretamente conectado com o servidor, que gerenciará a conta de cada usuário, bem como o tempo de disponibilidade da mídia para cada um deles. 

## **Contexto do negócio**

Com o software, o usuário será capaz de assistir qualquer conteúdo audiovisual, do conforto de sua casa ou de qualquer outro lugar sem precisar ser assinante de nenhum serviço de streaming e nem apelar para sites não confiáveis. Nosso software funciona como uma video locadora virtual com um vasto arsenal de mídia aberto para você conseguir explorá-lo à vontade antes de tomar qualquer decisão e por um preço bem acessível.

## **Partes interessadas (stakeholders)**

Os principais stakeholders do projeto são divididos em duas partes: O professor da disciplina, que se interessa pelo projeto em prol da avaliação,
e pessoas que não tem muito tempo disponível, não possuem condições financeiras ou que, por opção, não possuem nenhuma assinatura de serviços de streaming, mas ainda assim gostam de consumir esse tipo de conteúdo.


## **Equipe do projeto**

 - **Amanda Lucio** - Responsável pela gestão do projeto, atuará como Product Owner, mantendo a integridade conceitual do backlog e o alinhamento com a visão do produto;

 - **Nayara Gomes** - Será responsável pela experiência do usuário, por sua interface gráfica e pelo desenvolvimento da mesma, além de monitorar e realizar constantes testes funcionais, de usabilidade, exploratórios, etc;

- **Lucas Máximo Dantas** - Atuará como desenvolvedor backend, atuando diretamente com o banco de dados do projeto e com as APIs, além de cuidar de toda infraestrutura necessária para o projeto.

## **Características do produto**

- **Autenticação:** 

Antes de tudo, o software deve ter um mecanismo de autenticação para garantir a segurança e a integridade do sistema. Nesse sistema, é importante coletar alguns dados essenciais do usuário, como nome, data de nascimento, e-mail, senha, forma de pagamento, para garantir a identidade do usuário e oferecer produtos personalizados.

- **Catálogo de conteúdos:** 

Deverá conter um catálogo com todos os filmes, séries, documentários e quaisquer tipos de conteúdo audiovisual disponíveis na plataforma.

- **Página detalhada de mídia:**

É imprescindível que tenha uma página detalhada da mídia selecionada, com todas as informações, como sinopse, título, preço, avaliação, tempo de duração, etc.

- **Biblioteca de conteúdo alugado:**

É importante também que o software tenha uma seção com todos os produtos alugados, bem como o tempo restante para consumí-los.

- **Filtro de pesquisa:**

Uma barra de pesquisa é essencial para que se encontre o título desejado com maior rapidez e praticidade sem perda de tempo.

- **Carrinho de aluguel:**

Para gerenciar os títulos desejados da melhor forma, é importante que tenha-se um carrinho que conterá todos os títulos que o usuário deseja alugar. Nesse carrinho, poderão ser gerenciados o tempo de aluguel, a promoção ou cupom de desconto, se houver, ou até remover um título que não desejar mais alugar.

- **Página de pagamento:**

O sistema terá uma página de pagamento para o usuário finalizar o pedido, colocando a forma de pagamento desejada ou optando pela forma de pagamento já cadastrada ao sistema.

- **Solicitação de novos títulos:**

O sistema permitirá que para um título desejado não disponível, possa ser realizado um pedido. Desta forma, o servidor terá acesso a títulos muito requisitados não pertencentes ao catálogo.


## **Restrições do produto**

Um dos requisitos prioritários para o sistema deverá ser finalizado até o fim da disciplina de Qualidade de Software, então temos um curto prazo para finalizar o projeto. Além disso, o projeto só pode ser feito utilizando ferramentas gratuitas e de baixo custo, devido ao baixo orçamento.

