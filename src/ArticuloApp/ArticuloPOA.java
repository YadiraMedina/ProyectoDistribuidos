package ArticuloApp;


/**
* ArticuloApp/ArticuloPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Articulo.idl
* lunes 29 de octubre de 2018 03:24:08 PM COT
*/

public abstract class ArticuloPOA extends org.omg.PortableServer.Servant
 implements ArticuloApp.ArticuloOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("insertarArticulo", new java.lang.Integer (0));
    _methods.put ("eliminarArticulo", new java.lang.Integer (1));
    _methods.put ("actualizarArticulo", new java.lang.Integer (2));
    _methods.put ("shutdown", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ArticuloApp/Articulo/insertarArticulo
       {
         int id_articulo = in.read_long ();
         int id_tpArticulo = in.read_long ();
         int cantidad = in.read_long ();
         int precio = in.read_long ();
         String estado = in.read_wstring ();
         boolean $result = false;
         $result = this.insertarArticulo (id_articulo, id_tpArticulo, cantidad, precio, estado);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // ArticuloApp/Articulo/eliminarArticulo
       {
         int id_articulo = in.read_long ();
         boolean $result = false;
         $result = this.eliminarArticulo (id_articulo);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // ArticuloApp/Articulo/actualizarArticulo
       {
         int id_articulo = in.read_long ();
         int id_tpArticulo = in.read_long ();
         int cantidad = in.read_long ();
         int precio = in.read_long ();
         String estado = in.read_wstring ();
         boolean $result = false;
         $result = this.actualizarArticulo (id_articulo, id_tpArticulo, cantidad, precio, estado);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // ArticuloApp/Articulo/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ArticuloApp/Articulo:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Articulo _this() 
  {
    return ArticuloHelper.narrow(
    super._this_object());
  }

  public Articulo _this(org.omg.CORBA.ORB orb) 
  {
    return ArticuloHelper.narrow(
    super._this_object(orb));
  }


} // class ArticuloPOA
