package com.averysadproject.webapp.service;

import java.util.List;

import com.averysadproject.webapp.entities.Veicoli;

public interface VeicoliService 
{
	Veicoli SelebyTarga(String Targa);
	
	List<Veicoli> SeleByCitta(String Dislocazione);

	
	void Salva(Veicoli veicolo);
	
	void AggiornaVei(Veicoli veicolo);

	void EliminaVei(Veicoli veicolo);
	
	List<Veicoli> SelTutti();
}