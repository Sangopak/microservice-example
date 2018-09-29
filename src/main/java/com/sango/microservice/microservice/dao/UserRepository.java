package com.sango.microservice.microservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sango.microservice.microservice.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
