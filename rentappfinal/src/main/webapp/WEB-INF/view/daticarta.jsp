<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


					
					
					<div class="card">
					<form:form  method="POST" modelAttribute="carta">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
<div class="card-body">
<h3 class="card-title info-car">Dati Pagamento</h3>
<br>
<br>
<h5>Metodi di Pagamento accettati:</h5>
<img class="card-img-top" src="https://electricvehicleequipment.co.uk/wp-content/uploads/2018/06/cards-1.png.webp" class="card-img-top" alt="Card image cap">
<br>
<div class="row">
<div class="form-group col-md-12">
<label for="titolare"> <spring:message code="datip.titolare"/></label>
<form:input id="titolare" path="titolare" type="text" class="form-control" placeholder="Mario Rossi"/>
<form:errors path="titolare" cssClass="text-danger"/>
</div>
</div>
<div class="row">
<div class="form-group col-md-12">
<label for="numero"> <spring:message code="datip.carta"/></label>
<form:input id="numero" data-testid="card-number-input-field" path="numero" type="text" class="form-control" placeholder="5246 1000 2000 3000"/>
<form:errors path="numero" cssClass="text-danger"/>
</div>
</div>
<div class="row">
<div class="form-group col-md-5">
<label for="cvv"> <spring:message code="datip.cvv"/></label>
<form:input id="cvv" path="cvv" type="text" class="form-control" placeholder="000"/>
<form:errors path="cvv" cssClass="text-danger"/>
</div>
<div class="form-group col-md-5">
<label for="data"> <spring:message code="datip.data"/></label>
<form:input id=".data" path="data" type="text" class="form-control" placeholder="MM/YYYY"/>
<form:errors path="data" cssClass="text-danger"/>
</div>
</div>	
<br>
<div class="form group" align="center">
<h3>Totale : ${prezzotot}</h3>
<br>
</div>						
						
<div class="form group" align="center">
						<input type="submit" id="btnAdd" class="btn btn-outline-success form-buttons" value = "Conferma" />
		    			<a href="pay/Errorepagamento" class="card-link btn btn-outline-danger form-buttons">Annulla</a>
						</div>
									
					</div>
					</form:form>
				</div>	
