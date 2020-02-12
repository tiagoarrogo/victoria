package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;

public class Tb_Produtos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String cod_produto;
	private String descricao;
	private String unidade;
	private String preco_ven;
	private String valor_bonus;
	
	
	public Tb_Produtos() {
		
	}


	public Tb_Produtos(String cod_produto, String descricao, String unidade, String preco_ven, String valor_bonus) {
		super();
		this.cod_produto = cod_produto;
		this.descricao = descricao;
		this.unidade = unidade;
		this.preco_ven = preco_ven;
		this.valor_bonus = valor_bonus;
	}


	public String getCod_produto() {
		return cod_produto;
	}


	public void setCod_produto(String cod_produto) {
		this.cod_produto = cod_produto;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getUnidade() {
		return unidade;
	}


	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}


	public String getPreco_ven() {
		return preco_ven;
	}


	public void setPreco_ven(String preco_ven) {
		this.preco_ven = preco_ven;
	}


	public String getValor_bonus() {
		return valor_bonus;
	}


	public void setValor_bonus(String valor_bonus) {
		this.valor_bonus = valor_bonus;
	}
	
	

}
