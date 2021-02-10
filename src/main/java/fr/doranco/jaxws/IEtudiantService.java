package fr.doranco.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import fr.doranco.entity.Etudiant;

@WebService(name = "EtudiantService", targetNamespace = "https://jaxws.doranco.fr")
public interface IEtudiantService {
	
	@WebMethod
	Etudiant addEtudiant(@WebParam(name = "etudiant") Etudiant etudiant) throws Exception;
	
	@WebMethod
	List<Etudiant> getEtudiants() throws Exception;
	
	@WebMethod
	Etudiant getEtudiantById(@WebParam(name = "id") Integer id) throws Exception;
	
	@WebMethod
	Etudiant updateEtudiant(@WebParam(name = "etudiant") Etudiant etudiant) throws Exception;
	
	@WebMethod
	void removeEtudiant(@WebParam(name = "id") Integer id) throws Exception;
}
