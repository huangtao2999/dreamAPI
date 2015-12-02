package cn.com.tetration.reponse.user;

import cn.com.tetration.reponse.BaseResponse;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-29 下午3:24:36 
 */
public class LoginResponse extends BaseResponse{
	/**
	 * 登录成功状态  0:失败 1：成功
	 */
	private int status = 0;
	/**
	 * 登录失败描述
	 */
	private String msg;
	/**
	 * 登录成功sessionId
	 */
	private String sessionId;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	
	
}
