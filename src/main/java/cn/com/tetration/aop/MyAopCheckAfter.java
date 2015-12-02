package cn.com.tetration.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** 
 * 类说明  '检查参数设置'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午10:31:27 
 */
public class MyAopCheckAfter extends HandlerInterceptorAdapter{
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
	

}
