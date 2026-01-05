package fr.restau.model;

public class Plat {
    private String id;
    private String nom;
    private String description;
    private double prix;
    private Categorie categorie; // Utilise maintenant la classe Categorie
    private String regimeSpecial; // Ex: "Végétarien", "Pimenté", "Sans Gluten"
    private boolean estDisponible; // Obligatoire selon REQ-MNU-004

    public Plat() {}

    public Plat(String id, String nom, String description, double prix, Categorie categorie, String regimeSpecial) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.regimeSpecial = regimeSpecial;
        this.estDisponible = true;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public String getRegimeSpecial() { return regimeSpecial; }
    public void setRegimeSpecial(String regimeSpecial) { this.regimeSpecial = regimeSpecial; }

    public boolean isEstDisponible() { return estDisponible; }
    public void setEstDisponible(boolean estDisponible) { this.estDisponible = estDisponible; }
}
