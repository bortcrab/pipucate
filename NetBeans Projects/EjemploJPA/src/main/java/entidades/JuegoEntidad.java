/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author bortc
 */
@Entity
@Table(name = "tblJuegos")
public class JuegoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idJuego")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "desarrolladora", nullable = false)
    private String desarrolladora;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "lanzamiento", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar lanzamiento;
    
    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
    private List<LogroEntidad> listaLogros;
    
    @ManyToMany(mappedBy = "juegos")
    private Set<JugadorEntidad> jugadores;
    
    public JuegoEntidad() {
    }

    public JuegoEntidad(String desarrolladora, String nombre, Calendar lanzamiento, List<LogroEntidad> listaLogros) {
        this.desarrolladora = desarrolladora;
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.listaLogros = listaLogros;
        for (LogroEntidad logro : listaLogros) {
            logro.setJuego(this);
        }
    }
    
    public JuegoEntidad(String desarrolladora, String nombre, Calendar lanzamiento, List<LogroEntidad> listaLogros, Set<JugadorEntidad> jugadores) {
        this.desarrolladora = desarrolladora;
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.listaLogros = listaLogros;
        for (LogroEntidad logro : listaLogros) {
            logro.setJuego(this);
        }
        this.jugadores = jugadores;
        for (JugadorEntidad jugador : jugadores) {
            jugador.getJuegos().add(this);
        }
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

    public Calendar getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Calendar lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
    
    public List<LogroEntidad> getListaLogros() {
        return listaLogros;
    }

    public void setListaLogros(List<LogroEntidad> listaLogros) {
        this.listaLogros = listaLogros;
    }

    public Set<JugadorEntidad> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<JugadorEntidad> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JuegoEntidad other = (JuegoEntidad) obj;
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {
        return "entidades.JuegoEntidad[ id=" + id + " ]";
    }
    
}
