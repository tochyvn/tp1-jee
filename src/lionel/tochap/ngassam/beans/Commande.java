package lionel.tochap.ngassam.beans;

public class Commande {

	private String modePaiement;
	private String statutPaiement;
	private String modeLivraison;
	private String statutLivraison;
	private Client client;
	private double montant;
	private String date;
	
	
	public String getModePaiement() {
		return modePaiement;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public String getStatutPaiement() {
		return statutPaiement;
	}
	public void setStatutPaiement(String statutPaiment) {
		this.statutPaiement = statutPaiment;
	}
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	public String getStatutLivraison() {
		return statutLivraison;
	}
	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
