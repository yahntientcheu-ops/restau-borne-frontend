package fr.restau.model;

public class LigneCommande {
    private int quantite; // Entre 1 et 9
    private double prixUnitaire; // Ajouté selon le diagramme
    private String options; // Ex: "Sans oignons", "Supplément fromage"
    private Plat plat; // L'association avec le plat

    public LigneCommande() {}

    // Constructeur complet
    public LigneCommande(Plat plat, int quantite, String options) {
        this.plat = plat;
        this.quantite = quantite;
        this.prixUnitaire = plat.getPrix(); // On fige le prix du plat au moment de la commande
        this.options = options;
    }

    // Calcul du sous-total pour cette ligne spécifique
    public double getSousTotal() {
        return prixUnitaire * quantite;
    }

    // --- Getters et Setters (indispensables pour le diagramme et Jackson) ---
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrixUnitaire() { return prixUnitaire; }
    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public String getOptions() { return options; }
    public void setOptions(String options) { this.options = options; }

    public Plat getPlat() { return plat; }
    public void setPlat(Plat plat) { this.plat = plat; }
}
