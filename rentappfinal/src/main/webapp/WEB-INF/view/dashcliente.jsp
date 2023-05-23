<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="org.keycloak.AuthorizationContext" %>
<%@ page import="org.keycloak.KeycloakSecurityContext" %>
<%@ page import="org.keycloak.representations.idm.authorization.Permission" %>
<%@ page import="java.util.Map"%>
<%@ page import="com.averysadproject.webapp.entities.Utenti" %>
<%@ page import="com.averysadproject.webapp.entities.Utenti" %>
<%@ page import="com.averysadproject.webapp.entities.Ruoli" %>
<%@ page import="com.averysadproject.webapp.service.UtentiService" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>



<div class="jumbotron jumbotron-billboard">
  <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
              <h1>${Titolo}</h1>
                <h2>${User}</h2>
            </div>
        </div>
    </div>
</div>

<br>
<br>

<div class="container">
  <div class="jumbotron">
    <h3>${intestazione}</h3>
    
    
  </div>
  
</div>

<br>
<br>

<div class="card-deck">
  <div class="card">
    <img class="card-img-top" src="https://raw.githubusercontent.com/Nello6/averysadprojectresourcestore/main/autopren%20(1).jpg" class="card-img-top" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">Visualizza prenotazioni</h5>
      <p class="card-text">Visualizza le prenotazioni da te effettuate e gesticile tramite le funzionalità della nostra webapp.</p>
      <br>
      <p class="card-button"><a href="dashcliente/visualizzaprenotazioni" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Visualizza Prenotazioni</a>
      <p class="card-text"><small class="text-muted"></small></p>
    </div>
  </div>
  <div class="card">
    <img class="card-img-top" src="https://static.nexilia.it/indiscreto/2019/07/carrental-e1562576518852.jpg" class="card-img-top" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">Effettua prenotazione</h5>
      <p class="card-text">Effettua una prenotazione in base alle date in cui necessiti di un veicolo e al luogo di ritiro.</p>
      <br>
      <p class="card-button"><a href="dashcliente/prenotazione" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Prenota veicolo</a>
      <p class="card-text"><small class="text-muted"></small></p>
    </div>
  </div>
  <div class="card">
    <img class="card-img-top" src="https://us.123rf.com/450wm/tommaso79/tommaso791110/tommaso79111000029/12897604-l-uomo-chiamando-il-servizio-di-riparazione-dopo-il-guasto-auto.jpg?ver=6" alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">Segnala guasti o incidenti </h5>
      <p class="card-text">Invia la tua posizione specificando il motivo dell'impossibilità di locomozione del veicolo e ricevi la nostra assistenza gratuitamente</p>
      <p class="card-button"><a href="dashcliente/segnalazione" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Effettua Segnalazione </a>
      <p class="card-text"><small class="text-muted"></small></p>
    </div>
  </div>
</div>





<br>
<br>
<br>
<br>


<br>
<br>
<div data-testid="cluster" class="btui-o-cluster btui-o-cluster--large bgui-u-justify-between bgui-u-mt-medium bgui-u-pb-largest"><img src="https://cdn2.rcstatic.com/images/supplier_logos/sicily_by_car_logo_lrg.gif" alt="Sicily By Car" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/locauto_logo_lrg.gif" alt="Locauto" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/budget_logo_lrg.gif" alt="Budget" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/maggiore_logo_lrg.gif" alt="Maggiore" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/hertz_logo_lrg.gif" alt="Hertz" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/avis_logo_lrg.gif" alt="Avis" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/europcar_logo_lrg.gif" alt="Europcar" data-testid="supplier-logo" class="supplier-logos-image"><img src="https://cdn2.rcstatic.com/images/supplier_logos/firefly_logo_lrg.gif" alt="Firefly" data-testid="supplier-logo" class="supplier-logos-image"></div>
</br>
</br>
