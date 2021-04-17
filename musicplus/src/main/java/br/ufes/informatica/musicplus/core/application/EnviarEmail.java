package br.ufes.informatica.musicplus.core.application;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.*;

import java.io.IOException;

public class EnviarEmail {

   public EnviarEmail(String assunto, String destinatario, String conteudo) throws IOException {

       Email from = new Email("sistemamusicplus@gmail.com");
       Email to = new Email(destinatario); // use your own email address here

//       formatando mensagem de email
       Content content = new Content("text/html", conteudo);

       Mail mail = new Mail(from, assunto, to, content);

//       chave super secreta
       SendGrid sg = new SendGrid("");
       Request request = new Request();

       request.setMethod(Method.POST);
       request.setEndpoint("mail/send");
       request.setBody(mail.build());

       Response response = sg.api(request);

       System.out.println(response.getStatusCode());
       System.out.println(response.getHeaders());
       System.out.println(response.getBody());
   }
}