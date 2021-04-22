<!doctype html>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Elimina elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettaglio
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Marca: </dt>
				  <dd class="col-sm-9">${automobileDaEliminare.marca}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Genere: </dt>
				  <dd class="col-sm-9">${automobileDaEliminare.modello}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cilindrata: </dt>
				  <dd class="col-sm-9">${automobileDaEliminare.cilindrata}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data Immatricolazione:</dt>
				  <fmt:formatDate var="dataImmatricolazioneParsed" value="${automobileDaEliminare.dataImmatricolazione}" type="date" pattern="yyyy-MM-dd"/>
				  <dd class="col-sm-9">${dataImmatricolazioneParsed}</dd>
		    	</dl>
		    	
		    </div>
		    
			<div class='card-footer'>
			    <form method="post" action="ExecuteDeleteAutomobileServlet" novalidate="novalidate">
			  	   <input type="hidden" name="idAutomobileDelete" value="${automobileDaEliminare.id}">
				    <button type="submit" name="submit" value="submit" id="submit" class="btn btn-danger btn-sm">Elimina</button>	
				    <a href="ListAutomobiliServlet" class='btn  btn-sm btn-outline-secondary'>
		           	 <i class='fa fa-chevron-left'></i> Annulla
		        	</a>			    
				</form> 				 
			</div>    
						
			   
		</div>		

	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>