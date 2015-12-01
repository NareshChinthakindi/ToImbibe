/**
 * 
 */
package org.imbibe.vo;

import java.util.List;

/**
 * @author nchinthakindi
 *
 */
public class UserFriends extends ImbibeVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserVo user;
	private List<UserVo> friends;
	private Integer status;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the user
	 */
	public UserVo getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserVo user) {
		this.user = user;
	}
	/**
	 * @return the friends
	 */
	public List<UserVo> getFriends() {
		return friends;
	}
	/**
	 * @param friends the friends to set
	 */
	public void setFriends(List<UserVo> friends) {
		this.friends = friends;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
