/**
 * 
 */
package uf2178;

import java.util.Scanner;

/**
 * @author 
 *
 */
public class Ppal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Escribe aqu� las sentencias del apartado 3
		Scanner teclado = new Scanner(System.in);
		// TODO perfectamente pedido por teclado con control de errores 0.25/0.25
		System.out.println("Introduce la tasa de alcoholemia del conductor:");
		double tasa=teclado.nextDouble();
		while (tasa<0) {
			System.out.println("La tasa no puede ser negativa, vuelve a introducirla:");
			tasa=teclado.nextDouble();
		}
		
		// TODO llamada a la función correcta 0.25/0.25
		Funciones.calculaSancion(tasa);
				
		// TODO vectores pedidos correctamente 0.5/0.5
		int puntos[]=new int[6];
		System.out.println();
		System.out.println("Introduce los puntos de los conductores:");
		Funciones.pedir_vector(puntos);
		System.out.println();
		System.out.println("Ahora introduce las sanciones aplicadas a dichos conductores:");
		int sanciones[]=new int[6];
		Funciones.pedir_vector(sanciones);
		
		// TODO invocación correcta 0.25/0.25
		Funciones.restaPuntos(puntos, sanciones);
		
		System.out.println();
		// TODO puntos mostrados correctamente 0.25/0.25
		System.out.println("Estos son los puntos restantes de la lista de conductores: ");
		Funciones.mostrar_vector(puntos);
		
		teclado.close();
	}

}
