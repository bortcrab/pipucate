package entidades;

import entidades.AstronautaEntidad;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-03-06T18:32:41", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(MuerteEntidad.class)
public class MuerteEntidad_ { 

    public static volatile SingularAttribute<MuerteEntidad, Calendar> fechaHora;
    public static volatile SingularAttribute<MuerteEntidad, AstronautaEntidad> astronauta;
    public static volatile SingularAttribute<MuerteEntidad, Long> id;

}