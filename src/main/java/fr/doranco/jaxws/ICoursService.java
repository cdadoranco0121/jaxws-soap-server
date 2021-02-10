package fr.doranco.jaxws;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.entity.Cours;

@WebService(name = "CoursService", targetNamespace = "https://jaxws.doranco.fr")
public interface ICoursService {
	@WebMethod
	List<Cours> getCours() throws SQLException, MissingResourceException, IOException;
	
	@WebMethod
	Cours getCoursById(@WebParam(name = "cours") Integer id) throws SQLException, MissingResourceException, IOException;
	
	@WebMethod
	Cours addCours(@WebParam(name = "cours") Cours cours) throws SQLException, MissingResourceException, IOException;
	
	@WebMethod
	Cours updateCours(@WebParam(name = "cours") Cours cours) throws SQLException, MissingResourceException, IOException;
	
	@WebMethod
	void removeCours(@WebParam(name = "cours") Integer id) throws SQLException, MissingResourceException, IOException;
}
