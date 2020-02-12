package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;

public class Tb_loja implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer loja;
	private String nomeLoja;
	
	public Tb_loja() {
		
	}
	
	
	

	public Tb_loja(Integer loja, String nomeLoja) {
		super();
		this.loja = loja;
		this.nomeLoja = nomeLoja;
	}




	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}
	
	

}
