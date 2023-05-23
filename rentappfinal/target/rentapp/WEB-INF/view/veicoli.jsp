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
			<h3 class="page-title">Risultati Ricerca: <small>Trovati ${NumVe} Veicoli</small></h3>
		</div>
		<div class="col-md-6 col-sm-6">
		<a href="<spring:url value="/veicoli/aggiungi" /> "  style="margin-left: 20px;" class="btn btn-success float-right">Nuovo Veicolo</a>

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
			<table id="veicoli" class="table table-striped table-bordered">
				<thead>
		            <tr>
		            	<th>Targa</th>
		                <th>Modello</th>
		                <th>Marca</th>
		                <th>Alimentazione</th>
		                <th>Segmento</th>
		                <th>Tipo</th>
		                <th>Cilindrata</th>
		                <th>Colore</th>
		                <th>Km</th>
		                <th>Prezzo</th>
		                <th>Parco Affine</th>
		                <th>
		                </th>
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
	        		<c:forEach items="${Veicoli}" var="veicolo">
						<tr>
							<td>${veicolo.targa}</td>
							<td>${veicolo.modello}</td>
							<td>${veicolo.marca}</td>
							<td>${veicolo.alimentazione}</td>
							<td>${veicolo.segmento}</td>
							<td>${veicolo.tipo}</td>
							<td>${veicolo.cilindrata}</td>
							<td>${veicolo.colore}</td>
							<td>${veicolo.km}</td>
							<td>${veicolo.prezzo}</td>
							<td>${veicolo.id_parco}</td>
							
						</tr>
					</c:forEach>
	        	</tbody>
			</table>
		</div>
	</section>

