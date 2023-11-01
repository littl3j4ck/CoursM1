import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class AppliServeur {

	public static void main(String[] args) throws Exception {
		
		//Démarrage du RMIRegistry depuis le code
		System.out.println("Démarrage du RMIRegistry...");
		LocateRegistry.createRegistry(1099);
		//Création de l'objet distant
		System.out.println("Création du compte...");
		ICompte cpt = new Compte("Dupont", 300);
		
		//Déploiement de l'objet distant
		System.out.println("Déploiment du compte...");
		Naming.rebind("c1", cpt);
		
		System.out.println("Serveur prêt et l'écoute...");
		
	}
}
