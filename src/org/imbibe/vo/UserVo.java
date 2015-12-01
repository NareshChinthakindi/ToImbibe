package org.imbibe.vo;

import java.sql.Blob;
import java.util.Date;


/**
 * @author agoyal
 *
 */
public class UserVo extends ImbibeVO {
	
	private static final long serialVersionUID = 2404273553850590916L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private Integer securityQuestionId;
	private String securityQuestionAns;
	private String gender;
	private Date dateOfBirth;
	private String isActive ;
	private String isAdmin;
	private String profilePicType;
	private Blob profilePic;
	private Boolean enabled;
	private AddressVo addressVo;
	
	/**
	 * @return the addressVo
	 */
	public AddressVo getAddressVo() {
		return addressVo;
	}
	/**
	 * @param addressVo the addressVo to set
	 */
	public void setAddressVo(AddressVo addressVo) {
		this.addressVo = addressVo;
	}
	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSecurityQuestionId() {
		return securityQuestionId;
	}
	public void setSecurityQuestionId(Integer securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}
	public String getSecurityQuestionAns() {
		return securityQuestionAns;
	}
	public void setSecurityQuestionAns(String securityQuestionAns) {
		this.securityQuestionAns = securityQuestionAns;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	/**
	 * @param profilePicType the profilePicType to set
	 */
	public void setProfilePicType(String profilePicType) {
		this.profilePicType = profilePicType;
	}
	/**
	 * @return the profilePicType
	 */
	public String getProfilePicType() {
		return profilePicType;
	}
	/**
	 * @param profilePic the profilePic to set
	 */
	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}
	/**
	 * @return the profilePic
	 */
	public Blob getProfilePic() {
		return profilePic;
	}


}
