package com.jp.springbootH2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jp.springbootH2.entities.User;
import com.jp.springbootH2.repositories.UserRepository;
import com.jp.springbootH2.services.exceptions.DatabaseException;
import com.jp.springbootH2.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User create(User user) {
		return repository.save(user);
	}
	
	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}

	public void delete(Long id) {
		try {
			if (repository.existsById(id)) {
	            repository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException(id);			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }	
	}

}