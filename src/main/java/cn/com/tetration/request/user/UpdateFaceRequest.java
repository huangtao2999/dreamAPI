package cn.com.tetration.request.user;

import cn.com.tetration.request.BaseRequest;
import cn.com.tetration.utils.NotNull;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-4 上午11:24:34 
 */
public class UpdateFaceRequest extends BaseRequest{
	@NotNull
	private String sessionId;
	/**
	 * 用户ID
	 */
	@NotNull
	private int id;
	/**
	 * 图片路径
	 */
	@NotNull
	private String path;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
