package com.averysadproject.webapp.dao;

import java.util.Date;
import java.util.List;

import com.averysadproject.webapp.entities.Prenotazioni;

public interface PrenotazioniDao {
		
	List<Prenotazioni> SelectPrenByUser(String Username);
	
	List<Prenotazioni> SelectPrenByIdparchi(String Username); 
	
	List<Prenotazioni> SelectPrenByTarga(String Targa);
	
	void CreaPrenotazione(Prenotazioni Prenotazione);
	
	void Aggiorna(Prenotazioni Prenotazione);

	List<Prenotazioni> SelectPrenBydata(Date datainizio,Date datafine);
	
	void Elimina(Prenotazioni Prenotazione);
}
