package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemLoginController
 */
@WebServlet("/member/login.do")
public class MemLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("canon_id");
		String memberPw = request.getParameter("canon_pw");
		Member member = new Member(memberId, memberPw);
		MemberService service = new MemberService();
		Member mOne = service.selectCheckLogin(member);
		if(mOne != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", mOne.getMemberId());
			session.setAttribute("memberName", mOne.getMemberName());
			//로그인 성공!
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/myCanon.jsp");
			view.forward(request, response);
		} else {
			//로그인 실패
			request.setAttribute("msg", "로그인 되지 않았습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp");
			view.forward(request, response);
		}
	}

}
