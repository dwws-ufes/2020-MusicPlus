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
import br.ufes.informatica.musicplus.core.persistence.MusicaDAO;

@WebServlet(urlPatterns = {"/data/music"})
public class ListMusicInRdfServelet extends HttpServlet {
	
	private static final DateFormat df = new SimpleDateFormat("HH:mm:ss");
	
	@EJB
	private MusicaDAO musicaDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/xml");
		
		List<Musica> musicas = musicaDao.retrieveAll();
		
		Model model = ModelFactory.createDefaultModel();
		
		// Namespaces
		String myNS = "http://localhost:8080/musicplus/data/music/";
		String dcNS = "http://purl.org/dc/elements/1.1/";
		String foafNS = "http://xmlns.com/foaf/0.1/";
		String soNS = "https://schema.org/";
		model.setNsPrefix("schema", soNS );
		
		// Classes do vocabulário
		Resource soMusic = ResourceFactory.createResource(soNS + "MusicRecording");
		//Resource moTrack = ResourceFactory.createResource(moNS + "Track");
		
		// Propriedades(predicados) do vocabulário
		Property soName = ResourceFactory.createProperty(soNS + "name");
		Property soGenre = ResourceFactory.createProperty(soNS + "genre");
		Property soDatePublished = ResourceFactory.createProperty(soNS + "datePublished");
		Property soDuration = ResourceFactory.createProperty(soNS + "duration");
		Property soInLanguage = ResourceFactory.createProperty(soNS + "inLanguage");
		
		// Produzir o modelo em memória
		for(Musica musica: musicas) {
			
			Resource musicResource = model.createResource(myNS + musica.getId());
			musicResource.addProperty(RDF.type, soMusic);
			musicResource.addProperty(RDFS.label, musica.getNome());
			musicResource.addProperty(soGenre, musica.getGenero().toString());
			musicResource.addProperty(soDatePublished, musica.getDataLancamento().toString());
			musicResource.addProperty(soDuration, musica.getDuracao().toString());
			musicResource.addProperty(soInLanguage, musica.getIdioma().toString());
			
		}
		
		// Serializa e envia para o navegador
		try(PrintWriter out = resp.getWriter()){
			model.write(out, "RDF/XML");
		}
	}
}