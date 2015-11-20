/**
 * 
 */
package org.imbibe.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author nchinthakindi
 *
 */
public class ImbibeDAO extends HibernateDaoSupport{

	@Autowired
	public void init(SessionFactory factory) {
	    setSessionFactory(factory);
	}
	
}
