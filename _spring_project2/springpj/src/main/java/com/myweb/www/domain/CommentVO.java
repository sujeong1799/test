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
public class CommentVO {
/*
create table comment(
cno int not null auto_increment,
bno int not null,
writer varchar(100) not null,
content text,
reg_date datetime default now(),
mod_date datetime default now(),
primary key(cno));
 */
	
	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String reg_date;
	private String mod_date;

}
