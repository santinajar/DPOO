package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class restaurante {
	public void iniciarPedido(String nombreCliente, String direccionCliente) {

		System.out.println(
				"Iniciando un nuevo pedido para el cliente " + nombreCliente + " con dirección " + direccionCliente);

		Pedido pedidito = new Pedido(1, 1, nombreCliente, direccionCliente);
		opciones(pedidito);
	}

	public void opciones(Pedido pedidito) {

		String centinela = "";

		while (!centinela.equals("salir")) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"¿Quieres ver los combos, el menú o los ingredientes (escriba 1 para combos, 2 para menu)");
			String opcion = scanner.nextLine();

			if (opcion.equals("1")) {
				Scanner sca = new Scanner(System.in);
				cargarCombos();
				cargarmenu();
				System.out.println("Digite el numero de la opcion deseada: ");
				imprimircombos();
				String combito = sca.nextLine();
				String nombrecombo = codigocombo.get(Integer.valueOf(combito));
				ArrayList<String> listica = combos.get(nombrecombo);
				String descuentoString = listica.get(0).replace("%", "");
				double descuento = Double.valueOf(descuentoString) / 100;
				Combo combousuario = new Combo(descuento, nombrecombo, listica.get(1), listica.get(2), listica.get(3),
						menu);
				double precio = combousuario.getPrecio();
				pedidito.Agregarproducto(nombrecombo, precio);

			} else if (opcion.equals("2")) {
				Scanner sca = new Scanner(System.in);
				cargarmenu();
				System.out.println("Digite el numero de la opcion deseada: ");
				imprimirmenu();
				String elemento = sca.nextLine();
				String nombrelemento = codigomenu.get(Integer.valueOf(elemento));
				Integer precioelemento = menu.get(nombrelemento);
				cargaringredientes();
				ProductoMenu produc = new ProductoMenu(nombrelemento, precioelemento, ingredientes);
				double precio = produc.getPrecio();
				String ingre = produc.ajustarpedido();
				if (ingre.equals("")) {
					pedidito.Agregarproducto(nombrelemento, precio);
				} else {
					pedidito.Agregarproducto(nombrelemento, precio);
					pedidito.Agregarproducto(ingre, ingredientes.get(ingre));
				}
			}
			System.out.println("Desea seguir ordenando? Oprima 1 si sí o 2 de lo contrario");
			Scanner s = new Scanner(System.in);
			String numero = s.nextLine();
			if (numero.equals("2")) {
				centinela="salir";
			}
			
		}
		pedidito.guardarFactura();
	}

	public HashMap<String, ArrayList<String>> combos = new HashMap<>();
	public HashMap<String, Integer> menu = new HashMap<>();
	private HashMap<Integer, String> codigomenu = new HashMap<>();
	private HashMap<Integer, String> codigocombo = new HashMap<>();
	public HashMap<String, Integer> ingredientes = new HashMap<>();

	private void cargarCombos() {
		File archivo = new File("data/combos.txt");

		try (Scanner scanner = new Scanner(archivo)) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				String Nombrecombo = partes[0];
				ArrayList<String> datosCombo = new ArrayList<>();
				datosCombo.add(partes[1]);
				datosCombo.add(partes[2]);
				datosCombo.add(partes[3]);
				datosCombo.add(partes[4]);
				combos.put(Nombrecombo, datosCombo);
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");

		}
	}

	private void imprimircombos() {
		int i = 0;
		for (Map.Entry<String, ArrayList<String>> entrada : combos.entrySet()) {
			String nombre = entrada.getKey();
			i = i + 1;
			codigocombo.put(i, nombre);
			System.out.println(String.valueOf(i) + ": " + nombre);

		}
	}

	private void cargarmenu() {
		File archivo = new File("data/menu.txt");

		try (Scanner scanner = new Scanner(archivo)) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				menu.put(partes[0], Integer.valueOf(partes[1]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");

		}

	}

	private void imprimirmenu() {
		int i = 0;
		for (Map.Entry<String, Integer> entrada : menu.entrySet()) {
			String nombre = entrada.getKey();
			i = i + 1;
			codigomenu.put(i, nombre);
			System.out.println(String.valueOf(i) + ": " + nombre);
		}
	}

	private void cargaringredientes() {
		File archivo = new File("data/ingredientes.txt");

		try (Scanner scanner = new Scanner(archivo)) {
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] partes = linea.split(";");
				ingredientes.put(partes[0], Integer.valueOf(partes[1]));
			}
		} catch (FileNotFoundException e) {
			System.out.println("El archivo no existe");

		}
	}
}
