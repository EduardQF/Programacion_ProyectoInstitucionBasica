package Institucion;

import java.util.ArrayList;

/**
 * @version 0.0.0,16/04/2017.
 * @author Eduard QF
 */
public class Asignatura {

    /**
     * atributo que almacena el nombre de la asignatura.
     */
    private String Asign;

    /**
     * atributo que almacena el codigo de la asignatura.
     */
    private int codigoAsign;

    /**
     * atributo que almacena al Profesor que imparte la asignatura.
     */
    private Profesor docente;

    /**
     * atributo que almacena un arreglo de planificaciones a realizarse en la
     * asignatura.
     */
    private ArrayList<Planificacion> planificacion;

    /**
     * constructor de la clase Asignatura.
     *
     * @param Asign entrega el nombre de la asignatura al objeto.
     * @param codigoAsign entrega el codigo de la asignatura al objeto.
     * @param Prof entrega el docente a cargo de la asignatura al objeto.
     * @param planifi entrega la 1ra planificacion de la asignatura al objeto.
     */
    public Asignatura(String Asign, int codigoAsign, Profesor Prof, Planificacion planifi) {
        this.Asign = Asign;
        this.codigoAsign = codigoAsign;
        this.docente = Prof;
        this.planificacion = new ArrayList<>();
        planificacion.add(planifi);
    }

    /**
     * metodo que añade una planificacion a la asignatura.
     *
     * @param planificacion planificacion a ser añadida.
     */
    public void addPlanificacion(Planificacion planificacion) {
        this.planificacion.add(planificacion);
    }

    /**
     * @return el nombre de la asignatura.
     */
    public String getAsign() {
        return Asign;
    }

    /**
     * @return el codigo de la asignatura.
     */
    public int getCodigoAsign() {
        return codigoAsign;
    }

    /**
     * @return el docente que imparte la asignatura.
     */
    public Profesor getDocente() {
        return docente;
    }

    /**
     * @return retorna la planificacion del curso.
     */
    public ArrayList<Planificacion> getPlanificacion() {
        return planificacion;
    }

}
