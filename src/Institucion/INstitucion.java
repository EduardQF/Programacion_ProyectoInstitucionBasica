
package Institucion;

import alumnos.Evaluacion;
import alumnos.Asistencia;
import alumnos.Anotacione;
import java.util.ArrayList;

/**
 * @version 0.0.0,16/04/2017
 * @author Eduard QF
 */
public class INstitucion {
    /**
     * atributo que almacenara el nombre del Instituto.
     */
    private String nombre;
    
    /**
     * atributo que almacenara el arreglo de cursos.
     */
    private ArrayList<Curso> cursos;

    /**
     * constructor de la clase INstitucion
     * @param nombre indica el nombre de la Institucion.
     * @param cursos entrega los cursos que perteneceran a la Institucion
     */
    public INstitucion(String nombre, ArrayList<Curso> cursos) {
        this.nombre = nombre;
        this.cursos = cursos;
    }

    /**
     * @return el nombre de la institucion.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return  el arreglo de Cursos 
     */
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
    
    /**
     * @param cur indica el curso al que pertenece el alumno a recivir la anotacion.
     * @param alum indica al alumno al que pertenecera la anotacion.
     * @param tipo indica el tipo de anotacion que sera, true para Positiva y false para Negativa.
     * @param pro indica el profesor que ingreso la anotacion.
     * @param detalle entrega el detalle de la anotacion.
     */
    public void newAnotacion(int cur,int alum,boolean tipo,Profesor pro, String detalle){
        Anotacione an=new Anotacione(tipo, detalle, pro);
        cursos.get(cur).newAnotacion(alum,an);
    }
    
    /**
     * metodo que añade un objeto  Evaluacion al alumno.
     * @param cur indica el curso al que pertenece el alumno.
     * @param alum indica al alumno que pertenecera la evaluacion.
     * @param mat indica la materia a la que pertense.
     * @param nota indica el porcentaje de aprobacion de la  evaluacion en una escala del 1.0 al 7.0 
     * @param nEv indica a que tipo de evaluacion  pertenece la nota.
     */
    public void newEvaluacion(int cur,int alum, String mat,float nota,String nEv){
        Evaluacion ev=new Evaluacion( mat, nota, nEv);
        cursos.get(cur).newEvaluacion(alum,ev);
    
    }
    
    /**
     * metodo que añade un objeto Asistencia a un alumno.
     * @param cur indica cual es al curso que pertenecera el alumno de la nueva asistencia.
     * @param alum indica el alumno al cual pertenece la nueva indicacion de asistencia.
     * @param asis indica la asistencia que sera registrada con true con Presente y false para Ausente.
     * @param time indica la fecha de la nueva asistencia.
     */
    public void newAsistencia(int cur,int alum,boolean asis,String time){
        Asistencia as=new Asistencia(asis, time);
        cursos.get(cur).newAsistencia(alum,as);
    }
    
    /**
     * metodo que añade una planificacion a la institucion de forma mas dircta para ser llamdado por otro objeto.
     * @param cur indica el curso al cual pertenecera la nueva planificacion.
     * @param asign indica a cual es la asignatura a la que pertenecera la nueva planificacion.
     * @param plan objeto de tipo Planifcacion que sera añadido al arreglo de planoficaciones actuales.
     */
    public void newPlanificacion(int cur,int asign,Planificacion plan){
        cursos.get(cur).getAsignatura().get(asign).addPlanificacion(plan);
    }
    
}
