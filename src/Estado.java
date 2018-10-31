import conexion.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;


public class Estado extends EstadoApp.EstadoPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarEstado(int id_estado, String nombre) {
        boolean resultado = false;
        try {
            String query = "Insert into estado(id_estado,nombre)"
                    + "values ('"+id_estado+"','"+nombre+"')";
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
    public boolean eliminarEstado(int id_estado) {
        boolean resultado = false;
        try {
            String query = "Delete from estado where id_estado = "+id_estado;
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
    public boolean actualizarEstado(int id_estado, String nombre) {
        boolean resultado = false;
        try {
            String query = "Update estado set nombre='"+nombre+"'"
                    + " where id_estado='"+id_estado+"'";
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
    
    public ResultSet cargarTablaEstado(){
        ResultSet resultado = null;
        try {
            String query = "Select id_estado, nombre from estado";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
    
}
