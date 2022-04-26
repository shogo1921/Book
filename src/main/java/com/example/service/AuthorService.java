package com.example.service;

import java.util.List;

import com.example.domain.Author;

public interface AuthorService {

	List<Author> getAuthorList();
	Author getAuthorById(int id);
	void addAuthor(Author author);

}