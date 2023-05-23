package com.averysadproject.webapp.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import com.averysadproject.webapp.entities.ParchiAuto;
import com.averysadproject.webapp.entities.Utenti;


@Repository
public class ParchiAutoDaoImpl extends AbstractDao <ParchiAuto, Long>
	implements ParchiAutoDao
{
	
	
	
	@Override
	public void CreaParco(ParchiAuto ParcoAuto) {
	
		super.Inserisci(ParcoAuto);
		
	}

	@Override
	public void Aggiorna(ParchiAuto ParcoAuto){
		
		super.Aggiorna(ParcoAuto);
		
	}
	
	@Override
	public void Elimina(ParchiAuto ParcoAuto) {
	
		super.Elimina(ParcoAuto);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ParchiAuto> selbyUser(String Username) {
		
		String JPQL="";
		JPQL = "SELECT a FROM ParchiAuto a JOIN a.utente b WHERE b.username LIKE :user";
		List<ParchiAuto> parchiautobyuser = entityManager.createQuery(JPQL)
				.setParameter("user", Username)
				.getResultList();
		return parchiautobyuser;
		
	}

	@Override
	public Long getidbynome(String nome) {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ParchiAuto> queryDefinition = queryBuilder.createQuery(ParchiAuto.class);
		
		Root<ParchiAuto> recordset = queryDefinition.from(ParchiAuto.class); 
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("nome"), nome));
		
		ParchiAuto parcoauto = entityManager.createQuery(queryDefinition).getSingleResult();
		
		Long i = parcoauto.getIdparco();
		entityManager.clear();
		
		return i;
	}
	}
