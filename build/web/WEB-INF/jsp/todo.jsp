<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="static/css/estilos.css"/>
        <title>Todo</title>
    </head>
    <body>
        
        <%@include file="navbar.jsp"%>
      
        <h3>Operador:</h3>
        Gerenciar Reservas
        Alugar Carro reservado
        Receber Carro Alugado
        Visualizar situação da frota
        
        <h3>Cliente</h3>
        Reservar Carro
        
        
        <h3> Detalhamento aplicável: </h3>
        Carro: categoria, ano, placa, modelo, fabricante, cor, estado de conservação, quilometragem, tanque de
combustível (preenchimento);
        <br/>
        Reserva: Código de reserva, dados do usuário, hora início, término previsto, valor total previsto, categoria
de carro ou carro específico.
        <br/>
        Aluguel de carro (contrato): Dados do cliente, dados do carro, hora de retirada, hora de devolução, valor
total da reserva, valor pago antecipadamente, valor pago na devolução.

        
        
        <h3> Comportamento esperado das funcionalidades (mínimos além dos que são evidentes pelo diagrama): </h3>
UC.1. CRUD das reservas.
UC.2. Criar e abrir um contrato de locação (deve exigir um valor pago antecipadamente igual ao valor
previsto para a reserva);
UC.3. Deve fechar o contrato de locação, inserindo eventuais valores devidos e atualizando os dados do
carro no momento da devolução (ex. Estado de conservação, quilometragem, tanque, etc.)
UC.4. Visualizar quais carros estão alugados e quais estão disponíveis.

        
        
        
    </body>
</html>
