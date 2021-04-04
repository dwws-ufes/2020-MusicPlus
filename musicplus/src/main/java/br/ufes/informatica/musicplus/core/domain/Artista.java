package br.ufes.informatica.musicplus.core.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

/** TODO: generated by FrameWeb. Should be documented. */
@Entity
public class Artista extends PersistentObjectSupport implements Comparable<Artista> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private String nome;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private TipoPais nacionalidade;

	/** TODO: generated by FrameWeb. Should be documented. false */
    @ElementCollection
	private List<TipoGenero> generos;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private int numVezesFavoritado;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(mappedBy = "artistasFavoritados")
	private Set<Usuario> usuariosQueFavoritaram;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(
			cascade = CascadeType.ALL,
			mappedBy = "artistas"
			)
	private Set<Colecao> colecoes;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(
			cascade = CascadeType.ALL,
			mappedBy = "artistas"
			)
	private Set<Musica> musicas;

	/** Getter for nome. */
	public String getNome() {
		return nome;
	}

	/** Setter for nome. */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** Getter for nacionalidade. */
	public TipoPais getNacionalidade() {
		return nacionalidade;
	}

	/** Setter for nacionalidade. */
	public void setNacionalidade(TipoPais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	/** Getter for genero. */
	public List<TipoGenero> getGenero() {
		return generos;
	}

	/** Getter for numVezesFavoritado. */
	public int getNumVezesFavoritado() {
		return numVezesFavoritado;
	}

	/** Setter for numVezesFavoritado. */
	public void setNumVezesFavoritado(int numVezesFavoritado) {
		this.numVezesFavoritado = numVezesFavoritado;
	}

	/** Getter for Source. */
	public Set<Usuario> getUsuariosQueFavoritaram() {
		return usuariosQueFavoritaram;
	}

	/** Getter for Target. */
	public Set<Colecao> getColecoes() {
		return colecoes;
	}

	/** Getter for Target. */
	public Set<Musica> getMusicas() {
		return musicas;
	}
	
	public void addGenero(TipoGenero genero) {
		this.generos.add(genero) ;
	}

	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(Artista o) {
		if (this.getId() == o.getId())
			return 0 ;
		else {
			if (this.numVezesFavoritado == o.numVezesFavoritado) {
				return this.nome.compareTo(o.nome);
			}else {
				Integer thisNumVezesFavoritado = this.numVezesFavoritado;
				Integer oNumVezesFavoritado = o.numVezesFavoritado;
				return thisNumVezesFavoritado.compareTo(oNumVezesFavoritado);
			}
		}
	}
}