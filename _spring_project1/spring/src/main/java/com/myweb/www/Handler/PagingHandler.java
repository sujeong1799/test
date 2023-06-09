package com.myweb.www.Handler;

import com.myweb.www.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PagingHandler {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int totalCount;
	private PagingVO pgvo;
	
	public PagingHandler(PagingVO pgvo, int totalCount) {
		this.pgvo = pgvo;
		this.totalCount = totalCount;
		this.endPage = 
				(int)(Math.ceil(pgvo.getPageNo() / (pgvo.getQty() * 1.0))) * pgvo.getQty(); // 소수점을 만들어야 값을 올릴수잇다
		this.startPage = endPage -9; // 시작페이지 = 10 - 9
		int realEndPage = (int)Math.ceil((totalCount*1.0) / pgvo.getQty());
		
		if(realEndPage < this.endPage) { // 실제엔드페이지가 endpage보다 작을때
			this.endPage = realEndPage;	
		}
		
		this.prev = this.startPage > 1; // 1 > 11  //결과는 true / false임
		this.next = this.endPage < realEndPage; // 리얼엔드까지 갈떄까지 계속 생겨야함 //true면 생기는거고 / false면 안생김 
		
	}
}
