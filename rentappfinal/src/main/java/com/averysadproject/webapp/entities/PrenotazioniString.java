package com.averysadproject.webapp.entities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrenotazioniString {

	public String getDatainizio() {
		return datainizio;
	}
	public void setDatainizio(String datainizio) {
		this.datainizio = datainizio;
	}
	public String getDatafine() {
		return datafine;
	}
	public void setDatafine(String datafine) {
		this.datafine = datafine;
	}
	public String getDislocazione() {
		return dislocazione;
	}
	public void setDislocazione(String dislocazione) {
		this.dislocazione = dislocazione;
	}
	private String datainizio;
	private String datafine;
	private String dislocazione;
	
	public  Date FormattaData(String data) throws ParseException
	{
		String input=data;
		//System.out.println("questo il  zero  parser"+ data);
        SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
        Date date = parser.parse(input);
       // System.out.println("questo il  primo parser"+ date);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        input = formatter.format(date); //data come stringa
        parser = new SimpleDateFormat("yyyy-MM-dd");
        date = parser.parse(input);
        //System.out.println("questo il parser"+ date);
		return date;
	}
}
