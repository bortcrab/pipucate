/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author bortc
 */
@Entity
public class AstronautaNaveEntidad implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idAstronauta", nullable = false)
    private AstronautaEntidad astronauta;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idNave", nullable = false)
    private NaveEntidad nave;

    public AstronautaNaveEntidad() {
    }

    public AstronautaNaveEntidad(AstronautaEntidad astronauta, NaveEntidad nave) {
        this.astronauta = astronauta;
        astronauta.getListaNaves().add(this);
        this.nave = nave;
        nave.getListaAstronautas().add(this);
    }
    
    public AstronautaEntidad getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(AstronautaEntidad astronauta) {
        this.astronauta = astronauta;
    }

    public NaveEntidad getNave() {
        return nave;
    }

    public void setNave(NaveEntidad nave) {
        this.nave = nave;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof AstronautaNaveEntidad)) {
            return false;
        }
        AstronautaNaveEntidad other = (AstronautaNaveEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AstronautaNaveEntidad[ id=" + id + " ]";
    }
    
}
