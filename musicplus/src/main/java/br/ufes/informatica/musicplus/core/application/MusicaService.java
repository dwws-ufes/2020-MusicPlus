package br.ufes.informatica.musicplus.core.application;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.ufes.informatica.musicplus.core.domain.Musica;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface MusicaService extends Serializable {

	/** TODO: generated by FrameWeb. Should be documented. */
	public List<Musica> buscarMusica(String NomeDaMusica, String NomeDoArtista);

}