package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;


public class Tb_Marca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer cod_Prod_Marca;
	private String marca_Produto;
	
	
	public Tb_Marca() {
		
	}


	public Tb_Marca(Integer cod_Prod_Marca, String marca_Produto) {
		super();
		this.cod_Prod_Marca = cod_Prod_Marca;
		this.marca_Produto = marca_Produto;
	}


	public Integer getCod_Prod_Marca() {
		return cod_Prod_Marca;
	}


	public void setCod_Prod_Marca(Integer cod_Prod_Marca) {
		this.cod_Prod_Marca = cod_Prod_Marca;
	}


	public String getMarca_Produto() {
		return marca_Produto;
	}


	public void setMarca_Produto(String marca_Produto) {
		this.marca_Produto = marca_Produto;
	}
	
	
	

}
