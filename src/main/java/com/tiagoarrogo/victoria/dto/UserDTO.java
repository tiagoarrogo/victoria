package com.tiagoarrogo.victoria.dto;

import java.io.Serializable;

import com.tiagoarrogo.victoria.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String email;
	private String senha;
	
	
	public UserDTO() {
		
	}
	
	public UserDTO(User obj) {
		
		id = obj.getId();
		email = obj.getEmail();
		senha = obj.getSenha();
		
		
	}

	public UserDTO(Integer id, String email, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
}
