package dao;

import java.util.List;

import entities.*;

public class test {

	public static void main(String[] args) {
		
		GestionImp dao = new GestionImp();
		Categorie cat1=new Categorie(1,"Pc_portable");
		Categorie cat2=new Categorie(2,"Phone");
		Categorie cat3=new Categorie(3,"Tablette");
		Produit p1 = new Produit(1,"Toshiba", 1300,"img1",cat1);
		Produit p2 = new Produit(2,"Dell", 1500,"img2",cat1);
		Produit p3 = new Produit(3,"Asus", 2650,"img3" ,cat1);
		Produit p4 = new Produit(4,"Lenevo", 2700,"img4" ,cat1);
        Produit p5 = new Produit(5,"Galaxy6 edge", 700, "img5" ,cat2);
        Produit p6 = new Produit(6,"Iphone 12", 1200, "img6" ,cat2);
        Produit p7 = new Produit(7,"huawei nova 7i", 799, "img7" ,cat2);
        Produit p8 = new Produit(8,"Microsoft Lumia 950 Windows", 630, "img8" ,cat2);
        Produit p9 = new Produit(9,"Asus_tablette", 340, "img9" ,cat3);
        Produit p10 = new Produit(10,"samsung tablette ", 399, "img10" ,cat3);

Panier pan1 = new Panier(1,p1);
Panier pan2 = new Panier(2,p2);
Panier pan3 = new Panier(1,p3);
Panier pan4 = new Panier(2,p4);
Panier pan5 = new Panier(5,p5);
Panier pan6 = new Panier(1,p6);
Panier pan7 = new Panier(7,p7);
Panier pan8 = new Panier(8,p8);
Panier pan9 = new Panier(1,p9);
Panier pan10 = new Panier(2,p10);
/*
dao.addProducttoPanier(pan1);
dao.addProducttoPanier(pan2);
dao.addProducttoPanier(pan3);
dao.addProducttoPanier(pan4);
dao.addProducttoPanier(pan5);
dao.addProducttoPanier(pan6);
dao.addProducttoPanier(pan7);
dao.addProducttoPanier(pan8);
dao.addProducttoPanier(pan9);
dao.addProducttoPanier(pan10);
 List<Panier >l=dao.getAllPanier();
for(Panier temp : l) {System.out.println(temp);}     
    */    

int x=dao.PanierNumber();
System.out.println(x);
	}

}
