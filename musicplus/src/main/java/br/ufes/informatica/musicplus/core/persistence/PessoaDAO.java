package br.ufes.informatica.musicplus.core.persistence;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.informatica.musicplus.core.domain.Pessoa;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface PessoaDAO extends BaseDAO<Pessoa> {

	/** TODO: generated by FrameWeb. Should be documented. */
	public Pessoa buscarPorEmail(String email);

	/** TODO: generated by FrameWeb. Should be documented. */
	public Boolean trocarSenha(String novaSenha, Pessoa pessoa, String velhaSenha);

	/** TODO: generated by FrameWeb. Should be documented. */
	public void recuperarSenha(Pessoa pessoa, String email);

}