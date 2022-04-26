package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Book;
import com.example.mapper.BookMapper;

@Transactional
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookMapper mapper;

	@Override
	public List<Book> getAllBooks() {
		return mapper.findAll();
	}

}

