package cn.com.tetration.aop;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.tetration.request.BaseRequest;
import cn.com.tetration.utils.ErrorResponse;
import cn.com.tetration.utils.FuncStatic;
import cn.com.tetration.utils.NotNull;
import cn.com.tetration.utils.RedisClient;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/** 
 * 类说明  '检查参数设置'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午10:31:27 
 */
public class MyAopCheckBefore extends HandlerInterceptorAdapter{
	private final static String SESSIONID = "sessionId";
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String methodName = request.getParameter("method");
		Method []methods  =  handler.getClass().getDeclaredMethods();
		for(Method method:methods)
		{
			if(methodName.equals(method.getName()))
			{
				Class<BaseRequest>[] cls = (Class<BaseRequest>[]) method.getParameterTypes();
				Class<BaseRequest> obj = cls[0];
				BeanUtils.copyProperties(obj, request);
				List<Field> fields = FuncStatic.findClassAllField(obj);
				for(Field field:fields)
				{
					field.setAccessible(true);
					if(field.isAnnotationPresent(NotNull.class))
					{
						
						if(FuncStatic.checkIsEmpty(request.getParameter(field.getName())))
						{
							this.createErrorResponse(response,ErrorResponse.PARAMS_IS_NULL,field.getName());
							return false;
						}
						if(SESSIONID.equals(field.getName()))
						{
							if(!RedisClient.exists(request.getParameter(field.getName())))
							{
								this.createErrorResponse(response,ErrorResponse.SESSIONID_IS_VERIFICATION,null);
								return false;
							}
						}
					}
				}
				break;
			}
		}
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
