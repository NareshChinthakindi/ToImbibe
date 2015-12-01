package org.imbibe.service.impl;

import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;

import org.imbibe.dao.SecurityQuestionsDAO;
import org.imbibe.dao.UserDAO;
import org.imbibe.service.UserService;
import org.imbibe.vo.AddressVo;
import org.imbibe.vo.UserRolesVo;
import org.imbibe.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Autowired
	SecurityQuestionsDAO questionsDAO;

	@Autowired
	UserDAO userDAO;
	
	
	@Override
	public Integer saveUser(UserVo userVo, HttpServletRequest httpReq) 
	{
		Integer userId=userDAO.saveUser(userVo, httpReq);
		UserRolesVo userRolesVo = new UserRolesVo();
		userRolesVo.setUserId(userId);
		userRolesVo.setAuthority("ROLE_USER");
		userId = saveUserRole(userRolesVo, httpReq);
		return userId;
	}
	@Override
	public Integer saveAddress(AddressVo addressVo, HttpServletRequest httpReq) {
		Integer userId=userDAO.saveAddress(addressVo, httpReq);
		return userId;
	}
	@Override
	public UserVo verifyLoginIdPassoword(String loginId, String password) {
		UserVo userVo = null;	
		userVo= userDAO.verifyLoginIdPassword(loginId,password);
		return userVo;
	}
	@Override
	public Blob getUserProfilePic(Integer id) {
		Blob userPic=null;
		try {
		   userPic=userDAO.getUserProfilePic(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userPic;
	}
	@Override
	public UserVo getUserByLoginId(String strLoginId) {
		UserVo userVo = null;	
		userVo= userDAO.getUserByLoginId(strLoginId);
		return userVo;
	}
	@Override
	public Integer saveUserRole(UserRolesVo userRolesVo, HttpServletRequest httpReq) {
		Integer userId=userDAO.saveUserRole(userRolesVo, httpReq);
		return userId;
	}
	@Override
	public boolean updateUserProfile(UserVo userVo, HttpServletRequest httpReq) {
		boolean isUpdated=false;
		
		try{
			isUpdated=userDAO.updateUserProfile(userVo, httpReq);
		}catch(Exception e ){
			isUpdated=false;
			System.out.println(e.getMessage());
		}	
			return isUpdated;
	}
	
	
	
	

}
