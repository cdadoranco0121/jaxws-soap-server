package fr.doranco.jaxws.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;

import fr.doranco.entity.Cours;
import fr.doranco.jaxws.connexion.DataSourceConnexion;

public class CoursDAO implements ICoursDAO {

	@Override
	public List<Cours> getCours() throws SQLException, MissingResourceException, IOException {
		List<Cours> listeCours = new ArrayList<Cours>();
		Connection connection = null;
		
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "SELECT * FROM cours";
		PreparedStatement ps = connection.prepareStatement(requete);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Cours cours = new Cours();
			cours.setId(rs.getInt("id"));
			cours.setTitre(rs.getString("titre"));
			cours.setDuree(rs.getInt("duree"));
			
			listeCours.add(cours);
		}
		
		return listeCours;
	}

	@Override
	public Cours getCoursById(Integer id) throws SQLException, MissingResourceException, IOException {
		Cours cours = null;
		Connection connection = null;
		
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "SELECT * FROM cours WHERE id = ?";
		
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			cours = new Cours();
			cours.setId(rs.getInt("id"));
			cours.setTitre(rs.getString("titre"));
			cours.setDuree(rs.getInt("duree"));
		}
		
		return cours;
	}

	@Override
	public Cours addCours(Cours cours) throws SQLException, MissingResourceException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
			
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "INSERT INTO cours (titre, duree) "
				+ "VALUES(?, ?)";
		ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, cours.getTitre());
		ps.setInt(2, cours.getDuree());
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			cours.setId(rs.getInt(1));
		}
		
		return cours;
	}

	@Override
	public Cours updateCours(Cours cours) throws SQLException, MissingResourceException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
			
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "UPDATE cours SET titre = ?, duree = ? "
				+ "WHERE id = ?";
		ps = connection.prepareStatement(requete);
		
		ps.setString(1, cours.getTitre());
		ps.setInt(2, cours.getDuree());
		ps.setInt(3, cours.getId());
		ps.executeUpdate();
		
		return cours;
	}

	@Override
	public void removeCours(Integer id) throws SQLException, MissingResourceException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
			
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "DELETE FROM cours WHERE id = ?";
		ps = connection.prepareStatement(requete);
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}

}
