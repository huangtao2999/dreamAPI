/*
 * Created on 2004-12-13
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package cn.com.tetration.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 
 * @author julietty
 *
 */
public class MailAuthenticator extends Authenticator
{
	private String user;
	private String password;

	public MailAuthenticator(String user, String password)
	{
		super();
		this.user = user;
		this.password = password;
	}
	

	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(user, password);
	}
}
