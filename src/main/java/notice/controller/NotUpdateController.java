package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NotUpdateController
 */
@WebServlet("/notice/modify.do")
public class NotUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 이동용
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService service = new NoticeService();
		//SELECT * FROM CANON_NOTICE_TBL WHERE NOTICE_NO = ?
		Notice notice = service.selectOneByNo(noticeNo);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 수정용
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContents = request.getParameter("noticeContents");
		Notice notice = new Notice(noticeNo, noticeTitle, noticeContents);
		NoticeService service = new NoticeService();
		int result = service.updateNotice(notice);
		if(result > 0) {
			// 성공하면 상세페이지
			response.sendRedirect("/notice/detail.do?noticeNo="+noticeNo);
		} else {
			// 실패그냥 수정페이지머무름
			request.setAttribute("msg", "공지사항 수정이 완료되지 않았습니다.");
			request.setAttribute("url", "/notice/modify.do?noticeNo"+ noticeNo);
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

}
