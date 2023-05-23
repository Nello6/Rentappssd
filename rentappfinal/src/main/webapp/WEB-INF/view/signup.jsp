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
            	<i class="icon-settings oi oi-person"></i>
             	<span class="caption-subject bold uppercase"><spring:message code="inscliente.form.titolo.label"/></span>
            </div>
		</div>
		<div class="portlet-body form">
			<div class="tab-content" id="myTabContent">
			
				<!-- Visualizza l'allert -->
				<c:if test="${saved}">
					<div class="alert alert-success" role="alert">
	  					<spring:message code="inscliente.form.alert.label"/>
					</div>
				</c:if>
				<!-- Visualizza l'allert -->
				<c:if test="${utenteerror}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="inscliente.form.alert1.label"/>
					</div>
				</c:if>
				<!-- Form Dati Cliente -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="Utente">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
					
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="username"><spring:message code="inscliente.form.username.label"/></label>
								<form:input id="username" path="username" value="${Utente.username}" type="text" readonly="true" class="form-control"/>
								<form:errors path="username" cssClass="text-danger"/>  
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6" >
								<form:input id="password" path="password" value="${Utente.password}" hidden="true" type="text" readonly="true" class="form-control"/>
								<form:errors path="username" cssClass="text-danger"/>  
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="nome"><spring:message code="inscliente.form.nome.label"/></label>
								<form:input id="nome" path="nome" value="${Utente.nome}" type="text" class="form-control"/>  
							    <form:errors path="nome" cssClass="text-danger"/>
							</div>
							
							<div class="form-group col-md-6">
								<label for="cognome"><spring:message code="inscliente.form.cognome.label"/></label>
								<form:input id="cognome" path="cognome" value="${Utente.cognome}" type="text" class="form-control"/>  
							   <form:errors path="cognome" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="indirizzo"><spring:message code="inscliente.form.indirizzo.label"/></label>
							<form:input id="indirizzo" path="indirizzo" type="text" class="form-control" placeholder="Indirizzo"/>  
							<form:errors path="indirizzo" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="npatente"><spring:message code="inscliente.form.pat.label"/></label>
							<form:input id="npatente" path="npatente" type="text" class="form-control" placeholder="Numero Patente"/>  
							<form:errors path="npatente" cssClass="text-danger"/>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="piva"><spring:message code="inscliente.form.piva.label"/></label>
								<form:input id="piva" path="piva" type="text" class="form-control"/>  
								<form:errors path="piva" cssClass="text-danger"/>
							</div>
							
							<div class="form-group col-md-6">
								<label for="codfis"><spring:message code="inscliente.form.cf.label"/></label>
								<form:input id="codfis" path="codfis" type="text" class="form-control"/>  
								 <form:errors path="codfis" cssClass="text-danger"/>
							</div>
							
							
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="luogonascita"><spring:message code="inscliente.form.luogo.label"/></label>
								<form:input id="luogonascita" path="luogonascita" type="text" class="form-control"/>  
								<form:errors path="luogonascita" cssClass="text-danger"/>
							</div>
							
							<div class="form-group col-md-6">
								<label for="datanascita"><spring:message code="inscliente.form.data.label"/></label>
								<form:input id="datanascita" path="datanascita" type="text" class="form-control" placeholder="01/01/2000"/>  
								<form:errors path="datanascita" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group" hidden="true">
							
							<div class="mt-radio-inline">
								<label class="mt-radio">
									<form:radiobutton id="ruolo.id" class="form-check-input" path="ruolo.id" value="2" /> 
									<spring:message code="inscliente.form.stato1.label"/>
									<span></span> 
								</label>
								<label class="mt-radio">
									<form:radiobutton class="form-check-input" path="ruolo.id" value="3" checked="true"/> 
									<spring:message code="inscliente.form.stato2.label"/>
									<span></span> 
								</label>
							</div>
						</div>
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-outline-success form-buttons" value = <spring:message code="insarticolo.form.btnAdd.label"/> />
							
							<a href="<spring:url value="/" /> " id="btnAbort" class="btn btn-outline-primary form-buttons" >
								<spring:message code="insarticolo.form.btnAbort.label"/>
							</a>
						</div>
					</div>
					</form:form>
				</div>	
				</div>
		</div>
	</div>
</section>