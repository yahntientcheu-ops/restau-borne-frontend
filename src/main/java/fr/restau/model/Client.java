package fr.restau.model;

public class Client {
    private long id; // Type long comme sur le diagramme
    private String nomOuTable; // Permet d'identifier la table (ex: "Table 5")

    public Client() {}

    public Client(long id, String nomOuTable) {
        this.id = id;
        this.nomOuTable = nomOuTable;
    }

    // Getters et Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNomOuTable() { return nomOuTable; }
    public void setNomOuTable(String nomOuTable) { this.nomOuTable = nomOuTable; }
}
