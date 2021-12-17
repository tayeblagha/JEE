package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.*;

public class GestionImp implements Igestion {
	private EntityManager em;
	private EntityManagerFactory emf;

	public GestionImp() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("tp3");
			em = emf.createEntityManager();
		}
	}
	public void deletePanier(int idpan) {
		Panier p = em.find(Panier.class, idpan);
		em.getTransaction().begin();
em.remove(p);
em.getTransaction().commit();
	}
	public Produit getProduitbyId(int id) {
		
		Produit p =em.find(Produit.class, id);
		return p;
	}
	@Override
	public List<Produit> getAllProduit() {
		List<Produit> l = new ArrayList<Produit>();
		Query query = em.createQuery("Select p FROM Produit p ");
		l = query.getResultList();
		return l;
	}
	
	public List<Panier> getAllPanier(){
		Query q = em.createQuery("Select p FROM Panier p   ");
		
		List<Panier> l =q.getResultList();
		return l;
	}

	@Override
	public List<Produit> getAllProduitbyCat(int idc) {
		Query q = em.createQuery("Select p FROM Produit p  where p.cat.idc=:idc ");
		q.setParameter("idc",idc);
		List<Produit> l =q.getResultList();
		return l;
	}
	public Panier getPanierbyProd(Produit p1) {
		try {
		Panier p = new Panier();
		EntityTransaction tx = em.getTransaction();
		
		Query q= em.createQuery("Select pn from Panier pn where pn.p.idp=:p ");
		q.setParameter("p", p1.getIdp());
		p =(Panier) q.getSingleResult();
		
		return p;}catch(Exception ex) {ex.getMessage(); }
		return null;
	}

	@Override
	public void addProducttoPanier(Panier p) {	
		Panier p1= em.find(Panier.class,p.getIdpan());
		EntityTransaction tx = em.getTransaction();
		Produit pd = em.find(Produit.class, p.getP().getIdp());
		tx.begin();
		if(p1!=null) {p1.setQuantite(p1.getQuantite()+1);
		em.merge(p1);
		}
		else if(pd==null) {
			p.setQuantite(1);
			Produit p3 =p.getP();
           
			p.setP(null);
			em.persist(p);
			ajoutProduit(p3);
			p.setP(p3);
			em.merge(p);
			
		}
		else {Panier p2 = getPanierbyProd(pd);
		if(p2==null) {
			Panier p5 = new Panier();
			p5.setQuantite(1);
		em.persist(p5);
		p5.setP(pd);
		em.merge(p5);
		}
		else {
		p1=em.find(Panier.class, p2.getIdpan());
		p1.setQuantite(p1.getQuantite()+1);
		em.merge(p1);
		}
		}
		
		tx.commit();
		
	}
private Produit verifier(int idp) {
	Produit p = em.find(Produit.class, idp)	;	return p;
	}

public void ajoutProduit(Produit p) {
	Categorie cat1 =em.find(Categorie.class,p.getCat().getIdc());
	EntityTransaction tx = em.getTransaction();
	Categorie cat2=p.getCat();
	Produit p1 =new Produit();
	p1.setIdp(p.getIdp());p1.setImage(p.getImage());
	p1.setNom(p.getNom());p1.setPrix(p.getPrix());
	if(cat1==null) { 	em.persist(p); }
	else {
	em.persist(p1);
	p1.setCat(cat2);
	em.merge(p1);
	}
	
}
public int PanierNumber() {
	List<Panier> l=getAllPanier();
	int n=l.size();
	return n;
}


	@Override
	public void deleteProductfromPanier(int idp) {
		Panier p1= em.find(Panier.class, idp);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(p1);
		tx.commit();

	}

}
