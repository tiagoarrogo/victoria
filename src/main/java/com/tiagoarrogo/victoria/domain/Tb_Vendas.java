package com.tiagoarrogo.victoria.domain;

import java.io.Serializable;


public class Tb_Vendas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer loja;
	private String nomeLoja;	
	private String anoVenda;	
	private Double total;
	private String prod_Marca;
	private String vendedor;
	private Integer qtdeVenda;
	private Double ticketMedio;
	private Double totalOriginal;
	
	
	
	public Tb_Vendas() {
		
	}


	public Tb_Vendas(Integer loja, String nomeLoja, String anoVenda, Double total, String prod_Marca, String vendedor, Integer qtdeVenda, Double ticketMedio, Double totalOriginal) {
		super();
		this.loja = loja;
		this.nomeLoja = nomeLoja;
		this.anoVenda = anoVenda;
		this.total = total;
		this.prod_Marca = prod_Marca;
		this.vendedor = vendedor;
		this.qtdeVenda = qtdeVenda;
		this.ticketMedio = ticketMedio;
		this.totalOriginal = totalOriginal;
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


	public String getAnoVenda() {
		return anoVenda;
	}


	public void setAnoVenda(String anoVenda) {
		this.anoVenda = anoVenda;
	}


	public Double getTotal() {
		return total;
	}


	public void setTotal(Double total) {
		this.total = total;
	}


	public String getProd_Marca() {
		return prod_Marca;
	}


	public void setProd_Marca(String prod_Marca) {
		this.prod_Marca = prod_Marca;
	}


	public String getVendedor() {
		return vendedor;
	}


	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}


	public Integer getQtdeVenda() {
		return qtdeVenda;
	}


	public void setQtdeVenda(Integer qtdeVenda) {
		this.qtdeVenda = qtdeVenda;
	}


	public Double getTicketMedio() {
		return ticketMedio;
	}


	public void setTicketMedio(Double ticketMedio) {
		this.ticketMedio = ticketMedio;
	}


	public Double getTotalOriginal() {
		return totalOriginal;
	}


	public void setTotalOriginal(Double totalOriginal) {
		this.totalOriginal = totalOriginal;
	}




	
	

}
