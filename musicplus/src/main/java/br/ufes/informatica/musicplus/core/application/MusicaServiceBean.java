package br.ufes.informatica.musicplus.core.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.Musica;
import br.ufes.informatica.musicplus.core.persistence.MusicaDAO;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class MusicaServiceBean implements MusicaService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private MusicaDAO musicaDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Musica> buscarMusica(String NomeDaMusica, String NomeDoArtista) {
		// FIXME: auto-generated method stub
		return null;
	}
	
	public void save(Musica artista) {
		musicaDAO.save(artista);
	}

}