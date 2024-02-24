/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "tblJugadores")
public class JugadorEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idJugador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pseudonimo", nullable = false)
    private String pseudonimo;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    
    @Column (name = "fechaNacimiento", nullable = false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDireccion", referencedColumnName = "idDireccion")
    private DireccionEntidad direccion;
    
    @ManyToMany
    @JoinTable(
            name = "tblJugadores_Juegos",
            joinColumns = @JoinColumn(name = "idJugador"),
            inverseJoinColumns = @JoinColumn(name = "idJuego"))
    Set<JuegoEntidad> juegos;

    public JugadorEntidad(String pseudonimo, Sexo sexo, Calendar fechaNacimiento, DireccionEntidad direccion, Set<JuegoEntidad> juegos) {
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        direccion.setJugador(this);
        this.juegos = juegos;
        for (JuegoEntidad juego : juegos) {
            juego.getJugadores().add(this);
        }
    }
    
    public JugadorEntidad(String pseudonimo, Sexo sexo, Calendar fechaNacimiento, DireccionEntidad direccion) {
        this.pseudonimo = pseudonimo;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        direccion.setJugador(this);
    }
    
    public JugadorEntidad() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public DireccionEntidad getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionEntidad direccion) {
        this.direccion = direccion;
    }

    public Set<JuegoEntidad> getJuegos() {
        return juegos;
    }

    public void setJuegos(Set<JuegoEntidad> juegos) {
        this.juegos = juegos;
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
        if (!(object instanceof JugadorEntidad)) {
            return false;
        }
        JugadorEntidad other = (JugadorEntidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.JugadorEntidad[ id=" + id + " ]";
    }

}
