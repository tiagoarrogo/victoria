package com.tiagoarrogo.victoria.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.Tb_Produtos;
import com.tiagoarrogo.victoria.repositories.TbProdutoRepository;

@Service
public class Tb_ProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TbProdutoRepository repo;
	
	public List<Tb_Produtos> findAll(String marcaCodigo, Integer marcaTpProduto){
		
		return repo.findAll(marcaCodigo, marcaTpProduto);
		
	}
	
	
	

}
