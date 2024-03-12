package entidades;

import entidades.AstronautaNaveEntidad;
import entidades.MuerteEntidad;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-12T00:01:49", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(AstronautaEntidad.class)
public class AstronautaEntidad_ { 

    public static volatile SingularAttribute<AstronautaEntidad, String> apellidoPaterno;
    public static volatile SingularAttribute<AstronautaEntidad, String> tipoSangre;
    public static volatile SingularAttribute<AstronautaEntidad, MuerteEntidad> muerte;
    public static volatile ListAttribute<AstronautaEntidad, AstronautaNaveEntidad> listaNaves;
    public static volatile SingularAttribute<AstronautaEntidad, Long> id;
    public static volatile SingularAttribute<AstronautaEntidad, String> sexo;
    public static volatile SingularAttribute<AstronautaEntidad, Integer> edad;
    public static volatile SingularAttribute<AstronautaEntidad, String> nombres;
    public static volatile SingularAttribute<AstronautaEntidad, String> apellidoMaterno;

}