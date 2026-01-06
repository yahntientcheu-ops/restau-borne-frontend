package fr.restau.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Commande {
    private long id;
    private double prixTotal;
    private String identifiantClient;
    private Date date;
    private List<LigneCommande> lignes = new ArrayList<>();

    public Commande() {
        this.date = new Date();
    }

    public void calculerTotal() {
        this.prixTotal = 0;
        for (LigneCommande ligne : lignes) {
            this.prixTotal += (ligne.getPrixUnitaire() * ligne.getQuantite());
        }
    }

    // --- AJOUTE CES MÉTHODES ICI (LOGIQUE PERSONNE C) ---

    public void ajouterPlat(Plat plat) {
        for (LigneCommande ligne : lignes) {
            if (ligne.getPlat().getId() == plat.getId()) {
                if (ligne.getQuantite() < 9) { // Limite de 9
                    ligne.setQuantite(ligne.getQuantite() + 1);
                }
                calculerTotal();
                return;
            }
        }
        lignes.add(new LigneCommande(plat, 1, "")); // Nouvelle ligne
        calculerTotal();
    }

    public void retirerPlat(Plat plat) {
        lignes.removeIf(ligne -> {
            if (ligne.getPlat().getId() == plat.getId()) {
                if (ligne.getQuantite() > 1) {
                    ligne.setQuantite(ligne.getQuantite() - 1);
                    return false;
                }
                return true; // Supprime la ligne si qté arrive à 0
            }
            return false;
        });
        calculerTotal();
    }

    // --- FIN DES MÉTHODES AJOUTÉES ---

    // Tes Getters et Setters...
    public List<LigneCommande> getLignes() { return lignes; }
    // ... reste du code
}
