package cn.com.tetration.service;

import cn.com.tetration.reponse.product.GetProductListResponse;
import cn.com.tetration.request.product.AddProductRequest;
import cn.com.tetration.request.product.GetProductListRequest;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-7 下午2:15:30 
 */
public interface ProductService {
	int addProduct(AddProductRequest request);
	GetProductListResponse getProductList(GetProductListRequest request);

}
