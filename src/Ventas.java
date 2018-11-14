import conexion.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Ventas extends VentasApp.VentasPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

        public ResultSet listaArticulos(){
        ResultSet resultado = null;
        
        try {
            String query = "Select id_articulo, nombre from articulo";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " +e.getMessage());
        }
        
        return resultado;
    }
    
    @Override
    public boolean insertarVentas( int id_cliente, int cantidad_total, int valor_total) {
        
        boolean resultado = false;
        Date fecha =new Date();
        //SimpleDateFormat fecha= new SimpleDateFormat("dd-MM-yy");
         //Date date = fecha.parse("31-03-2016");
         
        JOptionPane.showConfirmDialog(null, "Id es: " + fecha);
        try {
            String query = "Insert into ventas(id_cliente,fecha,cantidad_total,valor_total)"
                    + "values ("+id_cliente+",'"+fecha+"',"+cantidad_total+","+valor_total+")";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public boolean eliminarVentas(int id_ventas) {
       
         boolean resultado = false;
        try {
            String query = "Delete from ventas where id_ventas = "+id_ventas;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean actualizarVentas(int id_ventas, int id_cliente, int cantidad_total, int valor_total) {
        
        boolean resultado = false;
        Date fecha =new Date();
        try {
            String query = "Update ventas set id_cliente="+id_cliente+",fecha='"+fecha+"',cantidad_total="+cantidad_total+",valor_total="+valor_total+""
                    + " where id_ventas="+id_ventas+"";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor > 0){
                resultado = true;
            }
            //Cerramos recursos
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ResultSet cargarTablaVentas(){
        ResultSet resultado = null;
        try {
            String query = "Select id_ventas, id_cliente, fecha, cantidad_total, valor_total from ventas";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }

}
