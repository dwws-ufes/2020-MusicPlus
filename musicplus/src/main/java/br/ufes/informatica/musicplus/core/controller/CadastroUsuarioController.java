package br.ufes.informatica.musicplus.core.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.musicplus.core.application.UsuarioService;
import br.ufes.informatica.musicplus.core.application.EmailService;
import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.Usuario;

@Model
@SessionScoped
public class CadastroUsuarioController extends JSFController {
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioService usuarioService;
	@EJB
	private EmailService emailService;
	private String nomeUsuario;
	private String username;
	private String email;
	private String senha;
	// artistasFavoritados not here
	private TipoGenero[] generosEscolhidos;
	private TipoGenero[] todosOsGeneros;
	
	@PostConstruct
	public void init() {
		todosOsGeneros = TipoGenero.todos();
		
	}
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}



	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
	}



	public TipoGenero[] getGenerosEscolhidos() {
		return generosEscolhidos;
	}



	public void setGenerosEscolhidos(TipoGenero[] generosEscolhidos) {
		this.generosEscolhidos = generosEscolhidos;
	}



	public TipoGenero[] getTodosOsGeneros() {
		return todosOsGeneros;
	}



	public void setTodosOsGeneros(TipoGenero[] todosOsGeneros) {
		this.todosOsGeneros = todosOsGeneros;
	}

	
	public String salvarUsuario() {
    	Usuario user = new Usuario();
    	user.setNome(nomeUsuario);
    	user.setUsername(username);
    	user.setEmail(email);
    	user.setSenha(senha);// encrypt before saving
    	user.setAdmin(false); // change this later
    	for (TipoGenero g : generosEscolhidos) {
    		user.addGenero(g);
    	}
    	
    	usuarioService.save(user);
    	emailService.enviarEmail("Confirmação de Cadastro", email, "Cadastro Realizado com Sucesso!");
//    	generosEscolhidos = null ; make null
    	
    	return "/index.xhtml?faces-redirect=true" ;
    }
	
	public String redirectCadastrar() {
		return "/core/cadastrar/Usuario.xhtml?faces-redirect=true" ;
	}
	
}
