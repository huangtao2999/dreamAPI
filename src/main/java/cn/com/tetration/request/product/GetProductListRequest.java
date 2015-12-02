package cn.com.tetration.request.product;

import cn.com.tetration.request.PageRequest;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-7 上午11:37:57 
 */
public class GetProductListRequest extends PageRequest{
	//商品类别ID
	private Integer category_id;
	
	private Integer from_id;
	
	private Integer to_id;

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
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

	
	
	

}
