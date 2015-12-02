package cn.com.tetration.reponse.product;

import java.util.List;

import cn.com.tetration.model.Product;
import cn.com.tetration.reponse.PageResponse;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-7 上午11:38:30 
 */
public class GetProductListResponse extends PageResponse{
	private List<Product> datas;

	public List<Product> getDatas() {
		return datas;
	}

	public void setDatas(List<Product> datas) {
		this.datas = datas;
	}
	

}
