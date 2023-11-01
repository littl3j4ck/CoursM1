package HelloApp;

import org.omg.CosNaming.*; // inclure le service de nommage
import org.omg.CORBA.*; // manipuler des objets CORBA

public class HelloClientApp {
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
            String nom = "MyHello";
            Hello helloRef = HelloHelper.narrow(ncRef.resolve_str(nom));
            // faire appel a l'objet serveur et imprimer les resultats
            String msg = helloRef.sayHello("Toto");
            System.out.println(msg);
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
            e.printStackTrace(System.out);
        }
    } // fin du main
} // fin de la classe HelloClient
