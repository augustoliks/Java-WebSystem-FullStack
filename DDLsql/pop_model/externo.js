
var x = document.getElementById("p1")

window.onload =  function(){


	var a  = document.getElementById("bot01")
	var btnAparace =  document.getElementById("aparece")
	var btnDesaparece =  document.getElementById("desaparece")
	
	var dinamico = document.getElementById("din")

	a.onclick = function(){
		x = document.getElementById("din")
		x.innerHTML += '<button id="lucas" onclick="a()">Carlinhos</button> '
	}

	function a(){
		console.log("aa")
	}

	btnAparace.onclick = function(){
		dinamico = document.getElementById("din")
		dinamico.innerHTML = "<button>BTN</button>"

	}

	btnDesaparece.onclick = function(){
		dinamico = document.getElementById("din")
		dinamico.innerHTML = ""

	}

}

