package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPostDao;
import com.example.demo.entities.Post;


@Service
public class PostServiceImpl implements IPostService{

	@Autowired
	IPostDao postDao;
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return (List<Post>) postDao.findAll();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return postDao.save(post);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		postDao.deleteById(id);
	}

	
	
}
