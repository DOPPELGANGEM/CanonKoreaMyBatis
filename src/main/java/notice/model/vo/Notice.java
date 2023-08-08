package notice.model.vo;

import java.sql.*;

public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContents;
	private Date regDate;
	
	public Notice() {}
	
	public Notice(String noticeTitle, String noticeContents) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
	}

	public Notice(int noticeNo, String noticeTitle, String noticeContents) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContents = noticeContents;
	}

	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContents() {
		return noticeContents;
	}
	public void setNoticeContents(String noticeContents) {
		this.noticeContents = noticeContents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "캐논공지사항 [번호=" + noticeNo + ", 제목=" + noticeTitle + ", 내용=" + noticeContents + ", 등록일=" + regDate + "]";
	}
	
	
}
