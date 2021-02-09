package fr.doranco.jaxws.main;

import java.util.List;

import fr.doranco.entity.Etudiant;
import fr.doranco.jaxws.EtudiantService;
import fr.doranco.jaxws.IEtudiantService;

public class Test {

	public static void main(String[] args)  {
		
		try {
			
			IEtudiantService etudiantService = new EtudiantService();
			
			Etudiant etudiant = new Etudiant("CAMUS", "Albert", "Ecrivain");
			System.out.println("Test de la m�thode d'ajout d'un �tudiant: " + etudiant);
			Etudiant etudiantAdded = etudiantService.addEtudiant(etudiant);
			
			if(etudiantAdded.getId() != 0) {
				System.out.println("L'�tudiant � bien �t� ajout�: " + etudiant);
			} else {
				System.out.println("L'�tudiant n'a pas �t� ajout� !");			
			}
			
			etudiant = new Etudiant("HUGO", "Victor", "Romancier");
			System.out.println("");
			System.out.println("Test de la m�thode d'ajout d'un �tudiant: " + etudiant);
			etudiantAdded = etudiantService.addEtudiant(etudiant);
			
			if(etudiantAdded.getId() != 0) {
				System.out.println("L'�tudiant � bien �t� ajout�: " + etudiant);
			} else {
				System.out.println("L'�tudiant n'a pas �t� ajout� !");			
			}
			
			System.out.println("");
			System.out.println("Test de la m�thode de r�cup�ration de tous les �tudiants: ");
			
			List<Etudiant> listeEtudiants = etudiantService.getEtudiants();
			
			for (Etudiant student : listeEtudiants) {
				System.out.println(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
