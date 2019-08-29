package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ingenieros;
import modelo.SeminariosCursos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(SeminariosAsistidos.class)
public class SeminariosAsistidos_ { 

    public static volatile SingularAttribute<SeminariosAsistidos, Ingenieros> ingenierosCedula;
    public static volatile SingularAttribute<SeminariosAsistidos, Integer> id;
    public static volatile SingularAttribute<SeminariosAsistidos, SeminariosCursos> seminariosCursosId;

}