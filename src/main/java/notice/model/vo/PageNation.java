package notice.model.vo;

import java.util.List;

public class PageNation {

	private List<Notice> nList; 
	private String page; //페이지번호
	
	public List<Notice> getnList() {
		return nList;
	}
	public void setnList(List<Notice> nList) {
		this.nList = nList;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "PageData [nList=" + nList + ", page=" + page + "]";
	} 
}
