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
            	<i class="icon-settings oi oi-list"></i>
             	<span class="caption-subject bold uppercase"><spring:message code="insveicolo.form.titolo.label"/></span>
            </div>
         <!--   
            <ul class="nav nav-form" id="account-tabs" role="tablist">
	            <li class="nav-item">
	            	<a class="nav-link active" id="dati-tab" data-toggle="tab" href="#dati" role="tab" aria-controls="dati" aria-selected="true">
	            		<spring:message code="inscliente.form.tab1.label"/>
	            	</a>
	            </li>
	            <li class="nav-item">
	            	<a class="nav-link" id="avatar-tab" data-toggle="tab" href="#avatar" role="tab" aria-controls="avatar" aria-selected="false">
	            		<spring:message code="inscliente.form.tab2.label"/>
	            	</a>
				</li>
            </ul>
            -->
            

		</div>
		<div class="portlet-body form">
			<div class="tab-content" id="myTabContent">
			
				<!-- Visualizza l'allert -->
				<c:if test="${saved}">
					<div class="alert alert-success" role="alert">
	  					<spring:message code="insveicolo.form.alert.label"/>
					</div>
				</c:if>
				<c:if test="${targaerror}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="insveicolo.form.alert1.label"/>
					</div>
				</c:if>
			<%-- 
				<c:if test="${error}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="insveicolo.form.warning.label"/>
					</div>
				</c:if>
			--%>
				
				<!-- Form Dati Cliente -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="newVeicolo">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
				
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="targa"><spring:message code="insveicolo.form.targa.label"/></label>
								<form:input id="targa" path="targa" type="text" class="form-control"/>  
								<form:errors path="targa" cssClass="text-danger"/>
								
							</div>
							
							<div class="form-group col-md-6">
								<label for="modello"><spring:message code="insveicolo.form.modello.label"/></label>
								<form:input id="modello" path="modello" type="text" class="form-control"/>  
								<form:errors path="modello" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="marca"><spring:message code="insveicolo.form.marca.label"/></label>
								<form:input id="marca" path="marca" type="text" class="form-control"/> 
								<form:errors path="marca" cssClass="text-danger"/> 
							</div>
							
								<div class="form-group col-md-6">
						<label for="alimentazione"><spring:message code="insveicolo.form.alimentazione.label"/></label>
						<form:select path="alimentazione" class="form-control">
							<form:option value="Benzina" label="Benzina"/>
							<form:option value="Diesel" label="Diesel"/>
							<form:option value="DHDI" label="DieselHDI"/>
							<form:option value="Gas" label="Gas"/>
							<form:option value="GPL" label="GPL"/>
							<form:option value="Elettrica" label="Elettrica"/>
							<form:option value="Hybrid" label="Hybrid"/>
						</form:select>
					</div>
							<div class="form-group col-md-6">
								<label for="segmento"><spring:message code="insveicolo.form.segmento.label"/></label>
								<form:input id="segmento" path="segmento" type="text" class="form-control"/> 
								<form:errors path="segmento" cssClass="text-danger"/> 
							</div>
						</div>
						
						<div class="form-group">
							<label for="tipo"><spring:message code="inscliente.form.tipo.label"/></label>
							<form:input id="tipo" path="tipo" type="text" class="form-control" placeholder="tipo"/>  
							<form:errors path="tipo" cssClass="text-danger"/>
						</div>
						
						<div class="form-group">
							<label for="cilindrata"><spring:message code="inscliente.form.cilindrata.label"/></label>
							<form:input id="cilindrata" path="cilindrata" type="text" class="form-control" placeholder="cilindrata"/>  
							<form:errors path="cilindrata" cssClass="text-danger"/>
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="colore"><spring:message code="insveicolo.form.colore.label"/></label>
								<form:input id="colore" path="colore" type="text" class="form-control"/>  
								<form:errors path="colore" cssClass="text-danger"/>
							</div>
							
							<div class="form-group col-md-6">
								<label for="km"><spring:message code="insveicolo.form.km.label"/></label>
								<form:input id="km" path="km" type="text" class="form-control"/>  
								<form:errors path="km" cssClass="text-danger"/>
							</div>
							
							
						</div>
						
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="prezzo"><spring:message code="insveicolo.form.prezzo.label"/></label>
								<form:input id="prezzo" path="prezzo" type="text" class="form-control"/>  
								<form:errors path="prezzo" cssClass="text-danger"/>
							</div>
								
					<%--
						<div class="form-group">
							<label for="parcoauto"><spring:message code="insveicolo.form.parcoauto.label"/></label>
							<form:input id="parcoauto.idparco" path="parcoauto.idparco" type="text" class="form-control" placeholder="parcoauto"/>  
							<form:errors path="parcoauto.idparco" cssClass="text-danger"/>
						</div>
						
						--%><%--
						<div class="form-group col-md-4">
							<label for="parcoauto.idparco "><spring:message code="insveicolo.form.parcoauto.label"/></label>
							<form:select path="parcoauto.idparco" class="form-control">
								 <form:options items="${idparchi}" />
							</form:select>
							<form:errors path="parcoauto.idparco" cssClass="text-danger"/> 
						</div>
						--%>
						<div class="form-group col-md-4">
							<label for="parcoauto.nome "><spring:message code="insveicolo.form.parcoauto.label"/></label>
							<form:select path="parcoauto.nome" class="form-control">
								 <form:options items="${nameparchi}" />
							</form:select>
							<form:errors path="parcoauto.nome" cssClass="text-danger"/> 
						</div>
						
						
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-outline-success form-buttons" value = <spring:message code="insveicolo.form.btnAdd.label"/> />
							
							<a href="<spring:url value="/dashgestore" /> " id="btnAbort" class="btn btn-outline-primary form-buttons">
								<spring:message code="insveicolo.form.btnAbort.label"/>
							</a>
							
						</div>
					</div>
					</div>
					</form:form>
				</div>
		</div>
	</div>
	</div>
</section>
































