package com.myweb.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDAO cdao;
}
