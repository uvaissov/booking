package kz.astana.uvaissov.booking.service;

import kz.astana.uvaissov.booking.entity.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
