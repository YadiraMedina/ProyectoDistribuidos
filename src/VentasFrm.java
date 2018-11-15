import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentasFrm extends javax.swing.JFrame {
     //Atributo para cargar el combo
     private DefaultTableModel modeloTablaVentas;
     private DefaultComboBoxModel modeloComboCliente;
     private DefaultComboBoxModel modeloComboArticulos;
       
    public VentasFrm() {
        modeloTablaVentas = new DefaultTableModel(null, getColumn());
        modeloComboArticulos = new DefaultComboBoxModel(new String [] {});
        modeloComboCliente = new DefaultComboBoxModel(new String [] {});
        
        initComponents();
        cargarTabla();
        cargarCboArticulos();
        cargarCboClientes();
    }
    
    //Se cargan las columnas a la tabla Ventas
    private String[] getColumn(){
        String columnas[] = new String[]{"id_ventas", "id_cliente", "Fecha", "Cantidad", "Valor"};
        return columnas;
    }   

    // CARGAR COMBOS
    private void cargarCboArticulos(){
        ResultSet ventas;
        Ventas objVentas = new Ventas();
        ventas = objVentas.listaArticulos(); 
        try {
            while(ventas.next()){
                modeloComboArticulos.addElement(new estadoArticulo(ventas.getInt("id_articulo"), ventas.getString("nombre")));
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un error: " + e.getMessage());
        }
     }
    
     private void cargarCboClientes(){
        ResultSet cliente;
        Ventas objVentas = new Ventas();
        cliente = objVentas.listaClientes();
        try {
            while(cliente.next()){
                modeloComboCliente.addElement(new estadoArticulo(cliente.getInt("id"), cliente.getString("nombre")));
                cargarCboClientexId(1,1);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un error: " + e.getMessage());
        }
     }
     
     private void cargarCboClientexId(int id, int soloide){
        ResultSet Cliente;
        Ventas objVentas = new Ventas();
        Cliente = objVentas.listaClientexId(id); 
       
        try {
            while(Cliente.next()){
               //modeloComboTpArt.addElement(new estadoArticulo(tpArticulo.getInt("id"), tpArticulo.getString("nombre")));
               if (soloide==0){
                    cboCliente.setSelectedIndex(Cliente.getInt("id")-1);
                    cboCliente.setSelectedItem(Cliente.getString("nombre"));
                    txtIdentificacion.setText(Cliente.getString("identificacion"));
               }else{
                    txtIdentificacion.setText(Cliente.getString("identificacion"));     
               }
               
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrio un error: " + e.getMessage());
        }
     }
     
    //Metodo para cargar la tabla
    private void cargarTabla(){
        Ventas objVentas = new Ventas();
        ResultSet resultado = objVentas.cargarTablaVentas();
        try {
            Object datos[] = new Object[5];
            while (resultado.next()){
                for(int i=0; i<5; i++){
                    datos[i] = resultado.getObject(i+1);
                }
                modeloTablaVentas.addRow(datos);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdentificacion = new java.awt.TextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorTotal = new java.awt.TextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cboArticulo = new javax.swing.JComboBox<>();
        cboCliente = new javax.swing.JComboBox<>();
        txtcantidad = new java.awt.TextField();
        jLabel8 = new javax.swing.JLabel();
        txtValor = new java.awt.TextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtventas = new javax.swing.JTable();
        txtIdVenta = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("VENTAS");

        jLabel2.setText("Id_venta");

        jLabel3.setText("Id_Cliente");

        jLabel4.setText("Identificación");

        jLabel6.setText("ValorTotal");

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

        jLabel7.setText("Articulo");

        cboArticulo.setModel(modeloComboArticulos);

        cboCliente.setModel(modeloComboCliente);
        cboCliente.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cboClientePropertyChange(evt);
            }
        });

        jLabel8.setText("Cantidad");

        jLabel9.setText("Valor");

        jtventas.setModel(modeloTablaVentas);
        jtventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtventasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtventas);

        txtIdVenta.setText("0");
        txtIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(cboArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(1, 1, 1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(22, 22, 22)
                                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalir)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         Ventas venta = new Ventas();
       int id=Integer.parseInt(txtIdVenta.getText());
       int idArticulo=cboArticulo.getSelectedIndex() + 1;
       int idCliente=cboCliente.getSelectedIndex() + 1;
//        JOptionPane.showConfirmDialog(null, "Id es: " + idTpArticulo);
       int cantidad=Integer.parseInt(txtcantidad.getText());
       int valor=Integer.parseInt(txtValor.getText());
       //String Nombre=txtArt.getText();
       if(id==0){
            boolean resultado = venta.insertarVentas(idCliente,cantidad, valor);
            if(resultado==true){
                JOptionPane.showMessageDialog(null, "Se insertó el registro!");
                this.modeloTablaVentas.getDataVector().clear();
                cargarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "No se insertó el registro");
            }
       }else{
            boolean resultado = venta.actualizarVentas(id, idCliente,cantidad, valor);
            if(resultado==true){
               JOptionPane.showMessageDialog(null, "Se actualizó el registro!");
               this.modeloTablaVentas.getDataVector().clear();
               cargarTabla();
           }else{
               JOptionPane.showMessageDialog(null, "No se actualizó el registro");
           }
           }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       Ventas venta = new Ventas();
        boolean resultado = venta.eliminarVentas(Integer.parseInt(txtIdVenta.getText()));
        if(resultado==true){
           JOptionPane.showMessageDialog(null, "Se eliminó el registro");
           this.modeloTablaVentas.getDataVector().clear();
          cargarTabla();          
       }else{
           JOptionPane.showMessageDialog(null, "No se eliminó el registro");
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      InicioFrm verFormularioInicio = new InicioFrm();
      verFormularioInicio.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVentaActionPerformed

    private void jtventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtventasMouseClicked
       int selection = jtventas.getSelectedRow();
        txtIdVenta.setText(String.valueOf(jtventas.getValueAt(selection, 0)));
        //modeloComboTpArt.setSelectedItem(String.valueOf(jtArticulo.getValueAt(selection, 1)));
                int id_cliente= (int)jtventas.getValueAt(selection,1);
                //JOptionPane.showConfirmDialog(null, "Id es: " + a);
                cargarCboClientexId(id_cliente,0);
        
        txtcantidad.setText(String.valueOf(jtventas.getValueAt(selection, 3)));
        txtValor.setText(String.valueOf(jtventas.getValueAt(selection, 4)));
        modeloComboArticulos.setSelectedItem(String.valueOf(jtventas.getValueAt(selection, 5)));
    }//GEN-LAST:event_jtventasMouseClicked

    private void cboClientePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cboClientePropertyChange
       int idCliente=cboCliente.getSelectedIndex() + 1;
       cargarCboClientexId(idCliente,1);
    }//GEN-LAST:event_cboClientePropertyChange
                                       
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
            java.util.logging.Logger.getLogger(VentasFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboArticulo;
    private javax.swing.JComboBox<String> cboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtventas;
    private java.awt.TextField txtIdVenta;
    private java.awt.TextField txtIdentificacion;
    private java.awt.TextField txtValor;
    private java.awt.TextField txtValorTotal;
    private java.awt.TextField txtcantidad;
    // End of variables declaration//GEN-END:variables
}
