package br.ufes.informatica.musicplus.core.application;

import java.io.Serializable;

import javax.ejb.Local;

//adaptado do codigo do marvin (dar credito properly nao esquecer)
@Local
public interface LoginService extends Serializable{
//	User getCurrentUser();
	void login(String username, String password);
//			how we are handling exceptions?
}
