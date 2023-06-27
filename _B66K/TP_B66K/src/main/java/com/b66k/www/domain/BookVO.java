package com.b66k.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookVO {
/*
create table book(
bno int auto_increment not null,
author varchar(100),
title varchar(100),
price int,
grade double,
amount int,
sale_amount int,
primary key(bno));
*/
	
	private int bno;
	private String author; // 작가
	private String title;
	private int price;
	private double grade; // 평점
	private int amount; // 재고
	private int sale_amount; // 판매량
	

}
