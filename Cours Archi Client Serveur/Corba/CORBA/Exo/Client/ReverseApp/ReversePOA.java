package ReverseApp;


/**
* ReverseApp/ReversePOA.java .
* Error reading Messages File.
* Error reading Messages File.
* vendredi 9 février 2018 14:46:28 heure normale d’Europe centrale
*/

public abstract class ReversePOA extends org.omg.PortableServer.Servant
 implements ReverseApp.ReverseOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("reverseString", new java.lang.Integer (0));
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
       case 0:  // ReverseApp/Reverse/reverseString
       {
         String chaineOrigine = in.read_string ();
         String $result = null;
         $result = this.reverseString (chaineOrigine);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ReverseApp/Reverse:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Reverse _this() 
  {
    return ReverseHelper.narrow(
    super._this_object());
  }

  public Reverse _this(org.omg.CORBA.ORB orb) 
  {
    return ReverseHelper.narrow(
    super._this_object(orb));
  }


} // class ReversePOA
