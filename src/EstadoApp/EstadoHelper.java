package EstadoApp;


/**
* EstadoApp/EstadoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Estado.idl
* lunes 29 de octubre de 2018 03:24:18 PM COT
*/

abstract public class EstadoHelper
{
  private static String  _id = "IDL:EstadoApp/Estado:1.0";

  public static void insert (org.omg.CORBA.Any a, EstadoApp.Estado that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static EstadoApp.Estado extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (EstadoApp.EstadoHelper.id (), "Estado");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static EstadoApp.Estado read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_EstadoStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, EstadoApp.Estado value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static EstadoApp.Estado narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof EstadoApp.Estado)
      return (EstadoApp.Estado)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      EstadoApp._EstadoStub stub = new EstadoApp._EstadoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static EstadoApp.Estado unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof EstadoApp.Estado)
      return (EstadoApp.Estado)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      EstadoApp._EstadoStub stub = new EstadoApp._EstadoStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}