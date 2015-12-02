package product;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.product.AddProductResponse;
import cn.com.tetration.request.product.AddProductRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_addProduct {
	private static String url = "http://127.0.0.1:8080/dreamAPI";
	private static String namespace = "/product/";
	private static String method = "addProduct";
	
	private AddProductRequest request = null;
	private AddProductResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new AddProductRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setSessionId("6223f99b050b448ea5f9134615a574c4");
		request.setMethod(method);
		request.setTitle("商品45");
		request.setInfo("才买45个星期哦");
		request.setCategory_id(4);
		request.setLevel(3);
		request.setFrom_id(14);
		request.setPrice(22.99);
//		List<String> list = new ArrayList<String>();
//		list.add("e4/38/e4fb0381f9d856aa588ebbfb23a1c638.jpg");
//		list.add("e4/38/e4fb0381f9d856aa588ebbfb23a1c638.jpg");
//		list.add("e4/38/e4fb0381f9d856aa588ebbfb23a1c638.jpg");
//		request.setProduct_imgs(list);
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, AddProductResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
