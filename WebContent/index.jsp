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
        	function myFunction(){
        		$.ajax({
        			url : 'GrafosServlet',
		            tpye: "POST",
		            success : function(responseText) {
		            	document.getElementById("ajaxGetUserServletResponse").innerHTML = responseText.replaceAll("\n", "<br>");
		            }
        		});
        	}
        </script>
        <button onClick="myFunction()">Mostrar matriz de caminos</button>
        <br>
        <br> 
        <strong>Ajax Response</strong>:
        <p id="ajaxGetUserServletResponse"></p>	
	</body>
</html>