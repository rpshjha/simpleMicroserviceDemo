package com.rupesh.practice.springboot.CreateMicroservices.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}
