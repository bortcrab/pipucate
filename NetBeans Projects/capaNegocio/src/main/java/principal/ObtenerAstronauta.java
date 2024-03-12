/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;

import com.mycompany.retomapeo.AstronautaDTO;
import entidades.AstronautaEntidad;

/**
 *
 * @author bortc
 */
public class ObtenerAstronauta {
    AstronautaDAO astronautaDAO = new AstronautaDAO();
    
    public AstronautaDTO obtenerAstronauta(Long id) throws Exception {
        try {
            AstronautaEntidad astronautaEntidad = astronautaDAO.obtenerPorId(id);
            AstronautaDTO astronautaDTO = convertirAstronautaEntidad(astronautaEntidad);
            return astronautaDTO;
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
