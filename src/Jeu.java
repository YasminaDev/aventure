/** @author     KADDOUH Heba 11405014, ELAZIZ Yasmina 11405067 */

import java.util.ArrayList;

/**
 *  Classe principale du jeu "Zork". <p>
 *
 *  Zork est un jeu d'aventure très rudimentaire avec une interface en mode
 *  texte: les joueurs peuvent juste se déplacer parmi les différentes pièces.
 *  Ce jeu nécessite vraiment d’être enrichi pour devenir intéressant!</p> <p>
 *
 *  Pour jouer a ce jeu, créer une instance de cette classe et appeler sa
 *  méthode "jouer". </p> <p>
 *
 *  Cette classe crée et initialise des instances de toutes les autres classes:
 *  elle crée toutes les pièces, crée l'analyseur syntaxique et démarre le jeu.
 *  Elle se charge aussi d'exécuter les commandes que lui renvoie l'analyseur
 *  syntaxique.</p>
 *
 * @author     Michael Kolling
 * @author     Marc Champesme (pour la traduction francaise)
 * @version    1.1
 * @since      March 2000
 */

public class Jeu {
	private AnalyseurSyntaxique analyseurSyntaxique;
	private Piece pieceCourante;
	private Joueur j;
	private ArrayList<Piece> listePiece;
	private ArrayList<Personnage> listePerso;
	private ArrayList<ObjetZork> listeAchat;
	private ArrayList<ObjetZork> listeObjet;
	private int minute;

	/**
	 *  Crée le jeu et initialise la carte du jeu (i.e. les pièces).
	 */
	public Jeu() {
		initialisation();
		analyseurSyntaxique = new AnalyseurSyntaxique();
		minute = 20;
	}

