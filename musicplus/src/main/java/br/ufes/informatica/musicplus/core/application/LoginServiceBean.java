package br.ufes.informatica.musicplus.core.application;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.enterprise.event.Event;

import br.ufes.inf.nemo.jbutler.TextUtils;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.musicplus.core.domain.Usuario;
import br.ufes.informatica.musicplus.core.persistence.UsuarioDAO;

@Stateless
public class LoginServiceBean implements LoginService{
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(LoginServiceBean.class.getCanonicalName());
	@EJB
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private Event<LoginEvent> loginEvent;
	
	@Resource
	private SessionContext sessionContext;
	
	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
		try {
			Usuario user = usuarioDAO.buscarPorEmail(username);
			// Creates the MD5 hash of the password for comparison.
			String md5pwd = TextUtils.produceBase64EncodedMd5Hash(password);

			// Checks if the passwords match.
			String pwd = user.getSenha();
			
			if ((pwd != null) && (pwd.equals(md5pwd))) {
				Usuario currentUser = user;
				pwd = null;
				
//				SessionInformation.getInstance().setUsuarioLogado(currentUser);
				System.out.println("Usuario logando com sucesso");
				// Fires a login event.
				loginEvent.fire(new LoginEvent(currentUser));
			}
			
			
		} catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro aqui Login Service Bean");
//			e.printStackTrace();
		}

		
		
	}

	
	 @Override
	  public Usuario getCurrentUser() {
	    try {
	      return usuarioDAO.buscarPorEmail(sessionContext.getCallerPrincipal().getName());
	    } catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
	      return null;
	    }
	  }
}
