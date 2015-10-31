<%@page import="Entidades.Partida"%>
<%@page import="Entidades.Pieza"%>
<%@page import="Controlador.CtrlJugar"%>
<%@page import= "java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
body{
	background:#A1CCFF;
}
.contenedor{
	width:70%;
	margin:auto;
	
	
}
.titulo{
	font-family:Courier New;
	text-align:center;
	}
.lateral-izq{
	float:left;
	width:69%;
	padding:0;
	border-right:dotted;
	}
.lateral-der{
	float:right;
	width:29%;
	height: 100%;
	
	}
.blancas{
	float:left;
	width: 49%;
	text-align:center;
	}
.negras{
	float:right;
	width: 49%;
	text-align:center;
	padding-right:2%;}
#Origen{
	
	}
#Destino{
	
	}
#titError{
color:black;}
.msgError{
	color:red;
	font-weight: bold;
}
.Pie{
  
 }

	
	
</style>
<title>..:::Partida Ajedrez:::..</title>
</head>
<body>
<% Partida partidaSession = (Partida)session.getAttribute("partidaSession"); %>
<%Controlador.CtrlJugar cj= new CtrlJugar(); %>

<div class= "contenedor">
	<div class= "titulo" id="titulo">
     <h1> Partida de Ajedrez </h1>
    </div>
		<div class= "lateral-izq">
	    	<div class="blancas">
	     	 <p>Piezas Blancas </p>
	    	<%
	    	ArrayList<Pieza> listPiezas = new ArrayList<Pieza>();
			
			listPiezas = cj.buscarPiezas(partidaSession);
			partidaSession.setPiezasPartida(listPiezas);
			
			for (Pieza a : listPiezas){
				if("blanca".equals(a.getColor())){
						
						out.println(a.getNombre()+" - "+a.getPosicion().getPosColumna()+a.getPosicion().getPosFila()+"<br/>");}}
			
		%>
	        </div>
	        <div class="negras">
	    	 <p>Piezas Negras </p>
	      <%
	    	ArrayList<Pieza> listPiezas2 = new ArrayList<Pieza>();
			
			listPiezas2 = cj.buscarPiezas(partidaSession);
			partidaSession.setPiezasPartida(listPiezas);
			
			for (Pieza a : listPiezas2){
				if("negra".equals(a.getColor()))
					out.println(a.getNombre()+" - "+a.getPosicion().getPosColumna()+a.getPosicion().getPosFila()+"<br/>");;}
			
		%>
	        </div>
		</div>
	    <div class="lateral-der">
	     	<div class="datos-Partida">
		        <p>Jugador 1:<%=partidaSession.getJugador1().getNombre()+" "+partidaSession.getJugador1().getApellido() %> </p>
		        <p>Jugador 2:<%=partidaSession.getJugador2().getNombre()+" "+partidaSession.getJugador2().getApellido() %> </p>
		        <p>Numero de Partida: <%= partidaSession.getIdPartida() %></p>
		        
		        <p>Turno : <%=partidaSession.getTurno() %></p>
	      	</div>
	        <div class="movimiento">
		        <form class="form-movimiento" name="formMover" action="movimiento" method="post">
			        <label for="Origen">Origen : </label>
			        <input name="Origen" type="text" autofocus="autofocus" id="Origen" size="1" maxlength="2" style="text-align:center" />
			        </br></br>
			        <label for="Destino">Destino:</label>
			        <input name="Destino" type="text" autofocus="autofocus" id="Destino" size="1" maxlength="2" style="text-align:center" />
			        </br></br>
			        <input type="reset" value="Limpiar" />
			        <input name="mover" type="submit" id="mover"  value="Mover" />
		        </form>
	      </div>
	     <div class="msgError" ><p id="titError">Mensaje: </p><%=request.getAttribute("msgError") %></div>
	    </div>
	 
	    <div class="pie">
	   
	    </div>
</div>
</body>
</html>