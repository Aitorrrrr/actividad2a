package actividad2a;

import java.util.ArrayList;

public class Libro {

	private String titulo;
	private int anyo;
	private ArrayList<String> autor;
	private String editor;
	private  int paginas;
	
	public Libro ()
	{
		
	}

	public Libro(String titulo, int anyo, ArrayList<String> autor, String editor, int paginas) 
	{
		super();
		this.titulo = titulo;
		this.anyo = anyo;
		this.autor = autor;
		this.editor = editor;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public ArrayList<String> getAutor() {
		return autor;
	}

	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		String aux;
		
		aux = "Libro\n";
		aux = aux+"Título: "+this.titulo+"\n";
		aux = aux+"Año: "+this.anyo+"\n";
		for (String autorAux: autor)
		{
			aux = aux+"Autor: "+autorAux+"\n";
		}
		aux = aux+"Editor: "+this.editor+"\n";
		aux = aux+"Páginas: "+this.paginas+"\n";
		
		return aux;
	}
}
