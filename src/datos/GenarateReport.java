/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import Institucion.Curso;
import alumnos.Alumno;
import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @version 0.0.0, 20/04/2016
 * @author Eduard QF
 */
public class GenarateReport {

    /**
     * atributo que almacena la raiz del xsl necesario para el parseo.
     */
    private String rootXSL;

    /**
     * atributo que almacenara el nombre del archivo a crearse
     */
    private String name;

    /**
     * atributo que almacena la raiz del xml generado.
     */
    private String rootXML;

    /**
     * atributos donde se guardaran los datos como direccion y contenido de los
     * registros
     */
    private Object param1, param2, param3;

    /**
     * metodo encargado de entregar los datos a Param1 param2 y param3 para
     * generar los reportes de los Apoderados.
     */
    public void genararReporteAlumno(Alumno alumno) {
        Alumno alumn = alumno;
        param1 = alumn.getNombre();
        param2 = alumn.getNombre();
        param3 = alumn;
        generar();
    }

    /**
     * metodo encargado de entregar los datos a Param1 param2 y param3 para
     * generar los reportes de las Asignaturas.
     *
     * @param codAsign indica el codigo de la asignatura
     * @param estudiantes arreglo de alumnos con sus respectivas notas en la
     * Asignatura.
     */
    public void generarReporteNotasAsign(int codAsign, ArrayList<ArrayList> estudiantes, Curso curs) {
        Curso cs = curs;
        param1 = cs.getAsignatura().get(codAsign);
        param2 = cs.getAsignatura().get(codAsign);
        param3 = estudiantes;
        generar();

    }

    /**
     * metodo que modifica el atributo rootXSL y el atributo name a Html.
     */
    private void generarHtml() {
        rootXSL = ("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\XSLs\\To_Html.xsl");
        name = ("C:\\Users\\Eduard QF\\Desktop\\inf\\Programacio2017\\reportes Obtenidos\\" + param1 + "\\" + param2 + ".html");
        generar2();
    }

    /**
     * metodo que modifica el atributo rootXSL y el atributo name para Word.
     */
    private void generarDoc() {
        rootXSL = ("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\XSLs\\To_Word.xsl");
        name = ("C:\\Users\\Eduard QF\\Desktop\\inf\\Programacio2017\\reportes Obtenidos" + param1 + "\\" + param2 + ".doc");
        generar2();
    }

    /**
     * metodo que modifica el atributo rootXSL y el atributo name para Excel.
     */
    private void generarExel() {
        rootXSL = ("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\XSLs\\To_Exel.xsl");
        name = ("C:\\Users\\Eduard QF\\Desktop\\inf\\Programacio2017\\reportes Obtenidos" + param1 + "\\" + param2 + ".xls");
        generar2();
    }

    /**
     * metodo encargado de generar un xml con los datos entregados.
     */
    private void generarXml() {
        rootXML = "C:\\Users\\Eduard QF\\Desktop\\inf\\Programacio2017\\reportes Obtenidos\\" + param1 + "\\" + param2 + ".xml";
        XStream xs = new XStream();
        xs.alias("Alumno", Alumno.class);
        String t = xs.toXML(param3);
        datos.DataReader.writeData(rootXML, t);
        System.out.println(t);
    }

    /**
     * metodo que modifica el atributo rootXSL y el atributo name a json.
     */
    private void generarJson() {
        rootXSL = ("C:\\Users\\Eduard QF\\Documents\\NetBeansProjects\\ProgramacionCursosBasica\\src\\XSLs\\To_json.xsl");
        name = ("C:\\Users\\Eduard QF\\Desktop\\inf\\Programacio2017\\reportes Obtenidos" + param1 + "\\" + param2 + ".json");
        generar2();
    }

    /**
     * 2da parte de la generacion de los reportes, en la cual se generan la
     * transformacion desde el xml
     */
    private void generar2() {
        Source xmlDoc = new StreamSource(rootXML);

        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xslDoc = new StreamSource(rootXSL);
            String outputFileName = name;

            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer trasform = tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo encargado de reenviar a los metodos generadores de los Reportes
     */
    private void generar() {
        generarXml();
        generarHtml();
        generarDoc();
        generarExel();
        generarJson();
    }
}
