/**
 * 
 */
package org.imbibe.controller;

import org.imbibe.service.SecurityQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author nchinthakindi
 *
 */
@Controller
public class TestController {

	@Autowired
	SecurityQuestionsService securityQuestionsService;


	/*@RequestMapping(value = "/index")    
	public String saveUser(Model model)
	{  
		
		securityQuestionsService.getSecurityQuestions();
		return "index";
	}*/
}
