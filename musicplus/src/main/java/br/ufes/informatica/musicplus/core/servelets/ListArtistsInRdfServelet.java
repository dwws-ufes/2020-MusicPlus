package br.ufes.informatica.musicplus.core.servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

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
import br.ufes.informatica.musicplus.core.persistence.ArtistaDAO;

@WebServlet(urlPatterns = {"/data/artists"})
public class ListArtistsInRdfServelet extends HttpServlet {
	
	@EJB
	private ArtistaDAO artistaDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/xml");
		
		List<Artista> artistas = artistaDAO.retrieveAll();
		
		Model model = ModelFactory.createDefaultModel();
		
		// Namespaces
		String myNS = "http://localhost:8080/musicplus/data/Artista/";
		//String grNS = "http://purl.org/goodrelations/v1#";
		String foafNS = "http://xmlns.com/foaf/0.1/";
		String moNS = "http://purl.org/ontology/mo/";
		model.setNsPrefix("mo", moNS );
		
		// Classes do vocabulário
		Resource moArtist = ResourceFactory.createResource(moNS + "MusicArtist");
		
		// Propriedades(predicados) do vocabulário
		Property moDiscography = ResourceFactory.createProperty(moNS + "discography");
		Property moOrigin = ResourceFactory.createProperty(moNS + "origin");
		
		// Produzir o modelo em memória
		for(Artista artista: artistas) {
			model.createResource(myNS + artista.getId())
			.addProperty(RDF.type, moArtist)
			.addProperty(RDFS.label, artista.getNome())
			//.addProperty(moDiscography, artista.getColecoes().toString())
			.addProperty(moOrigin, artista.getNacionalidade().toString());
//			.addProperty(grHasPriceSpecification, model.createResource()
//					.addProperty(RDF.type, grHasPriceSpecification)
//					.addProperty(grhasCurrencyValue, pack.getPrice())
//					);	
		}
		
		// Serializa e envia para o navegador
		try(PrintWriter out = resp.getWriter()){
			model.write(out, "RDF/XML");
		}
	}
}