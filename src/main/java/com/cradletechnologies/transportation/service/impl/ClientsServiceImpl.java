package com.cradletechnologies.transportation.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cradletechnologies.transportation.filter.ClientsDataFilter;
import com.cradletechnologies.transportation.model.Clients;
import com.cradletechnologies.transportation.repository.ClientsRepository;
import com.cradletechnologies.transportation.service.ClientsService;

@Service
public class ClientsServiceImpl implements ClientsService{

	@Autowired
	private ClientsRepository clientsRepository;

	@Override
	public List<Clients> getAllClients() {
		return this.clientsRepository.findAll();
	}

	@Override
	public Clients saveClient(Clients client) {
		return this.clientsRepository.save(client);
		
	}

	@Override
	public Clients getClient(int id) {
		Optional<Clients> optional = clientsRepository.findById(id);
		Clients client = null;
		if(optional.isPresent()) {
			client = optional.get();
		}
		else {
			throw new RuntimeException("Location not found for id : "+id);
		}
		return client;
	}


	@Override
	public void deleteClient(int id) {
		this.clientsRepository.deleteById(id);
		
	}

	@Override
	public Page<Clients> getClientsForDatatable(String queryString, Pageable pageable) {
		ClientsDataFilter clientsDataFilter = new ClientsDataFilter(queryString);
		return clientsRepository.findAll(clientsDataFilter, pageable);
	}
	
	

}
