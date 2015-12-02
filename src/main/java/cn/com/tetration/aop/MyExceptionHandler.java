package cn.com.tetration.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.com.tetration.utils.ErrorResponse;

import com.alibaba.fastjson.JSON;

/** 
 * 类说明  '异常处理'
 * @author : huangtao
 * @version 创建时间：2015-7-29 上午10:30:24 
 */
public class MyExceptionHandler implements HandlerExceptionResolver{
	private static Logger logger = Logger.getLogger(MyExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView();
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.getOutputStream().write(JSON.toJSONString(ErrorResponse.create(ErrorResponse.OS_IS_EXCEPTION)).getBytes());
		} catch (IOException e) {
			logger.error(e);
		}
		ex.printStackTrace();
		return mv;
	}
	
}
