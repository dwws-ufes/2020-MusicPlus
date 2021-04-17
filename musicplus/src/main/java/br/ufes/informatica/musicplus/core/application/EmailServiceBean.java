package br.ufes.informatica.musicplus.core.application;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.io.IOException;

@Stateless
public class EmailServiceBean implements EmailService {

   public void enviarEmail(String assunto, String destinatario, String conteudo) {

       Email from = new Email("sistemamusicplus@gmail.com");
       Email to = new Email(destinatario); // use your own email address here

//       formatando mensagem de email
       Content content = new Content("text/html", conteudo);

       Mail mail = new Mail(from, assunto, to, content);

//       chave super secreta
       SendGrid sg = new SendGrid("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");
       Request request = new Request();

       try {
	       request.setMethod(Method.POST);
	       request.setEndpoint("mail/send");
    	   request.setBody(mail.build());
    	   
    	   Response response = sg.api(request);
		

	       System.out.println(response.getStatusCode());
	       System.out.println(response.getHeaders());
	       System.out.println(response.getBody());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}