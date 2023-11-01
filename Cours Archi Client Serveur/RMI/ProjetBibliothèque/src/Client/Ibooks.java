package Client;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public interface Ibooks extends Remote
{
	//--M�thode permetant d'effectuer une liste selon un argument--
	//====================================================================//
	//--M�thode pour une liste d'apr�s le titre--
		public ResultSetMetaData getListTitre() throws RemoteException;
	//--M�thode pour une liste selon l'auteur--
		public ResultSetMetaData getListAuthor() throws RemoteException;
	//--m�thode pour une liste selon la cat�gorie--
		public ResultSetMetaData getListCat() throws RemoteException;
	//--m�thode pour une liste selon le type--
		public ResultSetMetaData getListType() throws RemoteException;
	//--m�thode pour une liste selon l'�dition--
		public ResultSetMetaData getListEdition() throws RemoteException;
	//====================================================================//
		//--M�thodes pour afficher une info sp�cifique et les modifier
	//====================================================================//
	//--m�thode pour rajouter  un livre--
		public ResultSetMetaData SetBook (String Titre,String Author,String Cat,String Type,String Edition,int pages) throws RemoteException;
	//--M�thode pour les pages--
		public ResultSetMetaData getPages(String Titre) throws RemoteException;
		public ResultSetMetaData setPages(String Titre,int pages) throws RemoteException;
	//--m�thode pour les auteurs--
		public ResultSetMetaData GetAuthor (String Titre) throws RemoteException;
		public ResultSetMetaData SetAuthor (String Titre,String Author) throws RemoteException;
	//--m�thode pour changer le titre d'un livre--
		public ResultSetMetaData SetTitre (String OldTitre,String NewTitre) throws RemoteException;
	//--M�thode pour les cat�gories--
		public ResultSetMetaData GetCat (String Titre) throws RemoteException;
		public ResultSetMetaData SetCat (String Titre,String Cat) throws RemoteException;
	//--m�thode pour les types--
		public ResultSetMetaData GetType (String Titre) throws RemoteException;
		public ResultSetMetaData SetType (String Titre,String Type) throws RemoteException;
	//--m�thode pour les �ditions--
		public ResultSetMetaData GetEdition (String Titre) throws RemoteException;
		public ResultSetMetaData SetEdition (String Titre,String Edition) throws RemoteException;
}


