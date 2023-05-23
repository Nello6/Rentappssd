package com.averysadproject.webapp.controller;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.averysadproject.webapp.service.PrenotazioniService;
import com.averysadproject.webapp.service.UtentiService;
import com.averysadproject.webapp.service.VeicoliService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.averysadproject.webapp.entities.*;

import java.net.http.HttpRequest;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


import org.keycloak.AuthorizationContext;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.authorization.client.util.Http;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.IDToken;
import org.keycloak.representations.idm.authorization.Permission;


@SuppressWarnings("unused")
@Controller
@RequestMapping("/dashcliente")
public class ClientiController {
	Credentials credentials= new Credentials();
	
	Utenti userdetails = new Utenti();
	boolean usererror=false;
	stubpay stubok=new stubpay("Mario","0000","123","06");

	private static final Logger logger = LoggerFactory.getLogger(ClientiController.class);
	
	@Autowired
	private PrenotazioniService prenotazioniService;
	
	@Autowired
	private UtentiService utente;
	
	@Autowired
	private VeicoliService veicoliService;
	List<Veicoli> MainRecordset;
	
	
	private Prenotazioni prenotazione = new Prenotazioni();
	//private stubpay card= new stubpay();


	private ParchiAuto parcoService;
	private List<Prenotazioni> recordset;
	private List<Veicoli> recordset1;
	
	private int NumPre = 0;
	
	double giorniFraDueDate =0;
	double b=0;
	int IntValue=0;
	
	
	private int NumVe=0;
	private boolean IsVeicoli = true;
	private boolean IsSaved;
	private HttpServletRequest request;
	
	
	
	@RequestMapping(value="")
	public String getWelcome(Model model,HttpServletRequest request)
	{
		
		 KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
		    AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
		    userdetails.setUsername(keycloakSecurityContext.getToken().getPreferredUsername());
		    
		    
		try {
			IsSaved=false;
			model.addAttribute("Titolo", "Benvenuto Cliente : ");
			model.addAttribute("User", userdetails.getUsername()); 
			model.addAttribute("intestazione", "Questa è la tua dashboard, da qui potrai accedere alle svariate funzionalità che il sistema ti offre. Effettua una prenotazione cercando un veicolo tra quelli disponibili in tutti i parchi auto o visualizza le prenotazioni effettuate");
			model.addAttribute("IsIndex", false);
			utente.SelByUsername(userdetails.getUsername());
		}catch(Exception e){
			model.addAttribute("Titolo", "Benvenuto Cliente : ");
			Map<String, Object> customClaims=keycloakSecurityContext.getToken().getOtherClaims();
			String[] splits = keycloakSecurityContext.getToken().getName().split(" ");
			userdetails.setNome(splits[0]);
			userdetails.setCognome(splits[1]);
			userdetails.setPassword("deprecated");
			model.addAttribute("utenteerror",usererror? true : false);
			model.addAttribute("Titolo2", "Prima di cominciare abbiamo bisogno di alcune informazioni");
			model.addAttribute("Utente", userdetails);
				return "insCliente";
			}
		
//		if(utente.SelByUsername(userdetails.getUsername()) == null) {
//			utente.Salva(userdetails);
//		}
		return "dashcliente";
	}
	
	@GetMapping(value = "/visualizzaprenotazioni")
	public String VisualizzaPrenotazione(Model model,HttpServletRequest request)
	{
		 KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
		    AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
		    userdetails.setUsername(keycloakSecurityContext.getToken().getPreferredUsername());
		    try {
		    	utente.SelByUsername(userdetails.getUsername());
		    }catch(Exception e) {
		    	return "redirect:/dashcliente";
		    }
		String ritorno="/dashcliente";
		String User = userdetails.getUsername();
		recordset= prenotazioniService.SelectPrenByUser(User);
		
		if (recordset != null)
			NumPre = recordset.size();
		
		List<String> dateinizio=new ArrayList<String>();
		List<String> datefine=new ArrayList<String>();
		for(Prenotazioni r: recordset)
		{
			String temp;
			temp=new java.text.SimpleDateFormat("dd-MM-yyyy").format(r.getDatainizio());
			dateinizio.add(temp);
			temp=new java.text.SimpleDateFormat("dd-MM-yyyy").format(r.getDatafine());
			datefine.add(temp);
		}
		
		model.addAttribute("Back",ritorno);
		model.addAttribute("Prenotazioni", recordset);
		model.addAttribute("dateinizio",dateinizio);
		model.addAttribute("datefine",datefine);
		model.addAttribute("NumPrenotazioni", NumPre);
		
		
		return "insPrenotazione";
	}
	
	
	
