package com.averysadproject.webapp.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.averysadproject.webapp.entities.Utenti;

@Repository
public class UtentiDaoImpl extends AbstractDao<Utenti, String>
	implements UtentiDao
{

	@Override
	public Utenti SelByUsername(String Username) 
	{
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Utenti> queryDefinition = queryBuilder.createQuery(Utenti.class);
		
		Root<Utenti> recordset = queryDefinition.from(Utenti.class); 
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("username"), Username));
		
		Utenti utente = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		return utente;
	}

	@Override
	public void Salva(Utenti utente) 
	{	
		super.Inserisci(utente);	
	}
	
	@Override
	public void Aggiorna(Utenti utente)
	{	
		super.Aggiorna(utente);	
	}
	
	@Override
	public void Elimina(Utenti utente) 
	{	
		super.Elimina(utente);
	}
	
}