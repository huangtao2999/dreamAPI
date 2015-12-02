package cn.com.tetration.dao;

import java.util.List;

import cn.com.tetration.model.Catergory;
import cn.com.tetration.request.catergory.GetListRequest;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午4:26:23 
 */
public interface CatergoryMapper {
	List<Catergory> getList(GetListRequest request);

}
