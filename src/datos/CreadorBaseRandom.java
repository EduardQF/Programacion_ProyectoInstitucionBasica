/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Institucion.*;
import alumnos.Alumno;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import alumnos.Apoderado;
import Institucion.Curso;
import alumnos.Asistencia;
import alumnos.Evaluacion;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * @version 0.0.0, 10,04,2017
 * @author Eduard QF
 */
public class CreadorBaseRandom {

    /**
     * contadores de dia, mes y año que seran ocupados en el metodo getFecha.
     */
    int contd = 1, contm = 1, conta = 2000;

    /**
     * arreglo que almacena la direccion de la base de datos de los nombres.
     */
    String pathnombre = "C:/Users/Eduard QF/Desktop/base nombre.txt";

    /**
     * arreglo que contiene la direccion del archibo que almacena los apellidos.
     */
    String pathApellido = "C:\\Users\\Eduard QF\\Desktop\\apellido.txt";

    /**
     * arreglo que almacenara los diferentes nombes de una base de datos.
     */
    String nOmbre[];

    /**
     * arreglo que almacenara los diferentes apellidos de una base de datos.
     */
    String aPellido[];

    /**
     * Main aparte de la clace principal del proyecto.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreadorBaseRandom pb = new CreadorBaseRandom();
        System.out.println("iniciar programa");
        System.out.println("instancio arreglo");
        INstitucion in = pb.m1(pb);
        pb.m2(in);
    }

    /**
     * metodo que genera el poblamiento inicial de y lo almacena en el Objeto in
     * de tipo Institucion.
     */
    private INstitucion m1(CreadorBaseRandom pb) {
        ArrayList<Curso> cursos = new ArrayList<>();
        pb.rellenoArreglo();
        INstitucion in = null;
        int contA = 0;
        int contB = 0;
        int ot = JOptionPane.showConfirmDialog(null, "desea iniciar la generacion de datos", "Iniciando", JOptionPane.YES_NO_CANCEL_OPTION);
        if (ot == JOptionPane.OK_OPTION) {

            for (int i = 0; i < 16; i++) {
                cursos.add(new Curso(pb.newIdcurso(i), pb.newAlumnos(), pb.asign(0)));
                contA++;
                contB++;
                System.out.println("agregando mas alumnos");
                for (int j = 0; j < 29; j++) {
                    System.out.println("j: " + j + " contA: " + contA + " contB:" + contB);
                    cursos.get(i).addAlumnos(pb.newAlumnos());
                    contB++;
                    contA++;
                    System.out.println("añadiendo asistencias");
                    for (int k = 0; k < 10; k++) {
                        alumnos.Asistencia as = new Asistencia(randomAsis(), pb.getFecha());
                        cursos.get(i).getAlumnos().get(j).addAsistencia(as);
                    }
                    System.out.println("añadiendo evaluaciones.");
                    float promedioFinal = 0;
                    float promTaller = 0;
                    for (int k = 0; k < 5; k++) {
                        for (int l = 0; l < 4; l++) {
                            float nota = randomnot();
                            alumnos.Evaluacion ev = new Evaluacion(pb.materia(k), nota, ("Prueba" + (l + 1)));
                            cursos.get(i).getAlumnos().get(j).addNotasEvaluaciones(ev);
                            promedioFinal += nota;
                        }
                        for (int l = 0; l < 6; l++) {
                            float nota = randomnot();
                            alumnos.Evaluacion ev = new Evaluacion(pb.materia(k), nota, ("Taller" + (l + 1)));
                            cursos.get(i).getAlumnos().get(j).addNotasEvaluaciones(ev);
                            promTaller = nota;
                        }
                        promTaller = promTaller / 6;
                        promedioFinal = (promedioFinal + promTaller) / 5;
                        alumnos.Evaluacion ev = new Evaluacion(pb.materia(k), promedioFinal, ("Promedio Final"));
                        cursos.get(i).getAlumnos().get(j).addNotasEvaluaciones(ev);

                    }
                }
                System.out.println("agregando Asignatura");
                for (int k = 1; k <= 4; k++) {
                    System.out.println("k:" + k + " contA: " + contA + " contB:" + contB);
                    cursos.get(i).addAsignatura(pb.asign(k));
                    contA++;
                }
                pb.contd = 1;
                pb.contm = 1;
            }
            in = new INstitucion("Ufrontera", cursos);
        }
        return in;
    }

    /**
     * metodo encargado de generar los archivos xml y json con el poblamiento
     * inicial.
     *
     * @param in objeto que sera cparseado a xml y json.
     */
    private void m2(INstitucion in) {
        int op = JOptionPane.showConfirmDialog(null, "desea convertir los objetos en xml", "terminado", JOptionPane.YES_NO_CANCEL_OPTION);
        if (op == JOptionPane.OK_OPTION) {

            XStream xs = new XStream();
            xs.alias("Institucion", INstitucion.class);
            String t = xs.toXML(in);
            datos.DataReader.writeData("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\datos\\DatosTotal.xml", t);
            System.out.println(t);
            /*---------------------------*/
            Gson g = new Gson();
            String p = g.toJson(in);
            datos.DataReader.writeData("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\datos\\DatosTotal.json", p);
            System.out.println(p);
        }
    }

