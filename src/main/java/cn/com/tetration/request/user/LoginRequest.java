package cn.com.tetration.request.user;

import cn.com.tetration.request.BaseRequest;
import cn.com.tetration.utils.NotNull;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-29 下午3:23:33 
 */
public class LoginRequest extends BaseRequest{
	@NotNull
	private String uname;
	@NotNull
	private String password;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
