package entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tblMuertes")
public class MuerteEntidad implements Serializable {

    @Id
    @Column(name = "idMuerte")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHora", nullable = false)
    private Calendar fechaHora;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idAstronauta", referencedColumnName = "idAstronauta")
    private AstronautaEntidad astronauta;
    
    public MuerteEntidad() {
    }

    public MuerteEntidad(Calendar fechaHora, AstronautaEntidad astronauta) {
        this.fechaHora = fechaHora;
        this.astronauta = astronauta;
        astronauta.setMuerte(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Calendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public AstronautaEntidad getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(AstronautaEntidad astronauta) {
        this.astronauta = astronauta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final MuerteEntidad other = (MuerteEntidad) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
