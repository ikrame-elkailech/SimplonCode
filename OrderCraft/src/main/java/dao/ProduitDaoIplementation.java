package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produit;

public class ProduitDaoIplementation implements IProduitDao {

	public Produit ajouterProduit(Produit p) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("INSERT INTO produit (nom, prix, quantite) VALUES(?, ?, ?)");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public List<Produit> showAllProduct() {
		List<Produit>produits = new ArrayList<Produit>();
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from Produit");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("id"));
				p.setNom(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				produits.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();	
		}
		return produits;
	}

	@Override
	public List<Produit> rechercheProduit(String mc) {
		List<Produit>produits = new ArrayList<Produit>();
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from Produit where nom like ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Produit p = new Produit();
				p.setNom(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				produits.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();	
		}
		return produits;
	}

	@Override
	public Produit getProduit(int id) {
		Produit p = null;
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from Produit where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Produit();
				p.setNom(rs.getString("nom"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
			}
		}catch(SQLException e){
			e.printStackTrace();	
		}
		return p;
	}

	@Override
	public Produit updateProduit(Produit p ,int id) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("UPDATE produit SET nom = ? , prix = ? , quantite = ? WHERE id = ?");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void supprimerProduit(int id) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("delete from produit where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
