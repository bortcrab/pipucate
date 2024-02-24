/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author bortc
 */
@Entity
@Table (name = "tblLogros")
public class LogroEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column (name = "nombre", nullable = false)
    private String nombre;
    
    @Column (name = "puntuacion", nullable = false)
    private String puntuacion;
    
    @ManyToOne
    @JoinColumn (name = "idJuego", nullable = false)
    private JuegoEntidad juego;

    public LogroEntidad(String nombre, String puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public LogroEntidad(String nombre, String puntuacion, JuegoEntidad juego) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.juego = juego;
    }
    
    public LogroEntidad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public JuegoEntidad getJuego() {
        return juego;
    }

    public void setJuego(JuegoEntidad juego) {
        this.juego = juego;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogroEntidad)) {
            return false;
        }
        LogroEntidad other = (LogroEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.LogroEntidad[ id=" + id + " ]";
    }
    
}
