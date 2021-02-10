package fr.doranco.jaxws.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import fr.doranco.entity.Cours;

public interface ICoursDAO {
	List<Cours> getCours() throws SQLException, MissingResourceException, IOException;
	Cours getCoursById(Integer id) throws SQLException, MissingResourceException, IOException;
	Cours addCours(Cours cours) throws SQLException, MissingResourceException, IOException;
	Cours updateCours(Cours cours) throws SQLException, MissingResourceException, IOException;
	void removeCours(Integer id) throws SQLException, MissingResourceException, IOException;
}
