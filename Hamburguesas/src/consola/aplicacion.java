
package consola;
import java.util.Scanner;

public class aplicacion {
	  public static void main(String[] args) {
		  	Scanner scanner = new Scanner(System.in);
		    restaurante restaurante = new restaurante();
		    
		    System.out.print("Por favor ingrese su nombre: ");
		    String Nombrecliente = scanner.nextLine();
		    System.out.print("Por favor ingrese su direccion: ");
		    String Dircliente =scanner.nextLine();
		    restaurante.iniciarPedido(Nombrecliente,Dircliente);
		  }
		}