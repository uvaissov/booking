package kz.astana.uvaissov.booking.service;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.User;

public interface ClientService {
	public Client findClientByUser(User user);
	public void saveClient(Client user);
}
