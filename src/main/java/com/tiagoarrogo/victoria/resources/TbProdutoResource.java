package com.tiagoarrogo.victoria.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tiagoarrogo.victoria.domain.Tb_Produtos;
import com.tiagoarrogo.victoria.services.Tb_ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class TbProdutoResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Tb_ProdutoService service;
	
	
	@RequestMapping(value = "/lista")
	public ResponseEntity<List<Tb_Produtos>> findAll(@RequestParam(value = "codigoMarca", defaultValue = "")String codigoMarca,
													 @RequestParam(value = "codigoTpLente", defaultValue = "")Integer codigoTpLente){
				
		List<Tb_Produtos> list = service.findAll(codigoMarca, codigoTpLente);
		return ResponseEntity.ok().body(list);
		
		
		
	}
	
	
	
}
