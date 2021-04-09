package br.ufes.informatica.musicplus.core.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.musicplus.core.application.ArtistaService;
import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.TipoGenero;
import br.ufes.informatica.musicplus.core.domain.TipoPais;

@Model
@SessionScoped
public class CadastroArtistaController extends JSFController {

	private static final long serialVersionUID = 1L;

	@EJB
	private ArtistaService artistaService;
	
	private String nomeArtista ;
	
	private TipoPais nacionalidade;
	
	private TipoPais[] todosOsPaises;
	
	private TipoGenero[] generosEscolhidos;

	private TipoGenero[] todosOsGeneros ;
	
	private int numVezesFavoritado;
	
	@PostConstruct
	public void init() {
		todosOsGeneros = TipoGenero.todos();
		todosOsPaises = TipoPais.todos();
		numVezesFavoritado = 0;
	}
	
	public TipoPais[] getTodosOsPaises() {
		return todosOsPaises;
	}

	public TipoGenero[] getTodosOsGeneros() {
		return todosOsGeneros;
	}

	public int getNumVezesFavoritado() {
		return numVezesFavoritado;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public void setNacionalidade(TipoPais nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public TipoPais getNacionalidade() {
		return nacionalidade;
	}

	public TipoGenero[] getGenerosEscolhidos() {
		return generosEscolhidos;
	}

	public void setNumVezesFavoritado(int numVezesFavoritado) {
		this.numVezesFavoritado = numVezesFavoritado;
	}

	public void setGenerosEscolhidos(TipoGenero[] generosEscolhidos) {
		this.generosEscolhidos = generosEscolhidos;
	}

	public String salvarArtista() {
    	Artista artista = new Artista();
    	for (TipoGenero g : generosEscolhidos) {
    		artista.addGenero(g);
    	}
    	artista.setNacionalidade(nacionalidade);
    	artista.setNome(nomeArtista);
    	artista.setNumVezesFavoritado(numVezesFavoritado);
    	artistaService.save(artista);
    	generosEscolhidos = null ;
    	nomeArtista = null ;
    	nacionalidade = null ;
    	return "/index.xhtml?faces-redirect=true" ;
    }
	
}
