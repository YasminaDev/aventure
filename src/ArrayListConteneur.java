/** @author     KADDOUH Heba 11405014, ELAZIZ Yasmina 11405067 */

import java.util.ArrayList;

public abstract class ArrayListConteneur implements Conteneur{
	private ArrayList <ObjetZork> listeObjet;
	
	public ArrayListConteneur(ArrayList<ObjetZork> listeObjet){
		this.listeObjet = (ArrayList<ObjetZork>) listeObjet.clone();
	}

	/**
	 *  Renvoie la capacite de cette piece (i.e. la capacite spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return    Capacite de la liste d'objet de cette piece
	 */
	public int getNbObj() {
		return listeObjet.size();
	}

	/**
	 *  Compare deux listes d'objets (i.e. la liste d'objet spécifiée lors
	 *  de la création de cette instance).
	 *  
	 * @param	listeObj liste d'objet a comparer
	 * @return	true si les listes son les même sinon false
	 */
	
	public boolean cmpList(ArrayList<ObjetZork> listeObj) {
		int i;
		if(listeObj.size() != 0 && listeObjet.size() != 0 && listeObj.size() == listeObjet.size()) {
			for(i=0; i<listeObjet.size(); i++) {
				if(!listeObjet.contains(listeObj.get(i)))
					return false;
			}
		}else
			return false;
		return true;
	}


	/**
	 *  Renvoie la liste d'objet de cette piece (i.e. la liste d'objet spécifiée lors
	 *  de la création de cette instance).
	 *
	 * @return    Liste d'objet de cette piece
	 */
	
	public ArrayList<ObjetZork> getListeObjet() {
		return (ArrayList<ObjetZork>) listeObjet.clone();
	}

	/**
	 *  Affiche la liste d'objet
	 */
	public void afficherListeObj() {
		int i = 0;
		if(listeObjet.size() > 0) {
			for(i=0; i<getNbObj(); i++)
				System.out.print(listeObjet.get(i).getDescription() + "   ");
			System.out.println();
		}
	}

	/**
	* Verifie si la liste d'objet contient l'objet 
	*
	* @param objet 
	* @return l'objet de la liste s'il le contient sinon retourne null
	*
	*/

	public ObjetZork contientStr(String s) {
		int i=0;
		for(i=0; i<getNbObj();i++) {
			if(listeObjet.get(i).getDescription().equals(s))
			return listeObjet.get(i);
		}
		return null;
	}

	/**
	 *  Retire une seul occurence de l'objet si c'est possible retourne vrai
	 *  Sinon retourne faux
	 *
	 * @param o L'objet à retirer
	 *
	 * @return    true si l'objet est retirer sinon false
	 */
	public boolean retirerObjet( ObjetZork o ) {
		return listeObjet.remove(o);
	}

	/** AjoutPossible foncton abstraire a definir dans les classes */


	public abstract boolean ajouterPossible (ObjetZork o);

	/**
	 *  Verifie si le nombre d'objet est inferieur a la capacité
	 *  ajoute l'objet et retourne vrai
	 *  Sinon retourne faux
	 *
	 * @param o L'objet à ajouter
	 *
	 * @return    true si l'objet a etait ajouter sinon false
	 */
	public boolean ajouterObjet( ObjetZork o ) {
		if(ajouterPossible(o)) {
			return listeObjet.add(o);
		}
		return false;
	}

	/**
	 *  Donne la recurrence de l'objet dans la liste
	 *  Initialise nbr le nombre de recurrence de l'objet 
	 *  Parcours tout les elements du tableau
	 *  Compare chaque objet du tableau avec l'objet donné  
	 *  Si l'objet est le meme, incremente de 1 nbr
         *
	 * @param o L'objet qu'il faut chercher
	 *
	 * @return    le nombre de recurrence de l'objet
	 */
	public int contientCombienDe(ObjetZork o) {
		int nbr = 0;
		if(o != null) {
			for(int i=0; i<listeObjet.size();i++) {
				if (listeObjet.get(i).equals(o)){
					nbr++;
				}
			}
		}
		return nbr;
	}

	/**
	 *  Dit si l'objet est dans la liste
	 *  Si contientCombienDe renvoie un nombre positive alors on retourne true
	 *  Sinon on retourne false
         *
	 * @param o L'objet qu'il faut chercher
	 *
	 * @return    true si l'objet est dans la liste, false sinon
	 */
	public boolean contient(ObjetZork o) {
		if(contientCombienDe(o)>0)
			return true;
		return false;
	}

}
