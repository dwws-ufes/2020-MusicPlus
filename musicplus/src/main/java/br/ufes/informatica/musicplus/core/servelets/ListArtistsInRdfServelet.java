package br.ufes.informatica.musicplus.core.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import br.ufes.informatica.musicplus.core.domain.Artista;
import br.ufes.informatica.musicplus.core.domain.Musica;
import br.ufes.informatica.musicplus.core.persistence.ArtistaDAO;

@WebServlet(urlPatterns = {"/data/artists"})
public class ListArtistsInRdfServelet extends HttpServlet {
	
	private static final DateFormat df = new SimpleDateFormat("HH:mm:ss");
	
	@EJB
	private ArtistaDAO artistaDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/xml");
		
		List<Artista> artistas = artistaDAO.retrieveAll();
		
		Model model = ModelFactory.createDefaultModel();
		
		// Namespaces
		String myNS = "http://localhost:8080/musicplus/data/artist/";
		String dcNS = "http://purl.org/dc/elements/1.1/";
		String foafNS = "http://xmlns.com/foaf/0.1/";
		String moNS = "http://purl.org/ontology/mo/";
		model.setNsPrefix("mo", moNS );
		
		// Classes do vocabulário
		Resource moArtist = ResourceFactory.createResource(moNS + "MusicArtist");
		//Resource moTrack = ResourceFactory.createResource(moNS + "Track");
		
		// Propriedades(predicados) do vocabulário
		Property moDiscography = ResourceFactory.createProperty(moNS + "discography");
		Property moOrigin = ResourceFactory.createProperty(moNS + "origin");
		Property moLength = ResourceFactory.createProperty(moNS + "length");
		Property moTrack = ResourceFactory.createProperty(moNS + "track");
		Property dcLanguage = ResourceFactory.createProperty(dcNS + "language");

		// Produzir o modelo em memória
		for(Artista artista: artistas) {
			
			Resource artistResource = model.createResource(myNS + artista.getId());
			artistResource.addProperty(RDF.type, moArtist);
			artistResource.addProperty(RDFS.label, artista.getNome());
			artistResource.addProperty(moDiscography, artista.getColecoes().toString());
			artistResource.addProperty(moOrigin, artista.getNacionalidade().toString());
			
			Set<Musica> musicasDoArtista = artista.getMusicas();
			for(Musica musicadoArtista: musicasDoArtista) {
				artistResource.addProperty(moTrack, musicadoArtista.getNome());
//				Resource musicResource = model.createResource(myNS + musicadoArtista.getId());
//				musicResource.addProperty(RDF.type, moTrack);
//				musicResource.addProperty(RDFS.label, musicadoArtista.getNome());
//				musicResource.addProperty(moLength, df.format(musicadoArtista.getDuracao()));
//				musicResource.addProperty(dcLanguage, musicadoArtista.getIdioma().toString());	
//				artistResource.(moTrack, musicResource);
			}
		}
		
		// Serializa e envia para o navegador
		try(PrintWriter out = resp.getWriter()){
			model.write(out, "RDF/XML");
		}
	}
}