package Client;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public interface Ibooks extends Remote
{
	//--Méthode permetant d'effectuer une liste selon un argument--
	//====================================================================//
	//--Méthode pour une liste d'après le titre--
		public ResultSetMetaData getListTitre() throws RemoteException;
	//--Méthode pour une liste selon l'auteur--
		public ResultSetMetaData getListAuthor() throws RemoteException;
	//--méthode pour une liste selon la catégorie--
		public ResultSetMetaData getListCat() throws RemoteException;
	//--méthode pour une liste selon le type--
		public ResultSetMetaData getListType() throws RemoteException;
	//--méthode pour une liste selon l'édition--
		public ResultSetMetaData getListEdition() throws RemoteException;
	//====================================================================//
		//--Méthodes pour afficher une info spécifique et les modifier
	//====================================================================//
	//--méthode pour rajouter  un livre--
		public ResultSetMetaData SetBook (String Titre,String Author,String Cat,String Type,String Edition,int pages) throws RemoteException;
	//--Méthode pour les pages--
		public ResultSetMetaData getPages(String Titre) throws RemoteException;
		public ResultSetMetaData setPages(String Titre,int pages) throws RemoteException;
	//--méthode pour les auteurs--
		public ResultSetMetaData GetAuthor (String Titre) throws RemoteException;
		public ResultSetMetaData SetAuthor (String Titre,String Author) throws RemoteException;
	//--méthode pour changer le titre d'un livre--
		public ResultSetMetaData SetTitre (String OldTitre,String NewTitre) throws RemoteException;
	//--Méthode pour les catégories--
		public ResultSetMetaData GetCat (String Titre) throws RemoteException;
		public ResultSetMetaData SetCat (String Titre,String Cat) throws RemoteException;
	//--méthode pour les types--
		public ResultSetMetaData GetType (String Titre) throws RemoteException;
		public ResultSetMetaData SetType (String Titre,String Type) throws RemoteException;
	//--méthode pour les éditions--
		public ResultSetMetaData GetEdition (String Titre) throws RemoteException;
		public ResultSetMetaData SetEdition (String Titre,String Edition) throws RemoteException;
}


