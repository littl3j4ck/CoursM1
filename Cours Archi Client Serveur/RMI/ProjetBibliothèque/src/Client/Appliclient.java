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
			//on vérifie que la connexion s'effectue bien et que il s'agit d'une instance de Ibooks.
			if (connexion instanceof Ibooks) 
			 	{
				 //On le signal
				 System.out.println("Instance initié...");
				 //Debut de la boucle "action utilisateur"
				 while (Sortie == 0)
						 {
					 		//première liste de choix
					 		reponse ="";
					 		System.out.println("Que souhaitez vous faire?");
					 		System.out.println("1:Afficher une liste globale des attributs.");
					 		System.out.println("2:Voir et manipuler des attributs spécifiques.");
					 		System.out.println("0:Quitter l'application.");
					 		reponse = saisi.nextLine();
					 		reponse = reponse.trim();
					 		//Si la réponse vaut 1, on entre dans la première catégorie.
					 		if (reponse.equals("1"))
					 		{
					 			while (SortieCat == 0) 
					 			{	
					 				System.out.println("veuillez choisir une action.");
					 				System.out.println("1:Obtenir la liste des livres.");
					 				System.out.println("2:obtenir la liste des auteurs.");
					 				System.out.println("3:obtenir la liste des catégories.");
					 				System.out.println("4:obtenir la liste des types de livres.");
					 				System.out.println("5:obtenir la liste des différents types d'éditions.");
					 				System.out.println("0:quitter.");
					 				reponse = saisi.nextLine();
					 				//je m'assure que il n'y a pas de problèmes d'espace en début ou fin de chaine.
					 				reponse = reponse.trim();
					 				System.out.println("choix = "+reponse);
					 				//Reponse 1: On affiche la liste des livres de la base de données.
					 				if (reponse.equals("1"))
					 				{
					 					System.out.println(((Ibooks) connexion).getListTitre());
					 					
					 				}
					 				else
					 				{
					 					//Reponse 2: On affiche la liste des auteur présent dans la BD.
					 					if (reponse.equals("2"))
					 					{
					 						System.out.println(((Ibooks) connexion).getListAuthor());
					 					}
					 					else
					 					{
					 						//Reponse 3: On affiche la liste des différentes catégories de livres de la base de données.
					 						if (reponse.equals("3"))
					 						{
					 							System.out.println(((Ibooks) connexion).getListCat());
					 						}
					 						else
					 						{
					 							//Reponse 4: On affiche la liste des différents types de livres dans la bd. 
					 							if (reponse.equals("4"))
					 							{
					 								System.out.println(((Ibooks) connexion).getListType());
					 							}
					 							else
					 							{
					 								//Reponse 5: On affiche la liste des editions présents dans la BD.
					 								if (reponse.equals("5"))
					 								{
					 									System.out.println(((Ibooks) connexion).getListEdition());
					 								}
					 								else
					 								{	//reponse 0: on sort de la catégorie et on repart vers la liste principale
					 									if (reponse.equals("0"))
					 									{
					 										System.out.println("sortie de la catégorie");
					 										SortieCat = 1;
					 										reponse = "";
					 									}
					 									//si l'utilisateur à rentrer les mauvais caractères. 
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
					 		//si la réponse vaut 2, on rentre dans l'autre catégorie. 
					 		if (reponse.equals("2"))
					 		{
					 			while (SortieCat == 0)
					 			{
					 				System.out.println("veuillez choisir une action.");		 
					 				System.out.println("1:Rajouter un livre.");
					 				System.out.println("2:Obtenir le nombre de pages d'un livre.");
					 				System.out.println("3:définir le nombre de pages d'un livre.");
					 				System.out.println("4:obtenir l'auteur d'un livre.");
					 				System.out.println("5:définir l'auteur d'un livre.");
					 				System.out.println("6:changer le titre d'un livre.");
					 				System.out.println("7:obtenir la catégorie d'un livre.");
					 				System.out.println("8:definir la catégorie d'un livre.");
					 				System.out.println("9:obtenir le type d'un livre.");
					 				System.out.println("10:définir le type d'un livre.");
					 				System.out.println("11:obtenir l'édition d'un livre.");
					 				System.out.println("12:définir l'édition d'un livre.");
					 				System.out.println("0:quitter.");
					 				reponse = saisi.nextLine();
					 				//on vérifie que il n'y est pas d'espace au début et fin de la chaine de caractères. 
					 				reponse = reponse.trim();
					 				System.out.println("choix = "+reponse);
					 				//Reponse 1: On rajoute un live.
					 				if (reponse.equals("1"))
					 				{
					 					System.out.println("Rajout d'un livre. Definition des différents éléments");
					 					System.out.println("Titre?");
					 					Titre = saisi.nextLine();
					 					System.out.println("Auteur?");
					 					Author = saisi.nextLine();
					 					System.out.println("catégorie");
					 					Cat = saisi.nextLine();
					 					System.out.println("Type?");
					 					Type = saisi.nextLine();
					 					System.out.println("Edition?");
					 					Edition = saisi.nextLine();
					 					System.out.println("nombre de pages?");
					 					reponse = saisi.nextLine();
					 					pages = Integer.parseInt(reponse);
					 					System.out.println("Mise à jour de la base de données en cours...");
					 					((Ibooks) connexion).SetBook(Titre, Author, Cat, Type, Edition, pages);
					 					System.out.println("Mise à jour effectué.");
					 				}
					 				else
					 				{
					 					//Reponse 2: On récupère le nombre de pages d'un livre.
					 					if (reponse.equals("2"))
					 					{
					 						System.out.println("De quel livre voulez vous le nombre de pages?");
					 						Titre = saisi.nextLine();
					 						System.out.println(((Ibooks) connexion).getPages(Titre)+" pages");
					 					}
					 					else
					 					{
					 						//Reponse 3: On défini le nombre de pages d'un livre.
					 						if (reponse.equals("3"))
					 						{
					 							System.out.println("de quel livre doit on modifier le nombre de pages?");
					 							Titre = saisi.nextLine();
					 							System.out.println("Combien de pages pour le livre \""+Titre+"\" ?");
					 							reponse = saisi.nextLine();
					 							pages = Integer.parseInt(reponse);
					 							System.out.println("Mise à jour de la base de données en cours...");
					 							System.out.println(((Ibooks) connexion).setPages(Titre,pages));
					 							System.out.println(pages+"ont été mise au livre \""+Titre+"\"");
					 						}
					 						else
					 						{
					 							//Reponse 4:On récupère l'auteur d'un livre
					 							if (reponse.equals("4"))
					 							{
					 								System.out.println("de quel livre souhaitez vous connaitre l'auteur ?");
					 								Titre = saisi.nextLine();
					 								System.out.println("l'auteur de "+Titre+" est "+((Ibooks) connexion).GetAuthor (Titre));
					 							}
					 							//Reponse 5:On défini l'auteur d'un livre
					 							else
					 							{
					 								if (reponse.equals("5"))
					 								{
					 									System.out.println("De quel livre souhaitez vous changer l'auteur?");
					 									Titre = saisi.nextLine();
					 									System.out.println("Qui est le nouveau auteur?");
					 									Author = saisi.nextLine();
					 									System.out.println("Mise à jour de la base de données en cours...");
					 									((Ibooks) connexion).SetAuthor(Titre, Author);
					 									System.out.println("auteur modifié.");
					 								}
					 								else
					 								{
					 									//Reponse 6:on défini le titre d'un livre
					 									if (reponse.equals("6"))
					 									{
					 										System.out.println("De quel livre souhaitez vous changer le titre?");
					 										reponse = saisi.nextLine();
					 										System.out.println("Quel est son nouveau titre?");
					 										Titre = saisi.nextLine();
					 										System.out.println("Mise à jour de la base de données en cours...");
					 										((Ibooks) connexion).SetTitre(reponse, Titre);
					 										System.out.println("Changement effectué.");
					 									}
					 									else
					 									{
					 										//Reponse 7:on récupère la catégorie d'un livre
					 										if (reponse.equals("7"))
					 										{
					 											System.out.println("De quel livre voulez vous connaitre la catégorie?");
					 											Titre = saisi.nextLine();
					 											System.out.println(((Ibooks) connexion).GetCat(Titre));
					 										}
					 										else
					 										{
					 											//Reponse 8: On modifie la catégorie d'un livre
					 											if (reponse.equals("8"))
					 											{
					 												System.out.println("De quel livre voulez vous modifier la catégorie?");
					 												Titre = saisi.nextLine();
					 												System.out.println("Quel est la nouvelle catégorie?");
					 												Cat = saisi.nextLine();
					 												System.out.println("Mise à jour de la base de données en cours...");
					 												((Ibooks) connexion).SetCat(Titre, Cat);
					 												System.out.println("Catégorie modifié.");
					 											}
					 											else
					 											{
					 												//réponse 9:On récupère le type d'un livre
					 												if (reponse.equals("9"))
					 												{
					 													System.out.println("De quel livre voulez vous connaitre le type?");
					 													Titre = saisi.nextLine();
					 													System.out.println(((Ibooks) connexion).GetType(Titre));
					 												}
					 												//réponse 10:On défini le type d'un livre
					 												else
					 												{
					 													if (reponse.equals("10"))
					 													{
					 														System.out.println("De quel livre voulez vous modifier le type?");
					 														Titre = saisi.nextLine();
					 														System.out.println("Quel est le nouveau type?");
					 														Type = saisi.nextLine();
					 														System.out.println("Mise à jour de la base de données en cours...");
					 														((Ibooks) connexion).SetType(Titre, Type);
					 														System.out.println("Changement effectué.");
					 													}
					 													else
					 													{
					 														//réponse 11:On récupère l'édition d'un livre
					 														if (reponse.equals("11"))
					 														{
					 															System.out.println("De quel livre voulez vous connaitre l'édition?");
					 															Titre = saisi.nextLine();
					 															System.out.println(((Ibooks) connexion).GetEdition(Titre));
					 														}
					 														else
					 														{
					 															//Réponse 12:On défini l'édition d'un livre
					 															if (reponse.equals("12"))
					 															{
					 																System.out.println("De quel livre voulez vous changez l'édition?");
					 																Titre = saisi.nextLine();
					 																System.out.println("Quel est la nouvelle édition?");
					 																Edition = saisi.nextLine();
					 																System.out.println("Mise à jour de la base de données en cours...");
					 																System.out.println(((Ibooks) connexion).SetEdition(Titre, Edition));
					 																System.out.println("changement effectué.");
					 															}
					 															else
					 																if(reponse.equals("0"))
					 																{
					 																	System.out.println("sortie de la catégorie");
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
					 		//réponse 0:on quitte l'appli. 
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
			// à la fin de l'application, on ferme la saisi utilisateur. 
			 saisi.close();
		}
}
	

	
	

