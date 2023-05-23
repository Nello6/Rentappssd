package com.averysadproject.webapp.service;


import com.averysadproject.webapp.entities.Utenti;

public interface UtentiService {

	Utenti SelByUsername(String Username);
	
	void Salva(Utenti utente);
	
	void Aggiorna(Utenti utente);

	void Elimina(Utenti utente);
	
}
