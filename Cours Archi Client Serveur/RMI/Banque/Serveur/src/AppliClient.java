import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class AppliClient {
	
	public static void main(String[] args) throws Exception{
		
		//Récupérer l'objet distant
		ICompte cpt = (ICompte) Naming.lookup("c1");
		
		//Interagir avec l'objet distant
		System.out.println(cpt.infosCompte());
		
		cpt.debiter(100);
		System.out.println(cpt.infosCompte());
		cpt.crediter(400);
		System.out.println(cpt.infosCompte());
	}

}
