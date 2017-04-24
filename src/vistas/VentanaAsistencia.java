package vistas;

import Institucion.*;
import alumnos.Asistencia;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import modelo.*;

/**
 *
 * @author Eduard QF
 */
public class VentanaAsistencia extends javax.swing.JFrame {

    /**
     * atributo que une la ventana con objeto Body.
     */
    Body bd;

    /**
     * atributo que une la ventana con el objeto INstitucion.
     */
    INstitucion in;

    /**
     * atributo en el que almacenamos un arreglo de la asistencia de los
     * alumnos.
     */
    String[][] asistencia;

    /**
     * atributo en el que almacenamos los caracteres que mostrara la tabla.
     */
    String titulo[];

    /**
     * constructor de la clase Ventena Asistencia.
     *
     * @param bd objeto Body para realizar la coneccion con el el Objeto
     * existente.
     */
    public VentanaAsistencia(Body bd) {
        System.out.println("ventana asistencia");
        this.bd = bd;
        in = bd.asignInst();
        llenarArreglos(0);
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAddAsistencia = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Curso:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 A", "1 B","2 A", "2 B","3 A", "3 B","4 A", "4 B","5 A", "5 B","6 A", "6 B","7 A", "7 B","8 A", "8 B"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            asistencia,
            titulo
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonAddAsistencia.setText("Añadir asistencia");
        jButtonAddAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAsistenciaActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar cambios");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonAddAsistencia)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonGuardar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddAsistencia)
                    .addComponent(jButtonGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * metodo que cambia los valores dentro de jTable1.
     *
     * @param evt entrega el evento del boton jComboBox1.
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        for (int i = 0; i < in.getCursos().get(jComboBox1.getSelectedIndex()).getAlumnos().size(); i++) {
            jTable1.setValueAt(in.getCursos().get(jComboBox1.getSelectedIndex()).getAlumnos().get(i).getNombre(), i, 0);
            for (int j = 1; j <= in.getCursos().get(jComboBox1.getSelectedIndex()).getAlumnos().get(i).getAsistencia().size(); j++) {
                if ((String.valueOf(in.getCursos().get(jComboBox1.getSelectedIndex()).getAlumnos().get(i).getAsistencia().get(j-1).getAsistencia()).equals("true"))) {
                    jTable1.setValueAt(("o"), i, j);
                }else if ((String.valueOf(in.getCursos().get(jComboBox1.getSelectedIndex()).getAlumnos().get(i).getAsistencia().get(j-1).getAsistencia()).equals("false"))) {
                    jTable1.setValueAt(("x"), i, j);
                }else   {
                    jTable1.setValueAt((" "), i, j);
                }
                
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * metodo encargado de añadir una nueva olumna a la tabla de asistencia.
     *
     * @peram evt entrega el evento del boton agregar Asistencia.
     */
    private void jButtonAddAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAsistenciaActionPerformed
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        modelo.addColumn(bd.getFecha());
        jTable1.setModel(modelo);
    }//GEN-LAST:event_jButtonAddAsistenciaActionPerformed

    /**
     * metodo encargado de agregar los datos nuevos de la tabla a cada alumno
     * estipulado en esta.
     *
     * @param evt entrega el evento del boton Guardar.
     */
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        alumnos.Asistencia as;
        JTableHeader th = jTable1.getTableHeader();
        String tcm = String.valueOf(th.getColumnModel().getColumn(th.getComponentCount()).getIdentifier());
        System.out.println(tcm);
        boolean asis;
        for (int i = 0; i < jTable1.getEditingRow(); i++) {
            if (((String)jTable1.getValueAt(i, jTable1.getColumnCount() - 1)).equalsIgnoreCase("o")) {
                asis=true;
            }else{
                asis=false;
            }
            as = new Asistencia(asis, tcm);
            in.getCursos().get(jComboBox1.getSelectedIndex()).getAlumnos().get(i).addAsistencia(as);
        }
        bd.guardarCambios();
    }//GEN-LAST:event_jButtonGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddAsistencia;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     * metollo que llena por primera ves los arreglos que contienen los primeros
     * datos a ser mostrados por la tabla
     *
     * @param curso entrega el primer curso en aparecer los datos en la tabla;
     */
    private void llenarArreglos(int curso) {
        titulo = new String[in.getCursos().get(curso).getAlumnos().get(0).getAsistencia().size() + 1];
        asistencia = new String[in.getCursos().get(curso).getAlumnos().size()][in.getCursos().get(curso).getAlumnos().get(0).getAsistencia().size() + 1];
        titulo[0] = "Estudiante";
        for (int i = 0; i < in.getCursos().get(curso).getAlumnos().size(); i++) {
            asistencia[i][0] = in.getCursos().get(curso).getAlumnos().get(i).getNombre();
            for (int j = 1; j <= in.getCursos().get(curso).getAlumnos().get(i).getAsistencia().size(); j++) {

                if (titulo[titulo.length - 1] == null) {
                    titulo[j] = in.getCursos().get(curso).getAlumnos().get(0).getAsistencia().get(j-1).getTime();
                }

                System.out.println("nombre:" + in.getCursos().get(curso).getAlumnos().get(i).getNombre());
                System.out.println(String.valueOf(in.getCursos().get(curso).getAlumnos().get(i).getAsistencia().get(j-1).getAsistencia()));
                if (String.valueOf(in.getCursos().get(curso).getAlumnos().get(i).getAsistencia().get(j-1).getAsistencia()).equals("true")) {
                    asistencia[i][j] = "o";
                }else{
                    asistencia[i][j] = "x";
                }
                

            }
        }
    }

}
