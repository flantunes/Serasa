package com.testet.serasa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testet.serasa.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Optional<Client> findById(long id);

	public List<Client> findAllByNameContainingIgnoreCase(String name);
	

}
