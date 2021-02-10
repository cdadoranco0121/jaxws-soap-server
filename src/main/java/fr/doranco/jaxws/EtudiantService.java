package fr.doranco.jaxws;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.MissingResourceException;

import javax.jws.WebService;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.dao.EtudiantDAO;
import fr.doranco.jaxws.dao.IEtudiantDAO;


@WebService(endpointInterface = "fr.doranco.jaxws.EtudiantService", 
	serviceName = "EtudiantService", 
	portName = "EtudiantPort")
public class EtudiantService implements IEtudiantService {
	
	private IEtudiantDAO etudiantDAO = new EtudiantDAO();
	
	@Override
	public Etudiant addEtudiant(Etudiant etudiant) throws SQLException, MissingResourceException, IOException {
		return etudiantDAO.addEtudiant(etudiant);
	}

	@Override
	public List<Etudiant> getEtudiants() throws SQLException, MissingResourceException, IOException {
		return etudiantDAO.getEtudiants();
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws SQLException, MissingResourceException, IOException {
		return etudiantDAO.getEtudiantById(id);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) throws SQLException, MissingResourceException, IOException {
		return etudiantDAO.updateEtudiant(etudiant);
	}

	@Override
	public void removeEtudiant(Integer id) throws SQLException, MissingResourceException, IOException {
		etudiantDAO.removeEtudiant(id);
	}

}
