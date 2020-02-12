package com.tiagoarrogo.victoria.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoarrogo.victoria.domain.Tb_TipoProduto;
import com.tiagoarrogo.victoria.services.Tb_TipoProdutoService;


@RestController
@RequestMapping(value = "/tipoprodutos")
public class TbTipoProdutoResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Tb_TipoProdutoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tb_TipoProduto>> findAll(){
		
	List<Tb_TipoProduto> list = service.findAll();
	return ResponseEntity.ok().body(list);
		
	}
	

}
