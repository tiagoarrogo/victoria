package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;

public class FiltrosVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String dias;
	private String lojas;
	private String Anos;
	private String Meses;
	
	
	
	public FiltrosVenda(String dias, String lojas, String anos, String meses) {
		super();
		this.dias = dias;
		this.lojas = lojas;
		Anos = anos;
		Meses = meses;
	}
	
	
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getLojas() {
		return lojas;
	}
	public void setLojas(String lojas) {
		this.lojas = lojas;
	}
	public String getAnos() {
		return Anos;
	}
	public void setAnos(String anos) {
		Anos = anos;
	}
	public String getMeses() {
		return Meses;
	}
	public void setMeses(String meses) {
		Meses = meses;
	}
	
	
	
	
	
	
	
	
	
}