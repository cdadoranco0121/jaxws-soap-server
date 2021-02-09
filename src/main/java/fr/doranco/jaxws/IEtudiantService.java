package fr.doranco.jaxws;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.entity.Etudiant;

@WebService(name = "EtudiantService", targetNamespace = "https://jaxws.doranco.fr")
public interface IEtudiantService {
	
	@WebMethod
	Etudiant addEtudiant(@WebParam(name = "etudiant") Etudiant etudiant) throws SQLException, MissingResourceException, IOException;
	
	@WebMethod
	List<Etudiant> getEtudiants() throws SQLException, MissingResourceException, IOException;
	
	@WebMethod
	Etudiant getEtudiantById(@WebParam(name = "etudiant") Integer id) throws SQLException, MissingResourceException, IOException;
}
