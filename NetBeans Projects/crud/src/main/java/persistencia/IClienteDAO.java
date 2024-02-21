package persistencia;

import entidad.dtos.ClienteTablaDTO;
import entidades.ClienteEntidad;
import java.util.List;

/**
 *
 * @author Diego Valenzuela Parra
 */
public interface IClienteDAO {    
    public List<ClienteTablaDTO> buscarClientesTabla(int limit, int offset, String filtro) throws PersistenciaException;

    public ClienteEntidad buscarPorIdCliente(int id) throws PersistenciaException;

    public ClienteEntidad guardar(ClienteEntidad cliente) throws PersistenciaException;

    public ClienteEntidad editar(ClienteEntidad cliente) throws PersistenciaException;

    public ClienteEntidad eliminar(ClienteEntidad cliente) throws PersistenciaException;
}
