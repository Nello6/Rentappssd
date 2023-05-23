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
             	<span class="caption-subject bold uppercase"><spring:message code="creaparcoauto.form.titolo.label"/></span>
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
	  					<spring:message code="creaparcoauto.form.alert.label"/>
					</div>
				</c:if>
				
			<!--
				<c:if test="${error}">
					<div class="alert alert-warning" role="alert">
	  					<spring:message code="creaparcoauto.form.warning.label"/>
					</div>
				</c:if>
			-->
				
				<!-- Form Dati Cliente -->
				<div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
					<form:form  method="POST" modelAttribute="newParco">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/> 
					
					<div class="form-body">
				
						<div class="form-row">
							<div class="form-group col-md-6" >
								<label for="nome"><spring:message code="creaparcoauto.form.nome.label"/></label>
								<form:input id="nome" path="nome" type="text" class="form-control" placeholder="Nome"/>
								<form:errors path="nome" cssClass="text-danger"/>  
							</div>
							
							<div class="form-group col-md-6">
								<label for="dislocazione"><spring:message code="creaparcoauto.form.dislocazione.label"/></label>
								<form:input id="dislocazione" path="dislocazione" type="text" class="form-control" placeholder="Dislocazione"/>  
							     <form:errors path="dislocazione" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="indirizzo"><spring:message code="creaparcoauto.form.indirizzo.label"/></label>
							<form:input id="indirizzo" path="indirizzo" type="text" class="form-control" placeholder="Indirizzo"/>  
							<form:errors path="indirizzo" cssClass="text-danger"/>
						</div>
						
						<hr class="line-form">
						
						<div class="form-actions">
							<input type="submit" id="btnAdd" class="btn btn-green form-button" value = <spring:message code="creaparcoauto.form.btnAdd.label"/> />
							
							<a href="<spring:url value="/dashgestore" /> " id="btnAbort" class="btn btn-outline-primary form-button" >
								<spring:message code="creaparcoauto.form.btnAbort.label"/>
							</a>
						</div>
					</div>
					</form:form>
				</div>	
				</div>
		</div>
	</div>
</section>