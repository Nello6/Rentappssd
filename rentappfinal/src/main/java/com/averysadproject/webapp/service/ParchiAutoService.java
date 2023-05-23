package com.averysadproject.webapp.service;

import java.util.List;

import com.averysadproject.webapp.entities.ParchiAuto;

public interface ParchiAutoService {

	
	List<ParchiAuto> selbyUser(String Username);
	
	Long getidbynome(String nome);
	
	void CreaParco(ParchiAuto ParcoAuto);
	
	void Aggiorna(ParchiAuto ParcoAuto);

	void Elimina(ParchiAuto ParcoAuto);
	
	
	
}
