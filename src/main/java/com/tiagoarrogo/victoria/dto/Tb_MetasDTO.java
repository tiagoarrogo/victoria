package com.tiagoarrogo.victoria.dto;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;


public class Tb_MetasDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

		
	@JsonFormat(pattern="yyyy-MM")
	private Date mes_Meta;
	
	private Integer cod_Loja;
	
	private String nome_Loja;

	private float valor_Meta;
	
	
	public Tb_MetasDTO() {
		
	}


	public Tb_MetasDTO(Date mes_Meta, Integer cod_Loja, String nome_Loja, float valor_Meta) {
		super();
		
		this.mes_Meta = mes_Meta;		
		this.nome_Loja = nome_Loja; 
		this.valor_Meta = valor_Meta;
		this.cod_Loja = cod_Loja;
	}


	

	public Date getMes_Meta() {
		return mes_Meta;
	}


	public void setMes_Meta(Date mes_Meta) {
		this.mes_Meta = mes_Meta;
	}
	
	
	
	public Integer getCod_Loja() {
		return cod_Loja;
	}


	public void setCod_Loja(Integer cod_Loja) {
		this.cod_Loja = cod_Loja;
	}


	public String getNome_Loja() {
		return nome_Loja;
	}


	public void setNome_Loja(String nome_Loja) {
		this.nome_Loja = nome_Loja;
	}


	public float getValor_Meta() {
		return valor_Meta;
	}


	public void setValor_Meta(float valor_Meta) {
		this.valor_Meta = valor_Meta;
	}


		
	

}
