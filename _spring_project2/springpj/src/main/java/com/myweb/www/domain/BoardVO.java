package com.myweb.www.domain;

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
public class BoardVO {
/*
create table board(
bno int not null auto_increment,
title varchar(200),
content text,
writer varchar(100),
reg_date datetime default now(),
read_count int,
isDel varchar(50) default "N",
primary key(bno));
*/
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String reg_date;
	private int read_count;
	private String isDel;
	
}
