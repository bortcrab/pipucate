/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tblDirecciones")
public class DireccionEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idDireccion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "calle", nullable = false)
    private String calle;
    
    @Column(name = "colonia", nullable = false)
    private String colonia;
    
    @Column(name = "numero", nullable = false)
    private String numero;
    
    @OneToOne(mappedBy = "direccion")
    private JugadorEntidad jugador;
    
    public DireccionEntidad() {
    }

    public DireccionEntidad(String calle, String colonia, String numero, JugadorEntidad jugador) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
        this.jugador = jugador;
    }

    public DireccionEntidad(String calle, String colonia, String numero) {
        this.calle = calle;
        this.colonia = colonia;
        this.numero = numero;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public JugadorEntidad getJugador() {
        return jugador;
    }

    public void setJugador(JugadorEntidad jugador) {
        this.jugador = jugador;
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
        if (!(object instanceof DireccionEntidad)) {
            return false;
        }
        DireccionEntidad other = (DireccionEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DireccionEntidad[ id=" + id + " ]";
    }
    
}
