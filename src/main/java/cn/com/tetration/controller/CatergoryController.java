package cn.com.tetration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.tetration.request.catergory.GetListRequest;
import cn.com.tetration.service.CatergoryService;

/** 
 * 类说明  '商品类别'
 * @author : huangtao
 * @version 创建时间：2015-8-5 下午3:39:58 
 */
@Controller
@RequestMapping("/catergory")
public class CatergoryController {
	
	@Autowired
	private CatergoryService catergoryService;
	
	@ResponseBody
    @RequestMapping(value = "/getList",produces=MediaType.APPLICATION_JSON_VALUE)
	public Object getList(GetListRequest request)
	{
		return catergoryService.getList(request);
	}

}
