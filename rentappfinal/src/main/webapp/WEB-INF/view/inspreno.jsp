<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<div class="portlet light bordered">
		<div class="portlet-title tabbable-line">
		 	 <div class="caption font-blue-madison">
            	<i class="icon-settings oi oi-calendar"></i>
             	<span class="caption-subject bold uppercase"><spring:message code="inspreno.form.titolo.label"/></span>
            </div>

		</div>
		<div class="portlet-body form">
			<div class="tab-content" id="myTabContent">
			
				<!-- Visualizza l'allert -->
				<c:if test="${saved}">
					<div class="alert alert-danger" role="alert">
	  					<spring:message code="inspreno.form.alert.label"/>
					</div>
				</c:if>
			
				<c:if test="${error}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="inspreno.form.warning.label"/>
					</div>
				</c:if>
		
				<!-- Form Inserimento prenotazione -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="newPrenotazione">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
				
						<div class="form-row">
							<div class="form-group col-md-4" >
								<label for="datainizio"><spring:message code="inspreno.form.datainizio.label"/></label>
								<form:input id="datainizio" path="datainizio" type="text" class="form-control it-date-datepicker" placeholder="01/01/2000"/>
								<form:errors path="datainizio" cssClass="text-danger"/>  
							</div>
							
						<div class="form-group col-md-4">
							<label for="datafine"><spring:message code="inspreno.form.datafine.label"/></label>
							<form:input id="datafine" path="datafine" type="text" class="form-control it-date-datepicker" placeholder="01/01/2000"/>  
							<form:errors path="datafine" cssClass="text-danger"/>
						</div>
						
						<div class="form-group col-md-4">
								<label for="dislocazione"><spring:message code="creaparcoauto.form.dislocazione.label"/></label>
								<form:input id="dislocazione" path="dislocazione" type="text" class="form-control" placeholder="Napoli "/>  
							     <form:errors path="dislocazione" cssClass="text-danger"/>
							</div>
						</div>
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-outline-success form-buttons" value = <spring:message code="inspreno.form.btnAdd.label"/> />
							<a href="<spring:url value="/dashcliente" /> " id="btnAbort" class="btn btn-outline-primary form-buttons" >
								<spring:message code="inspreno.form.btnAbort.label"/>
							</a>
						</div>
					
					</div>
					</form:form>
				</div>	
				</div>
				
		</div>
	</div>
</section>