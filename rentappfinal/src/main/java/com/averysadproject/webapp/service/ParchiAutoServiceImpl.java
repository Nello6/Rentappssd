package com.averysadproject.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.averysadproject.webapp.dao.ParchiAutoDao;
import com.averysadproject.webapp.entities.ParchiAuto;



@Service("parchiautoService")
@Transactional
public class ParchiAutoServiceImpl implements ParchiAutoService{

	@Autowired
	private ParchiAutoDao parchiautoRepository;
		
	
	@Override
	public void CreaParco(ParchiAuto ParcoAuto) {
	
		parchiautoRepository.CreaParco(ParcoAuto);

	}

	@Override
	public void Aggiorna(ParchiAuto ParcoAuto){
		
		parchiautoRepository.Aggiorna(ParcoAuto);
		
	}
	
	@Override
	public void Elimina(ParchiAuto ParcoAuto) {
	
		parchiautoRepository.Elimina(ParcoAuto);
		
	}

	@Override
	public List<ParchiAuto> selbyUser(String Username) {
		
		
		List<ParchiAuto> parchiauto = parchiautoRepository.selbyUser(Username);
		return parchiauto;
		
	}

	@Override
	public Long getidbynome(String nome) {
		
		return parchiautoRepository.getidbynome(nome);
	}
	
}
