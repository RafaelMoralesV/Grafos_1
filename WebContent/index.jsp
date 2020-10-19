<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Grafo Basico</title>
	</head>
	<body bgcolor=black style="color:white">
		<table border="10">
			<tr align=center>
				<td>
					<form action="GrafosServlet" method="post">
						Nombre su vertice: <input type="text" name="nombreVertice"><br />
						<input type="submit" value="Enviar nombre">
					</form>
				</td>
				<td>
					<form action="GrafosServlet" method="post">
						Vertice 1: <input type="text" name="aristaA"><br />
						Vertice 2: <input type="text" name="aristaB"><br />
						Peso (Vacio = 1): <input type="number" step="0.01" name="peso"><br />
						<input type="submit" name="dir" value="Arista Direccionada">
						<input type="submit" name="bidir" value="Arista Bidireccional">
					</form>
				</td>
			</tr>
		</table>
		
		<br>
		
		<!-- CODIGO AJAX JQUERY -->
		<script src="http://code.jquery.com/jquery-1.10.2.js"
		       type="text/javascript"></script>
		   <script src="js/app-ajax.js" type="text/javascript"></script>
        <script>
        	function myFunction(com){
        		$.ajax({
        			url : 'GrafosServlet',
		            tpye: "GET",
		            data: {
		            	command: com
		            },
		            success : function(responseText) {
		            	document.getElementById("ajaxGetUserServletResponse").innerHTML = responseText.replaceAll("\n", "<br>");
		            }
        		});
        	}
        </script>
        <h1>Mostrar: </h1>
        <button onClick="myFunction('matrizAdy')">Matriz de caminos</button>
        <button onClick="myFunction('matrizPeso')">Matriz de Pesos</button>
        <button onClick="myFunction('hamiltoneano')">Camino Hamiltoneano</button>
        <button onClick="myFunction('MST')">Arbol Generador Minimo</button>
        <br><hr><br>
        
        <script>
        	function myOtherFunction(com){
        		var ini = $("#inicio").val();
        		var destino = $("#fin").val();
        		$.ajax({
        			url : 'GrafosServlet',
		            type: "GET",
		            cache = false,
		            data: { command: com},
		            success : function(responseText) {
		            	document.getElementById("ajaxGetUserServletResponse").innerHTML = responseText.replaceAll("\n", "<br>");
		            }
        		});
        	}
        </script>
        <form>
	        Vertice inicial: <input type="text" name="inicio"><br />
	        Vertice final: <input type="text" name="fin"><br />
	        <input type="submit" name="post" value="Confirmar">
        </form>
        <button onClick="myOtherFunction('dijkstra')">Camino mas corto</button>
        <button onClick="myOtherFunction('flujo')">Flujo maximo</button>
        <br>
        <br> 
        <strong>Resultado</strong>:
        <p id="ajaxGetUserServletResponse"></p>	
	</body>
</html>