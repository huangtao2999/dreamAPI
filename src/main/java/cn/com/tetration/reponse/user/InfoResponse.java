package cn.com.tetration.reponse.user;

import java.util.Date;

import cn.com.tetration.reponse.BaseResponse;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-30 下午3:13:27 
 */
public class InfoResponse extends BaseResponse{
	private Integer id;
	private String uname;
	private String email;
    private String image_path;
    private int sex;
    private String birthday;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
    
}
