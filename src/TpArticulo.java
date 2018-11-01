
import conexion.Conexion;
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
            String sql="INSERT INTO tp_articulos (nombre) VALUES('"+ nombre +"')";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarTpArticulo(int id, String nombre) {
       
         boolean resultado=false;
        try {
            String sql="UPDATE terceros SET nombres='"+ nombre +"' WHERE id="+id;
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

    
}
