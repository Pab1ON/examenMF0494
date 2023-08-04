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
		System.out.println("Introduce la tasa de alcoholemia del conductor:");
		double tasa=teclado.nextDouble();
		while (tasa<0) {
			System.out.println("La tasa no puede ser negativa, vuelve a introducirla:");
			tasa=teclado.nextDouble();
		}
		
		Funciones.calculaSancion(tasa);
				
		int puntos[]=new int[6];
		System.out.println();
		System.out.println("Introduce los puntos de los conductores:");
		Funciones.pedir_vector(puntos);
		System.out.println();
		System.out.println("Ahora introduce las sanciones aplicadas a dichos conductores:");
		int sanciones[]=new int[6];
		Funciones.pedir_vector(sanciones);
		
		Funciones.restaPuntos(puntos, sanciones);
		
		System.out.println();
		System.out.println("Estos son los puntos restantes de la lista de conductores: ");
		Funciones.mostrar_vector(puntos);
		
		teclado.close();
	}

}
