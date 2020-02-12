package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;

public class Tb_TipoProduto implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	
	private Integer cod_Prod_Tipo;
	private String tipo_Produto;
	
	public Tb_TipoProduto() {
		
	}

	public Tb_TipoProduto(Integer cod_Prod_Tipo, String tipo_Produto) {
		super();
		this.cod_Prod_Tipo = cod_Prod_Tipo;
		this.tipo_Produto = tipo_Produto;
	}

	public Integer getCod_Prod_Tipo() {
		return cod_Prod_Tipo;
	}

	public void setCod_Prod_Tipo(Integer cod_Prod_Tipo) {
		this.cod_Prod_Tipo = cod_Prod_Tipo;
	}

	public String getTipo_Produto() {
		return tipo_Produto;
	}

	public void setTipo_Produto(String tipo_Produto) {
		this.tipo_Produto = tipo_Produto;
	}
	
	

}
