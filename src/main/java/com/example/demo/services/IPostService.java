package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Post;


public interface IPostService {
	public List<Post> findAll();
	public Post save(Post post);
	public void deleteById(Long id);
}
