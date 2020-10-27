package com.rupesh.practice.springboot.CreateMicroservices.users;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UsersDaoService service;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = service.findById(id);

		if (user == null) {
			throw new UserNotFoundException("id - " + id);
		}
		return user;
	}

	@PostMapping(path = "/add-user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User addedUser = service.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(addedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = service.deleteById(id);

		if (deletedUser == null) {
			throw new UserNotFoundException("id - " + id);
		}
	}

}
