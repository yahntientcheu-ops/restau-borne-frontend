package fr.restau.model;

public class LigneCommande {
    private Plat plat;
    private int quantite; // Permet de respecter REQ-ORD-002 (quantité 1 à 9)

    public LigneCommande() {}

    public LigneCommande(Plat plat, int quantite) {
        this.plat = plat;
        this.quantite = quantite;
    }

    // Calcul automatique du prix pour cette ligne (ex: 2 x 5€ = 10€)
    public double getSousTotal() {
        return plat.getPrix() * quantite;
    }

    // Getters et Setters
    public Plat getPlat() { return plat; }
    public void setPlat(Plat plat) { this.plat = plat; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
}
