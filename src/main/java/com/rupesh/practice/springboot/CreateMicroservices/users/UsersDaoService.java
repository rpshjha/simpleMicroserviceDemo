package com.rupesh.practice.springboot.CreateMicroservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UsersDaoService {

	private static List<User> users = new ArrayList<>();

	private int userCount = 5;

	static {
		users.add(new User(1, "Jane", new Date()));
		users.add(new User(2, "Jonny", new Date()));
		users.add(new User(3, "Adam", new Date()));
		users.add(new User(4, "Eve", new Date()));
		users.add(new User(5, "Jack", new Date()));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUser(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public User addUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User deleteUser(int id) {
		Iterator<User> userIterator = users.iterator();

		while (userIterator.hasNext()) {
			User user = userIterator.next();
			if (user.getId() == id) {
				userIterator.remove();
				return user;
			}
		}
		return null;
	}

}
