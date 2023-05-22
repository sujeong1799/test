package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.xdevapi.JsonArray;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;


@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	// 목적지 주소로 보내는 destPage는 쓰지않음.
	// 비동기 통신으로 요청이 온 곳으로 돌려보낸다.
	private int isOk;
	private CommentService csv;

    public CommentController() {
    	csv = new CommentServiceImpl();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 캐릭터 인코딩 설정, 컨텐츠 타입 설정
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//contentType은 사용하지 않는다.
//		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI(); // 전체 요청경로
		log.info(">>> uri  " + uri);
		
		String pathUri = uri.substring("/cmt/".length());
		log.info(">>path: " + pathUri);
		// pathUri의 결과 modify/1, post
		
		String path = pathUri;
		
		//뒤에 있는 숫자
		String pathVar = "";
		
		if(pathUri.contains("/")) { // "/"이게 있다면
			// 추출을 할거여
			// pathUri의 결과 modify/1를 m부터 '/' 앞까지 추출한다. 결과 -> modify
			path = pathUri.substring(0, pathUri.lastIndexOf("/"));
			
			// modify/1 의 뒤에 숫자만 추출 
			pathVar = pathUri.substring(pathUri.lastIndexOf("/")+1);
		}
		
		log.info(path);
		log.info(pathVar);
		
		switch(path) {
		case "post":
			try {
			// js에서 보낸 데이터를 StringBuffer로 읽어들이는 작업
				StringBuffer sb = new StringBuffer(); // sb에다가 객체 담을거야
				String line = "";
				BufferedReader br = request.getReader(); // 댓글 객체를 들고와
				while((line = br.readLine()) != null) { // line에 값이 있다면(line이 null이라면 더이상 읽을게 없음) 
					sb.append(line); // sb에 추가하고
				}
				log.info(">>> sb : "+ sb.toString()); // toString 찍어줄거야.
				
				// 객체로 생성
				// JSON <-> text
				JSONParser parser = new JSONParser();
				// JSONObject는 JSON데이터를 java에서 다루기 쉽게 해주는 클래스다.
				// parser.parse(sb.soString()) 부분은 위에서 만든 객체를 JSONObject로 형태 변환을 하고
				// Object 타입으로 반환한다.
				JSONObject jsonObj = (JSONObject)parser.parse(sb.toString());
				
				
				// jsonObj에서 값을 가져와서 객체에 담기
				int bno = Integer.parseInt(jsonObj.get("bno").toString());
				String writer = jsonObj.get("writer").toString();
				String content = jsonObj.get("content").toString();
				CommentVO cvo = new CommentVO(bno, writer, content);
				isOk = csv.post(cvo);
				log.info(">>> post : "+ (isOk > 0 ? "성공":"실패"));
				
				// 결과 전송
				PrintWriter out = response.getWriter();
				out.print(isOk);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "list":
			try {
				int bno = Integer.parseInt(pathVar); 
				log.info("bno > "+bno);
	    		
				// bno 달고 해당하는 리스트 가져오기
				List<CommentVO> list = csv.List(bno);
				log.info(">>> Comment List > DB Ok");
				
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				for(int i=0; i<list.size(); i++) {
					jsonObjArr[i] = new JSONObject(); // key : value 형태로 저장할수있는 객체가 만들어짐
					jsonObjArr[i].put("cno", list.get(i).getCno());
					jsonObjArr[i].put("bno", list.get(i).getBno());
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("reg_date", list.get(i).getReg_date());
					
					jsonObjList.add(jsonObjArr[i]);
					
				}
				log.info(">>> jsonObjList >" + jsonObjList);
				
				// jsonData란 이름으로 toString형태를 보냄
				String jsonData = jsonObjList.toJSONString();
				log.info(">>> jsonData > "+jsonData);
				
				PrintWriter out = response.getWriter();
				out.print(jsonData);
				
				
			} catch (Exception e) {
				log.info(">>> comment list > error");
				e.printStackTrace();
			}
			break;
		}
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
