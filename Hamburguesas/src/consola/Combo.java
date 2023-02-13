package consola;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Combo {
	private double descuento;
	private String nombreCombo;
	private String hamburguesa;
	private String papas;
	private String bebida;
	private HashMap<String,Integer> menu;

	public Combo(double descuento, String nombreCombo,String hamburguesa, String papas, String bebida,HashMap<String,Integer> menu) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.hamburguesa = hamburguesa;
		this.papas=papas;
		this.bebida=bebida;
		this.menu=menu;
		
	}

	public double getPrecio(){
		double precio=0;
		precio = ((Integer) menu.get(hamburguesa)).intValue() + ((Integer) menu.get(papas)).intValue() + ((Integer) menu.get(bebida)).intValue();
		precio=precio*(1-descuento);
		return precio;
	}

}
