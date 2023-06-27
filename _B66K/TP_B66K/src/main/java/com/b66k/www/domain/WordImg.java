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
public class WordImg {

	
	/*
	 create table wordImg(
cino int auto_increment NOT NULL,
save_path varchar(256),
primary key(cino)
);
*/
	
	private int cino;
	private String save_path;
	
}
