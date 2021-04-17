package br.ufes.informatica.musicplus.core.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.persistence.ArtistaDAO;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class ArtistaServiceBean implements ArtistaService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	@EJB
	private ArtistaDAO artistaDAO;

	public void save(Artista artista) {
		artistaDAO.save(artista);
	}

	@Override
	public List<Artista> buscarPorNome(String nome) {
		return artistaDAO.buscarPorNome(nome);
	}

	@Override
	public List<Artista> buscarTodosArtistas() {
		return artistaDAO.retrieveAll();
	}

	@Override
	public void delete(Artista artista) {
		artistaDAO.delete(artista);
	}

}