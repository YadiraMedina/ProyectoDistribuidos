
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class TpArticuloFrm extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    
    public TpArticuloFrm() {
         modeloTabla = new DefaultTableModel(null, getColumn());
        
        initComponents();
        cargarTabla();
    }
    
     private String[] getColumn(){
        String columnas[] = new String[]{"Id", "Nombre"};
        return columnas;
    }   
    
    //Metodo para cargar la tabla
    private void cargarTabla(){
        TpArticulo objTpArticulo = new TpArticulo();
        ResultSet resultado = objTpArticulo.cargarTablaTpArticulo();
        try {
            Object datos[] = new Object[2];
            while (resultado.next()){
                for(int i=0; i<2; i++){
                    datos[i] = resultado.getObject(i+1);
                }
                modeloTabla.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtId = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtTpArticulo = new javax.swing.JTable();
        BtnGuardar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtId.setText("0");
        jScrollPane1.setViewportView(txtId);

        jLabel2.setText("Id");

        jLabel3.setText("Nombre");

        jScrollPane2.setViewportView(txtNombre);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TIPOS DE ARTÍCULO");

        jtTpArticulo.setModel(modeloTabla);
        jtTpArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTpArticuloMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtTpArticulo);

        BtnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnAtras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnAtras.setText("ATRÁS");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEliminar)
                                .addGap(1, 1, 1)
                                .addComponent(BtnAtras))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnGuardar)
                            .addComponent(BtnEliminar)
                            .addComponent(BtnAtras))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed

        
        TpArticulo Tipo = new TpArticulo();
        int id =Integer.parseInt(txtId.getText());
        String Nombre=txtNombre.getText();
        
        if(id==0){
            boolean resultado = Tipo.insertarTpArticulo(Nombre);
            if(resultado==true){
                JOptionPane.showMessageDialog(null, "Se insertó el registro");
                this.modeloTabla.getDataVector().clear();
                cargarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "No se insertó el registro");
            }
        }else{
            boolean resultado = Tipo.actualizarTpArticulo(id, Nombre);
            if(resultado==true){
                JOptionPane.showMessageDialog(null, "Se actualizó el registro");
                this.modeloTabla.getDataVector().clear();
                cargarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "No se actualizó el registro");
            }
        }
        
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed

        TpArticulo Tipo = new TpArticulo();
        boolean resultado = Tipo.eliminarTpArticulo(Integer.parseInt(txtId.getText()));
        if(resultado==true){
            JOptionPane.showMessageDialog(null, "Se elimino el registro");
            this.modeloTabla.getDataVector().clear();
            cargarTabla();
        }else{
            JOptionPane.showMessageDialog(null, "No se elimino el registro");
        }
        
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed

        InicioFrm verFormularioInicio = new InicioFrm();
        verFormularioInicio.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void jtTpArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTpArticuloMouseClicked
        int selection = jtTpArticulo.getSelectedRow();
        txtId.setText(String.valueOf(jtTpArticulo.getValueAt(selection, 0)));
        txtNombre.setText(String.valueOf(jtTpArticulo.getValueAt(selection, 1)));
    }//GEN-LAST:event_jtTpArticuloMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TpArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TpArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TpArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TpArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TpArticuloFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtTpArticulo;
    private javax.swing.JTextPane txtId;
    private javax.swing.JTextPane txtNombre;
    // End of variables declaration//GEN-END:variables
}
