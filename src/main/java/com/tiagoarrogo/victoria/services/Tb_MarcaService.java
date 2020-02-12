package com.tiagoarrogo.victoria.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.Tb_Marca;
import com.tiagoarrogo.victoria.repositories.TbMarcaRepository;

@Service
public class Tb_MarcaService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TbMarcaRepository repo;
	
	public List<Tb_Marca> findAll(Integer id){
		return repo.findAll(id);
	}

}
