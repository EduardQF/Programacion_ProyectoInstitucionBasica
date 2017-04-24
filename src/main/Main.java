/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.FileNotFoundException;
import modelo.Body;
import vistas.PrincipalWindows;

/**
 *
 * @author Eduard QF
 */
public class Main {
    /**
     * Main del Proyecto.
     * @param args parametros iniciales de la clase.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Body bd= new Body();
        bd.init();
        PrincipalWindows pw=new PrincipalWindows(bd);
        pw.setVisible(true);
    }
}
