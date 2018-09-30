<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- CSS -->
        <link rel="stylesheet" href="../static/css/home_style.css">

        <!--Font Awesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

        <!--Fonte-->
        <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">

        <title>Tela Home</title>
    </head>

    <!-- Fazer uma calsse input e colocar o style do search la-->

    <body>

        <div>
            <input type="text" width="20%" placeholder="Pesquise koyata" class="inputStyle">
            <i class="fas fa-search" style="margin-top:2px"></i>
        </div>

        <img id="imagem_fundo" src="../static/images/koyata.png" class="center" style="margin-top:15%">

        <div id="fundo1" hidden style="">

            <h1 style="text-align:center"> Koyota </h1>
            <p>Há muito tempo eu ouvi dizer
                Que um homem vinha pra nos mostrar
                Que todo o mundo é bom
                E que ninguém é tão ruim

                O tempo voa e agora eu sei
                Que só quiseram me enganar
                Tem gente boa que me fez sofrer
                Tem gente boa que me faz chorar, me faz chorar

                Agora eu sei e posso te contar, posso te contar
                Não acredite se ouvir também
                Que alguém te ama e sem você
                Não consegue viver, não consegue viver

                Quem vive, mente
                Mesmo sem querer, mesmo sem querer
                E fere o outro, não pelo prazer
                Mas pela evidente razão, sobreviver

                Não é possível mais ignorar
                Que quem me ama me faz mal demais
                Mas ainda é cedo pra saber
                Se isso é ruim ou se é muito bom

                O tempo voa e agora eu sei
                Que só quiseram me enganar
                Tem gente boa que me fez sofrer
                Tem gente boa que me faz chorar, me faz chorar</p>
            <button id="voltar_home" class="center btn"> voltar </button>

            <hr class="mt-5"/>
        </div>

        <div>
            <div style="width: 100%; overflow:hidden; margin-bottom: 150px">
                <div style="width: 5%; float:left">
                    <ul>
                        <a id="li1" href="#div1"><li></li></a>
                        <a id="li2" href="#div2"><li></li></a>
                        <a id="li3" href="#div3"><li></li></a>
                        <a id="li4" href="#div4"><li></li></a>
                    </ul>
                </div>
                <div style="width: 95%;">
                    <button id="btnCadastro" class="btn center mt-5"> CADASTRAR</button>
                    <button id="btnLogin" class="btn center mt-1"> ENTRAR</button>


                </div>
            </div>
        </div>

        <!-- Cadastro Modal -->
        <div id="cadastro" class="modal">
            <!-- Modal content -->
            <div class="modal-content" style="border-radius:20px;text-align:center">
                <span class="close">×</span>
                <h3 style="text-align:center">Cadastro</h3>
                <form action="/CadastroCliente" method="POST">
                    <div style="white-space:nowrap">
                        <label style="">Nome Completo</label>
                        <input type="text" name="nome" class="inputStyle">
                    </div>
                    <div style="white-space:nowrap">
                        <label>RG</label>
                        <input type="text" name="rg" class="inputStyle">
                    </div>
                    <div>
                        <label>CPF</label>
                        <input type="text" name="cpf" class="inputStyle">
                    </div>
                    <div>
                        <label>Endereço</label>
                        <input type="text" name="endereco" class="inputStyle">
                    </div>
                    <div>
                        <label>Email</label>
                        <input type="text" name="email" class="inputStyle">
                    </div>
                    <div>
                        <label>Senha</label>
                        <input type="password" name="senha" class="inputStyle">
                    </div>
                    <button class="btn mt-1" type="submit">Cadastrar</button>
                </form>
            </div>
        </div>

        <!-- Login Modal -->
        <div id="login" class="modal">
            <!-- Modal content -->
            <div class="modal-content" style="border-radius:20px;text-align:center" >
                <span class="close closeL">×</span>
                <h3 >Entrar</h3>
                <form action="/login" method="POST">
                    <div>
                        <label>Login</label>
                        <input type="text" name="usuario">
                    </div>
                    <div>
                        <label>Senha</label>
                        <input type="password" name="senha">
                    </div>
                    <button type="submit" class="btn mt-1">Entrar</button>
                </form>
            </div>
        </div>


        <script>

            // mudar fundo ao clicar nos li
            primeiroLi = document.getElementById('li1');
            img_fundo = document.getElementById('imagem_fundo');
            fundo1 = document.getElementById('fundo1');


            document.getElementById('voltar_home').onclick = function () {
                img_fundo.style.display = "block";
                fundo1.style.display = "none";
                location.assign("/");
            };

            primeiroLi.onclick = function () {
                img_fundo.style.display = "none";
                fundo1.style.display = "block";
            };


            // escondendo as divs do modal
            window.onclick = function (event) {
                if (event.target === modal || event.target === modalL) {
                    modal.style.display = "none";
                    modalL.style.display = "none";
                }
            };

            // pegando as divs 
            var modal = document.getElementById('cadastro');
            var modalL = document.getElementById('login');

            // abrindo modal pelo botao
            var btn = document.getElementById("btnCadastro");
            var btnL = document.getElementById("btnLogin");

            btn.onclick = function () {
                modal.style.display = "block";
            };

            btnL.onclick = function () {
                modalL.style.display = "block";
            };
            //

            // fechando modal
            var span = document.getElementsByClassName("close")[0];
            var spanL = document.getElementsByClassName("closeL")[0];

            span.onclick = function () {
                modal.style.display = "none";
            };

            spanL.onclick = function () {
                modalL.style.display = "none";
            };
            //

        </script>
    </body>	
</html>