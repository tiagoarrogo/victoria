package com.tiagoarrogo.victoria.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiagoarrogo.victoria.domain.Tb_Metas;
import com.tiagoarrogo.victoria.dto.Tb_MetasDTO;
import com.tiagoarrogo.victoria.services.Tb_MetasService;

@RestController
@RequestMapping(value = "/metas")
public class TbMetasResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Tb_MetasService service;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tb_Metas> find(@PathVariable Integer id){
		
		Tb_Metas obj = service.find(id);
		return ResponseEntity.ok().body(obj); 
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Metas>> findAll(){
				
		List<Tb_Metas> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/metageral", method = RequestMethod.GET)
	public ResponseEntity<Double> findMetaGeral(@RequestParam(value = "lojas", defaultValue = "")String lojas){
				
		double obj = service.findMetaGeral(lojas.replace("'", ""));
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/metaloja", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Metas>> findMetaLoja(){
		
		List<Tb_Metas> obj = service.findMetaLoja();
		return ResponseEntity.ok().body(obj);
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Tb_MetasDTO objDto){
		
		Tb_Metas obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Tb_MetasDTO objDto, @PathVariable Integer id){
		
		Tb_Metas obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	

}
