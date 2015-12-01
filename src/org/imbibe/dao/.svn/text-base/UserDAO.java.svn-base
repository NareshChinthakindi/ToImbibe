package org.imbibe.dao;

import java.sql.Blob;

import javax.servlet.http.HttpServletRequest;

import org.imbibe.vo.AddressVo;
import org.imbibe.vo.UserRolesVo;
import org.imbibe.vo.UserVo;


public interface UserDAO {

	Integer saveUser(UserVo userVo, HttpServletRequest httpReq);

	Integer saveAddress(AddressVo addressVo, HttpServletRequest httpReq);

	Blob getUserProfilePic(Integer id);

	UserVo verifyLoginIdPassword(String loginId, String password);

	UserVo getUserByLoginId(String strLoginId);

	Integer saveUserRole(UserRolesVo userRolesVo, HttpServletRequest httpReq);

	boolean updateUserProfile(UserVo userVo, HttpServletRequest httpReq);
}
