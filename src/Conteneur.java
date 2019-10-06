/** @author     KADDOUH Heba 11405014, ELAZIZ Yasmina 11405067 */

import java.util.ArrayList;

public interface Conteneur {
	public int getNbObj();
	public abstract boolean ajouterPossible (ObjetZork o );
	public ArrayList<ObjetZork> getListeObjet();
	public boolean retirerObjet( ObjetZork o );
	public boolean ajouterObjet( ObjetZork o );
	public int contientCombienDe(ObjetZork o);
	public boolean contient(ObjetZork o);
}
