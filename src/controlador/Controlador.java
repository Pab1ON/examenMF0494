/**
 * 
 */
package controlador;

import java.util.ArrayList;

import dao.InfractoresDAO;
import dao.SancionDAO;
import modelo.Infractor;
import modelo.Sancion;
import vista.DialogoInsertarInfractor;
import vista.VentanaMostrarInfractores;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// VEntanas del sistema
	private VentanaPpal ventanaPpal;
	private DialogoInsertarInfractor dialogoInsertarInfractor;
	// TODO ventana definida
	private VentanaMostrarInfractores ventanaMostrarInfractores;

	
	// Objetos DAO o CRUD de la base de datos
	private SancionDAO sancionDAO;
	//TODO infractor definido
	private InfractoresDAO infractoresDAO;

	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		dialogoInsertarInfractor = new DialogoInsertarInfractor();
		// TODO ventana instanciada
		ventanaMostrarInfractores = new VentanaMostrarInfractores();
		
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoInsertarInfractor.setControlador(this);
		// TODO controlador enlazado 0.5/0.5
		ventanaMostrarInfractores.setControlador(this);
		
		
		// Creamos los objetos DAO
		sancionDAO = new SancionDAO();
		//TODO DAO instanciado
		infractoresDAO = new InfractoresDAO();
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}

	public void mostrarInsertarInfractores () {
		ArrayList<Sancion> listaSanciones = new ArrayList<Sancion>();
		listaSanciones = sancionDAO.obtenerSanciones();
		dialogoInsertarInfractor.setListaSanciones(listaSanciones);
		dialogoInsertarInfractor.setVisible(true);
	}
	
	// TODO método correcto 
	public void mostrarInfractores () {
		ArrayList<Infractor> listaInfractores = new ArrayList<Infractor>();
		listaInfractores = infractoresDAO.obtenerInfractores();
		ventanaMostrarInfractores.setListaInfractores(listaInfractores);
		ventanaMostrarInfractores.setVisible(true);
	}
	
	
}
