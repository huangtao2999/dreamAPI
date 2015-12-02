package cn.com.tetration.request.user;


import cn.com.tetration.request.BaseRequest;
import cn.com.tetration.utils.NotNull;

/** 
 * 类说明  '用户注册请求类'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:42:26 
 */
public class AddUserRequest extends BaseRequest{
	@NotNull
	private String uname;
	@NotNull
	private String password;
	@NotNull
	private String email;
    private String image_path;
	@NotNull
    private String sex;
	@NotNull
    private String birthday;
	private String insert_date;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	
	
    
}
