package actividad2a;

public class Principal {

	public static void main(String[] args) {
		Parser parser=new Parser();
		parser.xmlADocument("biblioteca.xml");
		parser.parsearDocumento();
		parser.mostrarLibros();
	}

}
