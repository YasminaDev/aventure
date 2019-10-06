/** @author     KADDOUH Heba 11405014, ELAZIZ Yasmina 11405067 */

public class ObjetZork{
		private double poids;
		private boolean portabilite;
		private String description;


	public ObjetZork(String description, double poids, boolean portabilite) {
		this.description=description;
		this.poids = poids;
		this.portabilite = portabilite;
	}
	
	public double getPoids() {
		return poids;
	}

	public boolean estTransportable() {
		return portabilite;
	}

	public String getDescription() {
		return description;
	}

	public boolean equals(ObjetZork o) {
		if(o == null)
			return false;
		if(poids != o.getPoids())
			return false;
		if(portabilite != o.estTransportable())
			return false;
		if(!(description.equals(o.getDescription())))
			return false;
		return true;
	}

	public ObjetZork clone() {
		ObjetZork leClone = null;
		try {
			leClone = (ObjetZork) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError("Clone devrait fonctionner");
		}
		return leClone;
	}
} 
