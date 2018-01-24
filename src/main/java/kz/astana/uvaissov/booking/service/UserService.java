package kz.astana.uvaissov.booking.service;

import kz.astana.uvaissov.booking.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
