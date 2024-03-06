/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.retomapeo;

import entidades.AstronautaEntidad;

/**
 *
 * @author bortc
 */
public class AstronautaDTO {
    private String nombre;
    private int edad;
    private String sexo;

    public AstronautaDTO(AstronautaEntidad astro) {
        this.nombre = astro.getNombres() + " " + astro.getApellidoPaterno() + " " + astro.getApellidoMaterno();
        this.edad = astro.getEdad();
        this.sexo = astro.getSexo();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", edad: " + edad + " años, sexo: " + sexo;
    }
}
