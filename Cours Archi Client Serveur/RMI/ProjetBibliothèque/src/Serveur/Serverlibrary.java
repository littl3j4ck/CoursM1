package Serveur;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.io.Serializable;
import java.sql.Statement;
import Serveur.Ibooks;
import java.rmi.RemoteException;


public class Serverlibrary extends UnicastRemoteObject implements Ibooks,Serializable 
{
	private static final long serialVersionUID = 1L;
	
	protected Serverlibrary() throws RemoteException 
	{
		super();
	}
	
	//variables pour la base de données
	String Titre;
	String Author;
	String Cat;
	String Type;
	String Edition;
	int pages;
	boolean rajout;
	int ID;
	// variables de connexion à la base de données.
	String url ="jdbc:postgresql://localhost:5432/Bookshelf";
	String user ="postgres";
	String pass ="azerty";
	
	
	


	
	//on récupère la liste des livres contenu dans la base de donnée.
	public ResultSetMetaData getListTitre() throws RemoteException 
	{
		try 
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta ;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	//on récupère la liste des auteurs contenu dans la bd.
	public ResultSetMetaData getListAuthor() throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"auteur\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;	
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère la liste des catégories contenu dans la bd.
	public ResultSetMetaData getListCat() throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"catégorie\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère la liste des types contenu dans la bd.
	public ResultSetMetaData getListType() throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"type\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère la liste des editions dans la bases de données.
	public ResultSetMetaData getListEdition() throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"edition\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on rajoute un nouveau livre dans la base de données.
	public ResultSetMetaData SetBook(String Titre, String Author, String Cat, String Type, String Edition, int pages) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("INSERT INTO public.\"Books\" VALUES ('"+Titre+"','"+Author+"','"+Cat+"','"+Type+"','"+Edition+"','"+pages+"')");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère le nombre de pages d'un livre.
	public ResultSetMetaData getPages(String Titre) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("\"SELECT \"Titre\",\"pages\" FROM public.\"Books\" WHERE \"Titre\" = \"+Titre+\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on défini le nombre de pages d'un livre.
	public ResultSetMetaData setPages(String Titre, int pages) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"pages\" = '"+pages+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}


	//on récupère l'auteur d'un livre.
	public ResultSetMetaData GetAuthor(String Titre) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"auteur\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on défini l'auteur d'un livre.
	public ResultSetMetaData SetAuthor(String Titre, String Author) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"auteur\" = '"+Author+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on modifie le titre d'un livre.
	public ResultSetMetaData SetTitre(String OldTitre, String NewTitre) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"auteur\" = '"+NewTitre+"' WHERE \"Titre\" = '"+OldTitre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère la catégorie d'un livre.
	public ResultSetMetaData GetCat(String Titre) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"catégorie\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on défini la catégorie d'un livre.
	public ResultSetMetaData SetCat(String Titre, String Cat) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"catégorie\" = '"+Cat+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère le type d'un livre.
	public ResultSetMetaData GetType(String Titre) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"type\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on défini le type d'un livre.
	public ResultSetMetaData SetType(String Titre, String Type) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"type\" = '"+Type+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on récupère l'édition d'un livre.
	public ResultSetMetaData GetEdition(String Titre) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"edition\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on défini l'édition d'un livre. 
	public ResultSetMetaData SetEdition(String Titre, String Edition) throws RemoteException 
	{
		try
		{
			//connexion à la base de données.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//exécution de la requête et récuperation du résultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"edition\" = '"+Edition+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le résultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