	/**
	 *  Crée toutes les pièces et relie leurs sorties les unes aux autres.
	 */
	public void initialisation() {

		// création des objets
		ObjetZork chocolat = new ObjetZork("chocolat",0.5,true);
		ObjetZork lait = new ObjetZork("lait",1,true);
		ObjetZork oeuf = new ObjetZork("oeuf",0.5,true);
		ObjetZork farine = new ObjetZork("farine",1,true);
		ObjetZork sucre = new ObjetZork("sucre",1,true);
		ObjetZork pain = new ObjetZork("pain",0.25,true);
		ObjetZork poulet = new ObjetZork("poulet",3,true);
		ObjetZork ingredientSecret = new ObjetZork("ingredientSecret",1,true);
		ObjetZork curry = new ObjetZork("curry",0.5,true);
		ObjetZork poivron = new ObjetZork("poivron",0.75,true);
		ObjetZork salade = new ObjetZork("salade",0.5,true);
		ObjetZork tomate = new ObjetZork("tomate",0.75,true);
		ObjetZork poisson = new ObjetZork("poisson",2,true);
		ObjetZork sel = new ObjetZork("sel",0.5,true);
		ObjetZork poivre = new ObjetZork("poivre",0.5,true);
		ObjetZork caddie = new ObjetZork("caddie",10,false);
		ObjetZork caisse = new ObjetZork("caisse",20,false);
		ObjetZork canape = new ObjetZork("canape",20,false);
		ObjetZork tv = new ObjetZork("tv",10,false);		
		ObjetZork argent = new ObjetZork("argent",1,true);
		ObjetZork sac = new ObjetZork("sac",9,true);
		ObjetZork temps = new ObjetZork("temps",0,true);
		ObjetZork salete = new ObjetZork("salete",0,false);
		ObjetZork tache = new ObjetZork("tache",0,false);
		ObjetZork couteau = new ObjetZork("couteau",0.25,true);
		ObjetZork pansement = new ObjetZork("pansement",0.25,true);
		ObjetZork desinfectant = new ObjetZork("desinfectant", 0.25,true);
		ObjetZork carotte = new ObjetZork("carotte", 0,false);
		ObjetZork kiwi = new ObjetZork("kiwi",0,false);
		ObjetZork fraise = new ObjetZork("fraise",0,false);
		ObjetZork cumin = new ObjetZork("cumin",0,false);
		ObjetZork cannelle = new ObjetZork("cannelle",0,false);
		


		// création des listes d'objets
		ArrayList<ObjetZork> listeMaison = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeDehors = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeaccueil= new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listePoissonnerie = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeBoucherie = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeEpicerie = new ArrayList<ObjetZork>();		
		ArrayList<ObjetZork> listeProduitFermier = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeFruitLegume = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeSucrerie= new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listeBoulangerie = new ArrayList<ObjetZork>();
		ArrayList<ObjetZork> listePharmacie = new ArrayList<ObjetZork>();


		// création des pièces
		Piece maison = new Piece("allongé sur le canape en face de la tele.", listeMaison);
		Piece dehors = new Piece("dans la rue.", listeDehors);
		Piece accueil = new Piece("à l’accueil du magasin.", listeaccueil);
		Piece poissonnerie = new Piece("dans le rayon poisson.", listePoissonnerie);
		Piece boucherie = new Piece("dans la boucherie.", listeBoucherie);
		Piece epicerie = new Piece("dans l'épicerie.", listeEpicerie);
		Piece produitFermier = new Piece("dans le rayon des produits fermier.", listeProduitFermier);
		Piece fruitLegume = new Piece("dans le rayon des fruits et legumes.", listeFruitLegume);
		Piece sucrerie = new Piece("dans le rayon sucrerie.", listeSucrerie);
		Piece boulangerie = new Piece("dans la boulangerie.", listeBoulangerie);
		Piece pharmacie = new Piece("dans la pharmacie.", listePharmacie);

		// Ajout de toutes les pièces à la liste de pièce
		listePiece = new ArrayList<Piece>(10);
		listePiece.add(maison);
		listePiece.add(dehors);
		listePiece.add(accueil);
		listePiece.add(poissonnerie);
		listePiece.add(boucherie);
		listePiece.add(epicerie);
		listePiece.add(produitFermier);
		listePiece.add(fruitLegume);
		listePiece.add(sucrerie);
		listePiece.add(boulangerie);
		listePiece.add(pharmacie);

		// Pour personnage mobile (employer)
		ArrayList<Piece> magasin = new ArrayList<Piece>();
			//Pièce dans laquelle l'employer peux se balader
		magasin.add(accueil);
		magasin.add(poissonnerie);
		magasin.add(boucherie);
		magasin.add(epicerie);
		magasin.add(produitFermier);
		magasin.add(fruitLegume);
		magasin.add(sucrerie);
		magasin.add(boulangerie);
		magasin.add(pharmacie);

		// création des personnage
		Personnage boulanger = new Personnage("boulanger", listePiece, new ArrayList<ObjetZork>(1), 1, boulangerie);
		Personnage boucher = new Personnage("boucher", listePiece, new ArrayList<ObjetZork>(2), 4, boucherie);
		Personnage poissonnier = new Personnage("poissonnier", listePiece, new ArrayList<ObjetZork>(2), 2.25, poissonnerie);
		Personnage caissier = new Personnage("caissier", listePiece, new ArrayList<ObjetZork>(29), 55, accueil);
		Personnage maman = new Personnage("maman", listePiece, new ArrayList<ObjetZork>(1), 9, maison);
		Personnage employer = new Personnage("employer", magasin, new ArrayList<ObjetZork>(), 0, accueil);

		// Ajout d'objet aux personnages
		maman.ajouterObjet(argent);
		employer.ajouterObjet(temps);
		
		
		
		// Ajout de tous les personnages dans la liste de personnage
		listePerso = new ArrayList<Personnage>();
		listePerso.add(boulanger);
		listePerso.add(boucher);
		listePerso.add(poissonnier);
		listePerso.add(caissier);
		listePerso.add(maman);
		listePerso.add(employer);

		// Ajoute des objets dans les différentes pièces
		accueil.ajouterObjet(caisse);
		epicerie.ajouterObjet(sel);
		epicerie.ajouterObjet(poivre);
		epicerie.ajouterObjet(curry);
		epicerie.ajouterObjet(cumin);
		epicerie.ajouterObjet(cannelle);
		produitFermier.ajouterObjet(lait);
		produitFermier.ajouterObjet(oeuf);
		produitFermier.ajouterObjet(farine);  
		fruitLegume.ajouterObjet(tomate);
		fruitLegume.ajouterObjet(poivron);
		fruitLegume.ajouterObjet(salade);
		fruitLegume.ajouterObjet(carotte);
		fruitLegume.ajouterObjet(kiwi);
		fruitLegume.ajouterObjet(fraise);
		sucrerie.ajouterObjet(sucre);
		sucrerie.ajouterObjet(chocolat);
		maison.ajouterObjet(tv);
		maison.ajouterObjet(canape);
		boulangerie.ajouterObjet(caddie);
		boulangerie.ajouterObjet(salete);
		boulangerie.ajouterObjet(tache);
		boulangerie.ajouterObjet(salete);
		pharmacie.ajouterObjet(pansement);
		pharmacie.ajouterObjet(desinfectant);

		// initialise les sorties des pièces
		maison.setSorties(null, null, dehors, null);
		dehors.setSorties(maison, null, accueil, null);
		accueil.setSorties(dehors, fruitLegume, poissonnerie, epicerie);
		poissonnerie.setSorties(accueil, sucrerie, boucherie, produitFermier);
		boucherie.setSorties(poissonnerie, boulangerie, null, null);
		epicerie.setSorties(null, accueil, produitFermier, null);
		fruitLegume.setSorties(pharmacie, null, sucrerie, accueil);
		boulangerie.setSorties(sucrerie, null, null, boucherie);
		produitFermier.setSorties(epicerie, poissonnerie, null, null);
		sucrerie.setSorties(fruitLegume, null, boulangerie, poissonnerie); 
		pharmacie.setSorties(null,null,fruitLegume,null);

		// le jeu commence dans la maison
		pieceCourante = maison;

		//initialise la liste d'achat
		listeAchat = new ArrayList<ObjetZork>();
		listeAchat.add(poisson);
		listeAchat.add(poulet);
		listeAchat.add(sel);
		listeAchat.add(poivre);
		listeAchat.add(salade);
		listeAchat.add(tomate);
		listeAchat.add(curry);
		listeAchat.add(lait);
		listeAchat.add(oeuf);
		listeAchat.add(farine);  
		listeAchat.add(poivron);
		listeAchat.add(sucre);
		listeAchat.add(chocolat);
		listeAchat.add(pain);
		listeAchat.add(ingredientSecret);
		
		//initialise la liste d'objet
		listeObjet = new ArrayList<ObjetZork>();
		listeObjet.add(argent);
		listeObjet.add(sac);
		listeObjet.add(temps);
		listeObjet.add(salete);
		listeObjet.add(tache);
		listeObjet.add(couteau);
		listeObjet.add(pansement);
		listeObjet.add(desinfectant);

		//initialise le joueur
		ArrayList<Piece> listep = new ArrayList<Piece>();
		ArrayList<ObjetZork> liste = new ArrayList<ObjetZork>();
		j = new Joueur("Sacha", listep, liste, 17);
		j.nouvelPiece(pieceCourante);
		
	}


