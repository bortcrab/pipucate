package negocio;

import entidad.dtos.ClienteTablaDTO;
import entidades.ClienteEntidad;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.IClienteDAO;
import persistencia.PersistenciaException;
import utilerias.Utilidades;

public class ClienteNegocio implements IClienteNegocio {

    private IClienteDAO clienteDAO;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public List<ClienteTablaDTO> buscarClientesTabla(int limit, int pagina, String filtro) throws NegocioException {
        try {
            if (this.esNumeroNegativo(limit)) {
                throw new NegocioException("El parametro limite no puede ser negativo");
            }
            if (this.esNumeroNegativo(pagina)) {
                throw new NegocioException("El parametro pagina no puede ser negativo");
            }
            
            int offset = this.obtenerOFFSETMySQL(limit, pagina);
            List<ClienteTablaDTO> clientesLista = this.clienteDAO.buscarClientesTabla(limit, offset, filtro);
            if (clientesLista == null && pagina != 1) {
                throw new NegocioException("No existen clientes registrados");
            }

            return clientesLista;
        } catch (PersistenciaException pe) {
            // hacer uso de Logger
            System.out.println(pe.getMessage());
            throw new NegocioException(pe.getMessage());
        }
    }
    
    @Override
    public ClienteEntidad buscarPorIdCliente(int id) throws NegocioException {
        try {
            if (id < 1) {
                throw new NegocioException("El ID no es válido.");
            }
            
            ClienteEntidad clienteEntidad = this.clienteDAO.buscarPorIdCliente(id);
            if (clienteEntidad == null) {
                throw new NegocioException("No se encontró el cliente con esa ID.");
            }
            
            return clienteEntidad;
        } catch (PersistenciaException pe) {
            System.out.println(pe.getMessage());
            throw new NegocioException(pe.getMessage());
        }
    }
    
    @Override
    public void guardar(ClienteEntidad clienteEntidad) throws NegocioException {
        try {
            this.clienteDAO.guardar(clienteEntidad);
        } catch (PersistenciaException pe) {
            System.out.println(pe.getMessage());
            throw new NegocioException(pe.getMessage());
        }
    }
    
    @Override
    public void editar(ClienteEntidad clienteEntidad) throws NegocioException {
        try {
            this.clienteDAO.editar(clienteEntidad);
        } catch (PersistenciaException pe) {
            System.out.println(pe.getMessage());
            throw new NegocioException(pe.getMessage());
        }
    }
    
    @Override
    public void eliminar(ClienteEntidad clienteEntidad) throws NegocioException {
        try {
            this.clienteDAO.eliminar(clienteEntidad);
        } catch (PersistenciaException pe) {
            System.out.println(pe.getMessage());
            throw new NegocioException(pe.getMessage());
        }
    }
    
    private boolean esNumeroNegativo(int numero) {
        return numero < 1;
    }

    private int obtenerOFFSETMySQL(int limit, int pagina) {
        return new Utilidades().RegresarOFFSETMySQL(limit, pagina);
    }
}
