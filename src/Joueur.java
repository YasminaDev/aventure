/** @author     KADDOUH Heba 11405014, ELAZIZ Yasmina 11405067 */

import java.util.ArrayList;


public class Joueur extends ArrayListConteneur {
		private String nom;
		private ArrayList<Piece> listep;
		private double capacite;


	public Joueur( String nom, ArrayList<Piece> listep, ArrayList<ObjetZork> liste, double capacite) {
		super(liste);
		this.nom = nom;
		this.listep = (ArrayList<Piece>) listep.clone();
		this.capacite = capacite;
	}

	
	public String getNom() {
		return nom;
	}

	public Piece getPiece() {
		return listep.get(listep.size() - 1);
	}
	
	public Piece getPiecePrec() {
		if(listep.size() > 1)
			return listep.get(listep.size() - 2);
		return null;
	}
	

	public double getCapacite() {
		return capacite;
	}


	public ArrayList<Piece> getListep() {
		return (ArrayList<Piece>) listep.clone();
	}

	public double getPoidsTotal() {
		double p=0;
		ArrayList <ObjetZork> l = getListeObjet();
		for(int i=0; i<getNbObj();i++) 
			p+=l.get(i).getPoids();
		return p;
	}	
		
	public void nouvelPiece (Piece p) {
		listep.add(p);
	}
	
	public boolean ajouterPossible (ObjetZork o) {
		if(o.getPoids() + getPoidsTotal() > capacite) {
				return false;
		}
		return true;
	}

	public Piece retour() {
		if(listep.size() > 1) {
			listep.remove(listep.size() - 1);
			return listep.get(listep.size() - 1);
		}
		System.out.print("Impossible.");
		return null;
	}

	public boolean prendre(ObjetZork o) {
		if(ajouterObjet(o))
			return getPiece().retirerObjet(o);
		return false;
	}

	public boolean poser(ObjetZork o) {
		if(getListeObjet().contains(o)) {
			getPiece().ajouterObjet(o);
			return retirerObjet(o);
		}
		return false;
	}
		
}
