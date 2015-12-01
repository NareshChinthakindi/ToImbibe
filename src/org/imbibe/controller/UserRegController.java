package org.imbibe.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.Hibernate;
import org.imbibe.dao.UserDAO;
import org.imbibe.service.SecurityQuestionsService;
import org.imbibe.service.UserService;
import org.imbibe.util.ImbibeCipher;
import org.imbibe.vo.AddressVo;
import org.imbibe.vo.SecurityQuestions;
import org.imbibe.vo.UserAddressFormVo;
import org.imbibe.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserRegController {

	@Autowired
	UserService userService;

	@Autowired
	SecurityQuestionsService securityQuestionsService;

	@Autowired
	private MailSender mailSender;

	@Autowired
	UserDAO userDAO;

	@Autowired
	 @Qualifier("org.springframework.security.authenticationManager")
	 protected AuthenticationManager authenticationManager;



	@RequestMapping(value = "/index")
	public String saveUser(Model model) {
		// securityQuestionsService.getResults();
		return "index";
	}

	@RequestMapping(value = "/newUserRegisterView")
	public String RegisterUser(Model model) {

		List<SecurityQuestions> securityQuestionsList = securityQuestionsService.getSecurityQuestions();

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("agoyal@allianceglobalservices.com");
		message.setTo("agoyal@allianceglobalservices.com");
		message.setSubject("Test Mail ");
		message.setText("Please ignore");
		// mailSender.send(message);
		model.addAttribute("securityQuestionsList", securityQuestionsList);

		return "user/UserRegistration";
	}

	/**
	 * This method is used to save user personal and address details into db.
	 * 
	 * @param userAddressVo
	 * @param model
	 * @param httpReq
	 * @return String
	 */
	@RequestMapping(value = "/registerUser", method = { RequestMethod.GET, RequestMethod.POST })
	public String createDataSetSubmit(@ModelAttribute("userModel") UserAddressFormVo userAddressVo, ModelMap model,
			HttpServletRequest httpReq) {
		Integer userId = null;
		try {
			
			AddressVo addressVo = new AddressVo();
			addressVo.setAddress(userAddressVo.getAddress());
			addressVo.setCountry(userAddressVo.getCountry());
			addressVo.setState(userAddressVo.getState());
			addressVo.setPin(userAddressVo.getPin());
			addressVo.setMobileNumber(userAddressVo.getMobileNumber());

			// saving user's address details into ADDRESS table
			//addressId = userService.saveAddress(addressVo, httpReq);
			
			UserVo userVo = new UserVo();
			userVo.setFirstName(userAddressVo.getFirstName());
			userVo.setLastName(userAddressVo.getLastName());
			userVo.setGender(userAddressVo.getGender());
			userVo.setLoginId(userAddressVo.getLoginId());
			userVo.setSecurityQuestionAns(userAddressVo.getSecurityQuestionAns());
			userVo.setSecurityQuestionId(userAddressVo.getSecurityQuestionId());
			userVo.setDateOfBirth(userAddressVo.getDateOfBirth());
			userVo.setPassword(ImbibeCipher.encrypt(userAddressVo.getPassword()));
			userVo.setIsAdmin("N");
			userVo.setIsActive("Y");
			userVo.setAddressVo(addressVo);
			userVo.setEnabled(true);
		
			MultipartFile userProfilePic = userAddressVo.getProfilePicture();
			if (null != userProfilePic && !userProfilePic.isEmpty()) {
				userVo.setProfilePicType(userProfilePic.getContentType());
				Blob blob = Hibernate.createBlob(userProfilePic.getInputStream());
				userVo.setProfilePic(blob);
			}

			// saving user details into USERS table
			userId = userService.saveUser(userVo, httpReq);

		
			
			httpReq.getSession().setAttribute("userVo", userVo);
			httpReq.getSession().setAttribute("addressVo", addressVo);
			model.addAttribute("statusMessage", "User Registered successfully");
			autoLogin(httpReq, userAddressVo.getLoginId(), userAddressVo.getPassword());

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return "user/userPostLogin";

	}

	

	@ResponseBody
	@RequestMapping(value = "/userLogin/open")
	public String open(HttpServletRequest httpReq,HttpServletResponse response) {
		try {
			UserVo userVo=(UserVo)httpReq.getSession().getAttribute("userVo");
			if(null==userVo){
				
				return "index";
			}
			Blob file1 = getFile(userVo.getId());
			//Blob file1=userVo.getProfilePic();
			response.setHeader("Content-Disposition", "inline;filename=\"" + "docgetFilename" + "\"");
			OutputStream out = response.getOutputStream();
			// response.setContentType(doc.getContentType());
			response.setContentType("image/jpg");

			IOUtils.copy(file1.getBinaryStream(), out);
			out.flush();
			// out.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "user/UserRegistration";
	}

	private Blob getFile(Integer id) {
		Blob userPic=null;
		try {
		   userPic= userService.getUserProfilePic(id);
		   
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return userPic;
	}
	
	 public void autoLogin(HttpServletRequest request, String username, String password)
	 {
		    try 
		    {
		      // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
		      UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		      request.getSession(true);
		      token.setDetails(new WebAuthenticationDetails(request));
		      Authentication authentication = authenticationManager.authenticate(token);
		      //logger.debug("Logging in with {}", authentication.getPrincipal());
		      SecurityContextHolder.getContext().setAuthentication(authentication);
		    } catch (Exception e) {
		      SecurityContextHolder.getContext().setAuthentication(null);
		      //logger.error("Failure in autoLogin", e);
		    }
		  }
}
