package consola;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pedido {
	private int numeropedido;
	private int idpedido;
	private String Nombrecliente;
	private String DirecCliente;
	
	
	
	public Pedido(int numeropedido, int idpedido,String Nombrecliente, String DirecCliente) {
		this.numeropedido =numeropedido;
		this.idpedido=idpedido;
		this.Nombrecliente=Nombrecliente;
		this.DirecCliente=DirecCliente; 
	}
	
	private HashMap<String, Double> pedido = new HashMap<>();
	
	public void Agregarproducto(String objeto, double precio) {
		pedido.put(objeto, precio);
		
	}
	public void guardarFactura() {
		System.out.println("el valor neto de su pedido es: "+getPrecionNetoPedido(pedido));
		System.out.println("el valor del iva de su pedido es: "+getPrecionIvaPedido(pedido));
		System.out.println("el valor total de su pedido es: "+getPrecionTotalPedido(pedido));
	}
	
	private double getPrecionNetoPedido(HashMap<String, Double> pedido) {
	    double suma = 0.0;
	    for (Map.Entry<String, Double> entrada : pedido.entrySet()) {
	        suma += entrada.getValue();
	    }
	    return (suma-suma*0.19);
	}
	private double getPrecionIvaPedido(HashMap<String, Double> pedido) {
	    double suma = 0.0;
	    for (Map.Entry<String, Double> entrada : pedido.entrySet()) {
	        suma += entrada.getValue();
	    }
	    return (suma*0.19);
	}
	private double getPrecionTotalPedido(HashMap<String, Double> pedido) {
	    double suma = getPrecionNetoPedido(pedido);
	    suma+=getPrecionIvaPedido(pedido);
	    return suma;
	}
	
}
