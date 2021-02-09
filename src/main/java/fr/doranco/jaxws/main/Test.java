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
			System.out.println("Test de la méthode d'ajout d'un étudiant: " + etudiant);
			Etudiant etudiantAdded = etudiantService.addEtudiant(etudiant);
			
			if(etudiantAdded.getId() != 0) {
				System.out.println("L'étudiant à bien été ajouté: " + etudiant);
			} else {
				System.out.println("L'étudiant n'a pas été ajouté !");			
			}
			
			etudiant = new Etudiant("HUGO", "Victor", "Romancier");
			System.out.println("");
			System.out.println("Test de la méthode d'ajout d'un étudiant: " + etudiant);
			etudiantAdded = etudiantService.addEtudiant(etudiant);
			
			if(etudiantAdded.getId() != 0) {
				System.out.println("L'étudiant à bien été ajouté: " + etudiant);
			} else {
				System.out.println("L'étudiant n'a pas été ajouté !");			
			}
			
			System.out.println("");
			System.out.println("Test de la méthode de récupération de tous les étudiants: ");
			
			List<Etudiant> listeEtudiants = etudiantService.getEtudiants();
			
			for (Etudiant student : listeEtudiants) {
				System.out.println(student);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
