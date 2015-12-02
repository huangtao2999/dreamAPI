package cn.com.tetration.service;

import cn.com.tetration.reponse.catergory.GetListResponse;
import cn.com.tetration.request.catergory.GetListRequest;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午4:24:29 
 */
public interface CatergoryService {
	GetListResponse getList(GetListRequest request);

}
