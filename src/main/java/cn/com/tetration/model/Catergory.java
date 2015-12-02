package cn.com.tetration.model;
/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午4:29:43 
 */
public class Catergory {
	private int id;
	/**
	 * 类别名称
	 */
	private String name;
	/**
	 * 类别图像
	 */
	private String icon;
	/**
	 * 类别别名介绍
	 */
	private String info;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	

}
