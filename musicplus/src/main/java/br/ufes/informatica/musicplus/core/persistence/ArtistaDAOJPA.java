package br.ufes.informatica.musicplus.core.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.TipoPais;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class ArtistaDAOJPA extends BaseJPADAO<Artista> implements ArtistaDAO {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

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
	public List buscarPorNome(String nome) {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List buscarPorGenero(TipoGenero genero) {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List buscarPorPais(TipoPais pais) {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List listarMusicasDoArtista(Artista artista) {
		// FIXME: auto-generated method stub
		return null;
	}

}