<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${Titolo}</h2>
                <p>${Titolo2}</p>
            </div>
        </div>
    </div>
</div>
    <section class="container">
		<div class="row">
		<div class = "col-md-6 col-sm-6">
			<h3 class="page-title">Risultati Visualizza Prenotazioni : <small> ${NumPrenotazioni} Prenotazioni </small></h3>
		</div>
		<div class="col-md-6 col-sm-6">
		
			<div id="rep" class="datafilter">
				<label>
					Pagine: 
					 <select name="numpage" aria-controls="sample_1" class="form-control input-sm input-xsmall input-inline">
						 <option value="10">10</option>
						 <option value="15">15</option>
						 <option value="20">20</option>
						 <option value="-1">Tutti</option>
					 </select>
				</label>
			</div>
		</div>
			<table id="prenotazioni" class="table table-striped table-bordered">
				<thead>
		            <tr>
		            	<th>Id Prenotazione</th>
		                <th>Data Inizio	</th>
		                <th>Data Fine</th>
		                <th>Utente </th>
		                <th>Parco Auto</th>
		                <th>Targa Veicolo </th>
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
	        		<c:forEach items="${Prenotazioni}" var="preno" varStatus="status">
						<tr>
							<td>${preno.id}</td>
							<td>${dateinizio[status.index]}</td>
							<td>${datefine[status.index]}</td>
							<td>${preno.utente.username}</td>
							<td>${preno.parcoauto.nome}</td>
							<td>${preno.veicolo.targa}</td>
						</tr>
						</c:forEach>

	        	</tbody>
			</table>
		</div>
		<a href="<spring:url value="${Back}" />" id="btnAbort" class="btn btn-outline-primary form-buttons">
								<spring:message code="visualizzaprenotazioni.form.btnAbort.label"/>
							</a>
		
		
	</section>

