package persistencia;

import java.sql.Connection;

/**
 *
 * @author Diego Valenzuela Parra
 */
public interface IConexionBD {
    public Connection crearConexion() throws PersistenciaException;
}
