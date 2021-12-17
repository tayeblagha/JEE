

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
@WebServlet("/ServMonPanier")
public class ServMonPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionImp dao;
    public ServMonPanier() {
        super();
    	dao = new GestionImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Panier> lpn= dao.getAllPanier();
		request.setAttribute("lpn", lpn);
		
		request.getRequestDispatcher("Monpanier.jsp").forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idp = Integer.parseInt(request.getParameter("idp"));
		Produit p =dao.getProduitbyId(idp);
		Panier pn= dao.getPanierbyProd(p);
	pn.setP(p);
	dao.addProducttoPanier(pn);
	doGet(request,response);
	}

}
