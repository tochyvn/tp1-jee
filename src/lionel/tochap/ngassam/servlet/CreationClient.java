package lionel.tochap.ngassam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lionel.tochap.ngassam.beans.Client;

public class CreationClient extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("La servlet de Creation client à bien été paramétrée");
		
		//Recupération des paramètres de requête
		String nom = req.getParameter("nomClient");
		String prenom = req.getParameter("prenomClient");
		String adresse = req.getParameter("adresseClient");
		String numTel = req.getParameter("telephoneClient");
		String email = req.getParameter("emailClient");
		String message = "";
		
		if (nom.trim().isEmpty() || adresse.trim().isEmpty() || numTel.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires."
					+ " <br> <a href=\"creationClient.jsp\">Cliquez ici</a> pour accéder"
					+ " au formulaire de création d'un client.";
		} else {
			message = "Client crée avec succès";
		}
		
		//Creation du Client
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setNumTel(numTel);
		client.setEmail(email);
		
		//Ajout du bean et du message à l'objet request
		req.setAttribute("client", client);
		req.setAttribute("message", message);
		
		//Transmission de l'affichage à la page JSP en charge de l'affichage
		this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	

}
