package ReverseApp;

/**
* ReverseApp/ReverseHolder.java .
* Error reading Messages File.
* Error reading Messages File.
* vendredi 9 février 2018 14:44:32 heure normale d’Europe centrale
*/

public final class ReverseHolder implements org.omg.CORBA.portable.Streamable
{
  public ReverseApp.Reverse value = null;

  public ReverseHolder ()
  {
  }

  public ReverseHolder (ReverseApp.Reverse initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ReverseApp.ReverseHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ReverseApp.ReverseHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ReverseApp.ReverseHelper.type ();
  }

}
