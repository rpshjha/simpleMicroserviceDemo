package com.rupesh.practice.springboot.CreateMicroservices.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Integer> {

}
