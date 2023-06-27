package com.b66k.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class WordVO {
	
	/*
	 create table word(
wno int auto_increment NOT NULL,
content text,
primary key(wno)
);
*/
	
	private int wno;
	private String content;
	

}