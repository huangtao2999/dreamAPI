package cn.com.tetration.reponse.catergory;

import java.util.List;

import cn.com.tetration.model.Catergory;
import cn.com.tetration.reponse.PageResponse;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午4:01:23 
 */
public class GetListResponse extends PageResponse{
	private List<Catergory> datas;

	public List<Catergory> getDatas() {
		return datas;
	}

	public void setDatas(List<Catergory> datas) {
		this.datas = datas;
	}
	

}
