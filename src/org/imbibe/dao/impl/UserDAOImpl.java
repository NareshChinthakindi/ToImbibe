package org.imbibe.dao.impl;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.imbibe.dao.ImbibeDAO;
import org.imbibe.dao.UserDAO;
import org.imbibe.vo.AddressVo;
import org.imbibe.vo.UserRolesVo;
import org.imbibe.vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends ImbibeDAO implements UserDAO {

	@Override
	public Integer saveUser(UserVo userVo, HttpServletRequest httpReq) {
		this.getHibernateTemplate().save(userVo);
		return userVo.getId();

	}

	@Override
	public Integer saveAddress(AddressVo addressVo, HttpServletRequest httpReq) {
		this.getHibernateTemplate().save(addressVo);
		return addressVo.getId();
	}

	@Override
	public Blob getUserProfilePic(Integer id) {

		String query = "select profilePic from UserVo where id=" + id;
		List<Blob> stuList = new ArrayList<Blob>();
		stuList = this.getHibernateTemplate().find(query);
		// UserVo userVo = (UserVo)this.getHibernateTemplate().get(UserVo.class,
		// id);
		// return userVo.getProfilePic();
		return stuList.get(0);
	}

	@Override
	public UserVo verifyLoginIdPassword(String loginId, String password) {
		Session session = null;
		UserVo userVo = null;
		try {

			String query = "select id from UserVo where loginId = '" + loginId + "' and password = '" + password + "'";
			List<Integer> list = new ArrayList<Integer>();
			list = this.getHibernateTemplate().find(query);

			if (list != null && list.size() > 0) {
				userVo = (UserVo) this.getHibernateTemplate().get(UserVo.class, list.get(0));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return userVo;
	}

	@Override
	public UserVo getUserByLoginId(String strLoginId) {
		UserVo userVo = null;
	try {

			String query = "select id from UserVo where loginId = '" + strLoginId + "'";
			List<Integer> list = new ArrayList<Integer>();
			list = this.getHibernateTemplate().find(query);

			if (list != null && list.size() > 0) {
				userVo = (UserVo) this.getHibernateTemplate().get(UserVo.class, list.get(0));
			}
			
			Hibernate.initialize(userVo.getAddressVo());
			int i = 1/0;
		} catch (Exception e) {
			System.out.println(e);
		}
		return userVo;
	}

	@Override
	public Integer saveUserRole(UserRolesVo userRolesVo, HttpServletRequest httpReq) 
	{
		int i = 1/0;
		this.getHibernateTemplate().save(userRolesVo);
		return userRolesVo.getUserId();
	}

	@Override
	public boolean updateUserProfile(UserVo userVo, HttpServletRequest httpReq) {
		boolean isUpdated = false;

		try {
			this.getHibernateTemplate().update(userVo);
			isUpdated = true;
		} catch (Exception e) {
			isUpdated = false;
			System.out.println(e.getMessage());
		}
		return isUpdated;
	}

}
