package com.averysadproject.webapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RUOLI")
public class Ruoli implements Serializable
{

	private static final long serialVersionUID = 7964108885554691836L;

	//Mapping
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NOME")
	private String nome;
	//
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ruolo", orphanRemoval = true)
	private Set<Utenti> utenti = new HashSet<>();
	
	public Set<Utenti> getUtenti() {
		return utenti;
	}
	public void setUtenti(Set<Utenti> utenti) {
		this.utenti = utenti;
	}
	//Costruttori get e set
	public Ruoli() { }
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	//
}

