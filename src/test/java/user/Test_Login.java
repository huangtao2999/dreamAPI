package user;

import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cn.com.tetration.reponse.user.LoginResponse;
import cn.com.tetration.request.user.LoginRequest;
import cn.com.tetration.utils.FuncHttp;

import com.alibaba.fastjson.JSON;


/** 
 * 类说明  '测试-用户注册'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:24:05 
 */
public class Test_Login {
	private static String url = "http://121.42.150.31:8080/dreamAPI";
//	private static String url = "http://127.0.0.1:8080/dreamAPI";
	private static String namespace = "/user/";
	private static String method = "login";
	
	private LoginRequest request = null;
	private LoginResponse response = null;
	public static void main(String[] args) throws Exception {
		long st = System.currentTimeMillis();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userId", "T0000001000575828");//S0000001004703258
		map.put("password", "123456");
		map.put("method", "flow/login");
		String str = FuncHttp.httpPost("http://app.iknei.com/SunDataAPI/api/flow/login",map,null);
		System.out.println(str);
		LoginResponse rs = JSON.parseObject(str, LoginResponse.class);
		System.out.println(rs.getSessionId());
		long et = System.currentTimeMillis();
		System.out.println((et-st));
	}
	@Before
	public void before() throws Exception
	{
		request = new LoginRequest();
		request.setAppKey("appKey");
		request.setAppScrect("appScrect");
		request.setUname("test");
		request.setPassword("123456");
		request.setMethod(method);
	}
	@Test
	public void test() throws Exception
	{
		String str = FuncHttp.httpPost(url+namespace+method, FuncHttp.entityToUrlMap(request), null);
		System.out.println("返回结果:"+str);
		response = JSON.parseObject(str, LoginResponse.class);
	}
	@After
	public void after() throws Exception
	{
		Assert.assertEquals(0,response.getErrorCode());
		Assert.assertEquals(null,response.getErrorMessage());
	}
}
