/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class ConexionBD implements IConexionBD {
    final String SERVER = "localhost";
    final String BASE_DATOS = "crud";
    private final String URL = "jdbc:mysql://" + SERVER + "/" + BASE_DATOS;
    final String USUARIO = "root";
    final String CONTRASENIA = "root";
    private Logger logger = Logger.getLogger(ConexionBD.class.getName());
    
    @Override
    public Connection crearConexion() throws PersistenciaException {
        try {
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
        logger.log(Level.INFO, "Conexión exitosa");
        return conexion;
        } catch (SQLException sqle) {
            logger.log(Level.SEVERE, "Error al conectar con la base de datos.", sqle);
            throw new PersistenciaException("Ocurrió un error al conectar con la base de datos. Revise que las credenciales sean las correctas.");
        }
    }
}
