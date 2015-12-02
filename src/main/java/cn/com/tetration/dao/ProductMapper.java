package cn.com.tetration.dao;

import java.util.List;

import cn.com.tetration.model.Product;
import cn.com.tetration.request.product.AddProductRequest;
import cn.com.tetration.request.product.GetProductListRequest;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-7 下午2:21:21 
 */
public interface ProductMapper {
	int addProduct(AddProductRequest request);
	List<Product> getProductList(GetProductListRequest request);

}
