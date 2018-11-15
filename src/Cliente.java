
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;


public class Cliente extends ClienteApp.ClientePOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarCliente(int identificacion, String nombre, String telefono) {
        
       boolean resultado = false;
        try {
            String query = "Insert into cliente(identificacion,nombre,telefono)"
                    + "values ("+identificacion+",'"+nombre+"','"+telefono+"')";
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
    public boolean eliminarCliente(int id_cliente) {
        
        boolean resultado = false;
        try {
            String query = "Delete from cliente where id_cliente="+id_cliente;
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
    public boolean actualizarCliente(int id_cliente,int identificacion, String nombre, String telefono) {
        
        boolean resultado = false;
        try {
            String query = "Update cliente set identificacion="+identificacion+", nombre='"+nombre+"',telefono='"+telefono+"'"
                         + " where id_cliente="+id_cliente;
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
    
    public ResultSet cargarTablaCliente(){
        ResultSet resultado = null;
        try {
            String query = "Select id_cliente,identificacion, nombre, telefono from cliente";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
    
}
