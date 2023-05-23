<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 

<!doctype html>
<html lang="it">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet">
    
    <!-- open-iconic -->
    <link href="<c:url value="/static/css/open-iconic-bootstrap.css" />" rel="stylesheet">
    
    <!-- Altri CSS -->
    <link href="<c:url value="/static/css/main.css" />" rel="stylesheet">

    <title><tiles:insertAttribute name="titolo" /></title>
  </head>
  <body>
  

  

  <!-- Navigation Bar --> 
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    		<span class="navbar-toggler-icon"></span>
  		</button>
  		<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
  		
  			 <a class="navbar-brand" href="<spring:url value="/veicoli/"/>"></a>
      				
				      				  <!-- Image and text -->
				<nav class="navbar navbar-light bg-light">
				  <a class="navbar-brand" href="#">
				    <img src="https://github.com/Nello6/averysadprojectresourcestore/blob/main/logo_large.png?raw=true" width="200" height="200" class="d-inline-block align-top" alt="">    
				  </a>
				 </nav>     				
      	
      	
      <div style="width:100%;"></div>
    		<div style="text-align:left; width:150px; padding:5px;">
    			<!-- dropdown menu -->
    			<c:choose>
    			<c:when test = "${IsIndex == false}">
    			<div class="dropdown">
    			
    				<button class="btn btn-default dropdown-toggle thumbnail"
    					type="button"
    					id="dropdownMenu1"
    					data-toggle="dropdown"
    					aria-haspopup="true" 
    					aria-expanded="true">
    					<img class="img-circle" src="<c:url value="/static/images/offline_user.png" />">
    					<span class="caret"></span>
    				</button>
    				
    				
    				<div class="dropdown-menu" aria-labelledby="dropdownMenu1" style=" text-align:left; padding:5px;">
    				
    							<form id="myHiddenFormId" action="localhost:9001/rentapp/logout" method="post" style="display: none" >
									<input type="hidden" name="logout" value="${User}">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								</form>
									
									<a class="dropdown-item" href="" onclick="$('#myHiddenFormId').submit(); return false;" title="Logout" style="text-align:left; width:100%; padding:5px;"> <spring:message code="base.dropdwn.menu3"/> ${User}</a>
    				</div>
    				
    			</div>
    			
    			</c:when>
    			</c:choose>
    		</div>
  		</div>
    </nav> 
    
     <tiles:insertAttribute name="content" /> 
     
     <tiles:insertAttribute name="footer" />  
      
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script type="text/javascript" src="<c:url value="/static/js/jquery-3.2.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js" />"></script>
     <script type="text/javascript" src="<c:url value="/static/js/main.js" />"></script>
  </body>
</html>
