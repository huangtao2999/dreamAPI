package catergory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.catergory.GetListResponse;
import cn.com.tetration.request.catergory.GetListRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_getList {
	private static String url = "http://127.0.0.1:8080/dreamAPI";
	private static String namespace = "/catergory/";
	private static String method = "getList";
	
	private GetListRequest request = null;
	private GetListResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new GetListRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setPageSize(1);
		request.setPage(1);
		request.setMethod(method);
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, GetListResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
