package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ingenieros;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(TitulosAcademicos.class)
public class TitulosAcademicos_ { 

    public static volatile SingularAttribute<TitulosAcademicos, Ingenieros> ingenierosCedula;
    public static volatile SingularAttribute<TitulosAcademicos, String> institucion;
    public static volatile SingularAttribute<TitulosAcademicos, Integer> idTitulo;
    public static volatile SingularAttribute<TitulosAcademicos, Date> fechaObtencion;
    public static volatile SingularAttribute<TitulosAcademicos, String> tituloObtenido;

}