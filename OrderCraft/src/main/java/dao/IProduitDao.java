package dao;

import java.util.List;

import model.Produit;


public interface IProduitDao {
	public Produit ajouterProduit(Produit p);
	public List<Produit> showAllProduct();
	public List<Produit> rechercheProduit(String mc);
	public Produit getProduit(int id);
	public Produit updateProduit(Produit p,int id);
	public void supprimerProduit(int id);
}
