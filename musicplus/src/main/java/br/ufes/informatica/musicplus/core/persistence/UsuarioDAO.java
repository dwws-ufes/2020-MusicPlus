package br.ufes.informatica.musicplus.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.Usuario;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface UsuarioDAO extends BaseDAO<Usuario> {

	/** TODO: generated by FrameWeb. Should be documented. */
	public void favoritarArtista(Artista artista, Usuario usuario);

	/** TODO: generated by FrameWeb. Should be documented. */
	public void favoritarGenero(TipoGenero genero, Usuario usuario);

	/** TODO: generated by FrameWeb. Should be documented. */
	public List listarArtistasFavoritos(Usuario usuario);

	/** TODO: generated by FrameWeb. Should be documented. */
	public List listarGenerosFavoritos(Usuario usuario);

}