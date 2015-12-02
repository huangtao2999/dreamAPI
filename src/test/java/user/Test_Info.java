package user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.user.InfoResponse;
import cn.com.tetration.request.user.InfoRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  '测试-用户注册'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_Info {
//	private static String url = "http://121.42.150.31:8080/dreamAPI";
	private static String url = "http://127.0.0.1:8080/dreamAPI";
	private static String namespace = "/user/";
	private static String method = "info";
	
	private InfoRequest request = null;
	private InfoResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new InfoRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setSessionId("f6f34cc42e4845b9bfe3f6b45ac130cc");
		request.setMethod(method);
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, InfoResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
