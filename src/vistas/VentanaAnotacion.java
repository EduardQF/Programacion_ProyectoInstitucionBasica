/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import Institucion.Profesor;
import Institucion.INstitucion;
import alumnos.Anotacione;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *@version 0.0.3
 * @author Eduard QF
 */
public class VentanaAnotacion extends javax.swing.JFrame {
    /**
     * atributo que almacena la intanciacion del objeto instituto.
     */
    INstitucion instituto;
    
    /**
     * atributo que almacena la instanciacion ya creada del objeto Body.
     */
    Body bd;
    
    /**
     * atributo que almacena los nombre de los profesores.
     */
    String[] nOmbprofes;
    
    /**
     * atributo que almacena los nombres de los alumnos.
     */
    String[] nombrAlums;
    
    /**
     * atributo que almacena los detalles de las anotaciones de cada alumno.
     */
    String[][] anotaciones;
    
    /**
     * constructor clase VentanaAnotacion
     * @param bd Instanciacion del objeto Body
     */
    public VentanaAnotacion(Body bd) {
        this.bd=bd;
        instituto=bd.asignInst();
        llenarArreglos(0);
        initComponents();    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        addAnotacion = new javax.swing.JButton();
        jComboBoxCurso = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTextDetalle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addAnotacion.setText("Agregar Anotacion");
        addAnotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAnotacionActionPerformed(evt);
            }
        });

        jComboBoxCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 A", "1 B","2 A", "2 B","3 A", "3 B","4 A", "4 B","5 A", "5 B","6 A", "6 B","7 A", "7 B","8 A", "8 B", }));
        jComboBoxCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursoActionPerformed(evt);
            }
        });

        jLabel1.setText("Curso:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "tipo de anotacion", "Profesor", "Detalle"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel2.setText("tipo:");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Positiva", "Negativa" }));

        jLabel3.setText("Profesor:");

        jComboBoxProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(nOmbprofes));

        jLabel4.setText("Detalle:");

        jLabel5.setText("Alumno:");

        jComboBoxAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(nombrAlums));
        jComboBoxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlumnosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxAlumnos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxProfesor, 0, 118, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(addAnotacion)
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextDetalle)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addAnotacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    /**
     * metodo que crea y almacena una nueva anotacion a trabes de los datos 
     * entregados en los campos jText y jComboBox.
     * @param evt evento del boton addAnotacion
     */
    private void addAnotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAnotacionActionPerformed
        boolean tipo;
        if (jComboBoxTipo.getSelectedItem()=="Positiva") {
            tipo=true;
        }else{
            tipo=false;
        }
        String detalle=jTextDetalle.getText();
        Profesor profesor=bd.compareDocentes(jComboBoxProfesor.getSelectedItem(),jComboBoxCurso.getSelectedIndex());
        Anotacione anota=new Anotacione(tipo, detalle, profesor);
        instituto.getCursos().get(0).getAlumnos().get(1).addAnotaciones(anota);
        JOptionPane.showMessageDialog(this, "anotacion ingresada correctamente");
        bd.guardarCambios();
        dispose();
    }//GEN-LAST:event_addAnotacionActionPerformed

    /**
     * metodo encargado de obtener los daros del curso seleccionado en el
     * jComboBoxCurso.
     * @param evt evento que entrega el boton jComboBoxCurso.
     */
    private void jComboBoxCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursoActionPerformed
        llenarArreglos(jComboBoxCurso.getSelectedIndex());
        jComboBoxAlumnos.removeAllItems();
        for (int i = 0; i < nombrAlums.length; i++) {
            jComboBoxAlumnos.addItem(nombrAlums[i]);
        }
        jComboBoxProfesor.removeAllItems();
        for (int i = 0; i < nOmbprofes.length; i++) {
            jComboBoxProfesor.addItem(nOmbprofes[i]);
        }
    }//GEN-LAST:event_jComboBoxCursoActionPerformed

    /**
     * metodo que entrega los datos y entrega el momento de rellenar la tabla
     * @param evt evento que entrega el boton jComboBoxAlumnos.
     */
    private void jComboBoxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlumnosActionPerformed
        llenarTablero(jComboBoxCurso.getSelectedIndex(),jComboBoxAlumnos.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxAlumnosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAnotacion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBoxAlumnos;
    private javax.swing.JComboBox<String> jComboBoxCurso;
    private javax.swing.JComboBox<String> jComboBoxProfesor;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextDetalle;
    // End of variables declaration//GEN-END:variables


    /**
     * metodo encargado de llenar los arreglos iniciales de la tabla.
     * @param curso entrega el curso inicial del cual la tabla mostrara sus datos. 
     */
    private void llenarArreglos(int curso) {
               
        nOmbprofes=new String[instituto.getCursos().get(curso).getAsignatura().size()];
        nombrAlums=new String[instituto.getCursos().get(curso).getAlumnos().size()];
        for (int i = 0; i < nOmbprofes.length ; i++) {
            nOmbprofes[i]=instituto.getCursos().get(curso).getAsignatura().get(i).getDocente().getNombre();
        }
        
        for (int i = 0; i < nombrAlums.length; i++) {
            nombrAlums[i]=instituto.getCursos().get(curso).getAlumnos().get(i).getNombre();
        }
        
    }
    
    /**
     * metodeo encargado de modificar los datos que entrega la tabla 
     * de anotaciones.
     * @param selectedalumno entrega el alumno seleccionado en el jComboBox del
     * arreglo de alumnos. 
     * @param selectedcurso entrega el curso seleccionado en el jComboBox del 
     * arreglo de curso.
     */
    private void llenarTablero(int selectedcurso, int selectedalumno){
        anotaciones=new String[3][instituto.getCursos().get(selectedcurso).getAlumnos().get(selectedalumno).getAnotaciones().size()];
        for (int i = 0; i < anotaciones.length; i++) {
            jTable2.setValueAt(instituto.getCursos().get(selectedcurso).getAlumnos().get(selectedalumno).getAnotaciones().get(i).getTipo(), i, 0);
            jTable2.setValueAt(instituto.getCursos().get(selectedcurso).getAlumnos().get(selectedalumno).getAnotaciones().get(i).getProfesor().getNombre(), i, 1);
            jTable2.setValueAt(instituto.getCursos().get(selectedcurso).getAlumnos().get(selectedalumno).getAnotaciones().get(i).getDetalle(), i, 2);
        }
    }
}
