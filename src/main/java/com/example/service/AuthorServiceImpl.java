package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Author;
import com.example.mapper.AuthorMapper;

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorMapper mapper;

	@Override
	public List<Author> getAuthorList() {
		return mapper.findAll();
	}

	@Override
	public Author getAuthorById(int id) {
		return mapper.findById(id);
	}

	@Override
	public void addAuthor(Author author) {
		// 著者名の追加
		mapper.insert(author); // auto_incrementで生成されたidがセットされる
		// 著者詳細にidをセット
		int authorId = author.getId();
		author.getDetail().setId(authorId);
		// 著者詳細を追加
		mapper.insertDetail(author.getDetail());
	}

}
