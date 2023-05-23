<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h2>${Titolo}</h2>
                <h4>Cliente : ${Titolo2}</h4>
            </div>
        </div>
    </div>
</div>
<section class="container">
	<div class="row">
		<div class="card">		
			<div class="card-body">
    			<h3 class="card-title info-car">${Veicolo.marca} ${Veicolo.modello}
    				<!-- <span class="badge badge-info">Promo</span> -->
    			</h3>
 		 	</div>
 		 	<ul class="list-group list-group-flush">
 		 		<li class="list-group-item list-group-item-light">Targa: <span class="info-car-1">${Veicolo.targa}</span></li>
	   			<li class="list-group-item list-group-item-light">Modello: <span class="info-car-1">${Veicolo.tipo}</span></li>
                <li class="list-group-item list-group-item-light">Alimentazione: <span class="info-car-1">${Veicolo.alimentazione}</span></li>
				<li class="list-group-item list-group-item-light">Cilindrata: <span class="info-car-1">${Veicolo.cilindrata}</span></li>
				<li class="list-group-item list-group-item-light">Colore: <span class="info-car-1">${Veicolo.colore}</span></li>
				<li class="list-group-item list-group-item-light">KM: <span class="info-car-1">${Veicolo.km}</span></li>
				<li class="list-group-item list-group-item-light">Prezzo: <span class="info-car-1">${Veicolo.prezzo}</span></li>
                <li class="list-group-item list-group-item-light">Autonoleggio: <span class="info-car-1">${Veicolo.parcoauto.nome}</span></li>
				<li class="list-group-item list-group-item-light">Indirizzo: <span class="info-car-1">${Veicolo.parcoauto.indirizzo}</span></li>
				<li class="list-group-item list-group-item-light">Dislocazione: <span class="info-car-1">${Veicolo.parcoauto.dislocazione}</span></li>
	   	 		<li class="list-group-item list-group-item-light">Data Inizio : <span class="info-car-1">${DateStart}</span></li>
	   	 		<li class="list-group-item list-group-item-light">Data Fine : <span class="info-car-1">${DateEnd}</span></li>
  			</ul>
  			<br>
			<div class="form group" align="center">
				<a href="${targa}/pay"   class="card-link btn btn-outline-success form-buttons">Conferma</a>
    			<a href="ErrorPay" class="card-link btn btn-outline-danger form-buttons">Annulla</a>
				</div>	
  			
		<%-- </div>
		<div class="card">		
			<div class="card-body">
				<h3 class="card-title info-car">Dati Pagamento</h3>
				<br>
				<br>
				<h5>Metodi di Pagamento accettati:</h5>
				<img class="card-img-top" src="https://electricvehicleequipment.co.uk/wp-content/uploads/2018/06/cards-1.png.webp" class="card-img-top" alt="Card image cap">
				<br>
				<div class="row">
				<div class="form-group col-md-12">
							<label for="carta.titolare"> <spring:message code="datip.titolare"/></label>
							<form:input id="carta.titolare" path="carta.titolare" type="text" class="form-control" placeholder="Mario Rossi"/>  
							<form:errors path="carta.titolare" cssClass="text-danger"/>
				</div>
				</div>
				<div class="row">
				<div class="form-group col-md-12">
							<label for="carta.numero"> <spring:message code="datip.carta"/></label>
							<form:input id="carta.numero" data-testid="card-number-input-field" path="carta.numero" type="text" class="form-control" placeholder="5246 1000 2000 3000"/>  
							<form:errors path="carta.numero" cssClass="text-danger"/>
				</div>
				</div>
				<div class="row">
				<div class="form-group col-md-5">
							<label for="carta.cvv"> <spring:message code="datip.cvv"/></label>
							<form:input id="carta.cvv" path="carta.cvv" type="text" class="form-control" placeholder="000"/>  
							<form:errors path="carta.cvv" cssClass="text-danger"/>
				</div>
				<div class="form-group col-md-5">
							<label for="carta.data"> <spring:message code="datip.data"/></label>
							<form:input id="carta.data" path="carta.data" type="text" class="form-control" placeholder="MM/YYYY"/>  
							<form:errors path="carta.data" cssClass="text-danger"/>
				</div>
					<h3>Totale : ${prezzotot}</h3>
				<br>
				
				<div class="form group" align="center">
				<a href="${targa}/pay"   class="card-link btn btn-outline-success form-buttons">Acquista</a>
    			<a href="ErrorPay" class="card-link btn btn-outline-danger form-buttons">Annulla</a>
				</div>
				</div>
				
				
		</div>--%>
	</div>
</section>