import ReverseApp.*; // le package qui contient les stubs
import org.omg.CosNaming.*; // inclure le service de nommage
import org.omg.CORBA.*; // manipuler des objets CORBA
import org.omg.CosNaming.NamingContextPackage.*;

public class ReverseClient {
	public static void main(String args[]) {
		try {
			// creer et initialiser l'ORB
			ORB orb = ORB.init(args, null);
			// obtenir une reference au service de nommage
			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			// Utiliser NamingContextExt au lieu de NamingContext.
			// car interoperable
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
			// demander la reference de l'objet au service de noms
			String nom = "MyReverse";
			Reverse reverseRef = ReverseHelper.narrow(ncRef.resolve_str(nom));
			// faire appel a l'objet serveur et imprimer les resultats
			String res = reverseRef.reverseString(args[0]);
			System.out.println("la chaine inversee de " + args[0] + " est : "
					+ res);
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
			e.printStackTrace(System.out);
		}
	} // fin du main
} // fin de la classe ReverseClient