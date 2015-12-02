package cn.com.tetration.model;

import java.util.Date;
import java.util.List;

/** 
 * 类说明  '商品'
 * @author : huangtao
 * @version 创建时间：2015-8-7 下午1:28:21 
 */
public class Product {
	private Integer id;
	//标题
	private String title;
	//描述
	private String info;
	//新旧程度 1:五成;2:六成;3:七成;4:八成;5:九成;6:崭新
	private Integer level;
	//类别ID
	private Integer category_id;
	//插入时间
	private Date insert_date;
	//售卖人ID
	private Integer from_id;
	//购买人ID
	private Integer to_id;
	//0,未上架;1,待审核;2,正在出售;3,已售出
	private int status = 0;
	//商品价格
	private double price;
	private List<String> product_imgs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	public Integer getFrom_id() {
		return from_id;
	}
	public void setFrom_id(Integer from_id) {
		this.from_id = from_id;
	}
	public Integer getTo_id() {
		return to_id;
	}
	public void setTo_id(Integer to_id) {
		this.to_id = to_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<String> getProduct_imgs() {
		return product_imgs;
	}
	public void setProduct_imgs(List<String> product_imgs) {
		this.product_imgs = product_imgs;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
