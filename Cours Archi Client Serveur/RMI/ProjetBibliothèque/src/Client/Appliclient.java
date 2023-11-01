package Client;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.util.Scanner;
import Serveur.Ibooks;
import java.io.Serializable;

public class Appliclient implements Serializable {
	public static void main(String[] args) throws Exception
	{
		
			//variables de connexion vers le serveur.
			Remote connexion = Naming.lookup("rmi://127.0.0.1/Serveur");
			System.out.println(connexion);
			//variables pour la communication Homme/Programmes.
			Scanner saisi = new Scanner(System.in);
			String reponse;
			//Variable de bouclage
			int Sortie = 0;
			int SortieCat = 0;
			//Variables concernant les livres.
			String Titre;
			String Author;
			String Cat;
			String Type;
			String Edition;
			int pages;
			///Debut du corps du programme client
			//on v�rifie que la connexion s'effectue bien et que il s'agit d'une instance de Ibooks.
			if (connexion instanceof Ibooks) 
			 	{
				 //On le signal
				 System.out.println("Instance initi�...");
				 //Debut de la boucle "action utilisateur"
				 while (Sortie == 0)
						 {
					 		//premi�re liste de choix
					 		reponse ="";
					 		System.out.println("Que souhaitez vous faire?");
					 		System.out.println("1:Afficher une liste globale des attributs.");
					 		System.out.println("2:Voir et manipuler des attributs sp�cifiques.");
					 		System.out.println("0:Quitter l'application.");
					 		reponse = saisi.nextLine();
					 		reponse = reponse.trim();
					 		//Si la r�ponse vaut 1, on entre dans la premi�re cat�gorie.
					 		if (reponse.equals("1"))
					 		{
					 			while (SortieCat == 0) 
					 			{	
					 				System.out.println("veuillez choisir une action.");
					 				System.out.println("1:Obtenir la liste des livres.");
					 				System.out.println("2:obtenir la liste des auteurs.");
					 				System.out.println("3:obtenir la liste des cat�gories.");
					 				System.out.println("4:obtenir la liste des types de livres.");
					 				System.out.println("5:obtenir la liste des diff�rents types d'�ditions.");
					 				System.out.println("0:quitter.");
					 				reponse = saisi.nextLine();
					 				//je m'assure que il n'y a pas de probl�mes d'espace en d�but ou fin de chaine.
					 				reponse = reponse.trim();
					 				System.out.println("choix = "+reponse);
					 				//Reponse 1: On affiche la liste des livres de la base de donn�es.
					 				if (reponse.equals("1"))
					 				{
					 					System.out.println(((Ibooks) connexion).getListTitre());
					 					
					 				}
					 				else
					 				{
					 					//Reponse 2: On affiche la liste des auteur pr�sent dans la BD.
					 					if (reponse.equals("2"))
					 					{
					 						System.out.println(((Ibooks) connexion).getListAuthor());
					 					}
					 					else
					 					{
					 						//Reponse 3: On affiche la liste des diff�rentes cat�gories de livres de la base de donn�es.
					 						if (reponse.equals("3"))
					 						{
					 							System.out.println(((Ibooks) connexion).getListCat());
					 						}
					 						else
					 						{
					 							//Reponse 4: On affiche la liste des diff�rents types de livres dans la bd. 
					 							if (reponse.equals("4"))
					 							{
					 								System.out.println(((Ibooks) connexion).getListType());
					 							}
					 							else
					 							{
					 								//Reponse 5: On affiche la liste des editions pr�sents dans la BD.
					 								if (reponse.equals("5"))
					 								{
					 									System.out.println(((Ibooks) connexion).getListEdition());
					 								}
					 								else
					 								{	//reponse 0: on sort de la cat�gorie et on repart vers la liste principale
					 									if (reponse.equals("0"))
					 									{
					 										System.out.println("sortie de la cat�gorie");
					 										SortieCat = 1;
					 										reponse = "";
					 									}
					 									//si l'utilisateur � rentrer les mauvais caract�res. 
					 									else 
					 									{
					 										System.out.println("le choix "+reponse+" n'est pas valide. Veuillez recommencez.");
					 									}
					 								}
					 							}
					 						}
					 					}
					 				}
					 			}
					 		}
					 		//si la r�ponse vaut 2, on rentre dans l'autre cat�gorie. 
					 		if (reponse.equals("2"))
					 		{
					 			while (SortieCat == 0)
					 			{
					 				System.out.println("veuillez choisir une action.");		 
					 				System.out.println("1:Rajouter un livre.");
					 				System.out.println("2:Obtenir le nombre de pages d'un livre.");
					 				System.out.println("3:d�finir le nombre de pages d'un livre.");
					 				System.out.println("4:obtenir l'auteur d'un livre.");
					 				System.out.println("5:d�finir l'auteur d'un livre.");
					 				System.out.println("6:changer le titre d'un livre.");
					 				System.out.println("7:obtenir la cat�gorie d'un livre.");
					 				System.out.println("8:definir la cat�gorie d'un livre.");
					 				System.out.println("9:obtenir le type d'un livre.");
					 				System.out.println("10:d�finir le type d'un livre.");
					 				System.out.println("11:obtenir l'�dition d'un livre.");
					 				System.out.println("12:d�finir l'�dition d'un livre.");
					 				System.out.println("0:quitter.");
					 				reponse = saisi.nextLine();
					 				//on v�rifie que il n'y est pas d'espace au d�but et fin de la chaine de caract�res. 
					 				reponse = reponse.trim();
					 				System.out.println("choix = "+reponse);
					 				//Reponse 1: On rajoute un live.
					 				if (reponse.equals("1"))
					 				{
					 					System.out.println("Rajout d'un livre. Definition des diff�rents �l�ments");
					 					System.out.println("Titre?");
					 					Titre = saisi.nextLine();
					 					System.out.println("Auteur?");
					 					Author = saisi.nextLine();
					 					System.out.println("cat�gorie");
					 					Cat = saisi.nextLine();
					 					System.out.println("Type?");
					 					Type = saisi.nextLine();
					 					System.out.println("Edition?");
					 					Edition = saisi.nextLine();
					 					System.out.println("nombre de pages?");
					 					reponse = saisi.nextLine();
					 					pages = Integer.parseInt(reponse);
					 					System.out.println("Mise � jour de la base de donn�es en cours...");
					 					((Ibooks) connexion).SetBook(Titre, Author, Cat, Type, Edition, pages);
					 					System.out.println("Mise � jour effectu�.");
					 				}
					 				else
					 				{
					 					//Reponse 2: On r�cup�re le nombre de pages d'un livre.
					 					if (reponse.equals("2"))
					 					{
					 						System.out.println("De quel livre voulez vous le nombre de pages?");
					 						Titre = saisi.nextLine();
					 						System.out.println(((Ibooks) connexion).getPages(Titre)+" pages");
					 					}
					 					else
					 					{
					 						//Reponse 3: On d�fini le nombre de pages d'un livre.
					 						if (reponse.equals("3"))
					 						{
					 							System.out.println("de quel livre doit on modifier le nombre de pages?");
					 							Titre = saisi.nextLine();
					 							System.out.println("Combien de pages pour le livre \""+Titre+"\" ?");
					 							reponse = saisi.nextLine();
					 							pages = Integer.parseInt(reponse);
					 							System.out.println("Mise � jour de la base de donn�es en cours...");
					 							System.out.println(((Ibooks) connexion).setPages(Titre,pages));
					 							System.out.println(pages+"ont �t� mise au livre \""+Titre+"\"");
					 						}
					 						else
					 						{
					 							//Reponse 4:On r�cup�re l'auteur d'un livre
					 							if (reponse.equals("4"))
					 							{
					 								System.out.println("de quel livre souhaitez vous connaitre l'auteur ?");
					 								Titre = saisi.nextLine();
					 								System.out.println("l'auteur de "+Titre+" est "+((Ibooks) connexion).GetAuthor (Titre));
					 							}
					 							//Reponse 5:On d�fini l'auteur d'un livre
					 							else
					 							{
					 								if (reponse.equals("5"))
					 								{
					 									System.out.println("De quel livre souhaitez vous changer l'auteur?");
					 									Titre = saisi.nextLine();
					 									System.out.println("Qui est le nouveau auteur?");
					 									Author = saisi.nextLine();
					 									System.out.println("Mise � jour de la base de donn�es en cours...");
					 									((Ibooks) connexion).SetAuthor(Titre, Author);
					 									System.out.println("auteur modifi�.");
					 								}
					 								else
					 								{
					 									//Reponse 6:on d�fini le titre d'un livre
					 									if (reponse.equals("6"))
					 									{
					 										System.out.println("De quel livre souhaitez vous changer le titre?");
					 										reponse = saisi.nextLine();
					 										System.out.println("Quel est son nouveau titre?");
					 										Titre = saisi.nextLine();
					 										System.out.println("Mise � jour de la base de donn�es en cours...");
					 										((Ibooks) connexion).SetTitre(reponse, Titre);
					 										System.out.println("Changement effectu�.");
					 									}
					 									else
					 									{
					 										//Reponse 7:on r�cup�re la cat�gorie d'un livre
					 										if (reponse.equals("7"))
					 										{
					 											System.out.println("De quel livre voulez vous connaitre la cat�gorie?");
					 											Titre = saisi.nextLine();
					 											System.out.println(((Ibooks) connexion).GetCat(Titre));
					 										}
					 										else
					 										{
					 											//Reponse 8: On modifie la cat�gorie d'un livre
					 											if (reponse.equals("8"))
					 											{
					 												System.out.println("De quel livre voulez vous modifier la cat�gorie?");
					 												Titre = saisi.nextLine();
					 												System.out.println("Quel est la nouvelle cat�gorie?");
					 												Cat = saisi.nextLine();
					 												System.out.println("Mise � jour de la base de donn�es en cours...");
					 												((Ibooks) connexion).SetCat(Titre, Cat);
					 												System.out.println("Cat�gorie modifi�.");
					 											}
					 											else
					 											{
					 												//r�ponse 9:On r�cup�re le type d'un livre
					 												if (reponse.equals("9"))
					 												{
					 													System.out.println("De quel livre voulez vous connaitre le type?");
					 													Titre = saisi.nextLine();
					 													System.out.println(((Ibooks) connexion).GetType(Titre));
					 												}
					 												//r�ponse 10:On d�fini le type d'un livre
					 												else
					 												{
					 													if (reponse.equals("10"))
					 													{
					 														System.out.println("De quel livre voulez vous modifier le type?");
					 														Titre = saisi.nextLine();
					 														System.out.println("Quel est le nouveau type?");
					 														Type = saisi.nextLine();
					 														System.out.println("Mise � jour de la base de donn�es en cours...");
					 														((Ibooks) connexion).SetType(Titre, Type);
					 														System.out.println("Changement effectu�.");
					 													}
					 													else
					 													{
					 														//r�ponse 11:On r�cup�re l'�dition d'un livre
					 														if (reponse.equals("11"))
					 														{
					 															System.out.println("De quel livre voulez vous connaitre l'�dition?");
					 															Titre = saisi.nextLine();
					 															System.out.println(((Ibooks) connexion).GetEdition(Titre));
					 														}
					 														else
					 														{
					 															//R�ponse 12:On d�fini l'�dition d'un livre
					 															if (reponse.equals("12"))
					 															{
					 																System.out.println("De quel livre voulez vous changez l'�dition?");
					 																Titre = saisi.nextLine();
					 																System.out.println("Quel est la nouvelle �dition?");
					 																Edition = saisi.nextLine();
					 																System.out.println("Mise � jour de la base de donn�es en cours...");
					 																System.out.println(((Ibooks) connexion).SetEdition(Titre, Edition));
					 																System.out.println("changement effectu�.");
					 															}
					 															else
					 																if(reponse.equals("0"))
					 																{
					 																	System.out.println("sortie de la cat�gorie");
					 																}
					 																else
					 																{
					 																	System.out.println("le choix "+reponse+" n'est pas valide. Veuillez recommencez.");
					 																}
					 														}
					 													}
					 												}
					 											}
					 										}
					 									}
					 								}
					 							}
					 						}
					 					}
					 				}
					 			}
					 		}
					 		//r�ponse 0:on quitte l'appli. 
					 		if (reponse.equals("0"))
					 		{
					 			System.out.println("sortie de l'application");
					 			Sortie = 1;
					 		}
					 		else 
					 		{
					 			System.out.println("le choix "+reponse+" n'est pas valide. Veuillez recommencez.");
					 		}
						 
						 }
			 	}
			
				 else
			 		{
					System.out.println("Impossible d'initialiser l'instance.");
			 		}
			// � la fin de l'application, on ferme la saisi utilisateur. 
			 saisi.close();
		}
}
	

	
	

