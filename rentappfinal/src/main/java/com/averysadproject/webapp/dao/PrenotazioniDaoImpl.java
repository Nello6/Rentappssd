package com.averysadproject.webapp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.averysadproject.webapp.entities.Prenotazioni;

import java.text.SimpleDateFormat;;
@Repository
public class PrenotazioniDaoImpl extends AbstractDao<Prenotazioni, Integer>
	implements PrenotazioniDao
{
		
	@Override
	@SuppressWarnings("unchecked")
	public List<Prenotazioni> SelectPrenByUser(String Username) {	
		String JPQL = "";
		JPQL = "SELECT a FROM Prenotazioni a JOIN a.utente b WHERE b.username LIKE :user ";
		
		List<Prenotazioni> prenotazioni = entityManager.createQuery(JPQL)
				.setParameter("user", Username)
				.getResultList();
		return prenotazioni;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Prenotazioni> SelectPrenByTarga(String Targa) {
		String JPQL = "";
		JPQL = "SELECT a FROM Prenotazioni a JOIN a.veicolo b WHERE b.targa LIKE :targa ORDER BY a.datafine ASC";
		
		List<Prenotazioni> prenotazioni = entityManager.createQuery(JPQL)
				.setParameter("targa", Targa)
				.getResultList();
		return prenotazioni;
	}

	@SuppressWarnings("unchecked")
	public List<Prenotazioni> SelectPrenBydata(Date datainizio,Date datafine) {

	String JPQL = "";
	JPQL = "SELECT a FROM Prenotazioni a WHERE (a.datafine >= :datainizio AND a.datainizio <= :datafine) ";

	List<Prenotazioni> prenotazioni = entityManager.createQuery(JPQL)
	.setParameter("datainizio", datainizio)
	.setParameter("datafine", datafine)
	.getResultList();
	
	
	return prenotazioni;

	}
	//AND GETDATE() < a.datafine
	
	
	@Override
	public void Aggiorna(Prenotazioni Prenotazione) {
		super.Aggiorna(Prenotazione);
	}
	
	@Override
	public void Elimina(Prenotazioni Prenotazione) {
		super.Elimina(Prenotazione);
	}

	@Override
	public void CreaPrenotazione(Prenotazioni Prenotazione) {
		super.Inserisci(Prenotazione);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Prenotazioni> SelectPrenByIdparchi(String username) {
		String JPQL = "";
		JPQL = "SELECT a FROM Prenotazioni a JOIN a.parcoauto b JOIN b.utente c WHERE c.username LIKE :user AND GETDATE() < a.datafine ORDER BY a.id ASC";
		
		List<Prenotazioni> prenotazioni = entityManager.createQuery(JPQL)
				.setParameter("user", username)
				.getResultList();
		return prenotazioni;
	
	}
	
	
	
	
}
