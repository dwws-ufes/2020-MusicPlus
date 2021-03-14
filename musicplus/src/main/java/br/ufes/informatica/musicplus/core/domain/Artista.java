package br.ufes.informatica.musicplus.core.domain;

import java.util.List;
import java.util.Set;

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
	@NotNull
	private List genero;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private int numVezesFavoritado;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(mappedBy = "Target")
	private Set<Usuario> Source;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany
	private Set<Colecao> Target;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany
	private Set<Musica> Target;

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
	public List getGenero() {
		return genero;
	}

	/** Setter for genero. */
	public void setGenero(List genero) {
		this.genero = genero;
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
	public Set<Usuario> getSource() {
		return Source;
	}

	/** Setter for Source. */
	public void setSource(Set<Usuario> Source) {
		this.Source = Source;
	}

	/** Getter for Target. */
	public Set<Colecao> getTarget() {
		return Target;
	}

	/** Setter for Target. */
	public void setTarget(Set<Colecao> Target) {
		this.Target = Target;
	}

	/** Getter for Target. */
	public Set<Musica> getTarget() {
		return Target;
	}

	/** Setter for Target. */
	public void setTarget(Set<Musica> Target) {
		this.Target = Target;
	}

	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(Artista o) {
		// FIXME: auto-generated method stub
		return super.compareTo(o);
	}
}