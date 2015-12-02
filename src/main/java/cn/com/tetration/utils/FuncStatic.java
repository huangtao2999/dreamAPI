package cn.com.tetration.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import cn.com.tetration.request.BaseRequest;


/** 
 * 类说明  '常用字符串,类工具'
 * @author : huangtao
 * @version 创建时间：2015-7-22 下午9:52:45 
 */
public class FuncStatic {
	private static Logger logger = Logger.getLogger(FuncStatic.class.getName());
	/**
	 * 获取某个类及其父类的Field
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<Field> findClassAllField (Class<?> clazz){
		ArrayList<Field> list = new ArrayList<Field>();
		try {
			List<Class>  clazzList = new ArrayList<Class>();
 
			while(!"java.lang.Object".equals(clazz.getName())){
				clazzList.add(clazz);
				clazz = clazz.getSuperclass();
			}
			Collections.reverse(clazzList);
			for(int i=0;i<clazzList.size();i++){
				Field[] fs =  clazzList.get(i).getDeclaredFields();
				for(Field f : fs){
					list.add(f);
				}				
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}
	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean checkIsEmpty(Object var) {
		if (var == null)
			return true;
		if (var.toString().equals(""))
			return true;
		return false;
	}
	/**
	 * 返回对象字符串
	 * @param obj
	 * @return
	 */
	public static String toStr(Object obj)
	{
		return String.valueOf(obj);
	}
	/**
	 * 暂时解决传入list 解析错误的问题
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	public static void parse(BaseRequest request)
	{
		List<Field> fields = FuncStatic.findClassAllField(request.getClass());
		for(Field field:fields)
		{
			if(List.class.isAssignableFrom(field.getType()))
			{
				field.setAccessible(true);
				try
				{
					List<String> strs= (List<String>) field.get(request);
					String str = strs.get(0);
					str = str.substring(1, str.length()-1);
					String[] strArr = str.split(",");
					List<String> params = new ArrayList<String>();
					for(String item:strArr)
					{
						params.add(item.trim());
					}
					field.set(request, params);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


}