	/*
	 * Si jamais le joueur à volé un article alors il a perdu
	 * si le temps c'est écoulé, alors il a aussi perdu
	 *
	 * @return true s'il a perdu sinon false
	 */
	public boolean aPerdu() {
		if(estVoleur())
			return true;
		if(minute == 0) {
			System.out.println("Perdu ! Temps écoulé !");
			return true;
		}
		return false;
	} 

	/*
	 * Si la maman récupère tous les ingrédients alors il gagne 
	 *
	 * @return true s'il a gagner sinon false
	 */
	public boolean aGagne() {	
		if(listePerso.get(4).contient(listeObjet.get(1))) {
			System.out.println("Gagné ! Vous avez tout ramené à la maison en moins d'une heure !");
			return true;
		}
		return false;
	}

	/**
	 *  Pour lancer le jeu. Boucle jusqu’à la fin du jeu.
	 */
	public void jouer() {
		afficherMsgBienvennue();

		// Entrée dans la boucle principale du jeu. Cette boucle lit
		// et exécute les commandes entrées par l'utilisateur, jusqu’à
		// ce que la commande choisie soit la commande "quitter"
		boolean termine = false;
		while (!termine) {
			Commande commande = analyseurSyntaxique.getCommande();
			termine = traiterCommande(commande);
		}
		System.out.println("Merci d'avoir jouer.  Au revoir.");
	}

	/**
	 * Le personnage se déplace aléatoirement dans les pièces du magasin
	 * La recourante se définit donc aléatoirement
	 * Si l'employer n'as pas de temps sur lui
	 * Alors on lui ajoute temps
	 */
	public void depRandom() {
		Piece p = listePerso.get(5).randomPiece();
		listePerso.get(5).setPiece(p);
		if(!listePerso.get(5).contient(listeObjet.get(2)))
			listePerso.get(5).ajouterObjet(listeObjet.get(2));
	}
	
	/**
	 * Si le joueur a du temps
	 * On retire le temps du joueurs
	 * On ajouter 3 minutes de temps supplémentaire
	 *
	 */

	public void plusTemps() {
		if(j.contient(listeObjet.get(2))) {
			j.retirerObjet(listeObjet.get(2));
			minute += 3;
			System.out.println("Vous avez gagné 3min de plus !");
		}
	}
		

	/**
	 *  Affiche le message d'accueil pour le joueur.
	 */
	public void afficherMsgBienvennue() {
		System.out.println();
		System.out.println();
		System.out.println("Bienvenue dans le monde de Zork !");
		System.out.println("Zork est un nouveau jeu d'aventure, terriblement ennuyeux.");
		System.out.println("Pour gagner il suffit d'apporter tout les ingredients nécessaire afin de faire un donner avant que les invites arrivent.");
		System.out.println("Pour cela vous disposez d'une liste:");
		System.out.println("pour afficher la liste d'achat taper 'afficher listeAchat'.");
		System.out.println("Tapez 'aide' si vous avez besoin d'aide.");
		System.out.println();
		info();
		System.out.println();
		System.out.println("Encore devant la télé ! Vite lève toi et va faire les courses t'as 30 minutes ! \nLes invités arrivent bientôt ! Tiens l'argent.");
		System.out.println();
	}

