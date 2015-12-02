package cn.com.tetration.dao;

import cn.com.tetration.model.User;
import cn.com.tetration.request.user.AddUserRequest;
import cn.com.tetration.request.user.LoginRequest;
import cn.com.tetration.request.user.UpdateFaceRequest;
/**
 * 
 * @author huangt
 */
public interface UserMapper {
    int addUser(AddUserRequest request);
    User login(LoginRequest request);
    User info(Integer id);
    int updateFace(UpdateFaceRequest request);
    
}