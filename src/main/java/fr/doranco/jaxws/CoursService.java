package fr.doranco.jaxws;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import javax.jws.WebService;

import fr.doranco.entity.Cours;
import fr.doranco.jaxws.dao.CoursDAO;
import fr.doranco.jaxws.dao.ICoursDAO;

@WebService(endpointInterface = "fr.doranco.jaxws.CoursService", 
	serviceName = "CoursService", 
	portName = "CoursPort")
public class CoursService implements ICoursService {
	
	private ICoursDAO coursDAO = new CoursDAO();

	@Override
	public List<Cours> getCours() throws SQLException, MissingResourceException, IOException {
		return coursDAO.getCours();
	}

	@Override
	public Cours getCoursById(Integer id) throws SQLException, MissingResourceException, IOException {
		return coursDAO.getCoursById(id);
	}

	@Override
	public Cours addCours(Cours cours) throws SQLException, MissingResourceException, IOException {
		return coursDAO.addCours(cours);
	}

	@Override
	public Cours updateCours(Cours cours) throws SQLException, MissingResourceException, IOException {
		return coursDAO.updateCours(cours);
	}

	@Override
	public void removeCours(Integer id) throws SQLException, MissingResourceException, IOException {
		coursDAO.removeCours(id);
	}

}
