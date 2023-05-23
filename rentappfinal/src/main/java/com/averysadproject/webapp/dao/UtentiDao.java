package com.averysadproject.webapp.dao;

import com.averysadproject.webapp.entities.Utenti;

public interface UtentiDao 
{
	Utenti SelByUsername(String Username);
	
	void Salva(Utenti utente);
	
	void Aggiorna(Utenti utente);

	void Elimina(Utenti utente);
}
