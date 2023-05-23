package com.averysadproject.webapp.controller;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class IndexController 
{

	
	boolean usererror =false;
	boolean isSaved=false;
	@RequestMapping(value="index")
	public String getWelcome(Model model)
	{
		
		usererror =false;
		isSaved=false;
		model.addAttribute("intestazione", "Benvenuti nel sito RentAPP");
		model.addAttribute("saluti", "Prenota,noleggia e sorridi");
		model.addAttribute("IsIndex", true);
		
		return "index";
	}
	
	@RequestMapping
	public String getWelcome2(Model model)
	{
		usererror =false;
		isSaved=false;
		model.addAttribute("intestazione", "Benvenuti nel sito RentAPP");
		model.addAttribute("saluti", "Prenota,noleggia e sorridi");
		model.addAttribute("IsIndex", true);
		return "index";
	}

	@RequestMapping(value="chisiamo")
	public String getChisiamo(Model model)
	{
		usererror =false;
		isSaved=false;
		model.addAttribute("intestazione", "Chi siamo?");
		model.addAttribute("saluti", "Contattaci");
		
		return "chisiamo";
	}
	
	@RequestMapping(value="logout",method=RequestMethod.POST)
	public String logout(HttpServletRequest request) throws ServletException
	{
		request.logout();
		return "redirect:" + "http://localhost:8080/realms/RentApp/"
						   + "protocol/openid-connect/logout"
						   + "?client_id=rentapp_client"
						   + "&post_logout_redirect_uri=http%3A%2F%2Flocalhost%3A9001%2Frentapp%2Fpostlogout";

	}
	@RequestMapping(value="postlogout",method=RequestMethod.GET)
	public String postlogout(HttpServletRequest request) throws ServletException
	{
		request.logout();
		return "logout";
	}

	
//	@RequestMapping(value="signup")
//	public String InsCliente(Model model)
//	{
//		
//		Utenti cliente = new Utenti();
//		model.addAttribute("utenteerror",usererror? true : false);
//		model.addAttribute("Titolo", "Inserimento Utente");
//		model.addAttribute("Utente", cliente);
//		model.addAttribute("saved", isSaved? true:false);
//		model.addAttribute("User", user.getUserName()); 
//		usererror =false;
//		isSaved=false;
//		return "insCliente";
//	}
//	
//	@PostMapping(value = "signup")
//	public String GestInsCliente(@Valid @ModelAttribute("Utente") Utenti cliente, BindingResult result, Model model,
//			RedirectAttributes redirectAttributes, HttpServletRequest request)
//	{
//		
//		usererror=false;
//		isSaved=false;
//		if (result.hasErrors())
//		{
//			return "insCliente";
//		}
//		try {
//			cliente.setPassword((new BCryptPasswordEncoder().encode(cliente.getPassword())));
//			isSaved=true;
//			utentiService.Salva(cliente);
//		//redirectAttributes.addFlashAttribute("saved", true);
//		
//		}
//		catch(Exception e) {
//			usererror=true;
//			isSaved=false;
//			//return "insCliente";
//			return "redirect:/signup";
//		}
//			
//		
//		
//		return "redirect:/signup";
//	}
	
	
	
}
