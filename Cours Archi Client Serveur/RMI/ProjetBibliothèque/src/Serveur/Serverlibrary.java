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
	
	//variables pour la base de donn�es
	String Titre;
	String Author;
	String Cat;
	String Type;
	String Edition;
	int pages;
	boolean rajout;
	int ID;
	// variables de connexion � la base de donn�es.
	String url ="jdbc:postgresql://localhost:5432/Bookshelf";
	String user ="postgres";
	String pass ="azerty";
	
	
	


	
	//on r�cup�re la liste des livres contenu dans la base de donn�e.
	public ResultSetMetaData getListTitre() throws RemoteException 
	{
		try 
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta ;
		}
		catch (Exception e)
		{
			return null;
		}
	}
	//on r�cup�re la liste des auteurs contenu dans la bd.
	public ResultSetMetaData getListAuthor() throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"auteur\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;	
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re la liste des cat�gories contenu dans la bd.
	public ResultSetMetaData getListCat() throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"cat�gorie\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re la liste des types contenu dans la bd.
	public ResultSetMetaData getListType() throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"type\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re la liste des editions dans la bases de donn�es.
	public ResultSetMetaData getListEdition() throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"edition\" FROM public.\"Books\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on rajoute un nouveau livre dans la base de donn�es.
	public ResultSetMetaData SetBook(String Titre, String Author, String Cat, String Type, String Edition, int pages) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("INSERT INTO public.\"Books\" VALUES ('"+Titre+"','"+Author+"','"+Cat+"','"+Type+"','"+Edition+"','"+pages+"')");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re le nombre de pages d'un livre.
	public ResultSetMetaData getPages(String Titre) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("\"SELECT \"Titre\",\"pages\" FROM public.\"Books\" WHERE \"Titre\" = \"+Titre+\"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on d�fini le nombre de pages d'un livre.
	public ResultSetMetaData setPages(String Titre, int pages) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"pages\" = '"+pages+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}


	//on r�cup�re l'auteur d'un livre.
	public ResultSetMetaData GetAuthor(String Titre) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"auteur\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on d�fini l'auteur d'un livre.
	public ResultSetMetaData SetAuthor(String Titre, String Author) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"auteur\" = '"+Author+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
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
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"auteur\" = '"+NewTitre+"' WHERE \"Titre\" = '"+OldTitre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re la cat�gorie d'un livre.
	public ResultSetMetaData GetCat(String Titre) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"cat�gorie\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on d�fini la cat�gorie d'un livre.
	public ResultSetMetaData SetCat(String Titre, String Cat) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"cat�gorie\" = '"+Cat+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re le type d'un livre.
	public ResultSetMetaData GetType(String Titre) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"type\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on d�fini le type d'un livre.
	public ResultSetMetaData SetType(String Titre, String Type) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"type\" = '"+Type+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on r�cup�re l'�dition d'un livre.
	public ResultSetMetaData GetEdition(String Titre) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("SELECT \"Titre\",\"edition\" FROM public.\"Books\" WHERE \"Titre\" = "+Titre+"");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	//on d�fini l'�dition d'un livre. 
	public ResultSetMetaData SetEdition(String Titre, String Edition) throws RemoteException 
	{
		try
		{
			//connexion � la base de donn�es.
			Connection conn=DriverManager.getConnection(url, user, pass);
			Statement stat = conn.createStatement();
			//ex�cution de la requ�te et r�cuperation du r�sultat
			ResultSet result = stat.executeQuery("UPDATE public.\"Books\" SET \"edition\" = '"+Edition+"' WHERE \"Titre\" = '"+Titre+"'");
			ResultSetMetaData resultMeta = result.getMetaData();
			//fermeture des connexions
			result.close();
			stat.close();
			conn.close();
			//on retourne le r�sultat.
			return resultMeta;
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
