package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NotInsertController
 */
@WebServlet("/notice/insert.do")
public class NotInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//공지사항 등록
		request.setCharacterEncoding("UTF-8");
		NoticeService service = new NoticeService();
		// getParameter() : jsp태그 내의 name속성에 담긴 value를 받아올 수 있음
		// getParameterValues() : jsp태그 내의 중복되는 name속성 값을 배열형태로 받아온다.
		String noticeTitle = request.getParameter("noticeTitle"); // input name값
		String noticeContents = request.getParameter("noticeContents"); // input name값
		Notice notice = new Notice(noticeTitle, noticeContents);
		int result = service.insertNotice(notice);
		if (result > 0) {
			// 성공하면 목록쪽으로이동 list.do
			response.sendRedirect("/notice/list.do");
		} else {
			// 실패하면 에러메시지
			request.setAttribute("msg", "공지사항입력 실패했습니다.");
			RequestDispatcher view =  request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
		
	}
}
