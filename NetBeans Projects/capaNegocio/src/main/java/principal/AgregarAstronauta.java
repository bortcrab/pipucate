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
                astronautaDTO.getSexo()
        );
        return astronautaEntidad;
    }
}
