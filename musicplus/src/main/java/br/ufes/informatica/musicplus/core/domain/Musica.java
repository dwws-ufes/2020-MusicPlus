package br.ufes.informatica.musicplus.core.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

/** TODO: generated by FrameWeb. Should be documented. */
@Entity
public class Musica extends PersistentObjectSupport implements Comparable<Musica> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private String nome;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private int duracao;

	@ManyToMany(mappedBy = "musicasFavoritadas")
	private Set<Usuario> usuariosQueFavoritaram;
	
	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
    @ElementCollection
	private List<TipoIdioma> idioma;

	/** TODO: generated by FrameWeb. Should be documented. false */
    @ElementCollection
	private List<TipoGenero> genero;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private int numVezesFavoritado;

	/** TODO: generated by FrameWeb. Should be documented. true */
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(mappedBy = "musicas")
	private Set<Colecao> colecoes;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany
	private Set<Artista> artistas;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(mappedBy = "musicas")
	private Set<Playlist> playlists;

	/** Getter for nome. */
	public String getNome() {
		return nome;
	}

	/** Setter for nome. */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** Getter for duracao. */
	public int getDuracao() {
		return duracao;
	}

	/** Setter for duracao. */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	/** Getter for idioma. */
	public List<TipoIdioma> getIdioma() {
		return idioma;
	}

	/** Setter for idioma. */
	public void setIdioma(List<TipoIdioma> idioma) {
		this.idioma = idioma;
	}

	/** Getter for genero. */
	public List<TipoGenero> getGenero() {
		return genero;
	}

	/** Getter for numVezesFavoritado. */
	public int getNumVezesFavoritado() {
		return numVezesFavoritado;
	}

	/** Setter for numVezesFavoritado. */
	public void setNumVezesFavoritado(int numVezesFavoritado) {
		this.numVezesFavoritado = numVezesFavoritado;
	}

	/** Getter for dataLancamento. */
	public Date getDataLancamento() {
		return dataLancamento;
	}

	/** Setter for dataLancamento. */
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	/** Getter for Target. */
	public Set<Colecao> getColecoes() {
		return colecoes;
	}

	/** Getter for Source. */
	public Set<Artista> getArtistas() {
		return artistas;
	}

	/** Getter for Source. */
	public Set<Playlist> getPlaylists() {
		return playlists;
	}

	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(Musica o) {
		// FIXME: auto-generated method stub
		return super.compareTo(o);
	}
}