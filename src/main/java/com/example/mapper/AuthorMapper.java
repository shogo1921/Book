package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Author;
import com.example.domain.AuthorDetail;

@Mapper
public interface AuthorMapper {

	List<Author> findAll();
	Author findById(Integer id);
	void insert(Author author);
	void insertDetail(AuthorDetail detail);

}