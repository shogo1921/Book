package com.example.service;

import com.example.domain.Reviewer;

public interface LoginService {

	Reviewer getLoginReviewer(String loginId, String loginPass);

}