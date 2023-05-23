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
            </div>
        </div>
    </div>
</div>
<div class="col-lg-12 text-center">
    
                <a href="<spring:url value="/dashcliente" />" id="DashBoardCliente" class="btn btn-success form-buttons"" role="button" aria-pressed="true">Dashboard</a>
            </div>
</body>
</html>