/**
 * 
 */
package uf2181;

/**
 * @author David
 *
 */
public class FuncionesDGT {
	/**
	 * Método que calcula la media de los puntos de un conductor
	 * @param puntos int[] con todos los puntos almacenados
	 * @return double con la media de los puntps
	 * @throws ArrayIndexOutOfBoundsException cuando se pasa una lista vacía
	 */
	public double mediaPuntos(int puntos[]) {
		double suma = 0;
		
		for (int i = 0; i < puntos.length; i++) {
			suma = suma +puntos[i];
		}
		if (puntos.length==0) throw new ArrayIndexOutOfBoundsException();
		return suma/puntos.length;
	}
	
	/**
	 * Método que devuelve la tasa máxima de alcohol permitida según el tipo de conductor
	 * @param tipoConductor String indicianto el tipo de conductor, que puede ser "General" o "Novel"
	 * @param aire boolean indicando si es la tasa en aire cuando es true, o en sangre cuando es false
	 * @return double con la tasa máxima permitida
	 */
	public double maximaTasaPermitida(String tipoConductor, boolean aire) {
		double tasa=0.25;
		if (tipoConductor.equalsIgnoreCase("General")) {
			if (aire) {
				tasa=0.25;
			} else {
				tasa=0.5;
			}
		} else {
			// profesionales y noveles
			if (aire) {
				tasa=0.15;
			} else {
				tasa=0.3;
			}
		}
		return tasa;
	}

	
}
