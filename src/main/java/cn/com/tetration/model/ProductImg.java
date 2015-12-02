package cn.com.tetration.model;
/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-24 上午10:31:33 
 */
public class ProductImg {
	
	private int id;
	//商品ID
	private int product_id;
	//商品路径
	private String img_path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	

}
