package fr.restau.model;

public class Categorie {
    private String id;
    private String date;

    public Categorie() {}

    public Categorie(String id, String date) {
        this.id = id;
        this.date = date;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
