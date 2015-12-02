package cn.com.tetration.request;
/** 
 * 类说明  '带有分页信息的请求'
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午3:49:09 
 */
public class PageRequest extends BaseRequest{
	/**
	 * 当前请求页
	 */
	private int page = 1;
	/**
	 * 当前请求页面数量
	 */
	private int pageSize = 10;
	private int start;
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
	public int getStart() {
		start = (this.page-1)*pageSize;
		return start;
	}
}
