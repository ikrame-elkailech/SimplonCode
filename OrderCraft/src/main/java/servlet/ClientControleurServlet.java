package servlet;

import java.io.IOException;
import java.util.List;

import dao.IClientDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Client;
import model.ClientModel;
import dao.ClientDaoIplementation;

public class ClientControleurServlet extends HttpServlet {
	private IClientDao metier;
	
	@Override
	public void init() throws ServletException {
		metier = new ClientDaoIplementation();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		//liste des Client
		if(path.equals("/Client.action")) {
			ClientModel model = new ClientModel();
			List<Client> clients = metier.showAllClient();
			model.setClients(clients);
			req.setAttribute("model", model);
			req.getRequestDispatcher("Client/client.jsp").forward(req, res);
		}//rechercher
		else if(path.equals("/SearchClient.action")){
			req.getRequestDispatcher("Client/rechercheClient.jsp").forward(req, res);	
		}
		else if(path.equals("/rechercheClient.action")) {
			String motCle = req.getParameter("motCle");
			ClientModel model = new ClientModel();
			model.setMotCle(motCle);
			List<Client> client = metier.rechercheClient("%"+motCle+"%");
			model.setClients(client);
			req.setAttribute("model", model);
			req.getRequestDispatcher("Client/rechercheClient.jsp").forward(req, res);
		}//ajouter Client
		else if(path.equals("/AjouterClient.action")){
			req.getRequestDispatcher("Client/ajouterClient.jsp").forward(req, res);	
		}
		else if(path.equals("/SaveClient.action")&&(req.getMethod().equals("POST"))) {
			String nom = req.getParameter("nom");
			String adresse =req.getParameter("adresse");
			String telephone = req.getParameter("telephone");
			metier.ajouterClient(new Client(nom, adresse,telephone));
			res.sendRedirect("Client.action");	
		}//update Client
		else if(path.equals("/EditClient.action")){
			int id = Integer.parseInt(req.getParameter("id"));
			Client c = metier.getClient(id);
			req.setAttribute("c", c);
			req.setAttribute("id", id);
			req.getRequestDispatcher("Client/updateClient.jsp").forward(req, res);	
		}
		else if(path.equals("/UpdateClient.action")&&(req.getMethod().equals("POST"))) {
			int id = Integer.parseInt(req.getParameter("id"));
			String nom = req.getParameter("nom");
			String adresse = req.getParameter("adresse");
			String telephone = req.getParameter("telephone");
			Client p=new Client(nom, adresse, telephone);
			p.setId(id);
			metier.updateClient(p,id);
			res.sendRedirect("Client.action");	
		}//delete Client
		else if(path.equals("/SupprimerClient.action")){
			int id = Integer.parseInt(req.getParameter("id"));
			metier.supprimerClient(id);
			res.sendRedirect("Client.action");	
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
