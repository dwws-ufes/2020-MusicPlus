package br.ufes.informatica.musicplus.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.TipoIdioma;
import br.ufes.informatica.musicplus.core.domain.TipoPais;
import br.ufes.informatica.musicplus.core.persistence.ArtistaDAO;
import br.ufes.informatica.musicplus.core.persistence.MusicaDAO;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.Musica;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class SugestaoServiceBean implements SugestaoService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private MusicaDAO musicaDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private ArtistaDAO artistaDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Artista> pedirSugestaoArtista(String rankingOuAleatorio, TipoPais pais, Integer numero, TipoGenero genero) {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Musica> pedirSugestaoMusica(String RankingOuAleatorio, TipoIdioma idioma, Integer numero, TipoGenero genero) {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	private List<Artista> selecionarArtistasAleatorios(List<Artista> listaArtistas, Integer numero) {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	private List<Musica> selecionarMusicasAleatorias(List<Musica> listaMusicas, Integer numero) {
		// FIXME: auto-generated method stub
		return null;
	}

}