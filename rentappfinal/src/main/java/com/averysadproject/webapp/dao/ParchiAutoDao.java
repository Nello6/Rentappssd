package com.averysadproject.webapp.dao;

import java.util.List;

import com.averysadproject.webapp.entities.ParchiAuto;

public interface ParchiAutoDao {

	List<ParchiAuto> selbyUser(String Username);
	
	//List<String> getnomiParchi(String Username);
	
	Long getidbynome(String nome);
	
	void CreaParco(ParchiAuto ParcoAuto);
	
	void Aggiorna(ParchiAuto ParcoAuto);

	void Elimina(ParchiAuto ParcoAuto);
	
}
