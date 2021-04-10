package br.ufes.informatica.musicplus.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-10T19:18:02.689-0300")
@StaticMetamodel(Artista.class)
public class Artista_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Artista, String> nome;
	public static volatile SingularAttribute<Artista, TipoPais> nacionalidade;
	public static volatile ListAttribute<Artista, TipoGenero> generos;
	public static volatile SingularAttribute<Artista, Integer> numVezesFavoritado;
	public static volatile SetAttribute<Artista, Usuario> usuariosQueFavoritaram;
	public static volatile SetAttribute<Artista, Album> colecoes;
	public static volatile SetAttribute<Artista, Musica> musicas;
}
