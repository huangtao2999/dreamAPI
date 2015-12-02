package cn.com.tetration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.tetration.reponse.product.AddProductResponse;
import cn.com.tetration.request.product.AddProductRequest;
import cn.com.tetration.request.product.GetProductListRequest;
import cn.com.tetration.service.ProductService;
import cn.com.tetration.utils.FormatDate;
import cn.com.tetration.utils.FuncStatic;

/** 
 * 类说明  '商品'
 * @author : huangtao
 * @version 创建时间：2015-8-7 上午11:36:50 
 */
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@ResponseBody
    @RequestMapping(value = "/addProduct",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object addProduct(AddProductRequest request)
	{
		FuncStatic.parse(request);
		AddProductResponse rs = new AddProductResponse();
		request.setInsert_date(FormatDate.getCurrentDateString());
		productService.addProduct(request);
		return rs;
	}
	@ResponseBody
    @RequestMapping(value = "/getProductList",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getProductList(GetProductListRequest request)
	{
		return productService.getProductList(request);
	}
}
