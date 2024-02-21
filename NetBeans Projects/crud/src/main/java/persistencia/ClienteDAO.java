package persistencia;

import entidad.dtos.ClienteTablaDTO;
import entidades.ClienteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Valenzuela Parra
 */
public class ClienteDAO implements IClienteDAO {
    public IConexionBD conexionBD;
    private Logger logger = Logger.getLogger(ClienteDAO.class.getName());
    
    public ClienteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<ClienteTablaDTO> buscarClientesTabla(int limit, int offset, String filtro) throws PersistenciaException {
        try {
            List<ClienteTablaDTO> clienteLista = null;
            if (!filtro.equals("")) {
                filtro = "WHERE (nombres LIKE '%"+filtro+"%' OR apellidoPaterno LIKE '%"+filtro+"%' OR apellidoMaterno LIKE '%"+filtro+"%') ";
            }
            try (Connection conexion = this.conexionBD.crearConexion()) {
                String codigoSQL = "SELECT idcliente, nombres, apellidoPaterno, apellidoMaterno, estaEliminado FROM clientes "
                        + filtro + "LIMIT " + limit + " OFFSET " + offset + ";";
                Statement comandoSQL = conexion.createStatement();
                ResultSet resultado = comandoSQL.executeQuery(codigoSQL);
                while (resultado.next()) {
                    if (clienteLista == null) {
                        clienteLista = new ArrayList<>();
                    }
                    ClienteTablaDTO cliente = this.clienteTablaDTO(resultado);
                    clienteLista.add(cliente);
                }
            }
            logger.log(Level.INFO, "Se obtuvo la lista de clientes.");
            return clienteLista;
        } catch (SQLException sqle) {
            // hacer uso de Logger
            logger.log(Level.SEVERE, "Ocurrió un error al obtener los clientes.", sqle);
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    private ClienteTablaDTO clienteTablaDTO(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("idCliente");
        String nombre = resultado.getString("nombres");
        String paterno = resultado.getString("apellidoPaterno");
        String materno = resultado.getString("apellidoMaterno");
        String estatus = resultado.getBoolean("estaEliminado") == true ? "Eliminado" : "No eliminado";
        return new ClienteTablaDTO(id, nombre, paterno, materno, estatus);
    }

    @Override
    public ClienteEntidad buscarPorIdCliente(int id) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            ClienteEntidad clienteEntidad = new ClienteEntidad();
            String codigoSQL = "SELECT idcliente, nombres, apellidoPaterno, apellidoMaterno, estaEliminado FROM clientes WHERE idcliente = " + id + ";";
            Statement comandoSQL = conexion.createStatement();
            ResultSet resultado = comandoSQL.executeQuery(codigoSQL);
            if (resultado.next()) {
                clienteEntidad.setIdCliente(resultado.getInt("idcliente"));
                clienteEntidad.setNombres(resultado.getString("nombres"));
                clienteEntidad.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                clienteEntidad.setApellidoMaterno(resultado.getString("apellidoMaterno"));
                clienteEntidad.setEstaEliminado(resultado.getBoolean("estaEliminado"));
            }
            logger.log(Level.INFO, "Se obtuvieron los datos del cliente: " + clienteEntidad.getIdCliente());
            return clienteEntidad;
        } catch (SQLException sqle) {
            // Hacer uso de Logger
            logger.log(Level.SEVERE, "Ocurrió un error al obtener los datos del cliente.", sqle);
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }
    
    @Override
    public ClienteEntidad guardar(ClienteEntidad cliente) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            try {
                // Desactivar el autocommit
                conexion.setAutoCommit(false);
                // Insertar el cliente
                insertarCliente(cliente, conexion);
                // Confirmar la transacción
                conexion.commit();
                logger.log(Level.INFO, "Se agregó un cliente a la tabla.");
                return cliente;
            } catch (SQLException ex) {
                conexion.rollback();
                // hacer uso de Logger
                logger.log(Level.SEVERE, "Ocurrió un error al insertar el cliente en la tabla.");
                throw new PersistenciaException("Ocurrió un error al agregar el cliente, inténtelo de nuevo, y si el error persiste comuníquese con el encargado del sistema.");
            }
        } catch (SQLException sqle) {
            // hacer uso de Logger
            logger.log(Level.SEVERE, "Ocurrió un error al agregar el cliente.");
            throw new PersistenciaException("Ocurrió un error al agregar el cliente, inténtelo de nuevo, y si el error persiste comuníquese con el encargado del sistema.");
        }
    }
    
    private void insertarCliente(ClienteEntidad cliente, Connection conexion) throws SQLException {
        String insertCliente = "INSERT INTO clientes (nombres, apellidoPaterno, apellidoMaterno) VALUES (?, ?, ?);";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getApellidoPaterno());
            preparedStatement.setString(3, cliente.getApellidoMaterno());
            // Ejecutar la inserción
            preparedStatement.executeUpdate();
            // Obtener las claves generadas
            ResultSet resultado = preparedStatement.getGeneratedKeys();
            while (resultado.next()) {
                cliente.setIdCliente(resultado.getInt(1));
            }
        }
    }

    @Override
    public ClienteEntidad editar(ClienteEntidad cliente) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            try {
                // Desactivar el autocommit
                conexion.setAutoCommit(false);
                // Actualizar el cliente
                actualizarCliente(cliente, conexion);
                // Confirmar la transacción
                conexion.commit();
                logger.log(Level.INFO, "Se editó un cliente exitosamente.");
                return cliente;
            } catch (SQLException ex) {
                conexion.rollback();
                // hacer uso de Logger
                logger.log(Level.SEVERE, "Ocurrió un error al actualizar el cliente.");
                throw new PersistenciaException("Ocurrió un error al editar el cliente, inténtelo de nuevo, y si el error persiste comuníquese con el encargado del sistema.");
            }
        } catch (SQLException sqle) {
            // hacer uso de Logger
            logger.log(Level.SEVERE, "Ocurrió un error al actualizar el cliente.", sqle);
            throw new PersistenciaException("Ocurrió un error al registrar el cliente, inténtelo de nuevo, y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    private void actualizarCliente(ClienteEntidad cliente, Connection conexion) throws SQLException {
        String updateCliente = "UPDATE clientes set nombres = ?, apellidoPaterno = ?, apellidoMaterno = ? WHERE idcliente = " + cliente.getIdCliente();
        try (PreparedStatement preparedStatement = conexion.prepareStatement(updateCliente)) {
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getApellidoPaterno());
            preparedStatement.setString(3, cliente.getApellidoMaterno());
            // Ejecutar la actualización
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public ClienteEntidad eliminar(ClienteEntidad cliente) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            try {
                // Desactivar el autocommit
                conexion.setAutoCommit(false);
                // Actualizar el cliente
                eliminarCliente(cliente, conexion);
                // Confirmar la transacción
                conexion.commit();
                logger.log(Level.INFO, "Se eliminó un cliente de la tabla.");
                return cliente;
            } catch (SQLException ex) {
                conexion.rollback();
                // hacer uso de Logger
                throw new PersistenciaException("Ocurrió un error al eliminar el cliente, inténtelo de nuevo, y si el error persiste comuníquese con el encargado del sistema.");
            }
        } catch (SQLException sqle) {
           // hacer uso de Logger
            throw new PersistenciaException("Ocurrió un error al registrar el cliente, inténtelo de nuevo, y si el error persiste comuníquese con el encargado del sistema.");
        }
    }
    
    private void eliminarCliente(ClienteEntidad cliente, Connection conexion) throws SQLException {
        String updateCliente = "UPDATE clientes set estaEliminado = ? WHERE idcliente = " + cliente.getIdCliente();
        try (PreparedStatement preparedStatement = conexion.prepareStatement(updateCliente)) {
            preparedStatement.setBoolean(1, true);
            // Ejecutar la actualización
            preparedStatement.executeUpdate();
        }
    }
}
