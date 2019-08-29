package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.SeminariosAsistidos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(SeminariosCursos.class)
public class SeminariosCursos_ { 

    public static volatile SingularAttribute<SeminariosCursos, Date> fechaInicio;
    public static volatile SingularAttribute<SeminariosCursos, String> lugar;
    public static volatile SingularAttribute<SeminariosCursos, Integer> id;
    public static volatile ListAttribute<SeminariosCursos, SeminariosAsistidos> seminariosAsistidosList;
    public static volatile SingularAttribute<SeminariosCursos, String> nombre;
    public static volatile SingularAttribute<SeminariosCursos, Date> fechaFinalizacion;

}