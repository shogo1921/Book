package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Book;

@Mapper
public interface BookMapper {

	List<Book> findAll();

}