import conexion.*;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;


public class Articulo extends ArticuloApp.ArticuloPOA{
    
    private ORB orb;
    Conexion conex = new Conexion();

    @Override
    public boolean insertarArticulo(int id_articulo, int id_tpArticulo, int cantidad, int precio, String estado) {
        
        boolean resultado = false;
        try {
            String query = "Insert into articulo(id_articulo,id_tpArticulo,cantidad,precio,estado)"
                    + "values ('"+id_articulo+"','"+id_tpArticulo+"','"+cantidad+"','"+precio+"','"+estado+"')";
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
    public boolean eliminarArticulo(int id_articulo) {
        
        boolean resultado = false;
        try {
            String query = "Delete from articulo where id_articulo = "+id_articulo;
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
    public boolean actualizarArticulo(int id_articulo, int id_tpArticulo, int cantidad, int precio, String estado) {
        boolean resultado = false;
        try {
            String query = "Update articulo set id_tpArticulo='"+id_tpArticulo+"',cantidad='"+cantidad+"',precio='"+precio+"',estado='"+estado+"'"
                    + " where id_articulo='"+id_articulo+"'";
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
    
    public ResultSet listaEstados(){
        ResultSet resultado = null;
        
        try {
            String query = "Select id_estado, nombre from estado";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " +e.getMessage());
        }
        
        return resultado;
    }
    
    public ResultSet cargarTablaArticulo(){
        ResultSet resultado = null;
        try {
            String query = "Select id_articulo, id_tpArticulo, cantidad, precio, estado from articulo";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            resultado = st.executeQuery(query);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error " + e.getMessage());
        }
        return resultado;
    }
}
