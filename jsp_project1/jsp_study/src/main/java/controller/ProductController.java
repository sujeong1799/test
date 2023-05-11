package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import service.ProductService;
import service.Service;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 상품등록, 상품리스트, 상품상세, 상품수정, 상품삭제에 대한 분기처리를 해야한다.
	// ~ 흐름 ~
	// 컨트롤러는 서비스를 호출해서 값을 처리. (메서드 호출)
	// 서비스는 DAO를 호출해서 처리
	// DAO는 DBconnection을 연결해서 처리

	// 멤버변수
	private Service svc;

	// 생성자
	public ProductController() {
		svc = new ProductService();

	}

	// 주 작업 영역
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get/post 모든 처리는 service에서 처리함
		// post방식으로 데이터 처리를 할 때 한글이 다 깨지는 것을 방지하려면 인코딩 해줘야한다.
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 보내는 response 객체 세팅
		response.setContentType("text/html; charset=UTF-8");

		// 무슨주소를 달고 오는지를 알아야함 uri는 요청에 대한 모든 객체를 담고 있다.
		// request에서 오는 requestURI를 가져와서 uri에 담아줄거임
		String uri = request.getRequestURI(); // 요청경로(원하는 서비스를 달고옴) 컨트롤러주소/요청서비스 < 이렇게 달고오는데 우리는 요청서비스만 달고올거임
		System.out.println("요청 uri >> " + uri);
		String context = request.getContextPath(); // 현재 요청하는 프로젝트의 명
		System.out.println("context >> " + context);

		// 객체를 보내야하는 목적지 주소
		String destPage = "";

		// 오는 요청에 대한 처리
		switch (uri) {
		case "/register.pd":
			// /폴더명/jsp파일명.jsp 로 경로설정해준다. 지금은 폴더가 없으니까 그냥 가져온다.
			destPage = "/register.jsp";
			break;

		// 받는거
		case "/insert.pd":
			// DB연결, 등록처리
			// jsp에서 가져온 객체(이름, 가격, 세부정보)를 싣고 insert.pd로 왔다.
			// service에게 가져온 데이터를 객체화 하여 db에 저장해달라고 요청해야함.

			// 1. 객체를 생성한다. String pname = request.getParameter();
			String pname = request.getParameter("pname");
			int price = Integer.parseInt(request.getParameter("price")); // parameter는 String처리가 됨, 그래서 형변환해서 price에
																			// 담아줘야 한다.
			String madeby = request.getParameter("madeby");
			ProductVO pvo = new ProductVO(pname, price, madeby);
			/*
			 * 생성자 없을 경우 ProductVO pvo = new ProdcutVO(); pvo.setPname(pname);
			 * pvo.setPrice(price); pvo.setMadeby(madeby);
			 */

			// 2. service에게 객체주고 요청
			int isOk = svc.register(pvo); // 리턴값 1개의 행이 등록
			System.out.println("상품등록 >>>" + (isOk > 0 ? "성공" : "실패"));

			destPage = "/index.jsp"; // 아직 list안만들었으니까 일단은 이렇게 가
			break;

		case "/list.pd":
			List<ProductVO> list = new ArrayList<ProductVO>();

			list = svc.list();
			request.setAttribute("list", list);
			System.out.println("상품리스트 성공 ◆◆");
			destPage = "/list.jsp";
			break;
		
			
		case "/detail.pd":
			int pno = Integer.parseInt(request.getParameter("pno")); // getParameter는 String이니까 parseInt해줘야함
			//내가 받아야하는 객체는 Product하나임
			ProductVO p = new ProductVO(); // 똑같은 객체 이름 쓰면 걸려서 p라고 썼음
			p = svc.detail(pno);
			// pvo 이름으로 p객체 보낸다.
			request.setAttribute("pvo", p);
			System.out.println("상품상세 성공 !!");
			destPage = "/detail.jsp";
			
			break;
			
		case "/modify.pd":
			// 애들 하나씩 다 데꼬와 ㅡㅡ 
			pno = Integer.parseInt(request.getParameter("pno")); // getParameter는 String이니까 parseInt해줘야함
			request.setAttribute("pvo", svc.detail(pno));
			System.out.println("상품정보가져오기 성공 !!");
			destPage = "/modify.jsp";			
			break;
			
		case "/edit.pd":
			int pno1 = Integer.parseInt(request.getParameter("pno"));
			String pname1 = request.getParameter("pname");
			int price1 = Integer.parseInt(request.getParameter("price"));
			String regdate1 = request.getParameter("regdate");
			String madeby1 = request.getParameter("madeby");
			
			ProductVO pvo1 = new ProductVO(pno1, pname1, price1, regdate1, madeby1);
			
			int isOk2 = svc.edit(pvo1); // 리턴값 1개의 행이 등록
			System.out.println("상품수정 >>>" + (isOk2 > 0 ? "성공" : "실패"));

			destPage = "/list.pd";
			// /list.jsp로 가면 아무것도 안나옴
			break;
			
		case "/remove.pd":
			int pno2 = Integer.parseInt(request.getParameter("pno"));
			
			int isOk3 = svc.remove(pno2); // 리턴값 1개의 행이 등록
			System.out.println("상품삭제 >>>" + (isOk3 > 0 ? "성공" : "실패"));
			destPage = "/list.pd";
			break;
		}
		
		
		
		

		// 웹의 목적지 주소로 연결해주는 객체 (보내는 객체처리) // 없으면 연결이 안됨
		// destPage로 이동시 응답 request객체를 싣고 가야 함
		RequestDispatcher rdp = request.getRequestDispatcher(destPage);
		// rdp에 요청할거여
		rdp.forward(request, response);

	}

	// get 방식으로 오는 값을 체킹하는 부분
	// service를 호출해서 처리할거여
	// service로 처리하면 따로 안받아도 됨 좀 쉽게하기 위해서 서비스로 보내버린다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	// post 방식으로 오는 값을 체킹하는 부분
	// 서비스를 호출해서 처리할거임...
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
