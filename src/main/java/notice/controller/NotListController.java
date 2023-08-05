package notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NotListController
 */
@WebServlet("/notice/list.do")
public class NotListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// notice/list.do는 get방식으로동작
		// SELECT * FROM CANON_NOTICE_TBL ORDER BY NOTICE_NO DESC (최신순 내림차순으로 가져오기)
		NoticeService service = new NoticeService();
		String page = request.getParameter("currentPage") != null ? request.getParameter("currentPage") : "1"; // page 1로세팅 삼항연산자
		int currentPage = Integer.parseInt(page);
		// nList는 없어도 널이 아니라서 isEmpt()로 비어있는지 체크
		// 비슷한 방법으로 nList.size() > 0 가 있음
		List<Notice> nList = service.selectNoticeList(currentPage);
		if(nList.isEmpty()) {
			// 성공하면 list.jsp
			request.setAttribute("nList", nList);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp"); //list.do test...
			view.forward(request, response); 
		} else {
			request.setAttribute("msg", "리스트 조회가 되지 않습니다.");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
