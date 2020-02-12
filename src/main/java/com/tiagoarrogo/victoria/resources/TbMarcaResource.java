package com.tiagoarrogo.victoria.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoarrogo.victoria.domain.Tb_Marca;
import com.tiagoarrogo.victoria.services.Tb_MarcaService;

@RestController
@RequestMapping(value = "/marcas")
public class TbMarcaResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Tb_MarcaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Marca>> findAll(@PathVariable Integer id){
		
		List<Tb_Marca> list = service.findAll(id);
		return ResponseEntity.ok().body(list);
		
	}

}
