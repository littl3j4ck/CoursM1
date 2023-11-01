import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class AppliServeur {

	public static void main(String[] args) throws Exception {
		
		//D�marrage du RMIRegistry depuis le code
		System.out.println("D�marrage du RMIRegistry...");
		LocateRegistry.createRegistry(1099);
		//Cr�ation de l'objet distant
		System.out.println("Cr�ation du compte...");
		ICompte cpt = new Compte("Dupont", 300);
		
		//D�ploiement de l'objet distant
		System.out.println("D�ploiment du compte...");
		Naming.rebind("c1", cpt);
		
		System.out.println("Serveur pr�t et l'�coute...");
		
	}
}
