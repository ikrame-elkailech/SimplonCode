package dao;

import java.util.List;

import model.Client;


public interface IClientDao {
	public Client ajouterClient(Client c);
	public List<Client> showAllClient();
	public List<Client> rechercheClient(String mc);
	public Client getClient(int id);
	public Client updateClient(Client c,int id);
	public void supprimerClient(int id);
}
