<%-- 
    Document   : user
    Created on : 23/09/2018, 19:04:50
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <title>Tela Usuário</title>
    </head>

    <style type="text/css">
        .modal-dialog {
            max-width: 1000px;
            margin: 1.75rem auto;
        }
    </style>

    <body>
        <div class="row">
            <div class="col-md-6 mt-1">
                <button class="btn btn-light logout" style="color:#000000" ><i class="fas fa-home"></i></button>
                <button class="btn btn-danger" data-toggle="modal" data-target="#meus_pedidos">Meus Pedidos</button>
            </div>
            
            <!--    MEUS PEDIDOS    -->

            <div class="modal fade" id="meus_pedidos" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Meus Pedidos</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <h1 class="text-center mb-4 mt-4">Minhas reservas</h1>
                            <div class="col-sm-12 border" style="padding: 2rem" >
                                <h5>Nome do Carro: ${reserva.nome}</h5>
                                <h5>Valor Total: ${reserva.total}</h5>
                                <h5>Data de Devolução: ${reserva.devolucao}</h5>
                            </div>
                            <div class="col-sm-12 border mt-2" style="padding: 2rem" >
                                <h5>Nome do Carro: ${reserva.nome}</h5>
                                <h5>Valor Total: ${reserva.total}</h5>
                                <h5>Data de Devolução: ${reserva.devolucao}</h5>
                            </div>
                            <div class="col-sm-12 border mt-2" style="padding: 2rem" >
                                <h5>Nome do Carro: ${reserva.nome}</h5>
                                <h5>Valor Total: ${reserva.total}</h5>
                                <h5>Data de Devolução: ${reserva.devolucao}</h5>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Fechar</button>

                        </div>
                    </div>
                </div>
            </div>

           

            <div class="col-md-6 text-right">
                <a href="#" class="mr-3 btn" style="text-decoration: none;color: black"><i class="far fa-user" style="font-size:25px;color:black"></i> ${nome} </a>
            </div>
        </div>

        <div class="row pb-3">
            <div class="col-md-5" style="border:solid; border-width: 1px">
                <center>
                    <img src="../static/images/koyata.png" width="90%" h1eight="90%" class="mt-4">
                </center>
                <div class="row">
                    <div class="col-md-3">
                        <b>Passo 1</b>
                        <p style="font-size: 13px">Preencha os campos referentes a sua pesquisa</p>
                    </div>
                    <div class="col-md-4">
                        <b>Passo 2</b>
                        <p style="font-size: 13px">Clique em <b>RESERVAR</b> caso queria reservar o veículo</p>
                    </div>
                    <div class="col-md-5">
                        <b>Observações</b>
                        <p style="font-size: 13px">Valores são baseados em dias e/ou kilometragem conservação do carro é levado em conta no valor final</p>
                    </div>
                </div>
            </div>
            <div class="col-md-7" style="border:solid; border-width: 1px; border-left: none">

                <h4 class="text-center mt-4">Pesquisar o veiculo</h4>				
                <form action="/PesquisarVeiculos" method="GET">
                    <div class="row offset-md-3 mt-4">

                        <p class="mt-1 mr-3">Categoria:</p>
                        <select class="form-control col-md-3" name="categoria" id="">
                            <option value="Economico">Economico</option>
                            <option value="Intermediario">Intermediário</option>
                            <option value="Luxo">Luxo</option>
                        </select>
                    </div>
                    <button  type="submit" class="btn btn-danger btn-sm offset-md-5 mt-4">Pesquisar</button>
                </form>
            </div>
        </div>

        <div class="col-md-12">
            <div class="row rowcars"></div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

        <script>
            $(document).ready(function () {
                var carrosFilter = <%= request.getAttribute("jsonListaCarros")%>
                var htm = ''
                carrosFilter.map(el => {
                    htm += '<div class="col-md-4 mt-2">'
                    htm += '<div class="card">'
                    htm += '<div class="card-body">'
                    htm += '<form action="/ReservarVeiculo" method="POST">'
                    htm += '<h5 class="card-title"> Modelo: ' + el.modelo + '</h5>'
                    htm += '<h6 class="card-subtitle mb-2 text-muted"> Fabricante: ' + el.fabricante + '</h6>'
                    htm += '<p class="card-text"> Combustivel: ' + el.combustivel + '</p>'
                    htm += '<input type="hidden" name="id_veiculo" value=' + el.id + '>'
                    htm += ' <div>'
                    htm += '<label> Data Inicial </label>'
                    htm += '<input type="date" name="date_ini" id="date_ini"/>'
                    htm += '</div>'
                    htm += '<div>'
                    htm += '<label>Data Fim</label>'
                    htm += '<input type="date" name="date_fim" id="date_fim"/>'
                    htm += '</div>'
                    htm += '<button type="submit" class="btn btn-danger btn-sm">Reservar</a>'
                    htm += '</form>'
                    htm += '</div>'
                    htm += '</div>'
                    htm += '</div>'
                    $('.rowcars').html(htm)
                })
            })

            $(document).on('click', '.logout', function () {
                alert("Voce tem certeza que deseja sair da sua conta?")
                location.assign("/logout")
            })

        </script>
    </body>	
</html>
