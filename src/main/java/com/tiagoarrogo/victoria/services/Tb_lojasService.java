package com.tiagoarrogo.victoria.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.Tb_loja;
import com.tiagoarrogo.victoria.repositories.TbLojasRepository;

@Service
public class Tb_lojasService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TbLojasRepository repo;
	
	public List<Tb_loja> findAll(){
		
		return repo.findAll();
		
	}

}
