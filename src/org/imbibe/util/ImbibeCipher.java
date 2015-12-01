/**
 * 
 */
package org.imbibe.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author nchinthakindi
 *
 */
public class ImbibeCipher {
	
	private static MessageDigest md;
	
	static{
		init();
	}
	
	public static String encrypt(String plainText)
	{
		String encryptedText = null;
		
		try
		{
		
		if(null != plainText)
		{
	       
	        md.update(plainText.getBytes("UTF-8"));
	 
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        encryptedText = sb.toString();
		}
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return encryptedText;
	}
	
	private static void init()
	{
		 try 
		 {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	public static String decrypt(String encryptedString)
	{
		String decrypttedText = null;
		
		try
		{
			if(null != encryptedString)
			{
				byte[] byteCipherText = Base64.decodeBase64(encryptedString);
				decrypttedText = new String(byteCipherText);
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
		return decrypttedText;
	}*/
	
	public static void main(String[] args) {
		
		String encyr = encrypt("Naresh");
		System.out.println("Encr "+encyr);
		//System.out.println("Dec "+decrypt(encyr));
	}
}
