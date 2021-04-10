package br.ufes.informatica.musicplus.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.TipoIdioma;
import br.ufes.informatica.musicplus.core.domain.TipoPais;
import br.ufes.informatica.musicplus.core.persistence.ArtistaDAO;
import br.ufes.informatica.musicplus.core.persistence.MusicaDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
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
	public List<Artista> pedirSugestaoArtista(String rankingOuAleatorio, List<TipoPais> paises, Boolean allPaises, Integer numero, List<TipoGenero> generos, Boolean allGeneros) {
		List<Artista> artistas = new ArrayList<Artista>() ;
		if (!allGeneros) {
			artistas.addAll(pedirSugestaoArtistaGenero(generos));
		}
		if (!allPaises)	{
			artistas.addAll(pedirSugestaoArtistaPais(paises));
		}
		if (allGeneros && allPaises) {
			return artistaDAO.retrieveAll();
		}
		return convert(artistas);
	}
	
	public List<Artista> convert(List<Artista> artistas){
		return artistas.stream().distinct().collect(Collectors.toList());
	}
	
	public List<Artista> pedirSugestaoArtistaGenero(List<TipoGenero> generos){
		List<Artista> artista_genero = new ArrayList<Artista>();
		try {
			for (TipoGenero g : generos) {
				artista_genero.addAll(artistaDAO.buscarPorGenero(g)) ;
			}
			return artista_genero.stream().distinct().collect(Collectors.toList());
		}catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e){
			e.printStackTrace();
			return null ;
		}
	}
	
	public List<Artista> pedirSugestaoArtistaPais(List<TipoPais> paises){
		List<Artista> artista_pais = new ArrayList<Artista>();
		try {
			for (TipoPais p : paises) {
				artista_pais.addAll(artistaDAO.buscarPorPais(p)) ;
			}
			return artista_pais.stream().distinct().collect(Collectors.toList());
		}catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e){
			e.printStackTrace();
			return null ;
		}
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public List<Musica> pedirSugestaoMusica(String RankingOuAleatorio, List<TipoIdioma> idioma, Integer numero, List<TipoGenero> genero) {
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