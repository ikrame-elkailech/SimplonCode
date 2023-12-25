package servlet;

import java.io.IOException;
import java.util.List;

import dao.IProduitDao;
import dao.ProduitDaoIplementation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produit;
import model.ProduitModel;

public class ProduitControleurServlet extends HttpServlet {
	private IProduitDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoIplementation();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		//liste des produit
		if(path.equals("/Produit.do")) {
			ProduitModel model = new ProduitModel();
			List<Produit> produits = metier.showAllProduct();
			model.setProduits(produits);
			req.setAttribute("model", model);
			req.getRequestDispatcher("/Produit/produit.jsp").forward(req, res);
		}//rechercher
		else if(path.equals("/SearchProduit.do")){
			req.getRequestDispatcher("Produit/rechercheProduit.jsp").forward(req, res);	
		}
		else if(path.equals("/rechercheProduit.do")) {
			String motCle = req.getParameter("motCle");
			ProduitModel model = new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits = metier.rechercheProduit("%"+motCle+"%");
			model.setProduits(produits);
			req.setAttribute("model", model);
			req.getRequestDispatcher("Produit/rechercheProduit.jsp").forward(req, res);
		}//ajouter produit
		else if(path.equals("/AjouterProduit.do")){
			req.getRequestDispatcher("Produit/ajouterProduit.jsp").forward(req, res);	
		}
		else if(path.equals("/SaveProduit.do")&&(req.getMethod().equals("POST"))) {
			String nom = req.getParameter("nom");
			double prix = Double.parseDouble(req.getParameter("prix"));
			int quantite = Integer.parseInt(req.getParameter("quantite"));
			metier.ajouterProduit(new Produit(nom, prix,quantite));
			res.sendRedirect("Produit.do");	
		}//update produit
		else if(path.equals("/EditProduit.do")){
			int id = Integer.parseInt(req.getParameter("id"));
			Produit p = metier.getProduit(id);
			req.setAttribute("p", p);
			req.setAttribute("id", id);
			req.getRequestDispatcher("Produit/updateProduit.jsp").forward(req, res);	
		}
		else if(path.equals("/UpdateProduit.do")&&(req.getMethod().equals("POST"))) {
			int id = Integer.parseInt(req.getParameter("id"));
			String nom = req.getParameter("nom");
			double prix = Double.parseDouble(req.getParameter("prix"));
			int quantite = Integer.parseInt(req.getParameter("quantite"));
			Produit p=new Produit(nom, prix,quantite);
			p.setId(id);
			metier.updateProduit(p,id);
			res.sendRedirect("Produit.do");	
		}//delete produit
		else if(path.equals("/SupprimerProduit.do")){
			int id = Integer.parseInt(req.getParameter("id"));
			metier.supprimerProduit(id);
			res.sendRedirect("Produit.do");	
		}
		//Not Found 
		else {
			req.getRequestDispatcher("/notFound.jsp").forward(req, res);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res); 
	}
}
