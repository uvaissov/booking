package kz.astana.uvaissov.booking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.User;
import kz.astana.uvaissov.booking.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Client findClientByUser(User user) {
		return clientRepository.findByUsers(user);
	}

	@Override
	public void saveClient(Client client) {
		clientRepository.save(client);
		
	}

}
