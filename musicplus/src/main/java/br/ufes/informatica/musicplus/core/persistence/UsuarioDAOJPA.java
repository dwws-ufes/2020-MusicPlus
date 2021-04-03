package br.ufes.informatica.musicplus.core.persistence;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.musicplus.core.domain.Usuario;
import br.ufes.informatica.musicplus.core.domain.Usuario_;

@Stateless
public class UsuarioDAOJPA extends BaseJPADAO<Usuario> implements UsuarioDAO {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(UsuarioDAOJPA.class.getCanonicalName());

	/** The application's persistent context provided by the application server. */
	@PersistenceContext
	private EntityManager entityManager;

	/** @see br.ufes.inf.nemo.util.ejb3.persistence.BaseJPADAO#getEntityManager() */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/** @see br.ufes.informatica.pooptime.core.persistence.UsuarioDAO#buscarPorEmail(java.lang.String) */
	@Override
	public Usuario buscarPorEmail(String email) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Recuperando o Usuario cujo e-mail eh \"{0}\"...", email);

		// Constroi a query na classe Usuario.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
		Root<Usuario> root = cq.from(Usuario.class);

		// Filters the query with the email.
		cq.where(cb.equal(root.get(Usuario_.email), email));
		Usuario result = executeSingleResultQuery(cq, email);
		logger.log(Level.INFO, "Recuperando o Usuario pelo e-mail \"{0}\" retornou \"{1}\"", new Object[] { email, result });
		return result;
	}

}