
package Institucion;

import alumnos.Persona;

/**
 * clase dedicada a crear objetos de tipo profesor
 * @version 0.1.0 
 * @author Eduard QF
 */
public class Profesor extends Persona{
    
    /**
     *atributo que almasena la asignatura que imparte 
    */
    private String asignatura;
    /**
    * atributo que almacena el curso del cual es profesor jefe.
    */
    private String jefaturaCurso;

    /**
     * @param nombre nombre a tener el profesor.
     * @param rut rut individual del profesor.
     * @param asignatura asignatura que imparte el profesor.
     * @param jefaturaCurso curso del cual esta a cargo. 
     */
    public Profesor(String nombre, String rut, String asignatura, String jefaturaCurso) {
        super(nombre, rut);
        this.asignatura = asignatura;
        this.jefaturaCurso = jefaturaCurso;
    }

    /**
     * @param nombre nombre a tener el profesor
     * @param rut rut individual del profesor
     * @param asignatura asignatura que imparte el profesor
     */
    public Profesor(String nombre, String rut, String asignatura) {
        super(nombre,rut);
        this.asignatura = asignatura;
    }

    /**
     * @return el nombre del profesor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el rut del profesor
     */
    public String getRut() {
        return rut;
    }

    /**
     * @return la asignatura qu imparte
     */
    public String getAsignatura() {
        return asignatura;
    }

    /**
     * @return el curso del cual es jefe en caso de serlo
     */
    public String getJefaturacurso() {
        return jefaturaCurso;
    }
}
