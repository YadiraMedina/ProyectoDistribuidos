package TpArticuloApp;

/**
* TpArticuloApp/TpArticuloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from TpArticulo.idl
* mi�rcoles 31 de octubre de 2018 09:34:27 PM COT
*/

public final class TpArticuloHolder implements org.omg.CORBA.portable.Streamable
{
  public TpArticuloApp.TpArticulo value = null;

  public TpArticuloHolder ()
  {
  }

  public TpArticuloHolder (TpArticuloApp.TpArticulo initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = TpArticuloApp.TpArticuloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    TpArticuloApp.TpArticuloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return TpArticuloApp.TpArticuloHelper.type ();
  }

}
