package notice.model.vo;

public class PageData {
//	https://hgko1207.github.io/2021/09/17/mybatis-1/
	private int pageNo; // 페이지번호
	private int amount; // 한페이지당 보여지는 갯수
	
	public PageData() {}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PageData [pageNo=" + pageNo + ", amount=" + amount + "]";
	}
	
	
	
}
