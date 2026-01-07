package fr.restau.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {

    private long id;
    private String identifiantClient;
    private Date date;
    private List<LigneCommande> lignes = new ArrayList<>();
    private double prixTotal;

    // --- CONSTRUCTEURS ---
    public Commande() {
        this.date = new Date();
    }

    // --- LOGIQUE MÉTIER ---
    public void calculerTotal() {
        prixTotal = 0;
        for (LigneCommande ligne : lignes) {
            prixTotal += ligne.getPrixUnitaire() * ligne.getQuantite();
        }
    }

    public void ajouterPlat(Plat plat) {
        for (LigneCommande ligne : lignes) {
            if (ligne.getPlat().getId() == plat.getId()) {
                if (ligne.getQuantite() < 9) { // limite de 9
                    ligne.setQuantite(ligne.getQuantite() + 1);
                }
                calculerTotal();
                return;
            }
        }
        lignes.add(new LigneCommande(plat, 1, ""));
        calculerTotal();
    }

    public void retirerPlat(Plat plat) {
        lignes.removeIf(ligne -> {
            if (ligne.getPlat().getId() == plat.getId()) {
                if (ligne.getQuantite() > 1) {
                    ligne.setQuantite(ligne.getQuantite() - 1);
                    return false;
                }
                return true;
            }
            return false;
        });
        calculerTotal();
    }

    // --- GETTERS ---
    public long getId() {
        return id;
    }

    public String getIdentifiantClient() {
        return identifiantClient;
    }

    public Date getDate() {
        return date;
    }

    public List<LigneCommande> getLignes() {
        return lignes;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    // --- SETTERS ---
    public void setId(long id) {
        this.id = id;
    }

    public void setIdentifiantClient(String identifiantClient) {
        this.identifiantClient = identifiantClient;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLignes(List<LigneCommande> lignes) {
        this.lignes = lignes;
        calculerTotal();
    }
}
