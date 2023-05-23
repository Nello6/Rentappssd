package com.averysadproject.webapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.IllegalArgumentException;
@Entity
@Table(name = "PARCHIAUTO")
public class ParchiAuto implements Serializable
{

	private static final long serialVersionUID = -8341977239546400204L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IDPARCO")
	private long idparco;
	
	
	@NotEmpty(message = "{NotNull.ParchiAuto.nome.validation}")
	@Column(name = "NOME")
	private String nome;
	@NotEmpty(message = "{NotNull.ParchiAuto.dislocazione.validation}")
	@Column(name = "DISLOCAZIONE")
	private String dislocazione;
	@NotEmpty(message = "{NotNull.ParchiAuto.indirizzo.validation}")
	@Column(name = "INDIRIZZO")
	private String indirizzo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parcoauto", orphanRemoval = true)
	private Set<Prenotazioni> prenotazioni = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "UTENTE_ID",referencedColumnName = "username")
	private Utenti utente;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parcoauto", orphanRemoval = true)
	private Set<Veicoli> veicoli = new HashSet<>();

	public ParchiAuto() {}
	
	public long getIdparco() {
		return idparco;
	}

	public void setIdparco(long idparco) {
		this.idparco = idparco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDislocazione() {
		return dislocazione;
	}

	public void setDislocazione(String dislocazione) {
		this.dislocazione = dislocazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Set<Prenotazioni> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Utenti getUtente() {
		return utente;
	}

	public void setUtente(Utenti utente) {
		this.utente = utente;
	}

	public Set<Veicoli> getVeicoli() {
		return veicoli;
	}

	public void setVeicoli(Set<Veicoli> veicoli) {
		this.veicoli = veicoli;
	}
	
	
}
