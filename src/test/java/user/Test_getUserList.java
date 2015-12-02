package user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.user.GetUserListResponse;
import cn.com.tetration.request.user.GetUserListRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  '测试-获取用户列表'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_getUserList {
	private static String url = "http://121.42.150.31:8080/dreamAPI";
//	private String url = "http://127.0.0.1:8080/dreamAPI";
	private String method = "/user/getUserList";
	
	private GetUserListRequest request = null;
	private GetUserListResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new GetUserListRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, GetUserListResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}

}
