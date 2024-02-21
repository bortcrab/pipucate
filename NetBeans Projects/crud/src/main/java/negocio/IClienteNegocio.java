package negocio;

import entidad.dtos.ClienteTablaDTO;
import entidades.ClienteEntidad;
import java.util.List;

public interface IClienteNegocio {

    public List<ClienteTablaDTO> buscarClientesTabla(int limit, int offset, String filtro) throws NegocioException;
    
    public ClienteEntidad buscarPorIdCliente(int id) throws NegocioException;

    public void guardar(ClienteEntidad clienteEntidad) throws NegocioException;
    
    public void editar(ClienteEntidad clienteEntidad) throws NegocioException;
    
    public void eliminar(ClienteEntidad clienteEntidad) throws NegocioException;
}
