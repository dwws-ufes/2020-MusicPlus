package br.ufes.informatica.musicplus.core.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;


import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.Artista_;
import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.TipoPais;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class ArtistaDAOJPA extends BaseJPADAO<Artista> implements ArtistaDAO {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(UsuarioDAOJPA.class.getCanonicalName());

	/** TODO: generated by FrameWeb. Should be documented. */
	@PersistenceContext
	private EntityManager entityManager;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Artista> buscarPorNome(String nome) {
		logger.log(Level.FINE, "Retrieving the Artista whose name is \"{0}\"...", nome);
		
		// Constructs the query over the Artista class.
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
		Root<Artista> root = cq.from(Artista.class);

		// Filters the query with the nome.
		cq.where(cb.like(cb.lower(root.get(Artista_.nome)), "%" + nome.toLowerCase() + "%"));
		List<Artista> result = entityManager.createQuery(cq).getResultList();
		logger.log(Level.INFO, "Retrieve Artista by the nome \"{0}\" returned \"{1}\"", new Object[] { nome, result });
		return entityManager.createQuery(cq).getResultList();
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Artista> buscarPorGenero(TipoGenero genero) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Recuperando os Artistas que performam o genero musica \"{0}\"...", genero);

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
		Root<Artista> root = cq.from(Artista.class);
		ListJoin<Artista, TipoGenero> Artista_genero = root.join(Artista_.generos);
		
		cq.where(cb.equal(Artista_genero, genero));
		List<Artista> result = entityManager.createQuery(cq).getResultList();
		logger.log(Level.INFO, "Recuperandos os Artistas pelo genero musical \"{0}\" retornou \"{1}\"", new Object[] { genero, result });

		return result;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Artista> buscarPorPais(TipoPais nacionalidade) throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException {
		logger.log(Level.FINE, "Recuperando o Artista cuja nacionalidade eh \"{0}\"...", nacionalidade);

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Artista> cq = cb.createQuery(Artista.class);
		Root<Artista> root = cq.from(Artista.class);

		cq.where(cb.equal(root.get(Artista_.nacionalidade), nacionalidade));
		List<Artista> result = entityManager.createQuery(cq).getResultList();
		logger.log(Level.INFO, "Recuperando o Artista pelo pais \"{0}\" retornou \"{1}\"", new Object[] { nacionalidade, result });
		return result;
	}

}