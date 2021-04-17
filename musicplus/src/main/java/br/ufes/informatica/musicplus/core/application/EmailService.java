package br.ufes.informatica.musicplus.core.application;

import javax.ejb.Local;

@Local
public interface EmailService {

	public void enviarEmail(String assunto, String destinatario, String conteudo);
}
