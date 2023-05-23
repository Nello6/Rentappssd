package com.averysadproject.webapp.service;


import java.util.Date;
import java.util.List;

import com.averysadproject.webapp.entities.Prenotazioni;

public interface PrenotazioniService {

	List<Prenotazioni> SelectPrenByUser(String Username);
	
	List<Prenotazioni> SelectPrenByIdparchi(String Username); 
	
	List<Prenotazioni> SelectPrenByTarga(String Targa);
	
	void CreaPrenotazione(Prenotazioni Prenotazione);
	
	List<Prenotazioni> SelectPrenBydata(Date datainizio,Date datafine);
	
	void Aggiorna(Prenotazioni Prenotazione);

	void Elimina(Prenotazioni Prenotazione);
}