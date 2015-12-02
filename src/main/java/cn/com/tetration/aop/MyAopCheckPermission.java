package cn.com.tetration.aop;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.tetration.utils.ErrorResponse;
import cn.com.tetration.utils.FuncStatic;

import com.alibaba.fastjson.JSON;

/** 
 * 类说明  '检查接口访问权限'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午10:31:27 
 */
public class MyAopCheckPermission extends HandlerInterceptorAdapter{
	private static Logger logger = Logger.getLogger(MyAopCheckPermission.class);
	private final static String APP_KEY = "appKey";
	private final static String APP_SCRECT = "appScrect";
	@SuppressWarnings("rawtypes")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		StringBuilder sb = new StringBuilder(request.getLocalAddr()+":"+request.getLocalPort() +request.getRequestURI()+"?");
		Map map = request.getParameterMap();
		Set set = map.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			sb.append(key+"="+request.getParameter(key)+"&");
		}
		logger.info(sb.toString());
		String appKey = String.valueOf(request.getParameter(APP_KEY));
		String appScrect = String.valueOf(request.getParameter(APP_SCRECT));
		if(!this.checkApp_key_screct(appKey, appScrect))
		{
			this.createErrorResponse(response,ErrorResponse.PARAMS_IS_VERIFICATION,APP_KEY+"-"+APP_SCRECT);
			return false;
		}
		return true;
		
	}
	private boolean checkApp_key_screct(String appKey,String appScrect)
	{
		//TODO;查询数据验证key和screct是否对应
		return true;
	}
	private void createErrorResponse(HttpServletResponse response,int errorCode,String paramsName) throws IOException
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		if(FuncStatic.checkIsEmpty(paramsName))
		{
			response.getOutputStream().write(JSON.toJSONString(ErrorResponse.create(errorCode)).getBytes());
		}
		else
		{
			response.getOutputStream().write(JSON.toJSONString(ErrorResponse.create(errorCode,paramsName)).getBytes());
		}
	}
	

}
