package Institucion;

import Institucion.Planificacion;
import Institucion.Profesor;
import alumnos.Evaluacion;
import alumnos.Asistencia;
import alumnos.Anotacione;
import alumnos.Alumno;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Eduard QF
 */
public class Curso {

    private String IDCurso;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Asignatura> asignatura;

    public Curso(String IDCurso, Alumno alumno1, Asignatura plan1) {
        this.IDCurso = IDCurso;
        alumnos = new ArrayList<>();
        asignatura = new ArrayList<>();
        alumnos.add(alumno1);
        asignatura.add(plan1);
    }

    public ArrayList<Asignatura> getAsignatura() {
        return asignatura;
    }

    public void addAsignatura(Asignatura asignatura) {
        this.asignatura.add(asignatura);
    }

    public String getIDCurso() {
        return IDCurso;
    }

    public void setIDCurso(String IDCurso) {
        this.IDCurso = IDCurso;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void addAlumnos(Alumno newAlumno) {
        alumnos.add(newAlumno);
    }


    public void newAnotacion(int alum, Anotacione an) {
        getAlumnos().get(alum).addAnotaciones(an);
    }

    public void newEvaluacion(int alum,Evaluacion ev) {
        getAlumnos().get(alum).addNotasEvaluaciones(ev);

    }

    public void newAsistencia(int alum, Asistencia as) {
        getAlumnos().get(alum).addAsistencia(as);
    }

}
