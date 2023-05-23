package com.averysadproject.webapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.averysadproject.webapp.dao.PrenotazioniDao;

import com.averysadproject.webapp.entities.Prenotazioni;



@Service("prenotazioniService")
@Transactional
public class PrenotazioniServiceImpl implements PrenotazioniService{

	@Autowired
	private PrenotazioniDao prenotazioniRepository;
	
	@Override
	public List<Prenotazioni> SelectPrenByUser(String Username){
		
		List<Prenotazioni> prenotazione = prenotazioniRepository.SelectPrenByUser(Username);
		return prenotazione;
		
	}

	@Override
	public List<Prenotazioni> SelectPrenByTarga(String Targa){
		
		List<Prenotazioni> prenotazione = prenotazioniRepository.SelectPrenByTarga(Targa);
		return prenotazione;
		
	}
	
	@Override
	public List<Prenotazioni> SelectPrenBydata(Date datainizio,Date datafine){
		List<Prenotazioni> prenotazione = prenotazioniRepository.SelectPrenBydata(datainizio,datafine);
		return prenotazione;
		
		
	}

	
	
	@Override
	public void CreaPrenotazione(Prenotazioni Prenotazione) {
		
		prenotazioniRepository.CreaPrenotazione(Prenotazione);
		
	}
	
	@Override
	public void Aggiorna(Prenotazioni Prenotazione) {
		
		prenotazioniRepository.Aggiorna(Prenotazione);
		
	}

	@Override
	public void Elimina(Prenotazioni Prenotazione) {
		
		prenotazioniRepository.Elimina(Prenotazione);
		
	}

	@Override
	public List<Prenotazioni> SelectPrenByIdparchi(String Username) {
		
		return prenotazioniRepository.SelectPrenByIdparchi(Username); 
	}
	
	
	
	
}
