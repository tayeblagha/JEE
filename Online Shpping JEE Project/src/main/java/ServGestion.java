

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
@WebServlet("/ServGestion")
public class ServGestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionImp dao;
    public ServGestion() {
        super();
    	dao = new GestionImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produit> lp= dao.getAllProduit();
		int n = dao.PanierNumber();
		request.setAttribute("n", n);
		request.setAttribute("lp", lp);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
