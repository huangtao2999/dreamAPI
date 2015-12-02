package cn.com.tetration.reponse.user;

import java.util.List;

import cn.com.tetration.reponse.BaseResponse;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午10:14:53 
 */
public class GetUserListResponse extends BaseResponse{
	private List<GetUserListResponseBean> datas;

	public List<GetUserListResponseBean> getDatas() {
		return datas;
	}

	public void setDatas(List<GetUserListResponseBean> datas) {
		this.datas = datas;
	}

}
