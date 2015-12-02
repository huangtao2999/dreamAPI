package product;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.product.GetProductListResponse;
import cn.com.tetration.request.product.GetProductListRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_getProductList {
//	private static String url = "http://127.0.0.1:8080/dreamAPI";
	private static String url = "http://121.42.150.31:8080/dreamAPI";
	private static String namespace = "/product/";
	private static String method = "getProductList";
	
	private GetProductListRequest request = null;
	private GetProductListResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new GetProductListRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setMethod(method);
//		request.setCategory_id(4);
		request.setPage(1);
		request.setPageSize(2);
//		request.setFrom_id(14);
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, GetProductListResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
