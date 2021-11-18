package com.example.security.service;

import com.example.security.entity.Post;
import java.util.List;




public interface PostService {
	List<Post> readAll();
	Post create(Post post);
	Post update(Post post);
	Post read(int id);
	void delete(int id);
}
