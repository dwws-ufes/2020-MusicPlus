package br.ufes.informatica.musicplus.core.domain;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport_;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2021-04-03T18:00:15.012-0300")
@StaticMetamodel(Colecao.class)
public class Colecao_ extends PersistentObjectSupport_ {
	public static volatile SingularAttribute<Colecao, String> nome;
	public static volatile SingularAttribute<Colecao, TipoColecao> tipoColecao;
	public static volatile SingularAttribute<Colecao, Date> dataLancamento;
	public static volatile SetAttribute<Colecao, Artista> artistas;
	public static volatile SetAttribute<Colecao, Musica> musicas;
}
