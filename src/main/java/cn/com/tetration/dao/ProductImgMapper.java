package cn.com.tetration.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/** 
 * 类说明  ''
 * @author : huangtao
 * @version 创建时间：2015-8-24 上午10:30:36 
 */
public interface ProductImgMapper {
	List<String> getProductImgList(int product_id);
	int addProductImg(@Param("product_id")int product_id,@Param("product_imgs")List<String> list);
	

}
