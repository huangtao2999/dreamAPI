package cn.com.tetration.utils;

import java.util.HashMap;
import java.util.Map;

import cn.com.tetration.reponse.BaseResponse;


/** 
 * 类说明  '错误相应类'
 * @author : huangtao
 * @version 创建时间：2015-7-23 上午9:30:21 
 */
public class ErrorResponse {
	public static int PARAMS_IS_NULL = 1;
	public static int PARAMS_IS_VERIFICATION = 2;
	public static int SESSIONID_IS_VERIFICATION = 3;
	public static int OS_IS_EXCEPTION = 9;
	private static Map<Integer, String> map = new HashMap<Integer, String>();
	static
	{
		map.put(PARAMS_IS_NULL, "参数不能为空");
		map.put(PARAMS_IS_VERIFICATION, "参数不合法");
		map.put(SESSIONID_IS_VERIFICATION, "sessionId不合法");
		map.put(OS_IS_EXCEPTION, "业务逻辑出错");
	}
	
	public static BaseResponse create(int errorCode)
	{
		BaseResponse response = new BaseResponse();
		response.setErrorCode(errorCode);
		response.setErrorMessage(map.get(errorCode));
		return response;
	}
	public static BaseResponse create(int errorCode,String appendMsg)
	{
		BaseResponse response = new BaseResponse();
		response.setErrorCode(errorCode);
		response.setErrorMessage(appendMsg+","+map.get(errorCode));
		return response;
	}
}
