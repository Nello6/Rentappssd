<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!--
	HttpSession sessione = request.getSession();
    sessione.invalidate();
    request.logout();
-->

<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
              <h2>Log out avvenuto con successo!</h2>
                <a href="/rentapp" id="Logout" class="btn btn-success form-buttons"" role="button" aria-pressed="true">Torna alla Homepage!</a>
            </div>
        </div>
    </div>
</div>

