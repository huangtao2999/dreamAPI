package cn.com.tetration.request.product;

import java.util.List;

import cn.com.tetration.request.BaseRequest;
import cn.com.tetration.utils.NotNull;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-7 下午2:10:12 
 */
public class AddProductRequest extends BaseRequest{
	private int id;
	@NotNull
	private String sessionId;
	@NotNull
	private String title;
	@NotNull
	private String info;
	@NotNull
	private int level;
	@NotNull
	private int category_id;
	private String insert_date;
	//商品图片
	private List<String> product_imgs;
	//售卖人ID
	@NotNull
	private int from_id;
	//商品价格
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public List<String> getProduct_imgs() {
		return product_imgs;
	}
	public void setProduct_imgs(List<String> product_imgs) {
		this.product_imgs = product_imgs;
	}
	public int getFrom_id() {
		return from_id;
	}
	public void setFrom_id(int from_id) {
		this.from_id = from_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
