package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDAO nDao;
	
	public NoticeService() {
		// 필드는 생성자에서 초기화한다.
		nDao = new NoticeDAO();
	}

	public int insertNotice(Notice notice) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.insertNotice(session, notice);
		// DML commit & rollback
		if(result > 0) {
			// 성공하면 커밋!
			session.commit();
		} else {
			// 실패시 롤백!
			session.rollback();
		}
		// 연결해제
		session.close();
		return result;
		
	}
	
	public int updateNotice(Notice notice) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession(); 
		int result = nDao.updateNotice(session, notice);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
		
	}

	public int deleteNotice(int noticeNo) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.deleteNotice(session, noticeNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
		
	}

	public List<Notice> selectNoticeList(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nDao.selectNoticeList(session, currentPage);
		session.close();
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Notice notice = nDao.selectOneByNo(session, noticeNo);
		session.close();
		return notice;
	}
	
	
}
