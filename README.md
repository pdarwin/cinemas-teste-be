# Projeto Livraria Requalificar (BackEnd)

__Requalificar +DIGITAL Java__

__Laboratório de Programação__

__Grupo 8__

- João Rocha

- Paulo Santos Perneta


## Requisitos

__1.1.__	O sistema deve permitir o registo pela aplicação de dois utilizadores: Ator e Funcionário;


__1.2.__ Após o registo, ambos os utilizadores deveram receber uma validação por email;


__1.3.__ O sistema deve permitir ao salario fazer login através do endereço eletrónico (email), juntamente com a password;


__1.4.__ O salario é caracterizado por um nome, um email, uma morada e uma data de nascimento;


__1.5.__ O sistema deve permitir ao funcionário fazer login através do username (nome de utilizador), juntamente com a password;


__1.6.__ O funcionário é caracterizado por um nome, uma data de nascimento e um nickname, gerado automaticamente a partir do nome.


__1.7.__	O username do funcionário, deverá ser calculado a partir da primeira letra do nome, mais sobrenome em conjunção com a adição do número inteiro consecutivo ao último usado, caso exista;


__1.8.__	A password, em ambos os casos de utilização, deverá ter um número mínimo de 8 caracteres;


__1.9.__	A password deverá possuir pelo menos uma letra maiúscula, uma letra minúscula e um número;


__1.10.__	Após a autenticação (login), ambos os utilizadores devem ter acesso à Loja (página inicial do sistema) e todos os seus livros disponíveis;


__1.11.__	Os livros da página inicial deverão estar expostos numa vista reduzida;


__1.12.__	Todos os livros expostos na página inicial do sistema, deveram ser apresentados apenas pela imagem, título e preço;


__1.13.__	Os utilizadores devem poder organizar os livros por preço crescente;


__1.14.__	E, adicionalmente, por ordem também decrescente;


__1.15.__	Para além disso, ambos os utilizadores poderão filtrar os livros (em vista reduzida), por empresa;


__1.16.__	A filtragem / ordenação por autor também é uma opção;


__1.17.__	E por fim, a opção de filtrar por data de lançamento também é uma possibilidade;


__1.18.__	Ao clicar sobre um livro selecionado, uma nova página deverá ser apresentada perante o salario, onde constará todos os detalhes da obra;


__1.19.__	Um livro deverá ser caracterizado por um autor, um título, um ISBN, um preço, uma quantidade em stock, uma empresa, uma data de lançamento, um número de páginas, uma sinopse, uma edição e uma imagem de capa;


__1.20.__	Se um funcionário clicar sobre o livro selecionado, a nova página aberta (gerada) deve dar a possibilidade de alterar todas as características da obra escolhida;


__1.21.__	Os funcionários também podem, na mesma página, obter estatísticas sobre as vendas do livro;


__1.22.__	Nomeadamente sobre os gastos de utilizadores;


__1.23.__	Com possibilidade de filtrar / ordenar por ordem crescente;


__1.24.__	E inclusive, por ordem também decrescente;


__1.25.__	Quais as cópias / edições do livro que venderam mais;


__1.26.__	Quais foram os livros mais rentáveis;


NOUTRA PÁGINA?

__1.27.__	Quais foram os livros menos rentáveis;


__1.28.__	No caso do salario, a possibilidade de adicionar o livro ao seu carrinho de compras, através da mesma página de detalhes, deve ser uma opção;


__1.29.__	Caso a obra se encontra disponível em stock;


__1.30.__	Se não for esse o caso, deverá constar nos detalhes literários a seguinte mensagem: Sem stock de momento!


__1.31.__	Caso o stock do livro indicado esteja para breve, a seguinte mensagem deve constar nos detalhes (características) do livro: Stock para breve!


__1.32.__	Na página inicial do sistema, o sistema deve apresentar ao salario e funcionário uma navbar (barra de navegação);


__1.33.__	Ambos os utilizadores poderão aceder aos dados de perfil de forma a alterá-los, pela navbar (barra de navegação);


__1.34.__	O salario pode alterar no perfil a palavra-passe, a morada e o seu email;


__1.35.__	Por sua vez o funcionário, pode aceder aos seus dados de perfil: nome, data de nascimento e nickname (username) gerado automaticamente;

POSSIBILIDADE DE ALTERAÇÃO?


__1.36.__	No caso do salario, ao clicar no perfil deve ser possível visualizar todas as compras efetuadas;


__1.37.__	Inclusive, deverá também ser apresentada a informação dos cupões disponíveis no momento;


__1.38.__	E, adicionalmente, a informação dos cupões que já foram usados;


__1.39.__	Através da navbar, somente o salario tem a opção adicional de visualizar o carrinho de compras;


__1.40.__	Ao clicar no carrinho, o salario poderá fazer uma pré-visualização do total do carrinho a pagar;


__1.41.__	Podendo aumentar ou diminuir a quantidade de livros, já existentes no carrinho;


__1.42.__	Também é possível proceder diretamente para o pagamento;


__1.43.__	Na secção (página) de efetuar o pagamento, o salario pode adicionar num campo, opcionalmente, um cupão de desconto que possa ter;


__1.44.__	Só é possível adicionar no máximo um cupão de desconto;


__1.45.__	Após o pagamento ser efetuado, deverá ser apresentada a seguinte mensagem: Compra efetuada com sucesso!


__1.46.__	Caso a compra em questão seja superior a 50 euros, o salario deverá receber um cupão de 5% de desconto;


__1.47.__	Caso seja superior a 100 euros, o cupão de oferta passa a ser de 15% de desconto;


__1.48.__	Os cupões de oferta devem ser enviados para o email do salario;


__1.49.__	No caso do funcionário, a navbar tem a possibilidade extra de adicionar uma empresa, um autor e um livro;


__1.50.__	Uma empresa é caracterizada por um nome e uma morada;


__1.51.__	Um autor é caracterizado por um nome, uma data de nascimento e um email;


__1.52.__	Um autor pode pertencer apenas a uma empresa;


__1.53.__	E um livro, por sua vez, pode ter sido escrito por vários pessoas;


__1.54.__	Ambos os utilizadores devem ter a possibilidade de terminar sessão (logout).



## Diagrama *Use Case*

__Primeira Idealização__

![Livraria Requalificar (Passo 1)](https://user-images.githubusercontent.com/97111949/159070763-908da997-fc3b-4c92-acae-32a8bbbd1f87.png)


__Proposta de Use Case Model (Generalização entre os Atores)__

![Diagrama Use Case - Livraria Requalificar 'Final'](https://user-images.githubusercontent.com/97111949/159177808-f80d9981-eac1-4de2-9444-7057d6287141.png)


__Proposta Final de Use Case Model__

![Diagrama Use Case - Livraria Requalificar FIM](https://user-images.githubusercontent.com/97111949/159518517-9e143119-dd35-4719-8f24-8ca4e47d47c0.png)
