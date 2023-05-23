package com.averysadproject.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.averysadproject.webapp.dao.UtentiDao;
import com.averysadproject.webapp.entities.Utenti;

@Service("utentiService")
@Transactional
public class UtentiServiceImpl implements UtentiService
{

	@Autowired
	private UtentiDao utentiRepository;
	@Override
	public Utenti SelByUsername(String Username) {
		
		Utenti utente = utentiRepository.SelByUsername(Username);
		return utente;
	}

	@Override
	public void Salva(Utenti utente) {
		utentiRepository.Salva(utente);
		
	}

	@Override
	public void Aggiorna(Utenti utente) {
		utentiRepository.Aggiorna(utente);
		
	}

	@Override
	public void Elimina(Utenti utente) {
		utentiRepository.Elimina(utente);
	}

	
	
}
