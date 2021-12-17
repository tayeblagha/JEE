package entities;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpan;
	private int quantite ;
	

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idp")
	Produit p ;
	/*
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idlp")
	private Lignepanier lp ;*/

	public int getIdpan() {
		return idpan;
	}

	public void setIdpan(int idpan) {
		this.idpan = idpan;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getP() {
		return p;
	}

	public void setP(Produit p) {
		this.p = p;
	}

	

	public Panier() {
		super();
	}

	public Panier(int quantite, Produit p) {
		super();
		this.quantite = quantite;
		this.p = p;
	}

	
	@Override
	public String toString() {
		return "Panier [idpan=" + idpan + ", quantite=" + quantite + ", p=" + p + "]";
	}
	
}
