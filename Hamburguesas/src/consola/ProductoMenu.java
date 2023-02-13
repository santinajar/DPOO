package consola;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;

public class ProductoMenu {
	private String nombre;
	private Integer preciobase;
	private HashMap<String, Integer> ingredientes;
	
	private HashMap<Integer, String> codingre = new HashMap<>();
	
	public ProductoMenu(String nombre, int preciobase, HashMap<String, Integer> ingredientes) {
		this.nombre=nombre;
		this.preciobase=preciobase;
		this.ingredientes=ingredientes;
	}
	
	public double getPrecio() {
		return preciobase;
	}
	
	public String ajustarpedido() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("¿Desea agregar ingredientes extra? (escriba 'si' o 'no')");
		String respuesta = scanner.nextLine();

		if (respuesta.equals("si")) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Escoja su ingredient extra con el numero");
		    imprimiringredientes();
		    String numingrediente = sc.nextLine();
		    String ingre = codingre.get(Integer.valueOf(numingrediente));
		    return ingre;
		   
		}
		else {
			return "";}
	}
	
	private void imprimiringredientes() {
		int i = 0;
		for (Map.Entry<String, Integer> entrada : ingredientes.entrySet()) {
			String nombre = entrada.getKey();
			i = i + 1;
			codingre.put(i, nombre);
			System.out.println(String.valueOf(i) + ": " + nombre);
		}
	}

}
