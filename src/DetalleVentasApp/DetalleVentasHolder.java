package DetalleVentasApp;

/**
* DetalleVentasApp/DetalleVentasHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from DetalleVentas.idl
* mi�rcoles 14 de noviembre de 2018 10:57:43 PM COT
*/

public final class DetalleVentasHolder implements org.omg.CORBA.portable.Streamable
{
  public DetalleVentasApp.DetalleVentas value = null;

  public DetalleVentasHolder ()
  {
  }

  public DetalleVentasHolder (DetalleVentasApp.DetalleVentas initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DetalleVentasApp.DetalleVentasHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DetalleVentasApp.DetalleVentasHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DetalleVentasApp.DetalleVentasHelper.type ();
  }

}
