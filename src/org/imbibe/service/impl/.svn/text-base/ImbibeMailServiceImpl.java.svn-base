/**
 * 
 */
package org.imbibe.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.imbibe.exception.ImbibeException;
import org.imbibe.service.ImbibeMailService;
import org.imbibe.vo.EmailNotificationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;


/**
 * @author nchinthakindi
 *
 */
@Service
public class ImbibeMailServiceImpl implements ImbibeMailService {


	//private static final Logger logger = Logger.getLogger(ImbibeMailServiceImpl.class);

	@Autowired
	private org.springframework.mail.javamail.JavaMailSenderImpl mailSender;

	@Override
	public void sendMail(EmailNotificationVO emailNotification) throws ImbibeException
	{


		//logger.debug("Enter into sendEmail(EmailNotification emailNotification)");
		MimeMessage message = null;
		MimeMessageHelper helper = null;
		try
		{


			message = this.mailSender.createMimeMessage();

			// use the true flag to indicate you need a multipart message
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setFrom(emailNotification.getFrom());
			// msg.setTo(Arrays.asList(emailNotification.getToRecipients()));
			List<String> toList = emailNotification.getToRecipients();
			/*toList.add("nchinthakindi@havigs.com");*/
			if(toList != null)
			{
				String to[] =  toList.toArray(new String[toList.size()]);
				helper.setTo(to);
			}
			List<String> ccList = emailNotification.getCcRecipients();
			if(ccList != null)
			{
				String cc[] =  ccList.toArray(new String[ccList.size()]);
				helper.setCc(cc);
			}

			if(emailNotification.getFilepath() != null)
			{
				File file = new File(emailNotification.getFilepath());

				if(file != null && file.exists())
				{
					int dotPos = file.getName().lastIndexOf(".");
					String extension = file.getName().substring(dotPos);
					helper.addAttachment(MimeUtility.encodeText(emailNotification.getSubject()+extension, "UTF-8", "Q"), file);
				}
			}
			helper.setText(emailNotification.getMessage(),true);
			helper.setSubject(emailNotification.getSubject());
			helper.setSentDate(Calendar.getInstance().getTime());

			this.mailSender.send(message);
		}
		catch(MailException ex) 
		{
			//logger.error(ex.getMessage());  
			throw new ImbibeException(ex.getMessage());
		}
		catch (Exception ex) 
		{
			//logger.error(ex.getMessage());  
			throw new ImbibeException(ex.getMessage());
		}
		finally
		{
			message = null;
			helper = null;
		}
		//logger.debug("Exit from sendEmail(EmailNotification emailNotification)");
	}
}
