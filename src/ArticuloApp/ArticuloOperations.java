package ArticuloApp;


/**
* ArticuloApp/ArticuloOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Articulo.idl
* martes 13 de noviembre de 2018 10:35:12 PM COT
*/

public interface ArticuloOperations 
{
  boolean insertarArticulo (int id_tpArticulo, int cantidad, int precio, String estado, String nombre);
  boolean eliminarArticulo (int id_articulo);
  boolean actualizarArticulo (int id_articulo, int id_tpArticulo, int cantidad, int precio, String estado, String nombre);
  void shutdown ();
} // interface ArticuloOperations
