<%-- 
    Document   : admin
    Created on : 23/09/2018, 19:05:01
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Tela Admin</title>
  </head>

  <style>
  
    .nav-tabs .nav-link {
        border: 1px solid transparent;
        /* border-top-left-radius: .25rem; */
        border-top-right-radius: .25rem;
    }
    .nav-tabs li a {
        color: white;
        background-color: #ff0000;
        font-size: 0.875rem;
        font-family: open_sans_regular;
    }
    .tab-content {
        -webkit-border-radius: 3px;
        -moz-border-radius: 3px;
        -ms-border-radius: 3px;
        -o-border-radius: 3px;
        border-radius: 3px;
        border: 1px solid #dddddd;
        border-bottom-width: 3px;
        padding: 15px;
        margin-bottom: 15px;
        border-top-left-radius: 0;
    }
    button:hover {
        background-color:#d9d9d9;
        color: white;
    }
    .voltaHome:hover {
        color: white !important;
    }
  
  </style>
  <body>
        
        <div class="col-md-10 offset-md-1 pt-4">
            <ul class="nav nav-tabs">
                <li class="active nav-item">
                    <a class="nav-link active " href="#gerar_contrato" data-toggle="tab">Gerar Contrato</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link btn-red" href="#reservas" data-toggle="tab">Reservas</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="#receber_veiculos" data-toggle="tab">Receber Veículos</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="#inserir_veiculo" data-toggle="tab">Inserir Veiculos</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link teste" href="#veiculos_reservados" data-toggle="tab">Veiculos Reservados</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" href="#veiculos_disponiveis" data-toggle="tab">Veiculos Disponívies</a>
                </li>
            </ul>
            
            <div class="tab-content">
                <div class="tab-pane active in" id="gerar_contrato">
                    <!-- GERAR CONTRATO -->
                    <form action="/AbrirContrato" method="POST">
                        <div class="form-group row">
                            <label class="col-sm-5"> Codigo da Reserva:</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="" placeholder="" name="id_reserva">
                            </div>
                            
                            <div class="col-sm-12">
                                <hr>
                            </div>
                            <label for="" class="col-sm-4 mt-2">Valor Pago Antecipadamente:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="valor_pag_ant">
                            </div>
                        </div>
                        <!--<button class="btn btn-muted" id="">Procurar</button>-->
                        <button type="submit" class="btn btn-muted" id="">Gerar</button>
                        <a href="/" class="btn voltaHome" style="float:right;color:black;background-color: #d9d9d9">Voltar pra Pagina Principal</a>

                    </form>
                </div>
                <div class="tab-pane" id="reservas">
                    <!-- RESERVA -->
                    <form>
                        <div class="form-group row">

                            <label for="" class="col-sm-3">Dados do Usuário:</label>
                            <label for="" class="col-sm-2 mt-2">Nome:</label>
                            
                            <div class="col-sm-7">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>


                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Sobrenome:</label>
                            
                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">CPF:</label>
                            
                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Endereço:</label>
                            
                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Código de Registro:</label>
                            
                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>
                                
                            <div class="col-sm-12">
                                <hr>
                            </div>
                            
                            <label for="" class="col-sm-4 mt-2">Horário de Inicio:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Término Previsto:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Valor Total Previsto:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Categoria do Carro</label>
                            
                            <div class="col-sm-8 mt-2">
                                <select class="form-control">
                                    <option>Popular</option>
                                    <option>Luxo</option>
                                    <option>Esportivo</option>
                                </select>
                            </div>

                        </div>

                        <button class="btn btn-muted" >Procurar</button>
                        <button class="btn btn-muted" >Alterar</button>
                        <button class="btn btn-muted" >Criar</button>
                        <button class="btn btn-muted" id="btnDel">Deletar</button>
                    </form>
                </div>
                <div class="tab-pane" id="receber_veiculos">
                    <!-- RECEBER VEICULO -->
                    <form>
                        <div class="form-group row">
                            <label for="" class="col-sm-4 col-form-label">Código de Reserva:</label>
                            
                            <div class="col-sm-8 mb-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Data de devolução:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Conservação:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Kilometragem:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                            <label for="" class="col-sm-4 mt-2">Acréscimo $$:</label>
                            
                            <div class="col-sm-8 mt-2">
                                <input type="text" class="form-control" id="" placeholder="">
                            </div>

                        </div>

                        <button class="btn btn-muted" >Procurar</button>
                        <button class="btn btn-muted" >Gerar</button>
                    </form>
                </div>
                <div class="tab-pane" id="inserir_veiculo">
                    <form action="/CadastroVeiculo" method="POST">
                        
                        <div class="form-group row">
                            
                            <label for="" class="col-sm-3">Dados do Carro</label>
                           
                            <label for="" class="col-sm-2">Categoria:</label>

                            <div class="col-sm-7">
                                <select class="form-control" name="categoria">
                                    <option value="Economico">Economico</option>
                                    <option value="Intermediario">Intermediário</option>
                                    <option value="Luxo">Luxo</option>
                                </select>
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Ano:</label>

                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="ano">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Placa:</label>

                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="placa">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Modelo:</label>

                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="modelo">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Fabricante:</label>

                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="fabricante">
                            </div>

                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Cor:</label>

                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="cor">
                            </div>
                            
                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-2 mt-2">Quilometragem:</label>

                            <div class="col-sm-7 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="kilometragem">
                            </div>
                            
                            <label for="" class="col-sm-3"></label>
                            <label for="" class="col-sm-3 mt-2">Estado de Conservação:</label>

                            <div class="col-sm-6 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="conservacao">
                            </div>
                            
                            <label for="" class="col-sm-3"> </label>
                            <label for="" class="col-sm-3 mt-2">Tanque de Combustivel:</label>

                            <div class="col-sm-6 mt-2">
                                <input type="text" class="form-control" id="" placeholder="" name="combustivel">
                            </div>
                            
                            <div class="col-sm-12">
                                <button type="submit" class="btn btn-muted">Inserir</button>
                            </div>
                        </div>
                    </form>
                </div>
                
                <div class="tab-pane" id="veiculos_reservados">
                    <div class="row" id="div_veiculos_reservados">
                        
                    </div>
                </div>
                
                <div class="tab-pane" id="veiculos_disponiveis">
                    <div class="row" id="div_veiculos_disponiveis">
                        
                    </div>
                </div>
                
            </div>
        </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <script>
        
        $(document).ready(function(){
                
            var status_abrir_contrato = <%= request.getAttribute("status_abrir_contrato")%>
            var status_abrir_contrato_err = <%= request.getAttribute("status_abrir_contrato_err")%>
            
            var status_cadastro_veiculo = <%= request.getAttribute("status_cadastro_veiculo")%>
            var status_cadastro_veiculo_err = <%= request.getAttribute("status_cadastro_veiculo_err")%>
            
    
            var listaCarrosDisponiveis = <%= request.getAttribute("jsonListaCarrosDisponiveis")%>
            var listaCarrosNaoDisponiveis = <%= request.getAttribute("jsonListaCarrosNaoDisponiveis")%>
            
            if(status_abrir_contrato){
                alert("contrato gerado com sucesso!")
            }
            if(status_abrir_contrato_err){
                alert("Erro ao abrir contrato")
            }
            if(status_cadastro_veiculo){
                alert("Veiculo cadastrado com sucesso!")
            }
            if(status_cadastro_veiculo_err){
                alert("Erro ao cadastrar veiculo")
            }
            
            if(listaCarrosDisponiveis){
                console.log("CARROS DISPONIVEIS == ", listaCarrosDisponiveis)
                
                var htm  = ''
                
                listaCarrosDisponiveis.map(e => {
                    htm += '<div class="col-md-6 mt-2">'
                    htm += '<div class="card">'
                    htm += '<div class="card-body">'
                    htm += '<h1>' + e.modelo + '</h1>'
                    htm += '<p>' + e.fabricante + '</p>'
                    htm += '<p>' + e.ano + '</p>'
                    htm += '</div>'
                    htm += '</div>'
                    htm += '</div>'
                    $('#div_veiculos_disponiveis').html(htm)
                    
                })
                
            }
            
            if(listaCarrosNaoDisponiveis){
                
                console.log("CARROS NAO DISPONIVEIS", listaCarrosNaoDisponiveis)
                
                var htm2 = ''
                listaCarrosNaoDisponiveis.map(e => {
                        
                    
                    htm2 += '<div class="col-md-6 mt-2">'
                    htm2 += '<div class="card">'
                    htm2 += '<div class="card-body">'
                    htm2 += '<h1>' + e.modelo + '</h1>'
                    htm2 += '<p>' + e.fabricante + '</p>'
                    htm2 += '<p>' + e.ano + '</p>'
                    htm2 += '</div>'
                    htm2 += '</div>'
                    htm2 += '</div>'

                    $('#div_veiculos_reservados').html(htm2)
                    
                    
                })
            }
            
        })
        
        
        
        
    </script>
    
    
  
  
  </body>
</html>