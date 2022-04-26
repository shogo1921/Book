package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Reviewer;

@Mapper
public interface ReviewerMapper {

	Reviewer findByLoginId(String loginId);

}