	/* Si il a l'argent et toutes la liste d'achat alors le joueur peux prendre le sac du caissier */
	public void donneSac() {
		int i;
		ArrayList<ObjetZork> l;
		aTout();	
		if(aArgentTout()) {
			System.out.println("Merci, tenez votre sac.");
			for(i=0; i<listeAchat.size(); i++)
				listePerso.get(3).retirerObjet(listeAchat.get(i));
			listePerso.get(3).ajouterObjet(listeObjet.get(1));
		}
	}
	
	/*
	 * Si le caissier a tous les articles de la liste d'achat
	 * alors retourne vrai
	 * sinon faux
	 *
	 * @return true si la caissier a tous les articles sinon false
	 */
	public boolean aTout()  {	
		if(listePerso.get(3).cmpList(listeAchat)) {
			System.out.println("Bravo! Vous avez trouvé tout vos articles. Cela vous fera 33€.");
			return true;
		}
		return false;
	}
	
	/* 
	 * Si le caissier a l'argent et la liste d'achat
	 * 
	 * @return true sinon false
	 */
	public boolean aArgentTout() {
		ObjetZork argent = new ObjetZork("argent",1,false);
		if(listePerso.get(3).retirerObjet(listeObjet.get(0))) {
			if(listePerso.get(3).cmpList(listeAchat)){
				listePerso.get(3).ajouterObjet(argent);
				return true;
			}
			listePerso.get(3).ajouterObjet(listeObjet.get(0));
		}
		return false;
	}	

	/**
	 *  Exécute la commande spécifiée. Si cette commande termine le jeu, la valeur
	 *  true est renvoyée, sinon false est renvoyée
	 *
	 * @param  commande  La commande a exécuter
	 * @return           true si cette commande termine le jeu ; false sinon.
	 */
	public boolean traiterCommande(Commande commande) {
		if (commande.estInconnue()) {
			System.out.println("Je ne comprends pas ce que vous voulez...");
			return false;
		}
		String motCommande = commande.getMotCommande();
		if (motCommande.equals("aide")) {
			afficherAide();
		} else if (motCommande.equals("nettoyer")) {
			nettoyerObjet(commande);
		} else if (motCommande.equals("recevoir")) {
			recevoirObjet(commande);
			plusTemps();
		} else if (motCommande.equals("prendre")) {
			prendreObjet(commande);
		} else if (motCommande.equals("donner")) {
			donnerObjet(commande);
			donneSac();
			return aGagne();
		} else if (motCommande.equals("deposer")) {
			deposerObjet(commande);
		} else if (motCommande.equals("afficher")) {
			afficher(commande);
		} else if (motCommande.equals("eclairer")) {
				System.out.println("Dans cette piece il y a :");
				pieceCourante.afficherListeObj();
				afficherListePerso();
		} else if (motCommande.equals("aller")) {
			if( pieceCourante.descriptionCourte().equals("dans le rayon sucrerie.") && commande.getSecondMot().equals("est")) { 
				teleportation();
			} else {
				deplacerVersAutrePiece(commande);
			}
			depRandom();
			info();
			endroit();
			endroit2();
			endroit3();
			return aPerdu();
		} else if (motCommande.equals("retour")) {
			Piece p = j.retour();
			if(p != null) {
				pieceCourante = p;
				minute--;
			}
			info();
			return aPerdu();
		} else if (motCommande.equals("quitter")) {
			if (commande.aSecondMot()) {
				System.out.println("Quitter quoi ?");
			} else {
				return true;
			}
		}
		return false;
	}

	/*
	 * Téléporte le joueur dans une pièce au hasard du magasin
	 * si l’ingrédient secret et encore dans la liste d'objet
	 * on ajoute l'objet dans la pièce et le supprime de la liste d'objet 
	 * 
	 */

	public void teleportation() {
		pieceCourante = listePerso.get(5).randomPiece();
		j.nouvelPiece(pieceCourante);
		minute--;
		System.out.println("Wooooow je me suis teleporté !!!");
		if(!listeObjet.contains(listeAchat.get(14))) {
			pieceCourante.ajouterObjet(listeAchat.get(14));
			listeObjet.add(listeAchat.get(14));
		}
	}
	/*
	 * Si le joueur n'a que le sac dans son inventaire, il a tout acheter
	 * si le caissier a tous les articles de la liste d'achat, il a alors tout donner
	 * Sinon si le joueur n'as pas encore pris l'objet et que le caissier ne l'as pas et que l'objet est différent de argent 
	 * alors afficher le reste des objets a acheter
	 *
	 */

