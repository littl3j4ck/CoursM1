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

// le servant hérite du squelette ReversePOA
class ReverseServant extends ReversePOA {
	public String reverseString(String chaineOrigine) {
		int longueur = chaineOrigine.length();
		StringBuffer temp = new StringBuffer(longueur);
		for (int i = longueur; i > 0; i--) {
			temp.append(chaineOrigine.substring(i - 1, i));
		}
		return temp.toString();
	}
} // fin de ReverseServant