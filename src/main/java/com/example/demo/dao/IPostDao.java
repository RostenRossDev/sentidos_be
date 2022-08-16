package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Post;


@Repository
public interface IPostDao extends CrudRepository<Post, Long>{
		
			
}
