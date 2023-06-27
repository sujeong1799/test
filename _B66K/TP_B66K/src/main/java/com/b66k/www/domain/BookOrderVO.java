package com.b66k.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookOrderVO {

	private int ono;
	private String id;
	private int bno;
	private int price;
	private String title;
	private int count;
	private int total; // 총금액
	private String name; // 수령인 이름
	private String address_code; // 우편주소
	private String address_juso; // 도로명주소
	private String address_detail; // 상세주소
	private String pay_type; // 결제방법
	private String order_status; // 주문상태(주문대기 & 주문완료 & 주문취소)
	
}
