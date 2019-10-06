/** @author     KADDOUH Heba 11405014, ELAZIZ Yasmina 11405067 */

import java.util.ArrayList;
import java.util.Random;

public class Personnage extends Joueur {
		Piece pieceCourante;
	public Personnage( String nom, ArrayList<Piece> listep, ArrayList<ObjetZork> liste, double capacite, Piece pieceCourante) {
		super(nom, listep, liste, capacite);
		this.pieceCourante = pieceCourante;
	}

	public Piece randomPiece() {
		Random r = new Random();
		return getListep().get(r.nextInt(getListep().size()-1));
	}

	public void setPiece(Piece p) {
		if(p != null)
			pieceCourante = p;
	}

	public Piece getPieceC() {
		return pieceCourante;
	}

}
