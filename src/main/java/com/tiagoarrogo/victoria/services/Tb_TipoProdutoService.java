package com.tiagoarrogo.victoria.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.Tb_TipoProduto;
import com.tiagoarrogo.victoria.repositories.TbTipoProdutoRepository;


@Service
public class Tb_TipoProdutoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TbTipoProdutoRepository repo;
	
	public List<Tb_TipoProduto> findAll() {

		return repo.findAll();
	}

}