	public void listeDachat() {			
		if(j.getNbObj() == 1 && j.contient(listeObjet.get(1)))
			System.out.println("Vous avez tout acheté !");
		else if(listePerso.get(3).contient(listeObjet.get(1)))
			System.out.println();
		else if(listePerso.get(3).cmpList(listeAchat))
			System.out.println("Vous avez tout donnez au caissier.");
		else {
			for(int i=0; i< listeAchat.size(); i++ ) {
				if( !j.contient(listeAchat.get(i)) && !listePerso.get(3).contient(listeAchat.get(i)))
					System.out.println(listeAchat.get(i).getDescription());
			}
			System.out.println();
		}
	}

	/*
	 * Affiche le poids, le temps, l'inventaire, listeDachat
	 */

	public void afficher(Commande commande) {
			Personnage p;
			if (!commande.aSecondMot()) {
				// si la commande ne contient pas de second mot, nous 
				// ne savons pas quoi afficher..				
				System.out.println("Afficher quoi ?");
					return;
			}
			if (!commande.aDernierMot() && commande.getSecondMot().equals("listeAchat") ) {
				// si la commande ne contient pas de dernier mot, et que le second mot est liste d'achat alors
				// on affiche la liste d'achat..
				listeDachat();
			} else if(commande.getSecondMot().equals("temps")) 
				System.out.println("Il vous reste " + minute + " minute(s).");
			else if(commande.getSecondMot().equals("poids"))
				System.out.println("Vous transportez " + j.getPoidsTotal() + " kilo d'objets.");
			else if(commande.getSecondMot().equals("plan"))
				plan();
			else if(commande.getSecondMot().equals("inventaire")) {
				if (!commande.aDernierMot()) { 
					// si pas de troisième mot afficher inventaire du joueurs
					if(j.getNbObj() > 0)
						j.afficherListeObj();
					else
						System.out.println("Vous n'avez aucun objets.");
				} else { 
					// si troisième mot afficher inventaire du personnage
					p = inPiece(commande.getDernierMot());
					if(p != null) { 
					//si le personnage est dans la pièce
						if(p.getNbObj() > 0)
							p.afficherListeObj();
						else
							System.out.println(p.getNom() + " n'a aucun objet.");
					}
					else
						System.out.println("Ce personnage n'est pas dans la piece."); 
				}
			} else
				System.out.println("Je ne comprend pas se que vous voulez..."); 
	}
			
	/*
	 * Permet de prendre un objet de la pièce 
	 * si il y a des objet dans la pièce
	 * et qu'on a un deuxième mot en paramètre
	 * et que cet objet est dans la pièce 
	 * alors on ramasse l'objet
	 *
	 * @param commande : la ligne de commande
	 */

	public void prendreObjet(Commande commande) {
		if(pieceCourante.getNbObj() != 0) {
			if (!commande.aSecondMot()) {
				// si la commande ne contient pas de second mot, nous ne
				// savons pas quoi prendre..
				System.out.println("Prendre quoi ?");
					return;
			}
			else {
				if(pieceCourante.contientStr(commande.getSecondMot()) == null) 
					// si l'objet n'est pas dans la pièce
					System.out.println("Cette objet n'est pas dans la piece.");
				else {
					if(pieceCourante.contientStr(commande.getSecondMot()).estTransportable()) { 
					// si l'objet est transportable
						if(j.prendre(pieceCourante.contientStr(commande.getSecondMot()))) 
							System.out.println("Vous avez pris " + commande.getSecondMot() + ".");
						else
							System.out.println("Vous n'avez plus de place sur vous.");
					}
					else
						System.out.println("Je n'en ai pas besoin...");
				}
			}
		}
		else
			System.out.println("Il n'y a aucun objet dans la piece.");
	}
	
	/*
	 * Permet afficher la liste de personnage dans la pièce courante
	 * @pure
	 */

