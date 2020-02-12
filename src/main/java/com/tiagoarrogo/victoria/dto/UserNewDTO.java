package com.tiagoarrogo.victoria.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class UserNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String senha;
	
	private String loja;
	
	public UserNewDTO() {
		
	}

	public UserNewDTO(String email, String senha, String loja) {
		super();
		this.email = email;
		this.senha = senha;
		this.loja = loja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLoja() {
		return loja;
	}

	public void setLoja(String loja) {
		this.loja = loja;
	}
	

}
