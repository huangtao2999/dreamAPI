package cn.com.tetration.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.tetration.dao.ProductImgMapper;
import cn.com.tetration.dao.ProductMapper;
import cn.com.tetration.model.Product;
import cn.com.tetration.reponse.product.GetProductListResponse;
import cn.com.tetration.request.product.AddProductRequest;
import cn.com.tetration.request.product.GetProductListRequest;
import cn.com.tetration.service.ProductService;
import cn.com.tetration.utils.ConstConfig;
import cn.com.tetration.utils.FuncStatic;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-7 下午2:16:36 
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductImgMapper productImgMapper;
	@Override
	public int addProduct(AddProductRequest request) {
		int num = productMapper.addProduct(request);
		int product_id = request.getId();
		if(product_id != 0 
				&& request.getProduct_imgs() != null 
				&& request.getProduct_imgs().size() > 0)
		{
			productImgMapper.addProductImg(product_id,request.getProduct_imgs());
		}
		return num;
	}
	@Override
	public GetProductListResponse getProductList(GetProductListRequest request) {
		GetProductListResponse rs = new GetProductListResponse();
		List<Product> list = productMapper.getProductList(request);
		for(Product product:list)
		{
			List<String> list2 = new ArrayList<String>();
			List<String> imgs = productImgMapper.getProductImgList(product.getId());
			for(String str:imgs)
			{
				if(!FuncStatic.checkIsEmpty(str))
				{
					str =  ConstConfig.ICON_URL_BASE+str;
					list2.add(str);
				}
			}
			product.setProduct_imgs(list2);
		}
		rs.setDatas(list);
		return rs;
	}

}
