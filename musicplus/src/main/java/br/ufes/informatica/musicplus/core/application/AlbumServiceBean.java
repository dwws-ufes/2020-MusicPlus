package br.ufes.informatica.musicplus.core.application;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.musicplus.core.domain.Album;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.Usuario;
import br.ufes.informatica.musicplus.core.persistence.AlbumDAO;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class AlbumServiceBean implements AlbumService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	@EJB
	private AlbumDAO albumDAO;
	
	@Override
	public void criarAlbum(String nomeAlbum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarMusicaNoAlbum(Usuario usuarioLogado, String nomeAlbum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerMusicaDoAlbum(Usuario usuarioLogado, String nomeAlbum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarMusicasDoAlbum(Usuario usuarioLogado, String nomeAlbum) {
		// TODO Auto-generated method stub
	}

	@Override
	@RolesAllowed("Admin")
	public void save(Album album) {
		// TODO Auto-generated method stub
		albumDAO.save(album);
	}

}