import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Compte 
	extends UnicastRemoteObject
	implements ICompte{

	//Attributs
	private String titulaire;
	private double solde;
	
	//Constructeurs
	public Compte(String titulaire) throws RemoteException {
		super();
		this.titulaire = titulaire;
		this.solde = 0;
	}
	public Compte(String titulaire, double solde) throws RemoteException {
		super();
		this.titulaire = titulaire;
		this.solde = solde;
	}

	//Services/Méthodes
	@Override
	public boolean crediter(double somme) throws RemoteException {
		System.out.println("Appel de la méthode Créditer");
		if(somme > 0){
			this.solde = this.solde + somme;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean debiter(double somme) throws RemoteException {
		System.out.println("Appel de la méthode Débiter");
		if(somme > 0 && this.solde >= somme){
			this.solde = this.solde - somme;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String infosCompte() throws RemoteException {
	
		return "Titulaire : " + this.titulaire + 
				"\nSolde : " + this.solde;
	}
}
