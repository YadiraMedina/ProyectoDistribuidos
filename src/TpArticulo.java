
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class TpArticulo extends TpArticuloApp.TpArticuloPOA{

    private ORB orb;
    Conexion conex = new Conexion();
    
    @Override
    public boolean insertarTpArticulo(String nombre) {
       
        boolean resultado=false;
        try {
            String sql="INSERT INTO tp_articulo (nombre) VALUES('"+ nombre +"')";
            conex.conexion();
            Statement st=conex.conex.createStatement();
            int valor=st.executeUpdate(sql);
            if(valor>0){
                resultado=true;
            }
            //Se cierran conexiones
            conex.conex.close();
            st.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al insertar."+ e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public boolean eliminarTpArticulo(int id) {
        
          boolean resultado = false;
        try {
            String query = "Delete from tp_articulo where id = "+id;
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
    public boolean actualizarTpArticulo(int id, String nombre) {
       
         boolean resultado=false;
        try {
            String sql="UPDATE tp_articulo SET nombre='"+ nombre +"' WHERE id="+id;
            conex.conexion();
            Statement st=conex.conex.createStatement();
            int valor=st.executeUpdate(sql);
            if(valor>0){
                resultado=true;
            }
            //Se cierran conexiones
            conex.conex.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar."+ e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet cargarTablaTpArticulo(){
        ResultSet resultado = null;
        try {
            String query = "Select id, nombre from tp_articulo";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
    
}
