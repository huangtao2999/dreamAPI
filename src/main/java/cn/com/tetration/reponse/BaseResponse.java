package cn.com.tetration.reponse;
/** 
 * 类说明  '相应原始类'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午4:36:33 
 */
public class BaseResponse {
	/**
	 * 错误代码  0:无错误
	 */
	private int errorCode = 0;
	/**
	 * 错误描述
	 */
	private String errorMessage;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
