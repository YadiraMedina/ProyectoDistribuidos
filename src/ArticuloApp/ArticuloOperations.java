package ArticuloApp;


/**
* ArticuloApp/ArticuloOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Articulo.idl
* lunes 29 de octubre de 2018 03:24:08 PM COT
*/

public interface ArticuloOperations 
{
  boolean insertarArticulo (int id_articulo, int id_tpArticulo, int cantidad, int precio, String estado);
  boolean eliminarArticulo (int id_articulo);
  boolean actualizarArticulo (int id_articulo, int id_tpArticulo, int cantidad, int precio, String estado);
  void shutdown ();
} // interface ArticuloOperations
