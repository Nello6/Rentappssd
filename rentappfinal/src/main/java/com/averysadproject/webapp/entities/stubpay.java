package com.averysadproject.webapp.entities;





public class stubpay {

	String titolare;
	String numero;
	String cvv;
	String data;
	
	public stubpay() {}
	public stubpay(String titolare,String numero,String cvv,String data) {
		this.titolare = titolare;
		this.numero=numero;
		this.cvv=cvv;
		this.data=data;
	}
	public boolean uguale(stubpay carta) {
		
		if(this.cvv.equals(carta.getCvv())&& this.data.equals(carta.getData()) &&this.numero.equals(carta.getNumero())&&this.titolare.equals(carta.getTitolare()))
		return true;
		else return false;
	}
	
	
	
	public String getTitolare() {
		return titolare;
	}
	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
