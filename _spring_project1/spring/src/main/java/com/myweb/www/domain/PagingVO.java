package com.myweb.www.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PagingVO {
	
	private int pageNo; // 현재 화면에 출력된 페이지네이션 번호 (누르는 페이지 넘버)
	private int qty; // 한페이지당 보여지는 게시글 수 (10개)
	
	// 검색고나련 멤버변수
	private String type;
	private String keyword;
	
	// 특별한 VO들은 생성자 직접 만ㄷ늘어줘야함
	
	public PagingVO() {
		this(1, 10); // 1페이지에 10개
	}
		
	public PagingVO(int pageNo, int qty) {
		this.pageNo = pageNo;
		this.qty = qty;
	}
	
	public int getPageStart() { // DB상 limit의 시작값을 구하는 메서드
		//limit의 시작값은 0부터 10개  limit 0, 10 이렇게 들어가야함
		return (this.pageNo-1)*qty;
	}
	
	
	// 이게뭐징?
	public String[] getTypeToArray() {
		return this.type == null ? new String[] {} : this.type.split("");
	}
	
	
	
}
