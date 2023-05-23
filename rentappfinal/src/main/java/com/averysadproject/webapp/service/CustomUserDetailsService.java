package com.averysadproject.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import  org.springframework.security.core.userdetails.User;

import com.averysadproject.webapp.entities.Ruoli;
import com.averysadproject.webapp.entities.Utenti;



@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UtentiService utenteService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userId) 
			throws UsernameNotFoundException
	{
		 Utenti utente = utenteService.SelByUsername(userId);
		 
		 if (utente == null)
		 {
			 throw new UsernameNotFoundException("Utente non Trovato!!");
		 }
		 
		 UserBuilder builder = null;
		
		 builder = User.withUsername(utente.getUsername());
		 builder.disabled(false);
		 builder.password(utente.getPassword());
		 
		 Ruoli ruolo = utente.getRuolo();
		 String profili= "ROLE_"+ruolo.getNome();
		 
		 builder.authorities(profili);
		 
		 return builder.build();
	}
	 
}
