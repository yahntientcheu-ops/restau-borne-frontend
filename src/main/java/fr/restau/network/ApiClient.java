package fr.restau.network;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.restau.model.Commande;
import fr.restau.model.Plat;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiClient {
    private final String BASE_URL = "http://localhost:7070"; // Port de la Personne A
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

   // Dans ApiClient.java
public List<Plat> getTousLesPlats() throws Exception {
    // Change "/plats" par "/menu" car c'est ce que la personne A a écrit
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/menu")) 
            .GET()
            .build();
    // ... reste du code
}

public void envoyerCommande(Commande commande) throws Exception {
    // Change "/commander" par "/valider"
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/valider"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(commande)))
            .build();
    // ... reste du code
}

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
