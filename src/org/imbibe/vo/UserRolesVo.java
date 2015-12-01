package org.imbibe.vo;



/**
 * @author agoyal
 *
 */
public class UserRolesVo extends ImbibeVO {
	
	private static final long serialVersionUID = 3020506241206644843L;
	private Integer userRoleId;
	private Integer userId;
	private String authority;
	
	
	public Integer getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
	
}