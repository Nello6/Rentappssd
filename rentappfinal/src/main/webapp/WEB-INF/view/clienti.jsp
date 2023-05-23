<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${Titolo}</h2>
                <p>
                    ${Titolo2}
                </p>
            </div>
        </div>
    </div>
</div>
    <section class="container">
		<div class="row">
		<div class = "col-md-6 col-sm-6">
			<h3 class="page-title">Risultati Ricerca: <small>Trovati ${NumRecords} Veicoli</small></h3>
		</div>
		<div class="col-md-6 col-sm-6">
			<a href="<spring:url value="/clienti/aggiungi" /> "  style="margin-left: 20px;" class="btn btn-success float-right">Nuovo Cliente</a>
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
			<table id="clienti" class="table table-striped table-bordered">
				<thead>
		            <tr>
		            	<th>
		            		Fidelity
		            		<a href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=0,${OrderType},1;paging=1,${RecPage},0" /> " class="btn btn-xs">
		            		<span class="oi oi-elevator"></span>
		            		</a>
		            	</th>
		                <th>
		                	Nominativo
		                	<a href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=1,${OrderType},1;paging=1,${RecPage},0" /> " class="btn btn-xs">
		                	<span class="oi oi-elevator"></span>
		                	</a>
		                </th>
		                <th>
		                	Comune
		                	<a href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=2,${OrderType},1;paging=1,${RecPage},0" /> " class="btn btn-xs">
		                	<span class="oi oi-elevator"></span>
		                	</a>
		                </th>
		                <th>
		                	Bollini
		                	<a href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=3,${OrderType},1;paging=1,${RecPage},0" /> " class="btn btn-xs">
		                	<span class="oi oi-elevator"></span>
		                	</a>
		                </th>
		                <th>
		                	Ultima Spesa
		                	<a href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=4,${OrderType},1;paging=1,${RecPage},0" /> " class="btn btn-xs">
		                	<span class="oi oi-elevator"></span>
		                	</a>
		                </th>
		                <th></th>
		                <th></th>
		            </tr>
	        	</thead>
	        	<tfoot>
	        	</tfoot>
	        	<tbody>
	        		<c:forEach items="${veicoli}" var="Veicoli">
						<tr>
							<td>${Veicoli.targa}</td>
							<td> ${Veicoli.marca} ${Veicoli.modello}</td>
							<td><a href="<spring:url value="/clienti/cerca/comune?filter=${Veicoli.marca}" /> ">${Veicoli.modello}</a></td>
							<td>
							<fmt:formatNumber value = "${Veicoli.parcoauto.idparco}"  minFractionDigits = "0" type = "number"/>
							</td>
						</tr>
					</c:forEach>
	        	</tbody>
			</table>
			<nav aria-label="Page navigation example">
				 <ul class="pagination">
				 	<c:if test="${PageNum == 1}">
					 	<li class="page-item disabled">
					 		 <a class="page-link" href="#" aria-label="Previous">
	        				 	<span aria-hidden="true">&laquo;</span>
	        				 	<span class="sr-only">Precedente</span>
	      					</a>
					 	</li>
				 	</c:if>
				 	<c:if test="${PageNum > 1}">
					 	<li class="page-item">
					 		 <a class="page-link" href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=${OrderBy},${OrderType},0;paging=${PageNum},${RecPage},-1" /> " aria-label="Previous">
	        				 	<span aria-hidden="true">&laquo;</span>
	        				 	<span class="sr-only">Precedente</span>
	      					</a>
					 	</li>
				 	</c:if>
				 	
				 	<c:forEach items="${Pages}" var="Pagine">
				 		 <c:choose>
					 		<c:when test="${Pagine.isSelected}">
							 	<li class="page-item active">
							 		<a class="page-link" href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=${OrderBy},${OrderType},0;paging=${Pagine.pageNum},${RecPage},0" /> ">${Pagine.pageNum}</a>
							 	</li>
						 	</c:when>
						 	<c:otherwise>
						 		<li class="page-item">
							 		<a class="page-link" href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=${OrderBy},${OrderType},0;paging=${Pagine.pageNum},${RecPage},0" /> ">${Pagine.pageNum}</a>
							 	</li>
						 	</c:otherwise>
					 	</c:choose>
				 	</c:forEach>
    				
 
    				<li class="page-item">
    					<a class="page-link" href="<spring:url value="/clienti/cerca/parametri;filtro=${filter},0;orderby=${OrderBy},${OrderType},0;paging=${PageNum},${RecPage},1" /> " aria-label="Next">
        					<span aria-hidden="true">&raquo;</span>
        					<span class="sr-only">Successivo</span>
      					</a>
    				</li>
				 </ul>
			</nav>
		</div>
		
	</section>

