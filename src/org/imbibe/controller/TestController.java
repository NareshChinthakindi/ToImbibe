/**
 * 
 */
package org.imbibe.controller;

import org.imbibe.service.SecurityQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nchinthakindi
 *
 */
@Controller
public class TestController {

	@Autowired
	SecurityQuestionsService securityQuestionsService;


	@RequestMapping(value = "/index")    
	public String saveUser(Model model)
	{  
		
		securityQuestionsService.getResults();
		return "index";
	}
}
