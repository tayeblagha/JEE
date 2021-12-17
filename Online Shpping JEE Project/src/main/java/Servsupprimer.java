

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GestionImp;
import entities.Panier;
import entities.Produit;

/**
 * Servlet implementation class Servsupprimer
 */
@WebServlet("/Servsupprimer")
public class Servsupprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GestionImp dao;
    public Servsupprimer() {
        super();
    	dao = new GestionImp();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idp = Integer.parseInt(request.getParameter("idpn"));
		dao.deletePanier(idp);
		request.getRequestDispatcher("ServMonPanier").forward(request, response)
		;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
