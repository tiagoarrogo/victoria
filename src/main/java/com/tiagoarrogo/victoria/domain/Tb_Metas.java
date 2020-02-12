package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tb_Metas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date mes_Meta;
	
	private Integer cod_Loja;
	private String nome_Loja;

	private double valor_Meta;
	
	
	public Tb_Metas() {
		
	}


	public Tb_Metas(Integer id, Date mes_Meta, Integer cod_Loja, String nome_Loja, double valor_Meta) {
		super();
		this.id = id;
		this.mes_Meta = mes_Meta;		
		this.nome_Loja = nome_Loja; 
		this.valor_Meta = valor_Meta;
		this.cod_Loja = cod_Loja;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public double getValor_Meta() {
		return valor_Meta;
	}


	public void setValor_Meta(double valor_Meta) {
		this.valor_Meta = valor_Meta;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;		
		result = prime * result + ((mes_Meta == null) ? 0 : mes_Meta.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tb_Metas other = (Tb_Metas) obj;		
		if (mes_Meta == null) {
			if (other.mes_Meta != null)
				return false;
		} else if (!mes_Meta.equals(other.mes_Meta))
			return false;
		return true;
	}
	
	
	

}
