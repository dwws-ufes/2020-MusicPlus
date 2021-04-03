package br.ufes.informatica.musicplus.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-03T18:00:15.014-0300")
@StaticMetamodel(Musica.class)
public class Musica_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Musica, String> nome;
	public static volatile SingularAttribute<Musica, Integer> duracao;
	public static volatile SetAttribute<Musica, Usuario> usuariosQueFavoritaram;
	public static volatile ListAttribute<Musica, TipoIdioma> idioma;
	public static volatile ListAttribute<Musica, TipoGenero> genero;
	public static volatile SingularAttribute<Musica, Integer> numVezesFavoritado;
	public static volatile SingularAttribute<Musica, Date> dataLancamento;
	public static volatile SetAttribute<Musica, Colecao> colecoes;
	public static volatile SetAttribute<Musica, Artista> artistas;
	public static volatile SetAttribute<Musica, Playlist> playlists;
}