  	public void afficherListePerso() {
		int i;
		if(listePerso.size() != 0) {
			for(i=0; i<listePerso.size(); i++) {
				if(listePerso.get(i).getPieceC().equals(pieceCourante))
					System.out.print(listePerso.get(i).getNom() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Permet de déposer des objets de notre inventaire
	 * si le joueur a des objets dans son inventaire
	 * et si la commande contient un second mot
	 * alors le joueurs dépose l'objet dans la pièce
	 *
	 */


	public void deposerObjet(Commande commande) {
		if(j.getNbObj() != 0) {
			if (!commande.aSecondMot()) {
				// si la commande ne contient pas de second mot, nous ne
				// savons pas quoi déposer..
				System.out.println("Deposer quoi ?");
					return;
			}
			else {
				if(j.contientStr(commande.getSecondMot()) == null)
					System.out.println("Cette objet n'est pas en votre possession.");
				else {
					if(j.poser(j.contientStr(commande.getSecondMot())))
						System.out.println("Vous avez posé " + commande.getSecondMot() + ".");
					else
						System.out.println("L'objet n'as pas pu etre deposé.");
				}
			}
		}
		else
			System.out.println("Vous n'avez pas d'objet sur vous.");
	}

	/*
	 * Si le joueurs était a l’accueil et qu'il se retrouve dehors
	 * et qu'il sors du magasin avec des articles non payes
	 * alors le joueurs est considérer comme voleur
	 *
	 * @return true s'il a volé sinon false
	 */

	public boolean estVoleur() {
		if(j.getPiecePrec() != null) {
			if(j.getPiecePrec().equals(listePiece.get(2)) && j.getPiece().equals(listePiece.get(1)) || j.getPiece().equals(listePiece.get(1))) {
				if(j.getNbObj() == 1 && (j.contient(listeObjet.get(1)) || j.contient(listeObjet.get(0))) || j.getNbObj() == 0)
					return false;
				System.out.println("Oh voleur! Vous etes sortit avec des articles que vous n'avez pas payés. Perdu !!!");
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Renvoie le personnage s'il est présent dans la pièce 
	 *
	 * @pure
	 * @param s : nom du personnage
	 */
	
	public Personnage inPiece(String s) {
		int i=0;
		for(i=0; i<listePerso.size(); i++) {
			if(listePerso.get(i).getNom().equals(s) && listePerso.get(i).getPieceC().equals(pieceCourante))
				return listePerso.get(i);
		}
		return null;
	}

	/**
	 * Permet de donner un objet a un personnage du jeu 
	 * Si la commande contient un second mot
	 * et que la commande contient egalement un troisieme mot
	 * que nous avons au moins un objet dans notre inventaire et que le personnage est prensent dans la piece
	 * Alors nous pouvons donner nos objets
	 * 
	 * Si le second mot est article
	 * alors le personnage donne tous les articles qu'il a dans son inventaire
	 *
	 * @param commande : ligne de commande
	 * 
	 */

	public void donnerObjet(Commande commande) {		
		Personnage p;
		ObjetZork o;
		ArrayList<ObjetZork> l;
		ArrayList<ObjetZork> lj;
		int i;
		if (!commande.aSecondMot()) {
		// si la commande ne contient pas de second mot, nous ne
		// savons pas quoi donner..
		System.out.println("Donner quoi ?");
			return;
		}
		if (!commande.aDernierMot()) {
		// si la commande ne contient pas de dernier mot, nous ne
		// savons à qui donner..
		System.out.println("Donner à qui ?");
			return;
		}
		o = j.contientStr(commande.getSecondMot());
		p = inPiece(commande.getDernierMot());
					
		if(j.getNbObj() != 0) {
			if(commande.getSecondMot().equals("article") && p!= null) {
				lj = j.getListeObjet();
				for(i=0; i<j.getNbObj(); i++) {
					if(!j.getListeObjet().get(i).equals(listeObjet.get(0)))
						p.ajouterObjet(lj.get(i));
				}
				l = p.getListeObjet();
				for(i=0; i<p.getNbObj(); i++)
					j.retirerObjet(l.get(i));
				System.out.println("Vous avez donné tout vos articles.");
				poissonne();
				boucher();
				return;
			}					
			if(o != null && p != null) {
				p.ajouterObjet(o);
				j.retirerObjet(o);
				System.out.println("Vous avez donné " + o.getDescription() + " à " + p.getNom());
				poissonne();
				boucher();
			}
			else if(o == null)
				 System.out.println("Vous n'avez pas cette objet.");
			else
				System.out.println("Ce personnage n'est pas dans la piece.");
		}
		else
			System.out.println("Vous n'avez aucun objet.");
	}

	/**
	 * Permet de recevoir un objet d'un personnage du jeu 
	 * Si la commande contient un second mot
	 * et que la commande contient egalement un troisieme mot
	 * que le personnage a au moins un objet dans son inventaire et que le personnage est prensent dans la piece
	 * Alors nous pouvons recevoir un objet 
	 *
	 * @param commande : ligne de commande
	 * 
	 */
	
	public void recevoirObjet(Commande commande) {
		Personnage p;
		ObjetZork o;
		if (!commande.aSecondMot()) {
		// si la commande ne contient pas de second mot, nous ne
		// savons pas quoi recevoir..
		System.out.println("Recevoir quoi ?");
			return;
		}
		if (!commande.aDernierMot()) {
		// si la commande ne contient pas de dernier mot, nous ne
		// savons pas de qui donner..
		System.out.println("Recevoir de qui ?");
			return;
		}
		p = inPiece(commande.getDernierMot());
		if(p != null) {
			o = p.contientStr(commande.getSecondMot());
			if(p.getNbObj() != 0) {
				if(p.contient(o) && o.estTransportable()) {
					if(j.ajouterObjet(o)){
						p.retirerObjet(o);
						System.out.println("Vous avez reçu " + o.getDescription() + " de " + p.getNom() + ".");
					}
					else
						System.out.println("Vous n'avez plus de place sur vous.");
				}
				else if(o == null)
					 System.out.println(p.getNom() + " n'a pas cette objet.");
				else
					System.out.println("Je n'en ai pas besoin...");
			}
			else
				System.out.println(p.getNom() + " n'a aucun objet.");
		}
		else
			System.out.println("Ce personnage n'est pas dans la piece.");
	}

	/**
	 * Permet de nettoyer un objet dans la piece 
	 * Si la commande contient un second mot
	 * et que la commande contient egalement un troisieme mot
	 * que nous avons au moins un objet salete ou tache dans la piece
	 * Alors nous pouvons nettoyer ces objets
	 * 
	 * @param commande : ligne de commande
	 * 
	 */
	
	public void nettoyerObjet(Commande commande) {
		if (!commande.aSecondMot()) {
		// si la commande ne contient pas de second mot, nous ne
		// savons pas quoi nettoyer..
		System.out.println("Nettoyer quoi ?");
			return;
		}
		if(pieceCourante.getNbObj() != 0) {
			ObjetZork o = pieceCourante.contientStr(commande.getSecondMot());
			if(o == null)
				System.out.println("Cette objet n'est pas dans la piece.");
			else{
				if(o.equals(listeObjet.get(3)) || o.equals(listeObjet.get(4)) ) {
					pieceCourante.retirerObjet(o);
					System.out.println(commande.getSecondMot()+" à été nettoyé.");
					boulanger();
				}else
					System.out.println("Vous ne pouvez pas nettoyer ça");
			}
		}
		else
			System.out.println("Vous n'avez aucun objet.");
	}

	/* 
	 * Si jamais la mission de nettoyer la piece n'est pas accomplie alors la mission est expliqué.
	 *
	 */
	public void endroit() {
		Piece boulang = listePiece.get(9);
		if(pieceCourante.equals(boulang) && (boulang.contient(listeObjet.get(3)) || boulang.contient(listeObjet.get(4)))) {
			System.out.println();
			System.out.println("Boulanger : J'imagine que vous cherchez du pain ?");
			System.out.println("Malheureusement l'endroit est trop sale pour que j'y pose de la nourriture");
			System.out.println("Aide moi à nettoyer tout ça, pendant se temps je te prépare un bon pain croustillant.");
			System.out.println();
		}
	}

	/*
	 * Si la mission est terminé alors le pain est en possession du boulanger
	 *
	 */
	public void boulanger() {
		Piece boulang = listePiece.get(9);
		if(!boulang.contient(listeObjet.get(3)) && !boulang.contient(listeObjet.get(4))) {
			listePerso.get(0).ajouterObjet(listeAchat.get(13));
			System.out.println("Ohhh ! Merci ! L'endroit est tout propre, tenez votre pain.");
		}
	}

	/*
	 * Si la mission est terminé alors le poisson est en possession du poissonier
	 *
	 */
	public void poissonne() {
		Piece poissonne = listePiece.get(3);
		if( pieceCourante.equals(poissonne) && listePerso.get(2).contient(listeObjet.get(5))) {
			listePerso.get(2).ajouterObjet(listeAchat.get(0));
			System.out.println("Ohhh ! Merci ! Enfin un couteau, tenez votre poisson.");
			ObjetZork couteau = new ObjetZork("couteau",0.25,false);
			if(listePerso.get(2).retirerObjet(listeObjet.get(5))) 
				listePerso.get(2).ajouterObjet(couteau); 	
		}
	}

	/* 
	 * Si la mission de ramener le couteau au poissonier n'est pas accomplie alors la mission est expliqué.
	 *
	 */
	public void  endroit2() {
		Piece poissonne = listePiece.get(3);
		if( pieceCourante.equals(poissonne) && listePerso.get(2).contientStr("couteau") == null) {
			System.out.println();
			System.out.println("Poissonnier : J'imagine que vous cherchez du poisson ?");
			System.out.println("Malheureusement je n'ai plus de couteau pour pouvoir couper mes poissons.");
			System.out.println("Aide moi à trouver un couteau et tu auras un bon poisson frai.");
			System.out.println();
		}
	}
	
	public void boucher() {
		Piece boucher = listePiece.get(4);
		if( pieceCourante.equals(boucher) && listePerso.get(1).contient(listeObjet.get(6)) && listePerso.get(1).contient(listeObjet.get(7))) {
			listePerso.get(1).ajouterObjet(listeAchat.get(1));
			listePerso.get(1).ajouterObjet(listeObjet.get(5));
			System.out.println("Ohhh ! Merci ! Je peux enfin me soigner, tenez votre votre poulet et ce couteau.");
			ObjetZork pansement = new ObjetZork("pansement",0.25,false);
			ObjetZork desinfectant = new ObjetZork("desinfectant",0.25,false);
			if(listePerso.get(1).retirerObjet(listeObjet.get(6)) && listePerso.get(1).retirerObjet(listeObjet.get(7))) {
				listePerso.get(1).ajouterObjet(pansement); 
				listePerso.get(1).ajouterObjet(desinfectant);	
			}
		
		}
	}
	

	public void  endroit3() {
		Piece boucher = listePiece.get(4);
		if(pieceCourante.equals(boucher) && listePerso.get(1).contientStr("desinfectant") == null && listePerso.get(1).contientStr("pansement") == null) {
			System.out.println();
			System.out.println("Boucher : J'imagine que vous cherchez du poulet ?");
			System.out.println("Malheureusement je me suis couper en coupant le poulet.");
			System.out.println("Aide moi à trouver un pansement et un desinfectant pendant que je"); 
			System.out.println("finit de couper toute ces viandes.");
			System.out.println("J'ai egalement entendu dire que le poissionner avait besoin d'un couteau.");
			System.out.println("Voulais-vous bien lui passer ?!.");
			System.out.println();
		}
	}
			
	/**
	 * Affiche la pièce ou on se trouv
	 * Les objets présents dans cette pièce
	 * La listes des personnages de la pièce
	 *
	 *@pure
	 *
	 */

	public void info() {
		System.out.println();
		System.out.println(pieceCourante.descriptionLongue());
		System.out.println("Dans cette piece il y a:");
		pieceCourante.afficherListeObj();
		afficherListePerso();
	}

	// implémentations des commandes utilisateur:

	/**
	 *  Affichage de l'aide. Affiche notamment la liste des commandes  utilisables.
	 */
	public void afficherAide() {
		System.out.println();
		System.out.println("Vous etes perdu. Vous etes seul.");
		System.out.println();
		System.out.println("Les commandes reconnues sont:");
		System.out.println("afficher temps/poids/plan/listeAchat");
		System.out.println("afficher inventaire");
		System.out.println("afficher inventaire 'personne'");
		System.out.println("nettoyer 'Objet à nettoyer'");
		System.out.println("aller 'sortie'");
		System.out.println("retour");
		System.out.println("quitter");
		System.out.println("prendre 'Objet à prendre'");
		System.out.println("deposer 'Objet à deposer'");
		System.out.println("eclairer");
		System.out.println("donner 'Objet à donner' 'à la personne' ");
		System.out.println("donner article 'personne': donne tout les articles");
		System.out.println("recevoir 'Objet à recevoir' 'de la personne'");

	}


	/**
	 *  Tente d'aller dans la direction spécifiée par la commande. Si la pièce
	 *  courante possède une sortie dans cette direction, la pièce correspondant a
	 *  cette sortie devient la pièce courante, dans les autres cas affiche un
	 *  message d'erreur.
	 *
	 * @param  commande  Commande dont le second mot spécifie la direction a suivre
	 */
	public void deplacerVersAutrePiece(Commande commande) {
		if (!commande.aSecondMot()) {
			// si la commande ne contient pas de second mot, nous ne
			// savons pas ou aller..
			System.out.println("Aller où ?");
			return;
		}

		String direction = commande.getSecondMot();

		// Tentative d'aller dans la direction indiquée.
		Piece pieceSuivante = pieceCourante.pieceSuivante(direction);

		if (pieceSuivante == null) {
			System.out.println("Il n'y a pas de porte dans cette direction!");
		} else {
			pieceCourante = pieceSuivante;
			j.nouvelPiece(pieceCourante);
			minute--;
		}
	}

	/**
	 * Affiche le plan du jeu 
	 * @pure
	 *
	 */
	public void plan() {
		System.out.println();
		System.out.println("                  ---------------");
		System.out.println("                  |             |");
		System.out.println("                  |   MAISON    |");
		System.out.println("                  |             |");
		System.out.println("                  ------   --------------------");
		System.out.println("                  |             |             |");
		System.out.println("                  |   DEHORS    |  PHARMACIE  |");
		System.out.println("                  |             |             |");
		System.out.println("    --------------------   -----------   ------");
		System.out.println("    |             |             |    FRUIT    |");
		System.out.println("    |  EPICERIE       ACCUEIL          ET     |");
		System.out.println("    |             |             |    LEGUME   |");
		System.out.println("    ------   -----------   -----------   --------------------");
		System.out.println("    |             |             |             |             |");
		System.out.println("    |   PRODUIT     POISSONNERIE    SUCRERIE       PIECE    |");
		System.out.println("    |   FERMIER   |             |             |   SECRETE   |");
		System.out.println("    --------------------   -----------   --------------------");
		System.out.println("                  |             |             |");
		System.out.println("                  |  BOUCHERIE    BOULANGERIE |");
		System.out.println("                  |             |             |");
		System.out.println("                  -----------------------------");
		System.out.println();
	}
}

