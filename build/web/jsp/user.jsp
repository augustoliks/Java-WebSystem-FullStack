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
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		<title>Tela Usuário</title>
	</head>
	<body>

		<div class="row">
			<div class="col-md-6 mt-1">
                            <a href="/" class="btn" style="color:#000000" ><i class="fas fa-home"></i></a>
                            <button class="btn btn-danger">Meus Pedidos</button>
			</div>	

			<div class="col-md-6 text-right">
				<a href="#" class="mr-3 btn" style="text-decoration: none;color: black"><i class="far fa-user" style="font-size:30px;color:black"></i> ${nome}</a>
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
				
				<div class="row offset-md-3 mt-4">
					<p class="mt-1 mr-3">Categoria:</p>
					<select class="form-control col-md-3" name="" id="">
						<option value="">Popular</option>
						<option value="">Esportivo</option>
						<option value="">Luxo</option>
					</select>
				</div>
				<button class="btn btn-danger btn-sm offset-md-5 mt-4">Pesquisar</button>
				
			</div>
		</div>

		<div class="col-md-12">
			<div class="row">
				<div class="col-md-4 mt-2">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">NOME DO CARRO</h5>
							<h6 class="card-subtitle mb-2 text-muted">TIPO DO CARRO</h6>
							<p class="card-text">DESCRICAO </p>
							<a href="#" class="btn btn-danger btn-sm">Reservar</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 mt-2">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">NOME DO CARRO</h5>
							<h6 class="card-subtitle mb-2 text-muted">TIPO DO CARRO</h6>
							<p class="card-text">DESCRICAO </p>
							<a href="#" class="btn btn-danger btn-sm">Reservar</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 mt-2">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">NOME DO CARRO</h5>
							<h6 class="card-subtitle mb-2 text-muted">TIPO DO CARRO</h6>
							<p class="card-text">DESCRICAO </p>
							<a href="#" class="btn btn-danger btn-sm">Reservar</a>
						</div>
					</div>
				</div>

				<div class="col-md-4 mt-2">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">NOME DO CARRO</h5>
								<h6 class="card-subtitle mb-2 text-muted">TIPO DO CARRO</h6>
								<p class="card-text">DESCRICAO </p>
								<a href="#" class="btn btn-danger btn-sm">Reservar</a>
							</div>
						</div>
					</div>
			</div>
		</div>

 	</body>	
</html>
