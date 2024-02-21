package crud;

import presentacion.frmCRUD;
import negocio.ClienteNegocio;
import negocio.IClienteNegocio;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.IClienteDAO;
import persistencia.IConexionBD;

/**
 * Clase de ejemplo de un CRUD con MySQL. :D
 * @author Diego Valenzuela Parra
 */
public class Crud {
    public static void main(String[] args) {
        IConexionBD conexionBD = new ConexionBD();
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);

        frmCRUD obj = new frmCRUD(clienteNegocio);
        obj.show();
    }
}
