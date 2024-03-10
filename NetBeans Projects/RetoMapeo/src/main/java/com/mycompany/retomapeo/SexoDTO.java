/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.retomapeo;

/**
 *
 * @author bortc
 */
class SexoDTO {
    private String sexo;
    private Long cantidad;
    
    public SexoDTO() {
    
    }
    
    public SexoDTO(String sexo, Long cantidad) {
        this.sexo = sexo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Sexo " + this.sexo + ": " + this.cantidad;
    }
    
}
