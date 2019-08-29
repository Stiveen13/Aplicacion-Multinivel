package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Conocimientos;
import modelo.GruposTrabajo;
import modelo.IngenierosJefe;
import modelo.IngenierosJunior;
import modelo.IngenierosSenior;
import modelo.SeminariosAsistidos;
import modelo.TitulosAcademicos;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2019-08-25T10:52:42")
@StaticMetamodel(Ingenieros.class)
public class Ingenieros_ { 

    public static volatile SingularAttribute<Ingenieros, String> apellidos;
    public static volatile ListAttribute<Ingenieros, GruposTrabajo> gruposTrabajoList;
    public static volatile SingularAttribute<Ingenieros, Date> fechaNacimiento;
    public static volatile SingularAttribute<Ingenieros, Integer> cedula;
    public static volatile SingularAttribute<Ingenieros, String> direccion;
    public static volatile ListAttribute<Ingenieros, SeminariosAsistidos> seminariosAsistidosList;
    public static volatile ListAttribute<Ingenieros, TitulosAcademicos> titulosAcademicosList;
    public static volatile SingularAttribute<Ingenieros, Integer> edad;
    public static volatile ListAttribute<Ingenieros, IngenierosJunior> ingenierosJuniorList;
    public static volatile SingularAttribute<Ingenieros, String> nombres;
    public static volatile SingularAttribute<Ingenieros, String> telefonoFijo;
    public static volatile SingularAttribute<Ingenieros, Integer> clase;
    public static volatile SingularAttribute<Ingenieros, Date> fechaIngreso;
    public static volatile ListAttribute<Ingenieros, IngenierosSenior> ingenierosSeniorList;
    public static volatile ListAttribute<Ingenieros, IngenierosJefe> ingenierosJefeList;
    public static volatile SingularAttribute<Ingenieros, String> telefonoMovil;
    public static volatile SingularAttribute<Ingenieros, Character> sexo;
    public static volatile SingularAttribute<Ingenieros, String> email;
    public static volatile ListAttribute<Ingenieros, Conocimientos> conocimientosList;

}