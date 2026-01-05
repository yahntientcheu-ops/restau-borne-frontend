package fr.restau.model;

public class Categorie {
    private String id;
    private String nom;

    public Categorie() {}

    public Categorie(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
