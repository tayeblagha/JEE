package dao;
import java.util.List;
import entities.*;
public interface Igestion {
public List<Produit> getAllProduit();
public List<Produit> getAllProduitbyCat(int idc);
public void addProducttoPanier(Panier p);
public void deleteProductfromPanier(int idp);
}
