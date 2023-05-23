package com.averysadproject.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.averysadproject.webapp.dao.VeicoliDao;
import com.averysadproject.webapp.entities.Veicoli;



@Service("veicoliService")
@Transactional
public class VeicoliServiceImpl implements VeicoliService
{
	@Autowired
	private VeicoliDao veicoliRepository;

	@Override
	public Veicoli SelebyTarga(String Targa) {
		
		Veicoli veicolo = veicoliRepository.SelbyTarga(Targa);
		
		return veicolo;
	}

	@Override
	public List<Veicoli> SeleByCitta(String Dislocazione) {
		List<Veicoli> veicolo = veicoliRepository.SelByCitta(Dislocazione);
		return veicolo;
	}

	@Override
	public void Salva(Veicoli veicolo) {
		veicoliRepository.Salva(veicolo);
		
	}

	@Override
	public void AggiornaVei(Veicoli veicolo) {
		veicoliRepository.Aggiorna(veicolo);
	}

	@Override
	public void EliminaVei(Veicoli veicolo) {
		veicoliRepository.Elimina(veicolo);
	}

	@Override
	public List<Veicoli> SelTutti() {
		List<Veicoli> veicolo = veicoliRepository.SelTutti();
		return veicolo;
	}
	
}
