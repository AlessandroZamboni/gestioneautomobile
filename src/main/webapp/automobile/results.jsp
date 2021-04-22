<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Pagina dei risultati</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-success alert-dismissible fade show ${successMessage==null?'d-none': ''}" role="alert">
		  ${successMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<!---------------------------------->
		<!-- ESEMPI DI ALERT DI BOOTSTRAP -->
		<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
		  Esempio di operazione fallita!
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
		  Aggiungere d-none nelle class per non far apparire
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<!--------   end  ------------------>
		<!---------------------------------->
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Lista dei risultati</h5> 
		    </div>
		    <div class='card-body'>
		    	<a class="btn btn-primary " href="PrepareInsertAutomobileServlet">Add New</a>
		    
		        <div class='table-responsive'>
		            <table class='table table-striped ' >
		                <thead>
		                    <tr>
		                        <th>Id</th>
		                        <th>Marca</th>
		                        <th>Modello</th>
		                        <th>Cilindarata</th>
		                        <th>Data Immatricolazione</th>
		                        <th>Azioni</th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<c:forEach var="auto_da_lista" items="${listaAutomobiliAttribute}">
                            <tr>
                                <td><c:out value="${auto_da_lista.id}"/></td>
                                <td><c:out value="${auto_da_lista.marca}"/></td>
                                <td><c:out value="${auto_da_lista.modello}"/></td>
                                <td><c:out value="${auto_da_lista.cilindrata}"/></td>
                                <fmt:formatDate type = "date" var="dataImmatricolazioneParsed" value ="${auto_da_lista.dataImmatricolazione}" pattern="yyyy-MM-dd"/>
                                <td><c:out value="${dataImmatricolazioneParsed}"/></td>
                            <td>
                                    <a class="btn  btn-sm btn-outline-secondary" href="ExecuteVisualizzaAutomobileServlet?idAutomobile=${auto_da_lista.id}">Visualizza</a>
                                    <a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateAutomobileServlet?idAutomobile=${auto_da_lista.id}">Edit</a>
                                    <a class="btn btn-outline-danger btn-sm" href="PrepareDeleteAutomobileServlet?idAutomobile=${auto_da_lista.id}">Delete</a>
                             </td>
                             
        						</tr>
		      				</c:forEach>   
		                </tbody>
		                	
		            </table>
		        </div>
		   
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>