package com.example.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Reviewer;
import com.example.mapper.ReviewerMapper;

@Transactional
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	ReviewerMapper mapper;

	@Override
	public Reviewer getLoginReviewer(String loginId, String loginPass) {
		Reviewer reviewer = mapper.findByLoginId(loginId);
		if(reviewer == null) {
			System.out.println("Wrong Login ID");
			return null;
		}

		String hashedPass = reviewer.getLoginPass();
		if(!BCrypt.checkpw(loginPass, hashedPass)) {
			System.out.println("Wrong Password");
			return null;
		}

		return reviewer;
	}

}