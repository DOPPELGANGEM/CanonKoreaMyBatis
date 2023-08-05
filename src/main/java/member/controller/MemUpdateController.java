package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemUpdateController
 */
@WebServlet("/member/update.do")
public class MemUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 먼저 get방식으로 아이디값으로 마이페이지로 이동시켜준다.
		MemberService service = new MemberService();
		String memberId = request.getParameter("member-id");
		Member member = service.selectOneById(memberId);
		request.setAttribute("member", member);
		request.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id"); // where 조건절땜에필요
		String memberPw = request.getParameter("member-pw");
		String memberName = request.getParameter("member-gender");
		String memberEmail = request.getParameter("member-email");
		String memberPhone = request.getParameter("member-phone");
		String memberAddress = request.getParameter("member-address");
		String memberHobby = request.getParameter("member-hobby");
		MemberService service = new MemberService();
		Member member = new Member(memberId, memberPw, memberName, memberEmail, memberPhone, memberAddress, memberHobby);
		int result =service.updateMember(member);
		if(result > 0) {
			// 성공하면 메인페이지
			response.sendRedirect("/index.jsp");
		} else {
			// 실패하면 에러페이지
			request.setAttribute("msg", "회원수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/serviceFailed.jsp").forward(request, response);
		}
		
	}

}