    /**
     * metodo que Instancia un objeto de tipo Actividad para luego entregarlo a
     * otro metodo que lo trabajara.
     *
     * @param i indica en el nivel de asignatura que va el generador el cual
     * varia entre el 0 y el 1.
     * @return retorna un Objeto Actividad relleno de datos semiAlatorios.
     */
    private Asignatura asign(int i) {
        Actividad actividad = new Actividad("prueba 1", getFecha());
        Profesor prof = newDocentes(i);
        Planificacion planifi = new Planificacion(actividad);
        Asignatura as = new Asignatura(materia(i), i, prof, planifi);
        return as;
    }

    /**
     * metodo que dedica su funcion a rellenar 2 arreglos diferentes, uno que
     * cotendra todos los nombres y otros los apellidos contenidos en 2
     * documentos externos.
     */
    private void rellenoArreglo() {
        System.out.println("inicio relleno arreglo nom,Apell");
        nOmbre = datos.DataReader.readData(pathnombre);
        System.out.println("nombre:" + nOmbre[0]);
        aPellido = datos.DataReader.readData(pathApellido);
        System.out.println("apellido:" + aPellido[12]);

    }

    /**
     *
     * metodo que genera el id de un curso a trabes de la divicion de un numero
     * entero.
     *
     * @param i indica en el numero del arreglo en que va el generador, desde el
     * 0 al 15.
     * @return el id con un digito entre el 1 y el 8 y un caracter alfabetico
     * que puede ser A o B.
     */
    public String newIdcurso(int i) {
        String id = "";
        int nivel = ((i + 2) / 2);
        if (i % 2 == 0) {
            id += nivel + " A";
        } else {
            id += nivel + " B";
        }
        System.out.println("rellenando curso: " + id);
        return id;
    }

    /**
     * metodo de crear un objeto Alumno con datos alatorios.
     *
     * @return un objeto Alumno oon sus datos creados alatoriamentes.
     */
    public Alumno newAlumnos() {
        String ape = aPellido[(int) (Math.random() * aPellido.length)].replaceAll(" ", "");
        String nombreAl = nOmbre[(int) (Math.random() * nOmbre.length)].replaceAll(" ", "") + " " + ape;
        String nombreAp = nOmbre[(int) (Math.random() * nombreAl.length())].replaceAll(" ", "") + " " + ape;
        String rutAl = getRandomRut();
        String rutAp = getRandomRut();
        System.out.println("nombreAl: " + nombreAl + "\nnombreAp:" + nombreAp);
        Apoderado apoderado = new Apoderado(nombreAp, rutAl);
        Alumno al = new Alumno(nombreAl, rutAp, apoderado);
        return al;
    }

    /**
     * metodo encargado de generar un nombre alatorio de un objeto tipo
     * Profesor.
     *
     * @param i indica l asignatura correspondiente al profesor en que vamos.
     * @return un objeto de Tipo Profesor creado alatoriamente.
     */
    public Profesor newDocentes(int i) {
        String nombre = nOmbre[(int) (Math.random() * nOmbre.length)] + " " + aPellido[(int) (Math.random() * aPellido.length)];
        String rut = getRandomRut();
        String asignatura = materia(i);
        Profesor p = new Profesor(nombre, rut, asignatura);
        return p;
    }

    /**
     * metodo que entrega el nombre de la asignatura correspondiente.
     *
     * @param i indica el id de la asignatura para registrar el nombre.
     * @return la asignatura corrspondiente.
     */
    private String materia(int i) {
        String asig = "";
        switch (i) {
            case 0:
                asig = "Lenguaje";
                break;
            case 1:
                asig = "Matematica";
                break;
            case 2:
                asig = "Ciencias Naturales";
                break;
            case 3:
                asig = "Historia";
                break;
            default:
                asig = "Ingles";
        }
        return asig;
    }

    /**
     * metodo que genera un rut alatorio.
     *
     * @return el rut con su digito verificador.
     */
    public static String getRandomRut() {
        int randomNum = new Random().nextInt((21000000 - 10000000) + 1) + 10000000;
        String rut = String.valueOf(randomNum);
        int cantidad = rut.length();
        int factor = 2;
        int suma = 0;
        String verificador = "";
        for (int i = cantidad; i > 0; i--) {
            if (factor > 7) {
                factor = 2;
            }
            suma += (Integer.parseInt(rut.substring((i - 1), i))) * factor;
            factor++;

        }
        verificador = String.valueOf(11 - suma % 11);
        if (verificador.equals("11")) {
            verificador = "0";
        } else if (verificador.equals("10")) {
            verificador = "K";
        }
        return rut + "-" + verificador;
    }

    /**
     * metodo que genera dias seguidos desde el 1/1/2000 por cada ves que se
     * llame.
     *
     * @return la fecha establecida a un dia cualquiera.
     */
    private String getFecha() {
        if (contd <= 30) {
            contd++;
        } else {
            contd = 0;
            contm++;
        }
        String fecha = contd + "/" + contm + "/" + conta;
        return fecha;
    }

    /**
     * metodo que genera un random entre 0 y 10 y segun este entrega un true o
     * un false.
     *
     * @return on boleano seguin un random que esta entre 0 y 10.
     */
    private static Boolean randomAsis() {
        int n = (int) Math.random() * (10 - 0) + 0;
        if (n < 5) {
            return true;
        }
        return false;
    }

    /**
     * metodo que genera numeros alatorios entre 1 y 7
     *
     * @return un numero alatorio entre 1 y 7 incluyendo decimales.
     */
    private static float randomnot() {
        return (float) (Math.random() * (7 - 1) + 1);
    }

}
