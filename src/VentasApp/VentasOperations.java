/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasApp;

/**
 *
 * @author yarevalo
 */
public interface VentasOperations {
    boolean insertarVentas (int id_venta, int id_Cliente);
    boolean eliminarVentas (int id_venta);
    boolean actualizarVentas (int id_venta, int id_Cliente);
    void shutdown ();
}
