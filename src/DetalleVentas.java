import conexion.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class DetalleVentas extends DetalleVentasApp.DetalleVentasPOA{
    
     private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarDetalleVentas(int id_venta, int id_articulo, int cantidad, int valor_unitario) {
        
         boolean resultado = false;
       
        try {
            String query = "Insert into detalle_venta(id_venta,id_articulo,cantidad,valor_unitario)"
                    + "values ("+id_venta+","+id_articulo+","+cantidad+","+valor_unitario+")";
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
    public boolean eliminarDetalleVentas(int id_detalle) {
        boolean resultado = false;
        try {
            String query = "Delete from detalle_venta where id_detalle = "+id_detalle;
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
    public boolean actualizarDetalleVentas(int id_detalle, int id_venta, int  id_articulo, int cantidad, int valor_unitario) {
        
         boolean resultado = false;
       
        try {
            String query = "Update detalle_venta set id_venta="+id_venta+", id_articulo="+ id_articulo+",cantidad="+cantidad+",valor_unitario="+valor_unitario+""
                    + " where id_detalle="+id_detalle+"";
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
    
    public ResultSet cargarTablaDetalleVentas(){
        ResultSet resultado = null;
        try {
            String query = "Select id_detalle, id_venta, id_articulo, "
                         + " (select nombre from articulo a where a.id_articulo=d.id_articulo) as articulo, "
                         + " cantidad, valor_unitario from detalle_venta d";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
    
    public ResultSet cargarTablaDetalleVentasxId(int Id){
        ResultSet resultado = null;
        try {
            String query = "Select id_detalle, id_venta, id_articulo, "
                         + " (select nombre from articulo a where a.id_articulo=d.id_articulo) as articulo, "
                         + " cantidad, valor_unitario from detalle_venta d where d.id_venta="+Id;
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
}
