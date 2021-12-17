package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idc;
	private String nom ;
	
	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Categorie() {
		super();
	}
	public Categorie(int idc, String nom) {
		super();
		this.idc = idc;
		this.nom = nom;
	}
}
