package user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.user.AddUserResponse;
import cn.com.tetration.request.user.AddUserRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  '测试-用户注册'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_addUser {
	private static String url = "http://127.0.0.1:8080/dreamAPI";
	private static String namespace = "/user/";
	private static String method = "addUser";
	
	private AddUserRequest request = null;
	private AddUserResponse response = null;
	@Before
	public void before() throws Exception
	{
		request = new AddUserRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setUname("huangt");
//		request.setImage_path("home/opt/source/img.png");
		request.setEmail("huangtao@163.com");
		request.setPassword("huangtXXX");
		request.setSex("1");
		request.setBirthday("2015-07-29 00:00:00");
		request.setMethod(method);
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, AddUserResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
