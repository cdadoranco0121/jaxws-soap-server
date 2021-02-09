package fr.doranco.jaxws.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import fr.doranco.entity.Etudiant;

public interface IEtudiantDAO {
	List<Etudiant> getEtudiants() throws SQLException, MissingResourceException, IOException;
	Etudiant getEtudiantById(Integer id) throws SQLException, MissingResourceException, IOException;
	Etudiant addEtudiant(Etudiant etudiant) throws SQLException, MissingResourceException, IOException;
}
