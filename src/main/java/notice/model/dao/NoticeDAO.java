package notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		// ** 잊지말기 ** 
		// DAO 다음 xml에 신고 등록!
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	public List<Notice> selectNoticeList(SqlSession session, int currentPage) {
		
		// RowBounds : 쿼리문을 변경하지 않고도 페이징을 처리하게 하는 클래스(MyBatis에 존재)
		// limit => 한 페이지당 보여주고 싶은 게시물의 갯수
		// offset은 시작값, 변하는 값
		// ex) 1페이지 에서는 1 ~10
		// 2페이지에서는 11 ~ 20
		// 3페이지에서는 21 ~ 30
		int limit = 10;
		int offset = (currentPage-1)*limit; // currengpage가 2라면 (2-1)*10 = 10
		RowBounds rowBounds = new RowBounds(offset, limit);
		// 세번째에 rowBounds쓰려고 두번째에 null해준다. (id값, 검색어, rowBounds객체) -> 검색어가 필요하지 않아도 생략하면안되고 null로 지정해야한다.
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds); 
		return nList;
		
	}

	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public String generatePageNavi(SqlSession session, int currentPage) {
		
		// 전체 게시물의 갯수
		int totalCount = getTotalCount(session);
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		int totalNaviCount;
		if(totalCount % recordCountPerPage > 0) {
			totalNaviCount = totalCount / recordCountPerPage + 1;
		} else {
			totalNaviCount = totalCount / recordCountPerPage;
		}
		
		int startNavi = ((currentPage-1)/naviCountPerPage) * naviCountPerPage + 1; // (2-1)*5 + 1 ->6
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > totalNaviCount) {
			endNavi = totalNaviCount;
		}
		StringBuffer result = new StringBuffer();
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi != 1) {
			result.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'><p><span>[이전]</span></p></a>");
		}
		for(int i=startNavi; i<=endNavi; i++) {
			result.append("<a href='/notice/list.do?currentPage="+i+"'>"+i+"</a>");
		}
		if(endNavi != totalNaviCount) {
			result.append("<a href='/notice/list.do?currentPage="+(endNavi + 1)+"'><p><span>[다음]</span></p></a>");
		}
		return result.toString();
		
	}
	
	private int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("NoticeMapper.getTotalCount");
		return totalCount;
	}

}
