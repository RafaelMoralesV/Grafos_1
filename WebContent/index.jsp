<%@ page import="trabajo.Grafo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body bgcolor=black>
		<table border="10">
			<tr align=center style="color:white;">
				<td>
					<form action="GrafosServlet" method="get">
						Nombre su vertice: <input type="text" name="nombreVertice"><br />
						<input type="submit" value="Enviar nombre">
					</form>
				</td>
				<td>
					<form action="GrafosServlet" method="get">
						Vertice 1: <input type="text" name="aristaA"><br />
						Vertice 2: <input type="text" name="aristaB"><br />
						<input type="submit" name="dir" value="Arista Direccionada">
						<input type="submit" name="bidir" value="Arista Bidireccional">
					</form>
				</td>
			</tr>
		</table>
		
		
	</body>
</html>