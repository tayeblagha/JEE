package entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	@Override
	public String toString() {
		return "Produit [idp=" + idp + ", nom=" + nom + ", prix=" + prix + ", cat=" + cat + ", image=" + image + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idp;
	private String nom ;
	
	private int prix;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idcat")
	private  Categorie cat;
	private String image;
	
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Produit() {
		super();
	}
	public Produit(int idp, String nom, int prix,String image,Categorie cat) {
		super();
		this.idp=idp;
		this.nom = nom;
		this.prix = prix;
		this.image=image;
		this.cat=cat;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
