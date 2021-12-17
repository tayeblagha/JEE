

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionImp;
import entities.*;
import jdk.jfr.DataAmount;

/**
 * Servlet implementation class ServGestion
 */
@WebServlet("/ServAjout")
public class ServAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionImp dao;
    public ServAjout() {
        super();
    	dao = new GestionImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("idp"));
		Produit p=dao.getProduitbyId(id);
		Panier pn =new Panier();
		pn.setP(p);
		dao.addProducttoPanier(pn);
		List<Produit> lp= dao.getAllProduit();
		int n = dao.PanierNumber();
		request.setAttribute("n", n);
		request.setAttribute("lp", lp);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
