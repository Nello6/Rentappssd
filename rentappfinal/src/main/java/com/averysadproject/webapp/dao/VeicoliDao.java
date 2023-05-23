/**
 * 
 */
package com.averysadproject.webapp.dao;

import java.util.List;

import com.averysadproject.webapp.entities.Veicoli;


/**
 * @author nello
 *
 */

public interface VeicoliDao 
{

	Veicoli SelbyTarga(String Targa);
	
	List<Veicoli> SelByCitta(String Dislocazione);
	
	void Salva(Veicoli veicolo);
	
	void Aggiorna(Veicoli veicolo);

	void Elimina(Veicoli veicolo);
	
	List<Veicoli> SelTutti();
}
