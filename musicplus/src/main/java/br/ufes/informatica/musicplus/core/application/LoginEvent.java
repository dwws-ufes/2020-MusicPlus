package br.ufes.informatica.musicplus.core.application;

import br.ufes.informatica.musicplus.core.domain.Usuario;

/**
 * TODO: document this type.
 *
 * @author Vítor E. Silva Souza (https://github.com/vitorsouza/)
 */
public class LoginEvent {
  /** TODO: document this field. */
  private Usuario usuario;

  /** Constructor. */
  public LoginEvent(Usuario usuario) {
    this.usuario = usuario;
  }

  /** Getter for user. */
  public Usuario getUsuario() {
    return usuario;
  }
}