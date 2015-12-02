package cn.com.tetration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.tetration.dao.UserMapper;
import cn.com.tetration.model.User;
import cn.com.tetration.reponse.user.InfoResponse;
import cn.com.tetration.request.user.AddUserRequest;
import cn.com.tetration.request.user.LoginRequest;
import cn.com.tetration.request.user.UpdateFaceRequest;
import cn.com.tetration.service.UserService;
import cn.com.tetration.utils.ConstConfig;
import cn.com.tetration.utils.FormatDate;
import cn.com.tetration.utils.FuncStatic;

import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author huangt
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public int addUser(AddUserRequest request)
	{
		int result = userMapper.addUser(request);
		return result;
	}

	@Override
	public User login(LoginRequest request)
	{
		return userMapper.login(request);
	}

	@Override
	public InfoResponse info(Integer id) throws Exception
	{
		User user = userMapper.info(id);
		InfoResponse rs = new InfoResponse();
		BeanUtils.copyProperties(rs,user);
		if(!FuncStatic.checkIsEmpty(rs.getImage_path()))
		{
			rs.setImage_path(ConstConfig.ICON_URL_BASE+rs.getImage_path());
		}
		rs.setBirthday(FormatDate.getDateString(user.getBirthday(), "yyyy-MM-dd"));
		return rs;
	}

	@Override
	public int updateFace(UpdateFaceRequest request)
			throws Exception {
		return userMapper.updateFace(request);
	}
}
