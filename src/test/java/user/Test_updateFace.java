package user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.user.AddUserResponse;
import cn.com.tetration.reponse.user.UpdateFaceResponse;
import cn.com.tetration.request.user.AddUserRequest;
import cn.com.tetration.request.user.UpdateFaceRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  '测试-用户更新用户头像'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_updateFace {
	private static String url = "http://127.0.0.1:8080/dreamAPI";
//	private static String url = "http://121.42.150.31:8080/dreamAPI";
	private static String namespace = "/user/";
	private static String method = "updateFace";
	
	private UpdateFaceRequest request = null;
	private UpdateFaceResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new UpdateFaceRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setMethod(method);
		request.setSessionId("f6f34cc42e4845b9bfe3f6b45ac130cc");
		request.setId(14);
		request.setPath("30/95/3025192a9a2e65bb3c515f4d17f0d895.jpg");
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, UpdateFaceResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
