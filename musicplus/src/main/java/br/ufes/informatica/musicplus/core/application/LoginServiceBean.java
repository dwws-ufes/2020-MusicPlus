package br.ufes.informatica.musicplus.core.application;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

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
	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
		try {
			Usuario user = usuarioDAO.buscarPorEmail(username);
			// Creates the MD5 hash of the password for comparison.
//			String md5pwd = TextUtils.produceBase64EncodedMd5Hash(password);

			// Checks if the passwords match.
//			String pwd = user.getPassword();
			
		} catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
