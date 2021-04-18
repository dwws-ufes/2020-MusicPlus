package br.ufes.informatica.musicplus.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-18T12:54:09.318-0300")
@StaticMetamodel(Usuario.class)
public class Usuario_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Usuario, String> nome;
	public static volatile SingularAttribute<Usuario, Boolean> admin;
	public static volatile SingularAttribute<Usuario, String> username;
	public static volatile SingularAttribute<Usuario, String> email;
	public static volatile SingularAttribute<Usuario, String> senha;
	public static volatile SetAttribute<Usuario, Artista> artistasFavoritados;
	public static volatile ListAttribute<Usuario, TipoGenero> generoFavoritados;
	public static volatile SetAttribute<Usuario, Musica> musicasFavoritadas;
	public static volatile SetAttribute<Usuario, Playlist> playlists;
}
