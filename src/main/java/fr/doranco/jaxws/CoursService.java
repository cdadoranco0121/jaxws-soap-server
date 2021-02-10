package fr.doranco.jaxws;

import java.util.List;

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
	public List<Cours> getCours() throws Exception {
		return coursDAO.getCours();
	}

	@Override
	public Cours getCoursById(Integer id) throws Exception {
		return coursDAO.getCoursById(id);
	}

	@Override
	public Cours addCours(Cours cours) throws Exception {
		return coursDAO.addCours(cours);
	}

	@Override
	public Cours updateCours(Cours cours) throws Exception {
		return coursDAO.updateCours(cours);
	}

	@Override
	public void removeCours(Integer id) throws Exception {
		coursDAO.removeCours(id);
	}

}
