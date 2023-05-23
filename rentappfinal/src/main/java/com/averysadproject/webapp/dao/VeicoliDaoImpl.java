package com.averysadproject.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
//import javax.xml.crypto.Data;

import org.springframework.stereotype.Repository;

import com.averysadproject.webapp.entities.Veicoli;


@Repository
public class VeicoliDaoImpl extends AbstractDao<Veicoli,String>
	implements VeicoliDao
{

	@Override
	public List<Veicoli> SelTutti(){
		
		return super.SelTutti();
		
	}
	
	@Override
	public Veicoli SelbyTarga(String Targa) {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Veicoli> queryDefinition = queryBuilder.createQuery(Veicoli.class);
		
		Root<Veicoli> recordset = queryDefinition.from(Veicoli.class); 
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("targa"),Targa));
		
		Veicoli veicolo = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		return veicolo;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Veicoli> SelByCitta(String Dislocazione) {
		
		String JPQL = "";
		
		JPQL = "SELECT a FROM Veicoli a JOIN a.parcoauto b WHERE b.dislocazione LIKE :luogo";
		List<Veicoli> veicoli = entityManager.createQuery(JPQL)
				.setParameter("luogo", Dislocazione)
				.getResultList();
		return veicoli;
	}
	

	@Override
	public void Salva(Veicoli veicolo) {
		super.Inserisci(veicolo);
		
	}

	@Override
	public void Aggiorna(Veicoli veicolo) {
		super.Aggiorna(veicolo);
		
	}

	@Override
	public void Elimina(Veicoli veicolo) {
		super.Elimina(veicolo);
		
	}

	
	
	
}
