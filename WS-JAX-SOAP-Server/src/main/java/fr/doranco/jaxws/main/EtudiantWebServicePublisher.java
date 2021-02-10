package fr.doranco.jaxws.main;

import javax.xml.ws.Endpoint;

import fr.doranco.jaxws.EtudiantService;

public class EtudiantWebServicePublisher {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			System.out.println("Publication du service web 'EtudiantService' en cours...");
			
			Endpoint.publish("http://localhost/9991/ws/etudiant-service", new EtudiantService());
			
			System.out.println("Web service 'EtudiantService' publié avec succès");
			
		} catch (Exception e) {
			System.err.println("[ERROR]: Web service non publié.");
			System.out.println(e.getMessage());
		}

	}

}
