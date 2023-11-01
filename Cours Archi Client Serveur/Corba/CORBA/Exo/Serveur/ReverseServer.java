// le package qui contient les squelettes
import ReverseApp.*;
// le serveur va utiliser le service de nommage
import org.omg.CosNaming.*;
//inclure le package des exceptions pouvant etre generees
// par le service de nommage
import org.omg.CosNaming.NamingContextPackage.*;
// sert a manipuler les objets CORBA
import org.omg.CORBA.*;
// Classes necessaires pour referencer le POA
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
// Proprietes pour initialiser l'ORB
import java.util.Properties;

public class ReverseServer {
	public static void main(String args[]) {
		try {
			// creer et initialiser l'ORB qui integre
			// le service de noms
			ORB orb = ORB.init(args, null);
			// obtenir la reference de rootpoa &
			// activer le POAManager
			POA rootpoa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();
			// creer le servant
			ReverseServant revRef = new ReverseServant();
			// obtenir la reference CORBA du servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(revRef);
			Reverse href = ReverseHelper.narrow(ref);
			// obtenir la reference du contexte de nommage
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			// Utiliser NamingContextExt qui est Interoperable
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			// enregistrer le servant dans le service de nommage
			String name = "MyReverse";
			NameComponent path[] = ncRef.to_name(name);
			ncRef.rebind(path, href);
			System.out.println("ReverseServer est pret et est en attente.");
			// attendre les invocations des clients
			orb.run();
		} catch (Exception e) {
			System.err.println("Erreur : " + e);
			e.printStackTrace(System.out);
		}
	}
} // fin de ReverseServer