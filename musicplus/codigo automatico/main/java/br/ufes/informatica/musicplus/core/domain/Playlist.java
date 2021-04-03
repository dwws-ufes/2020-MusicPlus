package br.ufes.informatica.musicplus.core.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

/** TODO: generated by FrameWeb. Should be documented. */
@Entity
public class Playlist extends PersistentObjectSupport implements Comparable<Playlist> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private String nome;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToOne
	private Usuario Source;

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

	/** Getter for Source. */
	public Usuario getSource() {
		return Source;
	}

	/** Setter for Source. */
	public void setSource(Usuario Source) {
		this.Source = Source;
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
	public int compareTo(Playlist o) {
		// FIXME: auto-generated method stub
		return super.compareTo(o);
	}
}