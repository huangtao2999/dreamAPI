package cn.com.tetration.reponse;
/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午3:52:52 
 */
public class PageResponse extends BaseResponse{
	/**
	 * 当前页码
	 */
	private int page = 1;
	/**
	 * 当前页面数量
	 */
	private int pageSize = 10;
	/**
	 * 页码总量
	 */
	private int totalPage = 1;
	/**
	 * 记录总量
	 */
	private int totalRecord;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}
