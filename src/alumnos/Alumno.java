
package alumnos;

import java.util.ArrayList;

/**
 * 
 * @version 0.1.2
 * @author Eduard QF
 */
public class Alumno extends Persona{

    private ArrayList<Evaluacion> notasEvaluaciones;
    private ArrayList<Asistencia> asistencia;
    private ArrayList<Anotacione> anotaciones;
    private Apoderado apoderado;

    /**
     * constructor de la clase Alumno.
     * 
     * @param apoderado indica el apoderado del alumno.
     * @param nombre nombre del Alumno.
     * @param rut del alumno.
     */
    public Alumno(String nombre, String rut, Apoderado apoderado) {
        super(nombre, rut);
        notasEvaluaciones = new ArrayList<>();
        asistencia = new ArrayList<>();
        anotaciones = new ArrayList<>();
        this.apoderado=apoderado;
    }

    /**
    * @return nombre dol Alumno. 
    */
    public String getNombre() {
        return nombre;
    }


    /**
    * @return el rut del Alumno
    */
    public String getRut() {
        return rut;
    }
   

    /**
    * @return un arreglo con las notas del Alumno
    */
    public ArrayList<Evaluacion> getNotasEvaluaciones() {
        return notasEvaluaciones;
    }

    /**
     * agraga la nota de una evaluacion.
     * @param newNota nueva nota a ser agregad  la lista
     */
    public void addNotasEvaluaciones(Evaluacion newNota) {
        notasEvaluaciones.add(newNota);
    }

    /**
    * @return la asistencia del alumno
    */
    public ArrayList<Asistencia> getAsistencia() {
        return asistencia;
    }

    /**
     * añade la asistencia al alumno. 
     * @param  newAsistencia asistenciadel dia
    */
    public void addAsistencia(Asistencia newAsistencia) {
       asistencia.add(newAsistencia);
    }

    /**
    * @return un arreglo con las anotaciones del alumno
    */
    public ArrayList<Anotacione> getAnotaciones() {
        return anotaciones;
    }

    /**
     * metodo que añade una anotacion al alumno
     * @param newAnotacion que es la nueva anogtacion del alumno
     */    
    public void addAnotaciones(Anotacione newAnotacion) {
       anotaciones.add(newAnotacion);
    }

    /**
    * @return el objeto del Apoderado asociado al alumno.
    */
    public Apoderado getApoderado() {
        return apoderado;
    }
    
   /**
    * modifica el apoderado asociado al alumno
    * @param  apoderado nuevos datos del apoderado.
    */
    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }
    

}
