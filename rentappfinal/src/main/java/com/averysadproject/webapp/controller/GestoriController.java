package com.averysadproject.webapp.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.keycloak.KeycloakSecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.averysadproject.webapp.entities.ParchiAuto;
import com.averysadproject.webapp.entities.Prenotazioni;
import com.averysadproject.webapp.entities.Utenti;
import com.averysadproject.webapp.entities.Veicoli;
import com.averysadproject.webapp.service.*;


@Controller
@RequestMapping("/dashgestore")
public class GestoriController {
	Utenti userdetails = new Utenti();
	@Autowired
	private VeicoliService veicoliService;
	
	@Autowired
	private ParchiAutoService parcoService;
	


	@Autowired
	private PrenotazioniService prenotazioniService;
	
	private List<Prenotazioni> recordset;
	private int NumPre = 0;
	private boolean IsSaved;
	boolean usererror=false;
	private boolean targaerror;
	
	@RequestMapping(value="")
	public String getWelcome(Model model,HttpServletRequest request)
	{
		 KeycloakSecurityContext keycloakSecurityContext = (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
		    userdetails.setUsername(keycloakSecurityContext.getToken().getPreferredUsername());
		    
		IsSaved=false;
		model.addAttribute("Titolo", "Benvenuto Gestore : ");
		model.addAttribute("User", userdetails.getUsername()); 
		model.addAttribute("intestazione", "Questa è la tua dashboard, da qui potrai accedere alle svariate funzionalità che il sistema ti offre. Se hai già un parco auto puoi usufruire del servizio di inserimento veicolo per arricchirlo, altrimenti creane uno da zero");
		model.addAttribute("IsIndex", false);
		return "dashgestore";
	}
	
	
	
	@GetMapping(value = "/aggiungi")
	public String InsVeicoli(Model model)
	{
		
		
		Veicoli veicolo = new Veicoli();
		
		String User = userdetails.getUsername();
		
		List<ParchiAuto> parchi = parcoService.selbyUser(User);
		
		
		List<String> nameparchi= new ArrayList<String>();
		for (ParchiAuto p : parchi ) {
			
				nameparchi.add(p.getNome());
			
		}
		
				
		model.addAttribute("targaerror",targaerror? true : false);
		
		model.addAttribute("modello", "Inserimento Nuovo Veicolo");
		model.addAttribute("newVeicolo", veicolo);
		model.addAttribute("User", userdetails.getUsername()); 
		model.addAttribute("nameparchi",nameparchi);	
		model.addAttribute("saved",IsSaved ? true : false);
		IsSaved=false;
		targaerror=false;
		return "insVeicolo";
	}
	

	@PostMapping(value = "/aggiungi")
	public String GestInsVeicoli(@Valid @ModelAttribute("newVeicolo" ) Veicoli veicolo, BindingResult result, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		
		
		if (result.hasErrors())
		{    
			String User = userdetails.getUsername();
			List<ParchiAuto> parchi = parcoService.selbyUser(User);
			List<String> nameparchi= new ArrayList<String>();
			for (ParchiAuto p : parchi ) {
				nameparchi.add(p.getNome());
			}
			model.addAttribute("nameparchi",nameparchi);
			return "insVeicolo";
		}
		
		
		
		try {
		
		
		
		veicolo.getParcoauto().setIdparco(parcoService.getidbynome(veicolo.getParcoauto().getNome()));
		
		veicoliService.Salva(veicolo);
		
		IsSaved= true;
		targaerror=false;
		return "redirect:/dashgestore/aggiungi ";
		}
	catch(Exception e){
		targaerror=true;
		System.out.println(" targa uguale");
		return "redirect:/dashgestore/aggiungi ";
		
	}
		
	}
	
		
	
	

	
	
	@GetMapping(value = "/creaparco")
	public String InsParco(Model model)
	{
		ParchiAuto parco = new ParchiAuto();
		
		model.addAttribute("modello", "Inserimento Nuovo Parco Auto");
		model.addAttribute("newParco", parco);
		model.addAttribute("saved",IsSaved ? true : false);
		IsSaved=false;
		
		return "insParco";
	}
	

	@PostMapping(value = "/creaparco")
	public String GestInsParco(@Valid @ModelAttribute("newParco" ) ParchiAuto parco, BindingResult result, Model model,
			RedirectAttributes redirectAttributes, HttpServletRequest request)
	{
		if (result.hasErrors())
		{
			return "insParco";
		}
		Utenti u = new Utenti();
		u.setUsername(userdetails.getUsername());
		parco.setUtente(u);
		parcoService.CreaParco(parco);
		
		IsSaved= true;
		
		return "redirect:/dashgestore/creaparco "   ;
	
	
	}
	
	@GetMapping(value = "/visualizzaprenotazioni")
	public String VisualizzaPrenotazione(Model model) 
	{
		
		
		String User = userdetails.getUsername();
		recordset= prenotazioniService.SelectPrenByIdparchi(User);
		
		if(recordset != null) {
			NumPre=recordset.size();
			
		}
		
		
		String ritorno = "/dashgestore";
		
		List<String> dateinizio=new ArrayList<String>();
		List<String> datefine=new ArrayList<String>();
		for(Prenotazioni d : recordset)
		{
			dateinizio.add(new SimpleDateFormat("dd/MM/yyyy").format(d.getDatainizio()));
			datefine.add(new SimpleDateFormat("dd/MM/yyyy").format(d.getDatafine()));
		}	
		
		model.addAttribute("Prenotazioni", recordset);
		model.addAttribute("dateinizio",dateinizio);
		model.addAttribute("datefine",datefine);
		model.addAttribute("Back",ritorno);
		model.addAttribute("NumPrenotazioni", NumPre);
		
		
		return "insPrenotazione";
	}
	
	
	
	
	 
	
	
	
	
	
	
	
	
	

	
	
}
