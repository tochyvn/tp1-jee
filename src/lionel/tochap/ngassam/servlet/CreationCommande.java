package lionel.tochap.ngassam.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lionel.tochap.ngassam.beans.Client;
import lionel.tochap.ngassam.beans.Commande;

public class CreationCommande extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("La servlet de Creation de commandes à bien été paramétrée");
		
		//Recuperation des données du formulaire
		//Recupération des paramètres de requête
		String nom = req.getParameter("nomClient");
		String prenom = req.getParameter("prenomClient");
		String adresse = req.getParameter("adresseClient");
		String numTel = req.getParameter("telephoneClient");
		String email = req.getParameter("emailClient");
		double montant = 0.0;
		try {
			montant = Double.parseDouble(req.getParameter("montantCommande"));
		} catch (NumberFormatException e) {
			montant = 1;
		}
		//Double montant = Double.parseDouble(montantString);
		String modePaiement = req.getParameter("modePaiementCommande");
		String statutPaiement = req.getParameter("statutPaiementCommande");
		String modeLivraison = req.getParameter("modeLivraisonCommande");
		String statutLivraison = req.getParameter("statutLivraisonCommande");
		String message = "";
			
		if ( nom.trim().isEmpty() || adresse.trim().isEmpty() || numTel.trim().isEmpty() || montant == -1
                || modePaiement.isEmpty() || modeLivraison.isEmpty() ) {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"creerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'une commande.";
        } else {
            message = "Commande créée avec succès !";
        }
			
		//Creation du Client
		Client client = new Client();
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setAdresse(adresse);
		client.setNumTel(numTel);
		client.setEmail(email);
		
		//creation de la commande
		Commande commande = new Commande();
		commande.setMontant(montant);
		commande.setClient(client);
		commande.setModeLivraison(modeLivraison);
		commande.setModePaiement(modePaiement);
		commande.setStatutLivraison(statutLivraison);
		commande.setStatutPaiement(statutPaiement);
		
		//Ajout des attribut à l'objet requete
		req.setAttribute("commande", commande);
		req.setAttribute("message", message);
		
		//Chargement de la vue d'affichage
		this.getServletContext().getRequestDispatcher("/afficherCommande.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	

}
