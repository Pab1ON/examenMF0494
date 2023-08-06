package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Infractor;
import modelo.Sancion;

public class InfractoresDAO {
private ConexionBD conexion;
	
    public InfractoresDAO() {
        this.conexion = new ConexionBD();
    }
    
    // TODO Método correcto 0.75
    public ArrayList<Infractor> obtenerInfractores() {
    	Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Infractor> lista = new ArrayList<Infractor>();
		
		try {
			consulta = con.createStatement();
			// TODO consulta correcta
			resultado = consulta.executeQuery("select * from infractores");
			
			while(resultado.next()) {
				// TODO Datos recogidos correctamente 
				String dni=resultado.getString("dni");
				String nombre=resultado.getString("nombre");
				String apellidos=resultado.getString("apellidos");
				int antiguedad=resultado.getInt("antiguedad");
				float sancion=resultado.getFloat("sancion");
				int puntos=resultado.getInt("puntos");
				
				// TODO Objeto instanciado y añadido a la lista
				Infractor i = new Infractor(dni,nombre,apellidos,antiguedad,sancion,puntos);
				lista.add(i);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre infractores: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return lista;
    }
    
    // TODO método correcto 0.75/0.75
    public int insertariInfractor(Infractor i) {
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			// TODO consulta correcta
			consulta = con.prepareStatement("INSERT INTO infractores "
					+ "VALUES(?,?,?,?,?,?)");
			
			// TODO parámetros establecidos correctamente 
			consulta.setString(1, i.getDni());
			consulta.setString(2, i.getNombre());
			consulta.setString(3, i.getApellidos());
			consulta.setInt(4, i.getAntiguedad());
			consulta.setFloat(5, i.getSancion());
			consulta.setInt(6, i.getPuntos());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción de un infractor: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }
}
