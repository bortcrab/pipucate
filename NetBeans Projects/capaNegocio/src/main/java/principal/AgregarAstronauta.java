/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import com.mycompany.retomapeo.AstronautaDTO;
import entidades.AstronautaEntidad;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bortc
 */
public class AgregarAstronauta {
    AstronautaDAO astronautaDAO = new AstronautaDAO();
    
    public void agregarAstronauta(AstronautaDTO astronautaDTO) {
        AstronautaEntidad astronautaEntidad = convertirAstronautaDTO(astronautaDTO);
        astronautaDAO.agregar(astronautaEntidad);
    }
    
    public AstronautaEntidad convertirAstronautaDTO(AstronautaDTO astronautaDTO) {
        AstronautaEntidad astronautaEntidad = new AstronautaEntidad(
                astronautaDTO.getNombres(),
                astronautaDTO.getApellidoP(),
                astronautaDTO.getApellidoM(),
                astronautaDTO.getSangre(),
                astronautaDTO.getEdad(),
                astronautaDTO.getSexo(),
                new ArrayList<>());
        return astronautaEntidad;
    }
    
    public void obtenerAstronauta(Long id) throws Exception {
        try {
            AstronautaEntidad astronautaEntidad = astronautaDAO.obtenerPorId(id);
            AstronautaDTO astronautaDTO = convertirAstronautaEntidad(astronautaEntidad);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    public AstronautaDTO convertirAstronautaEntidad(AstronautaEntidad astronautaEntidad) {
        AstronautaDTO astronautaDTO = new AstronautaDTO(
                astronautaEntidad.getNombres(),
                astronautaEntidad.getApellidoPaterno(),
                astronautaEntidad.getApellidoMaterno(),
                astronautaEntidad.getEdad(),
                astronautaEntidad.getSexo(),
                astronautaEntidad.getTipoSangre());
        astronautaDTO.setId(astronautaEntidad.getId());
        return astronautaDTO;
    }
}
