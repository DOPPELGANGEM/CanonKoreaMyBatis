package notice.model.vo;

import java.sql.*;

public class Notice {
	
	private int noticeNo;
	private String	noticeTitle;
	private String noticeContents;
	private Date regDate;
	
	public Notice() {}
	
	public Notice(String noticeTitle, String noticeContents) {
		super();
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
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContents=" + noticeContents
				+ ", regDate=" + regDate + "]";
	}
	
}
