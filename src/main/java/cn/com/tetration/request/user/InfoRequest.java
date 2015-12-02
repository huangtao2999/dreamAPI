package cn.com.tetration.request.user;

import cn.com.tetration.request.BaseRequest;
import cn.com.tetration.utils.NotNull;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-30 下午3:12:39 
 */
public class InfoRequest extends BaseRequest{
	@NotNull
	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
