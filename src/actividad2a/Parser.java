package actividad2a;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

	private Document documento;
	private ArrayList<Libro> libros;
	
	public Parser ()
	{
		this.documento = null;
		this.libros = new ArrayList<Libro>();
	}
	
	public void xmlADocument (String fichero)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder db = dbf.newDocumentBuilder();
			documento = db.parse(fichero);
		} 
		catch (ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		} 
		catch (SAXException se) 
		{
			se.printStackTrace();
		} 
		catch (IOException ioe) 
		{
			ioe.printStackTrace();
		}
	}
	
	public void parsearDocumento ()
	{
		Element eleRaiz = documento.getDocumentElement();
		
		NodeList nodoLibro = eleRaiz.getElementsByTagName("libro");
		
		if (nodoLibro!=null && nodoLibro.getLength()>0)
		{
			for (int i=0; i<nodoLibro.getLength(); i++)
			{
				Element eleLibro = (Element) nodoLibro.item(i);
				
				Libro aux = getLibro(eleLibro);
				
				libros.add(aux);
			}
		}
	}
	
	public Libro getLibro(Element eleLibro)
	{
		String nombre = getTextoUnico(eleLibro, "titulo");
		int anyo = getAtributoInt(eleLibro, "titulo", "anyo");
		ArrayList<String> autor = getTextosIguales(eleLibro, "autor");
		String editor = getTextoUnico(eleLibro, "editor");
		int pagina = getInt(eleLibro, "paginas");
		
		Libro aux = new Libro(nombre, anyo, autor, editor, pagina);
		
		return aux;
	}
	
	public String getTextoUnico(Element eleLibro, String tag)
	{
		String aux = null;
		NodeList nl = eleLibro.getElementsByTagName(tag);
		
		if (nl!=null && nl.getLength()>0)
		{
			Element elemento = (Element) nl.item(0);
			
			aux = elemento.getFirstChild().getNodeValue();
		}
		
		return aux;
	}
	
	public int getInt(Element eleLibro, String tag)
	{
		int aux;
		
		aux = Integer.parseInt(getTextoUnico(eleLibro,tag));
		
		return aux;
	}
	
	public String getAtributo(Element eleLibro, String tag, String atri)
	{
		String aux = null;
		NodeList nl = eleLibro.getElementsByTagName(tag);
		
		if (nl!=null && nl.getLength()>0)
		{
			Element elemento = (Element) nl.item(0);
			aux = elemento.getAttribute(atri);
		}
		
		
		return aux;
	}
	
	public int getAtributoInt(Element eleLibro, String tag, String atri)
	{
		int aux;
		
		aux = Integer.parseInt(getAtributo(eleLibro, tag, atri));
		
		return aux;
	}
	
	public ArrayList<String> getTextosIguales(Element eleLibro, String tag)
	{
		ArrayList<String> aux = new ArrayList<String>();
		NodeList nl = eleLibro.getElementsByTagName(tag);
		
		if (nl!=null && nl.getLength()>0)
		{		
				Element elemento = (Element) nl.item(0);
				NodeList nl2 = elemento.getElementsByTagName("nombre");
				
				if (nl2!=null && nl2.getLength()>0)
				{
					for (int i=0; i<nl2.getLength(); i++)
					{
						Element elemento2 = (Element) nl2.item(i);
						
						aux.add(elemento2.getFirstChild().getNodeValue());
					}
				}
		}
		
		return aux;
	}
	
	public void mostrarLibros()
	{
		for (Libro aux: libros)
		{
			System.out.println(aux.toString());
		}
	}
}
