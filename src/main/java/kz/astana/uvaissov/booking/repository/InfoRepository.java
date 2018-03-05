package kz.astana.uvaissov.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.astana.uvaissov.booking.entity.Client;
import kz.astana.uvaissov.booking.entity.ClientInfo;
import kz.astana.uvaissov.booking.entity.User;


@Repository("infoRepository")
public interface InfoRepository extends JpaRepository<ClientInfo, Long>{
	ClientInfo findByInfoId(Long id);
}