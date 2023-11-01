package Serveur;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import Serveur.Ibooks;

public class AppliServeur 
{
		public static void main(String[] args) throws Exception 
		{
			try 
			{
				//Démarrage de RMI registery
				System.out.println("RMIRegistry en cours de démarrage...");
				LocateRegistry.createRegistry(1099);
				System.out.println("RMIRegistry démarrée.");
				//définition de l'URL de connexion et enregistrement dans le registre RMI. 
				Serverlibrary library = new Serverlibrary();
				Naming.rebind("Serveur", library);
				System.out.println("le serveur RMI est disponible");
				
			}
			catch (Exception e)
			{
				System.out.println("Connexion impossible");
			}
			
		}

}
