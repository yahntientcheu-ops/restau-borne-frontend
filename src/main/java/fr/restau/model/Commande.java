package fr.restau.model;

import java.util.ArrayList;
import java.util.List;

public class Commande {
    private String id;
    private List<LigneCommande> lignes = new ArrayList<>();
    private double prixTotal;

    public Commande() {}

    // Méthode pour ajouter un plat au panier (Logique métier Personne C)
    public void ajouterPlat(Plat plat) {
        // 1. On cherche si le plat est déjà dans le panier
        for (LigneCommande ligne : lignes) {
            if (ligne.getPlat().getId().equals(plat.getId())) {
                // Si trouvé, on augmente la quantité (limite de 9 selon REQ-ORD-002)
                if (ligne.getQuantite() < 9) {
                    ligne.setQuantite(ligne.getQuantite() + 1);
                }
                calculerTotal();
                return;
            }
        }
        // 2. Si non trouvé, on crée une nouvelle ligne
        lignes.add(new LigneCommande(plat, 1));
        calculerTotal();
    }

    // Calcule la somme de tous les sous-totaux
    public void calculerTotal() {
        this.prixTotal = 0;
        for (LigneCommande ligne : lignes) {
            this.prixTotal += ligne.getSousTotal();
        }
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public List<LigneCommande> getLignes() { return lignes; }
    public void setLignes(List<LigneCommande> lignes) { this.lignes = lignes; }

    public double getPrixTotal() { return prixTotal; }
}
