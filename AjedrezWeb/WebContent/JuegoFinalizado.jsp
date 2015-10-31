<%@page import="Entidades.Partida"%>
<%@page import="Entidades.Pieza"%>
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
<title>..::: Partida Finalizada :::..</title>
</head>
<body>
<% Partida partidaSession = (Partida)session.getAttribute("partidaSession"); %>
<div class="contenedor">
	<div class="mensaje">
	<h1 id="titulo"> Partida terminada!! </h1>
    <h2 id="ganado"> Ganó <%for(Pieza pi : partidaSession.getPiezasPartida()){
    							if(pi.getNombre() == 'R' && pi.isEstadoPieza() == false){
    								if(pi.getColor().equalsIgnoreCase("blanca")){
    									out.println(partidaSession.getJugador2().getNombre()+" "+partidaSession.getJugador2().getApellido());}
    												else if(pi.getColor().equalsIgnoreCase("negra")){
    														out.println(partidaSession.getJugador1().getNombre()+" "+partidaSession.getJugador1().getApellido());} 
    							}}%>
    	   </h2>
    <%session.invalidate(); %>
    <a href="InicioAjedrez.html" id="link"> INICIAR NUEVA PARTIDA</a> 
	</div>
</div>

</body>
</html>