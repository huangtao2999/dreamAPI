package cn.com.tetration.request;

import cn.com.tetration.utils.NotNull;

/** 
 * 类说明  '原始请求类'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:33:51 
 */
public class BaseRequest {
	/**
	 * 接口请求key
	 */
	@NotNull
	private String appKey;
	/**
	 * 接口请求screct
	 */
	@NotNull
	private String appScrect;
	/**
	 * 接口请求方法
	 */
	@NotNull
	private String method;
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppScrect() {
		return appScrect;
	}
	public void setAppScrect(String appScrect) {
		this.appScrect = appScrect;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	

}
