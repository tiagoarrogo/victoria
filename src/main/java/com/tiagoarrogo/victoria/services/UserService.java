package com.tiagoarrogo.victoria.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.User;
import com.tiagoarrogo.victoria.dto.UserNewDTO;
import com.tiagoarrogo.victoria.repositories.UserRepository;
import com.tiagoarrogo.victoria.security.UserSS;
import com.tiagoarrogo.victoria.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	
	@Transactional
	public User insert(User obj) {		
		obj.setId(null);
		repo.save(obj);
		return obj;
		
	}
	
	
	
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}


	public User fromDTO(UserNewDTO objDto) {
		
		User user = new User(null, objDto.getEmail(), pe.encode(objDto.getSenha()));			
		return user;
	}


	public void delete(Integer id) {

		try {
			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new ObjectNotFoundException("Não é possível excluir uma entidade que possui relacionamentos!");
		}
	}




}
