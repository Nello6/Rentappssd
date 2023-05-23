package com.averysadproject.webapp.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.averysadproject.webapp.entities.Ruoli;


@Repository
public class RuoliDaoImpl extends AbstractDao<Ruoli,Integer>
	implements RuoliDao
{

	@Override
	public Ruoli getruolobyid(long Id) {
		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Ruoli> queryDefinition = queryBuilder.createQuery(Ruoli.class);
		
		Root<Ruoli> recordset = queryDefinition.from(Ruoli.class); 
		
		queryDefinition.select(recordset)
			.where(queryBuilder.equal(recordset.get("id"), Id));
		
		Ruoli ruolo = entityManager.createQuery(queryDefinition).getSingleResult();
		
		entityManager.clear();
		
		
		return ruolo;
		
	}

}
