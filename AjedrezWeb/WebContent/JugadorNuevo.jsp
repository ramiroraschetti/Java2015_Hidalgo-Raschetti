<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{
	background:#A1CCFF;
	text-align: center;
}

</style>
<title>..::: Jugador Nuevo :::..</title>
</head>
<body>
<div class="contenedor">
	<div class="titulo">
    <h1> Ingrese datos del nuevo jugador </h1>
    </div>	
    
    <div class="formulario">
          <form class="form-jugadorNuevo" name="formJugadorNuevo" action="newJugador" method="post">
	            <label for="Dni">Dni :</label>
	            <input name="Dni" type="text" autofocus="autofocus" id="Dni" size="8" maxlength="8" style="text-align:left"
	            value="<%  if( request.getAttribute("dni") == null) 
	            				out.println(" ");
	            				else out.println(request.getAttribute("dni"));%>"/> 
	             </br></br>
	             <label for="Nombre">Nombre :</label>
	               <input name="Nombre" type="text" autofocus="autofocus" id="Nombre" style="text-align:left" />
	             </br></br>
	             <label for="Apellido">Apellido :</label>
	            <input name="Apellido" type="text" autofocus="autofocus" id="Apellido" style="text-align:left" />
	            </br></br>
	            <input type="button" value="Atrás" name="atrás" onclick="history.back()" />
	            <input type="reset" value="Limpiar" />
				<input name="guardar" type="submit" id="guardar"  value="Guardar" />
        
            </form>
	</div>

</div>
</body>
</html>