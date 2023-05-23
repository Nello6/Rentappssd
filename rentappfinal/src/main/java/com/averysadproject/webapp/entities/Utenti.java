package com.averysadproject.webapp.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "UTENTI")
public class Utenti implements Serializable
{

	private static final long serialVersionUID = -2019898359041035307L;
	
	// Mapping 
	@Id
	@Column(name = "USERNAME")
	@NotNull(message = "{User.username.validation}")
	private String username;
	
	@Column(name = "PASSWORD")
	@NotNull(message = "{User.password.validation}")
	private String password;
	
	@Column(name = "NOME")
	@NotNull(message = "{User.nome.validation}")
	@Size(min=2, max=50, message = "{Size.Utenti.nome.validation}")
	private String nome;
	
	@Column(name = "COGNOME")
	@NotNull(message = "{User.cognome.validation}")
	@Size(min=2, max=50, message = "{Size.Utenti.cognome.validation}")
	private String cognome;
	
	@Column(name = "INDIRIZZO")
	@Size(min=2, max=50, message = "{Size.Utenti.indirizzo.validation}")
	private String indirizzo;
	
	@Column(name = "COD_FISCALE")
	@NotNull(message = "{User.cf.validation}")
	@Size(min=16, max=16, message = "{Size.Utenti.cf.validation}")
	private String codfis;
	
	@Column(name = "PIVA")
	@Size(min=11, max=11, message = "{Size.Utenti.piva.validation}")
	
	private String piva;
	
	@Column(name = "LUOGO_NASCITA")
	@Size(min=2, max=50, message = "{Size.Utenti.luogo.validation}")
	private String luogonascita;
	
	@Column(name = "N_PATENTE")
	private String npatente;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCITA")
	private Date datanascita;
	
	@ManyToOne
	@JoinColumn(name = "ID_RUOLO",referencedColumnName = "id")
	private Ruoli ruolo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "utente", orphanRemoval = true)
	private Set<Prenotazioni> prenotazioni = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "utente", orphanRemoval = true)
	private Set<ParchiAuto> parcoauto = new HashSet<>();
	//
	
	
	
	// Costruttore get e set
	public Utenti() {}
	
	public Ruoli getRuolo() {
		return ruolo;
	}



	public void setRuolo(Ruoli ruolo) {
		this.ruolo = ruolo;
	}



	public Set<Prenotazioni> getPrenotazioni() {
		return prenotazioni;
	}



	public void setPrenotazioni(Set<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}



	public Set<ParchiAuto> getParcoauto() {
		return parcoauto;
	}



	public void setParcoauto(Set<ParchiAuto> parcoauto) {
		this.parcoauto = parcoauto;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCodfis() {
		return codfis;
	}

	public void setCodfis(String codfis) {
		this.codfis = codfis;
	}

	public String getPiva() {
		return piva;
	}

	public void setPiva(String piva) {
		this.piva = piva;
	}

	public String getLuogonascita() {
		return luogonascita;
	}

	public void setLuogonascita(String luogonascita) {
		this.luogonascita = luogonascita;
	}

	public String getNpatente() {
		return npatente;
	}

	public void setNpatente(String npatente) {
		this.npatente = npatente;
	}

	public Date getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(Date datanascita) {
		this.datanascita = datanascita;
	}
	//

	
}
