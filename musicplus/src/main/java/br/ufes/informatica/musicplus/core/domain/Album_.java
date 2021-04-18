package br.ufes.informatica.musicplus.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-17T21:29:58.020-0300")
@StaticMetamodel(Album.class)
public class Album_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Album, String> nome;
	public static volatile SingularAttribute<Album, Date> dataLancamento;
	public static volatile SingularAttribute<Album, Artista> artista;
	public static volatile SetAttribute<Album, Musica> musicas;
}
