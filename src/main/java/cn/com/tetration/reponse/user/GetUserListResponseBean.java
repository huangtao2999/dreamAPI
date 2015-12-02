package cn.com.tetration.reponse.user;
/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午10:12:15 
 */
public class GetUserListResponseBean {
	private int id;
	/**
	 * 名称
	 */
	private String username;
	/**
	 * 头像
	 */
    private String imagepath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
    
}
