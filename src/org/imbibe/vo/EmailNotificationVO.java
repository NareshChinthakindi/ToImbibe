/**
 * 
 */
package org.imbibe.vo;

import java.util.List;

/**
 * @author nchinthakindi
 *
 */
public class EmailNotificationVO {

	
	private List<String> toRecipients;
	private List<String> ccRecipients;
	private String from;
	private String subject;
	private String message;
	private String filepath;
	/**
	 * @return the ccRecipients
	 */
	public List<String> getCcRecipients() {
		return ccRecipients;
	}
	/**
	 * @param ccRecipients the ccRecipients to set
	 */
	public void setCcRecipients(List<String> ccRecipients) {
		this.ccRecipients = ccRecipients;
	}
	/**
	 * @return the filepath
	 */
	public String getFilepath() {
		return filepath;
	}
	/**
	 * @param filepath the filepath to set
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * @return the toRecipients
	 */
	public List<String> getToRecipients() {
		return toRecipients;
	}
	/**
	 * @param toRecipients the toRecipients to set
	 */
	public void setToRecipients(List<String> toRecipients) {
		this.toRecipients = toRecipients;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
