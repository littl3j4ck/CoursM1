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
				//D�marrage de RMI registery
				System.out.println("RMIRegistry en cours de d�marrage...");
				LocateRegistry.createRegistry(1099);
				System.out.println("RMIRegistry d�marr�e.");
				//d�finition de l'URL de connexion et enregistrement dans le registre RMI. 
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
