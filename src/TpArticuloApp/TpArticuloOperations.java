package TpArticuloApp;


/**
* TpArticuloApp/TpArticuloOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from TpArticulo.idl
* mi�rcoles 31 de octubre de 2018 09:34:27 PM COT
*/

public interface TpArticuloOperations 
{
  boolean insertarTpArticulo (String nombre);
  boolean eliminarTpArticulo (int id);
  boolean actualizarTpArticulo (int id, String nombre);
  void shutdown ();
} // interface TpArticuloOperations
