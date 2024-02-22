/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author bortc
 */
@Entity
@Table (name = "tblJuegos")
public class JuegoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column (name = "idJuego")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column (name = "desarrolladora", nullable = false)
    private String desarrolladora;
    
    @Column (name = "nombre", nullable = false)
    private String nombre;
    
    @OneToMany (mappedBy = "juego", cascade = CascadeType.PERSIST)
    private List<LogroEntidad> listaLogros;

    public JuegoEntidad() {
    }

    public JuegoEntidad(String desarrolladora, String nombre) {
        this.desarrolladora = desarrolladora;
        this.nombre = nombre;
    }

    public JuegoEntidad(String desarrolladora, String nombre, List<LogroEntidad> listaLogros) {
        this.desarrolladora = desarrolladora;
        this.nombre = nombre;
        this.listaLogros = listaLogros;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LogroEntidad> getListaLogros() {
        return listaLogros;
    }

    public void setListaLogros(List<LogroEntidad> listaLogros) {
        this.listaLogros = listaLogros;
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
        if (!(object instanceof JuegoEntidad)) {
            return false;
        }
        JuegoEntidad other = (JuegoEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.JuegoEntidad[ id=" + id + " ]";
    }
    
}
