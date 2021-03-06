<!doctype html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="it">
  <head>
    
    <jsp:include page="../header.jsp" />
    
    <!-- Custom styles for this template -->
    <link href="./assets/css/global.css" rel="stylesheet">
    <style type="text/css">
    	body {
		  padding-top: 3.5rem;
		}	
    </style>
    
    <title>Cerca Automobile</title>
  </head>
  <body>
  
	<jsp:include page="../navbar.jsp"></jsp:include>
  
  
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Cerca elemento</h5> 
		    </div>
		    <div class='card-body'>
		    
			
					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteFindByExampleAutomobileServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Marca <span class="text-danger">*</span></label>
								<input type="text" name="marca" id="marca" class="form-control" value="${auto_find.marca}"  placeholder="Inserire la marca" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Modello <span class="text-danger">*</span></label>
								<input type="text" name="modello" id="modello" value="${auto_find.modello}" class="form-control" placeholder="Inserire il modello" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Cilindrata <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="cilindrata" id="cilindrata"  value="${auto_find.cilindrata}" placeholder="Inserire la Cilindrata" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Immatricolazione<span class="text-danger">*</span></label>
								<fmt:formatDate var="dataImmatricolazioneParsed" value="${auto_find.dataImmatricolazione}" type="date" pattern="yyyy-MM-dd"/>
                        		<input class="form-control" value="${dataImmatricolazioneParsed}" id="dataImmatricolazione" type="date" placeholder="gg/mm/aaaa"
                            		title="formato : gg/mm/aaaa"  name="dataImmatricolazione" required>
							</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
					

					</form>

		    
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
  </body>
</html>