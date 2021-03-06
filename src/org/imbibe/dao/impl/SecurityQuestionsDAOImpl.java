/**
 * 
 */
package org.imbibe.dao.impl;

import java.util.List;

import org.imbibe.dao.ImbibeDAO;
import org.imbibe.dao.SecurityQuestionsDAO;
import org.imbibe.vo.SecurityQuestions;
import org.springframework.stereotype.Repository;

/**
 * @author nchinthakindi
 *
 */
@Repository
public class SecurityQuestionsDAOImpl extends ImbibeDAO implements SecurityQuestionsDAO 
{

	

	@Override
	public List<SecurityQuestions> getAllSecurityQuestions() 
	{
		List<SecurityQuestions> list = this.getHibernateTemplate().find("from SecurityQuestions");

		return list;
	}

}
