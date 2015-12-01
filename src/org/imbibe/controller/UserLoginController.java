package org.imbibe.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.imbibe.service.SecurityQuestionsService;
import org.imbibe.service.UserService;
import org.imbibe.vo.AddressVo;
import org.imbibe.vo.SecurityQuestions;
import org.imbibe.vo.UserAddressFormVo;
import org.imbibe.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserLoginController {

	@Autowired
	UserService userService;

	@Autowired
	SecurityQuestionsService securityQuestionsService;

	/**
	 * This method is used to verify the User's login crendentials and get the
	 * user data.
	 * 
	 * @param userAddressVo
	 * @param model
	 * @param httpReq
	 * @return String
	 */
	@RequestMapping(value = "/Test", method = { RequestMethod.GET, RequestMethod.POST })
	public String createDataSetSubmit(ModelMap model, HttpServletRequest httpReq) {
		try {

			UserVo userVo = new UserVo();

			String loginId = httpReq.getParameter("loginId");
			String password = httpReq.getParameter("password");

			userVo = userService.verifyLoginIdPassoword(loginId, password);

			AddressVo addressVo = new AddressVo();

			httpReq.getSession().setAttribute("userVo", userVo);
			httpReq.getSession().setAttribute("addressVo", addressVo);
			model.addAttribute("statusMessage", "");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return "user/userPostLogin";

	}

	@RequestMapping(value = "/userLogin/welcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, HttpServletRequest httpReq, Principal principal) {
		UserVo userVo = null;

		String strLoginId = principal.getName();
		if (null != strLoginId) {
			userVo = userService.getUserByLoginId(strLoginId);
		}
		if (null != userVo) {
			httpReq.getSession().setAttribute("userVo", userVo);
		}
		List<SecurityQuestions> securityQuestionsList = securityQuestionsService.getSecurityQuestions();
		model.addAttribute("securityQuestionsList", securityQuestionsList);

		return "user/userPostLogin";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "index";

	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "index";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest httpReq) {
		
		//httpReq.getSession().invalidate();

		return "index";

	}

	@RequestMapping(value = "/userLogin/updateProfileView", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateUserProfile(ModelMap model, HttpServletRequest httpReq) {
		try {

			UserVo userVo = new UserVo();
			userVo = (UserVo) httpReq.getSession().getAttribute("userVo");
			httpReq.setAttribute("userVo", userVo);

			List<SecurityQuestions> securityQuestionsList = (List<SecurityQuestions>) httpReq.getSession()
					.getAttribute("securityQuestionsList");
			if (null == securityQuestionsList) {
				securityQuestionsList = securityQuestionsService.getSecurityQuestions();
				model.addAttribute("securityQuestionsList", securityQuestionsList);
			}
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return "user/userUpdateProfile";

	}

	@RequestMapping(value = "/userLogin/updateProfileSubmit", method = { RequestMethod.GET, RequestMethod.POST })
	public String createDataSetSubmit(@ModelAttribute("userModel") UserAddressFormVo userAddressVo, ModelMap model,
			HttpServletRequest httpReq) {
		boolean isUpdated = false;
		String strStatusMessage = "";
		String strErrMessage = "";

		try {
			UserVo userVo = (UserVo) httpReq.getSession().getAttribute("userVo");

			AddressVo addressVo = userVo.getAddressVo();
			addressVo.setAddress(userAddressVo.getAddress());
			addressVo.setCountry(userAddressVo.getCountry());
			addressVo.setState(userAddressVo.getState());
			addressVo.setPin(userAddressVo.getPin());
			addressVo.setMobileNumber(userAddressVo.getMobileNumber());

			userVo.setFirstName(userAddressVo.getFirstName());
			userVo.setLastName(userAddressVo.getLastName());
			userVo.setSecurityQuestionAns(userAddressVo.getSecurityQuestionAns());
			userVo.setIsAdmin("N");
			userVo.setIsActive("Y");
			userVo.setAddressVo(addressVo);
			userVo.setEnabled(true);

			// Updating user details
			isUpdated = userService.updateUserProfile(userVo, httpReq);
			if (isUpdated) {
				strStatusMessage = "Profile Updated Successfully";
			} else {
				strErrMessage = "Some error has occured , please try to update after some time.";
			}

			httpReq.getSession().setAttribute("userVo", userVo);
			httpReq.getSession().setAttribute("addressVo", addressVo);
			model.addAttribute("strStatusMessage", strStatusMessage);
			model.addAttribute("strErrMessage", strErrMessage);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return "user/userPostLogin";

	}
}
