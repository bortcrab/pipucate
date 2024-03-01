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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tblVuelos")
public class VueloEntidad implements Serializable {

    @Id
    @Column(name = "idVuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroPasajero", nullable = false)
    private Integer numeroPasajero;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHoraSalida", nullable = false)
    private Calendar fechaHoraSalida;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idNave", nullable = false)
    private NaveEntidad nave;

    public VueloEntidad() {
    }

    public VueloEntidad(Integer numeroPasajero, Calendar fechaHoraSalida, NaveEntidad nave) {
        this.numeroPasajero = numeroPasajero;
        this.fechaHoraSalida = fechaHoraSalida;
        this.nave = nave;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroPasajero() {
        return numeroPasajero;
    }

    public void setNumeroPasajero(Integer numeroPasajero) {
        this.numeroPasajero = numeroPasajero;
    }

    public Calendar getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Calendar fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public NaveEntidad getNave() {
        return nave;
    }

    public void setNave(NaveEntidad nave) {
        this.nave = nave;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final VueloEntidad other = (VueloEntidad) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
