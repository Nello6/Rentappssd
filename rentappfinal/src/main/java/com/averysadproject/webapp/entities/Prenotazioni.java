package com.averysadproject.webapp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.springframework.data.jpa.repository.Temporal;


@Entity
@Table(name = "PRENOTAZIONI")
public class Prenotazioni implements Serializable
{

	private static final long serialVersionUID = -1221149616487454691L;

	// Mapping
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Temporal(TemporalType.DATE)
	
	@Column(name = "DATAINIZIO")
	private Date datainizio;
	//@NotNull(message = "{Prenotazioni.datafine.validation}")
	@Temporal(TemporalType.DATE)
	@Column(name = "DATAFINE")
	
	private Date datafine;
	
	@ManyToOne
	@JoinColumn(name = "UTENTE_USERNAME",referencedColumnName = "username")
	private Utenti utente;
	
	@ManyToOne
	@JoinColumn(name = "PARCO_ID_PARCO",referencedColumnName = "idparco")
	private ParchiAuto parcoauto;
	
	@ManyToOne
	@JoinColumn(name = "VEICOLO_TARGA",referencedColumnName = "targa")
	private Veicoli veicolo;

	public Prenotazioni() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	public Date getDatafine() {
		return datafine;
	}

	public void setDatafine(Date datafine) {
		this.datafine = datafine;
	}

	public Utenti getUtente() {
		return utente;
	}

	public void setUtente(Utenti utente) {
		this.utente = utente;
	}

	public ParchiAuto getParcoauto() {
		return parcoauto;
	}

	public void setParcoauto(ParchiAuto parcoauto) {
		this.parcoauto = parcoauto;
	}

	public Veicoli getVeicolo() {
		return veicolo;
	}

	public void setVeicolo(Veicoli veicolo) {
		this.veicolo = veicolo;
	}
	
	
}
