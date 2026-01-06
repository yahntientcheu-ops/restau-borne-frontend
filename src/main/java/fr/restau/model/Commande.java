package fr.restau.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; // Pour la variable date du diagramme

public class Commande {
    private long id; // Type long comme sur le diagramme
    private double prixTotal;
    private String identifiantClient; // Ajouté selon le diagramme
    private Date date; // Ajouté selon le diagramme
    private List<LigneCommande> lignes = new ArrayList<>();

    public Commande() {
        this.date = new Date(); // Par défaut, la commande est à la date d'aujourd'hui
    }

    // La logique de calcul reste la même pour REQ-ORD-004
    public void calculerTotal() {
        this.prixTotal = 0;
        for (LigneCommande ligne : lignes) {
            this.prixTotal += (ligne.getPrixUnitaire() * ligne.getQuantite());
        }
    }

    // Getters et Setters pour correspondre aux tables
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public double getPrixTotal() { return prixTotal; }
    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }
    public String getIdentifiantClient() { return identifiantClient; }
    public void setIdentifiantClient(String idClient) { this.identifiantClient = idClient; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
