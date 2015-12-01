package org.imbibe.service;

import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;

import org.imbibe.vo.AddressVo;
import org.imbibe.vo.UserRolesVo;
import org.imbibe.vo.UserVo;

public interface UserService {

	Integer saveUser(UserVo userVo, HttpServletRequest httpReq);

	Integer saveAddress(AddressVo addressVo, HttpServletRequest httpReq);

	UserVo verifyLoginIdPassoword(String loginId, String password);

	Blob getUserProfilePic(Integer id);

	UserVo getUserByLoginId(String strLoginId);

	Integer saveUserRole(UserRolesVo userRolesVo, HttpServletRequest httpReq);

	boolean updateUserProfile(UserVo userVo, HttpServletRequest httpReq);
	
}
