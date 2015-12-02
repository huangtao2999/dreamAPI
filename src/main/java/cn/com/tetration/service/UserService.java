package cn.com.tetration.service;

import cn.com.tetration.model.User;
import cn.com.tetration.reponse.user.InfoResponse;
import cn.com.tetration.request.user.AddUserRequest;
import cn.com.tetration.request.user.LoginRequest;
import cn.com.tetration.request.user.UpdateFaceRequest;

/**
 * 
 * @author julietty
 */
public interface UserService {

	int addUser(AddUserRequest request);
	User login(LoginRequest request);
	InfoResponse info(Integer id) throws Exception;
	int updateFace(UpdateFaceRequest request) throws Exception;
}
