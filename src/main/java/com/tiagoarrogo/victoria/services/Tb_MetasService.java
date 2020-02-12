package com.tiagoarrogo.victoria.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.Tb_Metas;
import com.tiagoarrogo.victoria.dto.Tb_MetasDTO;
import com.tiagoarrogo.victoria.repositories.TbMetasRepository;
import com.tiagoarrogo.victoria.services.exceptions.DataIntegrityException;
import com.tiagoarrogo.victoria.services.exceptions.ObjectNotFoundException;

@Service
public class Tb_MetasService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TbMetasRepository repo;

	public Tb_Metas find(Integer id) {
		
		Optional<Tb_Metas> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Tb_Metas.class.getName()));
		
	}

	public List<Tb_Metas> findAll() {
		
		return repo.findAll();
	}
	public double findMetaGeral(String lojas) {
		
		List<String> myList = new ArrayList<String>(Arrays.asList(lojas.split(",")));		
		
		return repo.findMetaGeral(myList);
	}
	
	public List<Tb_Metas> findMetaLoja(){
		
		return repo.findAll();
		 
		
		
	}

	public Tb_Metas fromDTO(Tb_MetasDTO objDto) {
		
		Tb_Metas obj = new Tb_Metas(null, objDto.getMes_Meta(), objDto.getCod_Loja(), objDto.getNome_Loja(), objDto.getValor_Meta());		
		
		return obj;
	}

	@Transactional
	public Tb_Metas insert(Tb_Metas obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Tb_Metas update(Tb_Metas obj) {
		
		Tb_Metas newObj = find(obj.getId());
		updateData(newObj, obj);
				
		return repo.save(newObj);
	}

	private void updateData(Tb_Metas newObj, Tb_Metas obj) {
		
		newObj.setCod_Loja(obj.getCod_Loja());
		newObj.setNome_Loja(obj.getNome_Loja());
		newObj.setMes_Meta(obj.getMes_Meta());
		newObj.setValor_Meta(obj.getValor_Meta());
		
	}

	public void delete(Integer id) {
		
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma meta que posui vinculos!");
		}
		
	}

}