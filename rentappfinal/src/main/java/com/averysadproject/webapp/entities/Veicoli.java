package com.averysadproject.webapp.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "VEICOLI")
public class Veicoli implements Serializable
{

	private static final long serialVersionUID = 7692945323747561025L;

	@Id
	@Column(name = "TARGA")
	@NotEmpty(message = "{Veicoli.targa.validation}")
	@Size(min=7,  max=7,  message = "{Size.Veicoli.targa.validation}")
	private String targa;
	
	@Column(name = "MODELLO")
	@NotEmpty(message = "{Veicoli.modello.validation}")
	//@Size(min=2,max=50, message="Il nome modello deve essere composto da 2 a 50 caratteri")
	private String modello;
	
	@Column(name = "MARCA")
	@NotEmpty(message = "{Veicoli.marca.validation}")
	private String marca;
	
	@Column(name = "ALIMENTAZIONE")
	@NotNull(message = "{Veicoli.alimentazione.validation}")
	private String alimentazione;
	
	@Column(name = "SEGMENTO")
	@NotEmpty(message = "{Veicoli.segmento.validation}")
	private String segmento;
	
	
	@NotEmpty(message = "{Veicoli.tipo.validation}")
	@Column(name = "TIPO")
	private String tipo;
	
	@NotNull(message = "{Veicoli.cilindrata.validation}")
	//@Size(min=2,  max=5,  message = "{Size.Veicoli.cilindrata.validation}")
	@Column(name = "CILINDRATA")
	private int cilindrata;
	
	@Column(name = "COLORE")
	@NotEmpty(message = "{Veicoli.colore.validation}")
	private String colore;
	
	
	@Column(name = "KM")
	@NotNull(message = "{Veicoli.km.validation}")
	private int km;
	//@NotNegative("{}")
	@Column(name = "PREZZO")
	@NotNull(message = "{Veicoli.prezzo.validation}")
	//@Size(min=3,  max=10,  message ="{Size.Veicoli.prezzo.validation}")
	private float prezzo;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "veicolo", orphanRemoval = true)
	private Set<Prenotazioni> prenotazioni = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "IDPARCO",referencedColumnName = "idparco")
	private ParchiAuto parcoauto;
	
	public Veicoli() {}
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAlimentazione() {
		return alimentazione;
	}

	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Set<Prenotazioni> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazioni> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public ParchiAuto getParcoauto() {
		return parcoauto;
	}

	public void setParcoauto(ParchiAuto parcoauto) {
		this.parcoauto = parcoauto;
	}

}
