package br.ufes.informatica.musicplus.core.application;

import java.io.Serializable;

//adaptado do codigo do marvin (dar credito properly nao esquecer)
public interface LoginService extends Serializable{
//	User getCurrentUser();
	void login(String username, String password);
//			throws LoginFailedException; (handling exceptions)
}
