package com.sango.microservice.microservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sango.microservice.microservice.domain.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{

}
