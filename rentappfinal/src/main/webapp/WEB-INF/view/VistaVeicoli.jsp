<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
            <c:choose>
        	<c:when test = "${NumVeicoli != 0}">
              <h2>Sono stati calcolati ${NumVeicoli} preventivi dal ${datai} al ${dataf}</h2>
                <p>${Titolo2}</p>
            </c:when>
			</c:choose>
			<c:choose>
        	<c:when test = "${NumVeicoli == 0}">
        	<h2>Non sono stati trovati veicoli disponibili al noleggio per le date e il luogo indicato</h2>
                <p>${Titolo2}</p>
        	</c:when>
        	</c:choose>
            </div>
        </div>
    </div>
</div>
		
	
    <section class="container">
		<div class="row">
		<div class = "col-md-6 col-sm-6">
		
			<h3 class="page-title">Risultati   : <small> ${NumVeicoli} Veicoli   </small>    </h3>
		
		
		<h4> Durata Periodo Selezionato : ${periodo} Giorni</h4>
		</div>
		<c:choose>
    	<c:when test = "${NumVeicoli != 0}">	
			<table id="veicoli" class="table table-striped table-bordered" >
				<thead>
		            <tr>
		            	<th>Targa</th>
		                <th>Modello</th>
		                <th>Marca</th>
		                <th>Alimentazione</th>
		                <th>Segmento</th>
		                
		                <th>Cilindrata</th>
		                <th>Colore</th>
		                <th>Km</th>
		                <th>
		                <span class="oi oi-euro"></span>
		                </th>
		                <th>Preventivo </th>
		                <th>Autonoleggio</th>
		                <th></th>
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
	        		<c:forEach items="${Veicoli}" var="recordset1">
						<tr>
							<td>${recordset1.targa}</td>
							<td>${recordset1.modello}</td>
							<td>${recordset1.marca}</td>
							<td>${recordset1.alimentazione}</td>
							<td>${recordset1.segmento}</td>
							
							<td>${recordset1.cilindrata}</td>
							<td>${recordset1.colore}</td>
							<td>${recordset1.km}</td>
							<td>${recordset1.prezzo}</td>
							<td>${recordset1.prezzo*periodo}</td>
							<td>${recordset1.parcoauto.nome}</td>
							<td> 
								<a href=" <spring:url value="/dashcliente/pagamento/${recordset1.targa}" /> " class="btn btn-success">
									<span class="oi oi-credit-card"></span> Prenota
	      						</a>  
      						</td> 
							
							
						</tr>
						</c:forEach>
					
	        	</tbody>
			</table>
			</c:when>
			</c:choose>
			
		</div>
		<a href="<spring:url value="/dashcliente" /> " id="btnAbort" class="btn btn-outline-primary form-buttons">
								<spring:message code="visualizzaprenotazioni.form.btnAbort.label"/>
							</a>
		
	</section>
