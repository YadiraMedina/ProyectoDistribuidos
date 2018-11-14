import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ArticuloFrm extends javax.swing.JFrame {

    //Atributo para cargar el combo
       private DefaultTableModel modeloTabla;
       private DefaultComboBoxModel modeloComboEstado;
       private DefaultComboBoxModel modeloComboTpArt;
    
    public ArticuloFrm() {
        
        modeloComboEstado = new DefaultComboBoxModel(new String [] {});
        modeloComboTpArt = new DefaultComboBoxModel(new String [] {});
        modeloTabla = new DefaultTableModel(null, getColumn());
        
        initComponents();
        cargarTabla();
        
        cargarCboTpArticulo();
        cargarCboEstados();
    }
    
    //Se cargan las columnas a la tabla Artículo
    private String[] getColumn(){
        String columnas[] = new String[]{"id_articulo", "Tipo Artículo", "Nombre", "Cantidad", "Precio", "Estado"};
        return columnas;
    }   
    
    // CARGAR COMBOS
    private void cargarCboEstados(){
        ResultSet estados;
        Articulo objArticulo = new Articulo();
        estados = objArticulo.listaEstados(); 
        try {
            while(estados.next()){
                modeloComboEstado.addElement(new estadoArticulo(estados.getInt("id_estado"), estados.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un error: " + e.getMessage());
        }
     }
    
    private void cargarCboTpArticulo(){
        ResultSet tpArticulo;
        Articulo objArticulo = new Articulo();
        tpArticulo = objArticulo.listaTpArticulo(); 
        try {
            while(tpArticulo.next()){
               modeloComboTpArt.addElement(new estadoArticulo(tpArticulo.getInt("id"), tpArticulo.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un error: " + e.getMessage());
        }
     }
    
    private void cargarCboTpArticuloxId(int id){
        ResultSet tpArticulo;
        Articulo objArticulo = new Articulo();
        tpArticulo = objArticulo.listaTpArticuloxId(id); 
        
       
        try {
            while(tpArticulo.next()){
               //modeloComboTpArt.addElement(new estadoArticulo(tpArticulo.getInt("id"), tpArticulo.getString("nombre")));
               cboTpArt.setSelectedIndex(tpArticulo.getInt("id")-1);
               cboTpArt.setSelectedItem(tpArticulo.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un error: " + e.getMessage());
        }
     }
    //Metodo para cargar la tabla
    private void cargarTabla(){
        Articulo objArticulo = new Articulo();
        ResultSet resultado = objArticulo.cargarTablaArticulo();
        try {
            Object datos[] = new Object[6];
            while (resultado.next()){
                for(int i=0; i<6; i++){
                    datos[i] = resultado.getObject(i+1);
                }
                modeloTabla.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtcantidad = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtprecio = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIdArticulo = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtArticulo = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtNomArt = new javax.swing.JTextPane();
        cboTpArt = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("ARTÍCULOS");

        cboEstado.setModel(modeloComboEstado);
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo Artículo");

        jLabel4.setText("Cantidad");

        jScrollPane3.setViewportView(txtcantidad);

        jLabel5.setText("Precio");

        jScrollPane4.setViewportView(txtprecio);

        jLabel2.setText("id_articulo");

        txtIdArticulo.setText("0");
        jScrollPane1.setViewportView(txtIdArticulo);

        jLabel6.setText("Estado");

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSalir.setText("ATRÁS");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jtArticulo.setModel(modeloTabla);
        jtArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtArticuloMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtArticulo);

        jScrollPane6.setViewportView(txtNomArt);

        cboTpArt.setModel(modeloComboTpArt);
        cboTpArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTpArtActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cboTpArt, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane4)
                                    .addComponent(cboEstado, 0, 140, Short.MAX_VALUE))))))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTpArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnEliminar)
                            .addComponent(btnSalir)))
                    .addComponent(jLabel4))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       Articulo art = new Articulo();
       
       int idTpArticulo=cboTpArt.getSelectedIndex() + 1;
//        JOptionPane.showConfirmDialog(null, "Id es: " + idTpArticulo);
       int cantidad=Integer.parseInt(txtcantidad.getText());
       int precio=Integer.parseInt(txtprecio.getText());
       String estado=cboEstado.getSelectedItem().toString();
       int id =Integer.parseInt(txtIdArticulo.getText());
       String Nombre=txtNomArt.getText();
       if(id==0){
            boolean resultado = art.insertarArticulo(idTpArticulo, cantidad, precio, estado, Nombre);
            if(resultado==true){
                JOptionPane.showMessageDialog(null, "Se insertó el artículo!");
                this.modeloTabla.getDataVector().clear();
                cargarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "No se insertó el artículo");
            }
       }else{
            boolean resultado = art.actualizarArticulo(id, idTpArticulo, cantidad, precio, estado,Nombre);
            if(resultado==true){
               JOptionPane.showMessageDialog(null, "Se actualizó el artículo!");
               this.modeloTabla.getDataVector().clear();
               cargarTabla();
           }else{
               JOptionPane.showMessageDialog(null, "No se actualizó el artículo");
           }
           }
      
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Articulo art = new Articulo();
        boolean resultado = art.eliminarArticulo(Integer.parseInt(txtIdArticulo.getText()));
        if(resultado==true){
           JOptionPane.showMessageDialog(null, "Se eliminó el artículo");
           this.modeloTabla.getDataVector().clear();
          cargarTabla();          
       }else{
           JOptionPane.showMessageDialog(null, "No se eliminó el artículo");
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        InicioFrm verFormularioInicio = new InicioFrm();
        verFormularioInicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jtArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtArticuloMouseClicked
        int selection = jtArticulo.getSelectedRow();
        txtIdArticulo.setText(String.valueOf(jtArticulo.getValueAt(selection, 0)));
        //modeloComboTpArt.setSelectedItem(String.valueOf(jtArticulo.getValueAt(selection, 1)));
                int a= (int)jtArticulo.getValueAt(selection,1);
                //JOptionPane.showConfirmDialog(null, "Id es: " + a);
                cargarCboTpArticuloxId(a);
        txtNomArt.setText(String.valueOf(jtArticulo.getValueAt(selection, 2)));
        txtcantidad.setText(String.valueOf(jtArticulo.getValueAt(selection, 3)));
        txtprecio.setText(String.valueOf(jtArticulo.getValueAt(selection, 4)));
        modeloComboEstado.setSelectedItem(String.valueOf(jtArticulo.getValueAt(selection, 5)));
    }//GEN-LAST:event_jtArticuloMouseClicked

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
      
    }//GEN-LAST:event_cboEstadoActionPerformed

    private void cboTpArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTpArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTpArtActionPerformed

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
            java.util.logging.Logger.getLogger(ArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArticuloFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArticuloFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboTpArt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jtArticulo;
    private javax.swing.JTextPane txtIdArticulo;
    private javax.swing.JTextPane txtNomArt;
    private javax.swing.JTextPane txtcantidad;
    private javax.swing.JTextPane txtprecio;
    // End of variables declaration//GEN-END:variables
}
