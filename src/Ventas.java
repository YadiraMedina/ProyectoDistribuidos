import conexion.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

import java.util.Date;

public class Ventas extends VentasApp.VentasPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

       
    @Override
    public boolean insertarVentas( int id_cliente, int cantidad_total, int valor_total) {
        
        boolean resultado = false;
        Date fecha =new Date();
        int Anio =fecha.getYear()+1900;
        int Mes =fecha.getMonth();
        int Dia =fecha.getDate();
        String fechaActual = Anio + "-" + (Mes + 1) +"-" + Dia;
        //SimpleDateFormat fecha= new SimpleDateFormat("dd-MM-yy");
         //Date date = fecha.parse("31-03-2016");
         
        //JOptionPane.showConfirmDialog(null, "Id es: " + fechaActual);
        try {
            String query = "Insert into ventas(id_cliente,fecha,cantidad_total,valor_total)"
                    + "values ("+id_cliente+",'"+fechaActual+"',"+cantidad_total+","+valor_total+")";
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
        int Anio =fecha.getYear()+1900;
        int Mes =fecha.getMonth();
        int Dia =fecha.getDate();
        String fechaActual = Anio + "-" + (Mes + 1) +"-" + Dia;
        try {
            String query = "Update ventas set id_cliente="+id_cliente+",fecha='"+fechaActual+"',cantidad_total="+cantidad_total+",valor_total="+valor_total+""
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
   
    public ResultSet listaClientes(){
        ResultSet resultado = null;
        
        try {
            String query = "Select id_cliente as id, identificacion, nombre from cliente";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " +e.getMessage());
        }
        
        return resultado;
    }
    
    public ResultSet listaClientexId(int id){
        ResultSet resultado = null;
        //JOptionPane.showConfirmDialog(null, "Id es: " + id);
        try {
            String query = "Select id_cliente as id, nombre, identificacion from cliente where id_cliente="+id;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " +e.getMessage());
        }
        
        return resultado;
    }
    
     public ResultSet listaArticulosxId(int id){
        ResultSet resultado = null;
        //JOptionPane.showConfirmDialog(null, "Id es: " + id);
        try {
            String query = "Select id_articulo as id, id_tpArticulo,cantidad,precio,estado,nombre from articulo where id_articulo="+id;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " +e.getMessage());
        }
        
        return resultado;
    }

     public ResultSet consultarIdVenta(){
        ResultSet resultado = null;
        //JOptionPane.showConfirmDialog(null, "Id es: " + id);
        try {
            String query = "Select max(id_ventas) as id from ventas";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " +e.getMessage());
        }
        
        return resultado;
    }

}
