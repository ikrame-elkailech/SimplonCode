package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class ClientDaoIplementation implements IClientDao {

	public Client ajouterClient(Client c) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("INSERT INTO client( nom, adresse, telephone) VALUES(?, ?, ?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getAdresse());
			ps.setString(3, c.getTelephone());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public List<Client> showAllClient() {
		List<Client> clients = new ArrayList<Client>();
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from Client");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
				clients.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();	
		}
		return clients;
	}

	@Override
	public List<Client> rechercheClient(String mc) {
		List<Client>clients = new ArrayList<Client>();
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from Client where nom like ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Client c = new Client();
				c.setNom(rs.getString("nom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
				clients.add(c);
			}
		}catch(SQLException e){
			e.printStackTrace();	
		}
		return clients;
	}

	@Override
	public Client getClient(int id) {
		Client c = null;
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select *from Client where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c = new Client();
				c.setNom(rs.getString("nom"));
				c.setAdresse(rs.getString("adresse"));
				c.setTelephone(rs.getString("telephone"));
			}
		}catch(SQLException e){
			e.printStackTrace();	
		}
		return c;
	}

	@Override
	public Client updateClient(Client c ,int id) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("UPDATE Client SET nom = ? , adresse = ? , telephone = ? WHERE id = ?");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getAdresse());
			ps.setString(3, c.getTelephone());
			ps.setInt(4, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void supprimerClient(int id) {
		Connection con = SingletonConnection.getConnection();
		try {
			PreparedStatement ps =con.prepareStatement("delete from Client where id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
