package fr.doranco.jaxws;

import java.util.List;

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
	public Etudiant addEtudiant(Etudiant etudiant) throws Exception {
		return etudiantDAO.addEtudiant(etudiant);
	}

	@Override
	public List<Etudiant> getEtudiants() throws Exception {
		List<Etudiant> etudiants = etudiantDAO.getEtudiants();
		
		if (etudiants == null || etudiants.isEmpty())
			throw new NullPointerException("Il n'existe aucun étudiant dans la BDD !");
		
		return etudiants;
	}

	@Override
	public Etudiant getEtudiantById(Integer id) throws Exception {
		
		if (id == null || id <= 0) 
			throw new NullPointerException("L'id doit être numérique et >= 0 !");
		
		Etudiant etudiant = etudiantDAO.getEtudiantById(id);
		
		if (etudiant == null) 
			throw new NullPointerException("L'étudiant avec l'id = " + id + " n'existe pas !");
		
		return etudiant;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant etudiant) throws Exception {
		return etudiantDAO.updateEtudiant(etudiant);
	}

	@Override
	public void removeEtudiant(Integer id) throws Exception {
		etudiantDAO.removeEtudiant(id);
	}

}
