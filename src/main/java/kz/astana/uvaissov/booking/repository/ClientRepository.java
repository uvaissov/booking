package kz.astana.uvaissov.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.User;


@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Integer>{
	Client findByUsers(User user);
}