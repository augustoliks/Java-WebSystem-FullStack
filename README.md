# Sistema web para uma locadora de veículos

Desenvolvedores:

> * Carlos Augusto dos Santos Neto (visite o seu [github](https://github.com/augustoliks))
> * Gabriel Koyama Alves (visite o seu [github](https://github.com/Gabrielkoyamao))

---

# Requisitos do Sistema

> * 1: Utilizar a linguagem Java (Versão 8 ou superior) no back end;
> * 2: Utilizar DAO ou JPA com provedor Hibernate (5 ou superior) para persistência de dados;
> * 3: Utilizar o padrão de projeto MVC na arquitetura do sistema;
> * 4: Utilizar Servlets anotados ou com descritor de implantação;
> * 5: Utilizar Java Server Pages para criar páginas dinâmicas (tipo templates);
> * 6: Utilizar JavaScript (JS) no front end;
> * 7: Utilizar JS Closures;
> * 8: Utilizar JS DOM Handlers;
> * 9: Utilizar JS event listeners;
> * 10: Utilizar JS para criar dinamicamente elementos no DOM.
> * 11: Utilizar métodos da JQuery;
> * 12: Utilizar marcação HTML 5 com sintaxe e semântica adequados;
> * 13: Utilizar CSS 3 no front end;
> * 14: Utilizar CSS 3 com fonte externa nas interfaces;
> * 15: Utilizar CSS 3 media queries;
> * 16: Utilizar CSS 3 para deixar o sistema “minimamente responsivo”;
> * 17: Utilizar as bases de dados MySQL ou MariaDB para persistência de dados;
> * 18: Utilizar o Apache TomCat como web container;

---


# Diagrama de caso de uso

![diagrama-caso-uso.jpg](.images/diagrama-caso-uso.jpg)


# Comportamento esperado das funcionalidades 

Mínimos além dos que são evidentes pelo diagrama

> * UC.1. CRUD das reservas.
> * UC.2. Criar e abrir um contrato de locação (deve exigir um valor pago antecipadamente igual ao valor previsto para a reserva);
> * UC.3. Deve fechar o contrato de locação, inserindo eventuais valores devidos e atualizando os dados do carro no momento da devolução (ex. Estado de conservação, quilometragem, tanque, etc.)
> * UC.4. Visualizar quais carros estão alugados e quais estão disponíveis.

---

# Detalhamento aplicável (Entidades):

Requisitos de dados (mínimos além dos que são evidentes pelo diagrama):

**CARRO:** 
> * categoria 
> * ano 
> * placa
> * modelo
> * fabricante
> * cor
> * estado de conservação, 
> * quilometragem
> * tanque de combustível (preenchimento);

**RESERVA:** 
> * Código de reserva
> * Dados do usuário
> * Hora de início e término previsto, 
> * Valor total previsto, 
> * Categoria de carro ou carro específico.

**ALUGUEL DE CARRO (CONTRATO)** 
> * Dados do cliente
> * Dados do carro, 
> * Hora de retirada, 
> * Hora de devolução, 
> * valor total da reserva, 
> * valor pago antecipadamente, 
> * valor pago na devolução.
