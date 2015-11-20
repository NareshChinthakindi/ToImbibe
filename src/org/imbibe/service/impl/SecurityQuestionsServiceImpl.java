/**
 * 
 */
package org.imbibe.service.impl;

import org.imbibe.dao.SecurityQuestionsDAO;
import org.imbibe.service.SecurityQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nchinthakindi
 *
 */
@Service
@Transactional
public class SecurityQuestionsServiceImpl implements SecurityQuestionsService {

	
	@Autowired
	SecurityQuestionsDAO questionsDAO;
	@Override
	public void getResults() 
	{

		questionsDAO.getAllSecurityQuestions();
	}

}
