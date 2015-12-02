package cn.com.tetration.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.tetration.model.User;
import cn.com.tetration.reponse.user.AddUserResponse;
import cn.com.tetration.reponse.user.GetUserListResponse;
import cn.com.tetration.reponse.user.GetUserListResponseBean;
import cn.com.tetration.reponse.user.LoginResponse;
import cn.com.tetration.reponse.user.UpdateFaceResponse;
import cn.com.tetration.request.user.AddUserRequest;
import cn.com.tetration.request.user.GetUserListRequest;
import cn.com.tetration.request.user.InfoRequest;
import cn.com.tetration.request.user.LoginRequest;
import cn.com.tetration.request.user.UpdateFaceRequest;
import cn.com.tetration.service.UserService;
import cn.com.tetration.utils.ConstConfig;
import cn.com.tetration.utils.ErrorResponse;
import cn.com.tetration.utils.FormatDate;
import cn.com.tetration.utils.FuncStatic;
import cn.com.tetration.utils.RedisClient;

/**
 * 
 * @author huangt
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
    /**
     * 用户注册
     */
    @ResponseBody
    @RequestMapping(value = "/addUser",produces=MediaType.APPLICATION_JSON_VALUE)
    public Object addUser(AddUserRequest request)
    {
    	AddUserResponse rs = new AddUserResponse();
    	request.setInsert_date(FormatDate.getCurrentDateString());
    	userService.addUser(request);
    	return rs;
    }
    /**
     * 用户登录
     */
    @ResponseBody
    @RequestMapping(value = "/login",produces=MediaType.APPLICATION_JSON_VALUE)
    public Object login(LoginRequest request)
    {
    	LoginResponse rs = new LoginResponse();
    	User user = userService.login(request);
    	if(!FuncStatic.checkIsEmpty(user))
    	{
    		rs.setStatus(1);
    		UUID uuid = UUID.randomUUID();
    		String sessionId = String.valueOf(uuid).replaceAll("-", "");
    		RedisClient.setex(sessionId,ConstConfig.SESSIONID_TIME*60,FuncStatic.toStr(user.getId()));
    		rs.setSessionId(sessionId);
    	}
    	else
    	{
    		rs.setStatus(0);
    		rs.setMsg("用户名或密码错误");
    	}
    	return rs;
    }
    /**
     * 用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/info",produces=MediaType.APPLICATION_JSON_VALUE)
    public Object info(InfoRequest request) throws Exception
    {
    	String id = RedisClient.get(request.getSessionId());
    	if(!FuncStatic.checkIsEmpty(id))
    	{
    		return userService.info(Integer.parseInt(id));
    	}
    	return ErrorResponse.create(ErrorResponse.SESSIONID_IS_VERIFICATION);
    }
    /**
     *更新用户头像
     */
    @ResponseBody
    @RequestMapping(value = "/updateFace",produces=MediaType.APPLICATION_JSON_VALUE)
    public Object updateFace(UpdateFaceRequest request) throws Exception
    {
    	UpdateFaceResponse rs = new UpdateFaceResponse();
    	userService.updateFace(request);
    	return rs;
    }
    
    /**
     * 获取用户列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserList",produces=MediaType.APPLICATION_JSON_VALUE) 
    public Object getUserList(GetUserListRequest request)
    {
    	GetUserListResponse rs = new GetUserListResponse();
    	List<GetUserListResponseBean> datas = new ArrayList<GetUserListResponseBean>();
    	GetUserListResponseBean bean = null;
    	for(int i=0;i<10;i++)
    	{
    		bean = new GetUserListResponseBean();
    		bean.setId(i);
    		bean.setImagepath("http://www.baidu.com/opt/image"+i+".png");
    		bean.setUsername("user"+i);
    		datas.add(bean);
    	}
    	rs.setDatas(datas);
    	return rs;
    }
}
