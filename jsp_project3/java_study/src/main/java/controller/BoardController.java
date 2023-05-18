package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.MemberVO;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// log 설정
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	private RequestDispatcher rdp;
	private BoardService bsv;
	private int isOk;
	private String destPage;

	public BoardController() {
		bsv = new BoardServiceImpl();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String uri = request.getRequestURI(); // 전체 요청경로
		System.out.println(">>> uri  " + uri);
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>path: " + path);

		switch (path) {

		case "insert":
			try {
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");

				BoardVO bvo = new BoardVO(title, writer, content);

				isOk = bsv.insert(bvo);
				log.info(">>> 글 등록 > " + (isOk > 0 ? "성공" : "실패"));

			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage = "/";
			break;

		case "list":
			try {
				List<BoardVO> list = new ArrayList<>();
				list = bsv.list();
				request.setAttribute("list", list);
				log.info(">>> list 출력 완료");
				destPage = "/board/list.jsp";
			} catch (Exception e) {
			}
			break;

		case "detail":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = new BoardVO();
				bvo = bsv.detail(bno);
				request.setAttribute("bvo", bvo);
				log.info(">>> detail 출력 완료");
				destPage = "/board/detail.jsp";
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;

		case "editPage":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				BoardVO bvo = new BoardVO();
				bvo = bsv.detail(bno);
				request.setAttribute("bvo", bvo);
				log.info(">>> detail 출력 완료");
				destPage = "/board/edit.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case "edit":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				BoardVO bvo = new BoardVO(bno, title, content);
				isOk = bsv.edit(bvo);
				log.info(">>> edit > " + (isOk > 0 ? "성공" : "실패"));

				if (isOk > 0) {
					request.setAttribute("bvo", bvo);
				}

				destPage = "/brd/list";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "remove":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));

				isOk = bsv.remove(bno);
				log.info(">>> 글 삭제 >" + (isOk > 0 ? "성공" : "실패"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage = "/brd/list";
			break;

		case "mylist":
			try {

				String writer = request.getParameter("writer");

				List<BoardVO> mylist = new ArrayList<BoardVO>();
				mylist = bsv.mylist(writer);
				log.info("mylist size > "+mylist.size());
				
				//가져온 리스트 사이즈가 0보다 크면 setAttribute로 넣어주고 출력한다.
				if (mylist.size() > 0) {
					request.setAttribute("list", mylist);
					log.info(">>> mylist 출력 완료");
					destPage = "/board/mylist.jsp";
				} else {
					log.info("작성한 글이 없습니다.");
					// alert를 뜨게하기위해 
					request.setAttribute("msg_mylist", 0);
					destPage = "/";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			break;

		}

		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

}
