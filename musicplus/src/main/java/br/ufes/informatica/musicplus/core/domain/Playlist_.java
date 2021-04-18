package br.ufes.informatica.musicplus.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-17T21:29:58.061-0300")
@StaticMetamodel(Playlist.class)
public class Playlist_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Playlist, String> nome;
	public static volatile SingularAttribute<Playlist, Usuario> usuario;
	public static volatile SetAttribute<Playlist, Musica> musicas;
}
