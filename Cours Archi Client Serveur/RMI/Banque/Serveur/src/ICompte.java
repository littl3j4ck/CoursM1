import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICompte extends Remote{
	
	public boolean crediter(double somme) throws RemoteException; 
	public boolean debiter(double somme) throws RemoteException;
	public String infosCompte() throws RemoteException;

}
