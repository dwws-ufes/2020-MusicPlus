package br.ufes.informatica.musicplus.core.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.musicplus.core.application.LoginService;
import br.ufes.informatica.musicplus.core.application.MusicaService;
import br.ufes.informatica.musicplus.core.application.UsuarioService;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.Musica;
import br.ufes.informatica.musicplus.core.domain.TipoUsuario;
import br.ufes.informatica.musicplus.core.domain.Usuario;

/**
 * Stateless session bean implementing the login service. See the implemented interface
 * documentation for details.
 * @author Vítor E. Silva Souza (https://github.com/vitorsouza/)
 */
// inspired and adapted from marvin's code

@Named
@SessionScoped
public class SessionController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private LoginService loginService;
	
	@EJB
	private UsuarioService usuarioService ;

	@EJB
	private MusicaService musicaService ;

	private String email;
	
	private String password;
	
	private Usuario currentUser;
		
	private Musica musicaEscolhida ;

	private Artista artistaEscolhido ;

	private Set<Musica> musicas ;
	
	public Usuario getCurrentUser() { 
		return currentUser;
	}
	
	private class MyJSFController extends JSFController {
	    private static final long serialVersionUID = 1L;

	    void addMessage(String bundleName, FacesMessage.Severity severity, String summaryKey,
	        String detailKey) {
	      addGlobalI18nMessage(bundleName, severity, summaryKey, detailKey);
	    }

	    void addMessage(String bundleName, FacesMessage.Severity severity, String summaryKey,
	        Object[] summaryParams, String detailKey, Object[] detailParams) {
	      addGlobalI18nMessage(bundleName, severity, summaryKey, summaryParams, detailKey,
	          detailParams);
	    }
	  };
	/**
	 * Accesses the Login service to authenticate the user given his email and password.
	 */
	public String login() {
		try {
			// Uses the Session Information bean to authenticate the user.
			
			loginService.login(email, password);

			// Also authenticates on JAAS.
			// FIXME: is there a way to do this at the application package (in the EJB)?
			try {
				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				request.login(email, password);
			}
			catch (Exception e) {
				// handling exception
				new MyJSFController().addMessage("msgs", FacesMessage.SEVERITY_ERROR,
			              "login.error.nomatch.summary", "login.error.nomatch.detail");
				return null;
			}
		}
		catch (Exception e) {
			// handling exception
			new MyJSFController().addMessage("msgs", FacesMessage.SEVERITY_ERROR,
		              "login.error.nomatch.summary", "login.error.nomatch.detail");
			return null;
		}

		// If everything is OK, stores the current user and redirects back to the home screen.
		currentUser = loginService.getCurrentUser();
		System.out.println("Hello "+ currentUser.getNome());
		return "core/home/index.xhtml?faces-redirect=true";
	}

	public boolean isLoggedIn() {

		return currentUser != null; 
	}
	
	public boolean checkLogin() {
		if(!isLoggedIn()) {
			return false;
		}
		return true;
	}
	
	public boolean isAdmin() {
		if(!isLoggedIn()) {
			return false;
		}
		return currentUser.getAdmin().equals(TipoUsuario.Admin); 
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCurrentUser(Usuario currentUser) {
		this.currentUser = currentUser;
	}
	/*
	public List<Musica> getMusicasFavoritas() {
		musicasFavoritas = new ArrayList<Musica>() ;
		for (Musica musica : currentUser.getMusicasFavoritadas()) {
			musicasFavoritas.add(musica);
		}
		return musicasFavoritas ;
	}
	*/
	/*
	public List<Artista> getArtistasFavoritos() {
		artistasFavoritos = new ArrayList<Artista>() ;
		for (Artista artista : currentUser.getArtistasFavoritados()) {
			artistasFavoritos.add(artista);
		}
		return artistasFavoritos ;
	}
	*/
	
	public String desfavoritarMusica() {
		//musicasFavoritas.remove(musicaEscolhida);
		currentUser.getMusicasFavoritadas().remove(musicaEscolhida);
		usuarioService.atualizar(currentUser);
		currentUser = getCurrentUser() ;
		musicaEscolhida.decrementaNumVezesFavorito();
		musicaService.save(musicaEscolhida);
		musicaEscolhida = null ;
		return "/core/usuario/MyHome.xhtml?faces-redirect=true" ;
	}
	
	public String desfavoritarArtista() {
		//implementar
		return "/core/usuario/MyHome.xhtml";
	}
	
	public Musica getMusicaEscolhida() {
		return musicaEscolhida;
	}

	public void setMusicaEscolhida(Musica musicaEscolhida) {
		this.musicaEscolhida = musicaEscolhida;
	}
	
	public Boolean desabilitarBotaoMusica() {
		return musicaEscolhida == null ;
	}
	
	public Boolean desabilitarBotaoArtista() {
		return artistaEscolhido == null ;
	}

	public Artista getArtistaEscolhido() {
		return artistaEscolhido;
	}

	public void setArtistaEscolhido(Artista artistaEscolhido) {
		this.artistaEscolhido = artistaEscolhido;
	}

	public Set<Musica> getMusicas() {
		currentUser = getCurrentUser() ;
		return currentUser.getMusicasFavoritadas();
	}

	public void setMusicas(Set<Musica> musicas) {
		this.musicas = musicas;
	}
	
	
}
