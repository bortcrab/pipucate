package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblAstronautas")
public class AstronautaEntidad implements Serializable {

    @Id
    @Column(name = "idAstronauta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 30)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 30)
    private String apellidoMaterno;

    @Column(name = "tipoSangre", nullable = false, length = 30)
    private String tipoSangre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "sexo", nullable = false)
    private String sexo;
    
    @OneToOne(mappedBy = "astronauta")
    private MuerteEntidad muerte;
    
    @OneToMany(mappedBy = "astronauta", cascade = CascadeType.PERSIST)
    private List<AstronautaNaveEntidad> listaNaves;
    
    public AstronautaEntidad() {
    }

    public AstronautaEntidad(String nombres, String apellidoPaterno, String apellidoMaterno, String tipoSangre, Integer edad, String sexo, MuerteEntidad muerte, List<AstronautaNaveEntidad> listaNaves) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoSangre = tipoSangre;
        this.edad = edad;
        this.sexo = sexo;
        this.muerte = muerte;
        this.listaNaves = listaNaves;
    }
    
    public AstronautaEntidad(String nombres, String apellidoPaterno, String apellidoMaterno, String tipoSangre, Integer edad, String sexo, List<AstronautaNaveEntidad> listaNaves) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoSangre = tipoSangre;
        this.edad = edad;
        this.sexo = sexo;
        this.listaNaves = listaNaves;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public MuerteEntidad getMuerte() {
        return muerte;
    }

    public void setMuerte(MuerteEntidad muerte) {
        this.muerte = muerte;
    }

    public List<AstronautaNaveEntidad> getListaNaves() {
        return listaNaves;
    }

    public void setListaNaves(List<AstronautaNaveEntidad> listaNaves) {
        this.listaNaves = listaNaves;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final AstronautaEntidad other = (AstronautaEntidad) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