	@GetMapping(value = "/prenotazione")
	public String Prenotazione(Model model,HttpServletRequest request)
	{
		KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
	    AuthorizationContext authzContext = keycloakSecurityContext.getAuthorizationContext();
	    userdetails.setUsername(keycloakSecurityContext.getToken().getPreferredUsername());
	    try {
	    	utente.SelByUsername(userdetails.getUsername());
	    }catch(Exception e) {
	    	return "redirect:/dashcliente";
	    }
		
		Utenti u = new Utenti();
		ParchiAuto parco=new ParchiAuto();
		u.setUsername(userdetails.getUsername());
		PrenotazioniString preno= new PrenotazioniString();
		
		//PrenotazioniString prenostring= new PrenotazioniString();
		
		   	
		//preno.setUtente(u);
		prenotazione.setUtente(u);
		//System.out.println(preno.getUtente());
	
		
		model.addAttribute("modello", "Inserimento Prenotazione");
		model.addAttribute("newPrenotazione", preno);
		model.addAttribute("saved",IsSaved ? true : false);
		IsSaved=false;
		
		return "insPreno";
	}
	

	@PostMapping(value = "/prenotazione")
	public String GestPrenotazione(@Valid @ModelAttribute("newPrenotazione" ) PrenotazioniString prenostring, BindingResult result, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request) throws java.text.ParseException
	{
		if (result.hasErrors())
		{
			return "insPreno";
		}
		
		
		Prenotazioni preno = new Prenotazioni();
		try {
		
		preno.setDatainizio(prenostring.FormattaData(prenostring.getDatainizio()));
		preno.setDatafine(prenostring.FormattaData(prenostring.getDatafine()));
		}catch(Exception e) {
			IsSaved= true;
			return "redirect: /rentapp/dashcliente/prenotazione" ;
		}
		Date dallaData = preno.getDatainizio();
		Date allaData = preno.getDatafine();
		Date currentDate=new Date();
		//System.out.println(currentDate.after(preno.getDatainizio()));
		System.out.println(prenostring.FormattaData(prenostring.getDatainizio()));
		long dallaDataMilliSecondi = dallaData.getTime();
		long allaDataMilliSecondi = allaData.getTime();
		long millisecondiFraDueDate = allaDataMilliSecondi - dallaDataMilliSecondi;
		//1 giorno = 1000*60*60*24 ms = 86400000 ms
		giorniFraDueDate = millisecondiFraDueDate / 86400000;
		
		    System.out.println(giorniFraDueDate);
		 
		 if(giorniFraDueDate<=0 || currentDate.after(dallaData))
		 {
			 IsSaved= true;
			 System.out.println("date sbagliate");
		 return "redirect: /rentapp/dashcliente/prenotazione"   ;
		 }
		
		recordset1 = veicoliService.SeleByCitta(prenostring.getDislocazione());
		recordset = prenotazioniService.SelectPrenBydata(preno.getDatainizio(),preno.getDatafine());
		
		List<Veicoli> vei= new ArrayList<Veicoli>();
		int ok;
		for(Veicoli v : recordset1) {
			ok=1;
			String targa= v.getTarga();
			
			for(Prenotazioni p : recordset) {
				if(p.getVeicolo().getTarga().equals(targa) ){
					ok=0;
					System.out.println(v.getTarga()+"escluso");
					break;
				}
				
			}
			if(ok==1) {
				vei.add(v);
				System.out.println(v.getTarga());
			}
		}
		
		prenotazione.setDatainizio(preno.getDatainizio());
		prenotazione.setDatafine(preno.getDatafine());
		
		recordset1=vei;
		model.addAttribute("newPrenotazione",preno);
		
		
		return "redirect:/dashcliente/cercaLuogo"   ;
	
	
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/cercaLuogo")
	public String VisualizzaVeicoliCliente(Model model)
	{
		
		if(giorniFraDueDate != 0) {
			 b=giorniFraDueDate;
		}
		IntValue = (int) b;
		if (recordset1 != null) {
			NumVe = recordset1.size();
		}
			
		if(NumVe==0) {
				model.addAttribute("saved",true);
			
		}
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(prenotazione.getDatafine().getDate());
			stringBuilder.append("/");
			stringBuilder.append(1+prenotazione.getDatafine().getMonth());
			stringBuilder.append("/");
			stringBuilder.append(1900+prenotazione.getDatafine().getYear());
			String dataitfin= stringBuilder.toString();
			StringBuilder stringBuilder1 = new StringBuilder();
			stringBuilder1.append(prenotazione.getDatainizio().getDate());
			stringBuilder1.append("/");
			stringBuilder1.append(1+prenotazione.getDatainizio().getMonth());
			stringBuilder1.append("/");
			stringBuilder1.append(1900+prenotazione.getDatainizio().getYear());
			String dataitin= stringBuilder1.toString();
			
			
		model.addAttribute("Veicoli", recordset1);
		model.addAttribute("periodo",IntValue);
		model.addAttribute("NumVeicoli", NumVe);
		model.addAttribute("datai",dataitin);
		model.addAttribute("dataf",dataitfin);
		
		
		return "cercaLuogo";
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/pagamento/{targa}")
	public String Veicles(@PathVariable("targa") String targa,Model model)
	{
		Prenotazioni preno= new Prenotazioni();
		preno.setDatafine(prenotazione.getDatafine());
		preno.setDatainizio(prenotazione.getDatainizio());
		preno.setUtente(prenotazione.getUtente());
		//prenotazione = new Prenotazioni();
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(prenotazione.getDatafine().getDate());
		stringBuilder.append("/");
		stringBuilder.append(1+prenotazione.getDatafine().getMonth());
		stringBuilder.append("/");
		stringBuilder.append(1900+prenotazione.getDatafine().getYear());
		String dataitfin= stringBuilder.toString();
		StringBuilder stringBuilder1 = new StringBuilder();
		stringBuilder1.append(prenotazione.getDatainizio().getDate());
		stringBuilder1.append("/");
		stringBuilder1.append(1+prenotazione.getDatainizio().getMonth());
		stringBuilder1.append("/");
		stringBuilder1.append(1900+prenotazione.getDatainizio().getYear());
		String dataitin= stringBuilder1.toString();
	
		Veicoli veicolo=null;
		veicolo = veicoliService.SelebyTarga(targa);
		model.addAttribute("Titolo","Dettaglio Prenotazione");
		model.addAttribute("Titolo2",userdetails.getUsername());
		model.addAttribute("Veicolo",veicolo);
		model.addAttribute("prezzotot",veicolo.getPrezzo()*giorniFraDueDate);
		model.addAttribute("DateStart",dataitin);
		model.addAttribute("DateEnd",dataitfin);
		model.addAttribute("targa", veicolo.getTarga());	
		
		prenotazione.setVeicolo(veicolo);
		prenotazione.setParcoauto(veicolo.getParcoauto());
		
		
		return "pagamento";
		
	}
	
	@GetMapping(value = "**/pagamento/{targa}/pay")
	public String getdaticard(@PathVariable("targa") String targa,Model model) {
		stubpay card1 = new stubpay();
		model.addAttribute("carta",card1);
		model.addAttribute("targa",targa);
		model.addAttribute("prezzotot",prenotazione.getVeicolo().getPrezzo()*giorniFraDueDate);
		
		return "formcarta";
	}
	
	@PostMapping(value = "**/pagamento/{targa}/pay")
	public String checkpayeins(@Valid @ModelAttribute("carta") stubpay card,BindingResult result1, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request)
			{
	
		if (result1.hasErrors())
		{
			return "ErrorPay";
		}
		
			if(stubok.uguale(card)){
				prenotazioniService.CreaPrenotazione(prenotazione);
				prenotazione=new Prenotazioni();
				return "redirect: pay/Successopagamento";
			}
			else return "redirect: pay/Errorepagamento";
			}
	
	
	
	
	
	
	
	@GetMapping(value = "**/Successopagamento")
	public String SuccessoPagamento(Model model)
	{
		model.addAttribute("Titolo","Pagamento effettuato con successo ");
		
		return "SuccessPay";
	}
	
	@GetMapping(value = "**/Errorepagamento")
	public String FailPagamento(Model model)
	{
		model.addAttribute("Titolo","Pagamento fallito");
	
		return "ErrorPay";
	}
	
	@GetMapping(value = "/segnalazione")
	public String GetSegnalazioniWebApp(Model model)
	{
		model.addAttribute("Titolo","");
	
		return "Segnalazioni";
	}
	
	@PostMapping(value = "")
	public String GestInsCliente(@Valid @ModelAttribute("Utente") Utenti cliente, BindingResult result, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		
		usererror=false;
		if (result.hasErrors())
		{
			return "insCliente";
		}
		try {
			utente.Salva(cliente);
		}
		catch(Exception e) {
			usererror=true;
			model.addAttribute("Titolo", "Benvenuto Cliente: ");
			model.addAttribute("Titolo2", "Prima di cominciare abbiamo bisogno di alcune informazioni");
			return "insCliente";
		}
		
		return "redirect:/dashcliente";
	}
	
	
}