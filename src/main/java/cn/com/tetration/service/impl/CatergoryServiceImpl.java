package cn.com.tetration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.tetration.dao.CatergoryMapper;
import cn.com.tetration.model.Catergory;
import cn.com.tetration.reponse.catergory.GetListResponse;
import cn.com.tetration.request.catergory.GetListRequest;
import cn.com.tetration.service.CatergoryService;
import cn.com.tetration.utils.ConstConfig;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午4:25:03 
 */
@Service("catergoryService")
public class CatergoryServiceImpl implements CatergoryService{
	@Autowired
	private CatergoryMapper catergoryMapper;

	@Override
	public GetListResponse getList(GetListRequest request) {
		GetListResponse rs = new GetListResponse();
		List<Catergory>list = catergoryMapper.getList(request);
		for(Catergory item:list)
		{
			item.setIcon(ConstConfig.ICON_URL_BASE+item.getIcon());
		}
		rs.setDatas(list);
		return rs;
	}

}
