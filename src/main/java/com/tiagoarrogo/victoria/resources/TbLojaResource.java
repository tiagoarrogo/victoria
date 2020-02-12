package com.tiagoarrogo.victoria.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoarrogo.victoria.domain.Tb_loja;
import com.tiagoarrogo.victoria.services.Tb_lojasService;

@RestController
@RequestMapping(value = "/lojas")
public class TbLojaResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Tb_lojasService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tb_loja>> findAll(){
		
		List<Tb_loja> list = service.findAll();
		return ResponseEntity.ok().body(list);		
		
	}
	

}
