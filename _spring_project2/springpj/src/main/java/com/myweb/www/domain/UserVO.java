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
public class UserVO {
/*
 create table user(
id varchar(100) not null,
pw varchar(100) not null,
name varchar(100),
email varchar(100),
home varchar(100),
birth int,
reg_date datetime default now(),
primary key(id)); 
*/
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private String home;
	private int birth;
	private String reg_date;
	
	
}
