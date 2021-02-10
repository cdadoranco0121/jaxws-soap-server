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

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.connexion.DataSourceConnexion;

public class EtudiantDAO implements IEtudiantDAO {

	@Override
	public List<Etudiant> getEtudiants() throws SQLException, MissingResourceException, IOException {
		List<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
		Connection connection = null;
		
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "SELECT * FROM etudiant";
		PreparedStatement ps = connection.prepareStatement(requete);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Etudiant etudiant = new Etudiant();
			etudiant.setId(rs.getInt("id"));
			etudiant.setNom(rs.getString("nom"));
			etudiant.setPrenom(rs.getString("prenom"));
			etudiant.setSpecialite(rs.getString("specialite"));
			etudiant.setAge(rs.getInt("age"));
			
			listeEtudiant.add(etudiant);
		}
		
		return listeEtudiant;
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws SQLException, MissingResourceException, IOException {
		
		Etudiant etudiant = null;
		Connection connection = null;
		
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "SELECT * FROM etudiant WHERE id = ?";
		
		PreparedStatement ps = connection.prepareStatement(requete);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			etudiant = new Etudiant();
			etudiant.setId(rs.getInt("id"));
			etudiant.setNom(rs.getString("nom"));
			etudiant.setPrenom(rs.getString("prenom"));
			etudiant.setSpecialite(rs.getString("specialite"));
			etudiant.setAge(rs.getInt("age"));
		}
		
		return etudiant;
	}

	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws SQLException, MissingResourceException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
			
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "INSERT INTO etudiant (nom, prenom, specialite, age) "
				+ "VALUES(?, ?, ?, ?)";
		ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, etudiant.getNom());
		ps.setString(2, etudiant.getPrenom());
		ps.setString(3, etudiant.getSpecialite());
		ps.setInt(4, etudiant.getAge());
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			etudiant.setId(rs.getInt(1));
		}
		
		return etudiant;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) throws SQLException, MissingResourceException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
			
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "UPDATE etudiant SET nom = ?, prenom = ?, specialite = ?, age = ? "
				+ "WHERE id = ?";
		ps = connection.prepareStatement(requete);
		
		ps.setString(1, etudiant.getNom());
		ps.setString(2, etudiant.getPrenom());
		ps.setString(3, etudiant.getSpecialite());
		ps.setInt(4, etudiant.getAge());
		ps.setInt(5, etudiant.getId());
		ps.executeUpdate();
		
		return etudiant;
	}

	@Override
	public void removeEtudiant(Integer id) throws SQLException, MissingResourceException, IOException {
		Connection connection = null;
		PreparedStatement ps = null;
			
		connection = DataSourceConnexion.getInstance().getConnection();
		String requete = "DELETE FROM etudiant WHERE id = ?";
		ps = connection.prepareStatement(requete);
		ps.setInt(1, id);
		
		ps.executeUpdate();
	}

}
