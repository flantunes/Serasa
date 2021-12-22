package com.testet.serasa.controller;

import java.util.List;

import com.testet.serasa.model.Client;

import com.testet.serasa.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {

	@Autowired
	private ClientRepository repository;

	@GetMapping
	public ResponseEntity<List<Client>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Client> post(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(client));
	}

	@PutMapping
	public ResponseEntity<Client> put(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(client));
	}

}