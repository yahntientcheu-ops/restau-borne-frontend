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

    // Mission 1 : Récupérer la carte des plats
    public List<Plat> getTousLesPlats() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/plats"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Transforme le JSON reçu en une liste d'objets Plat
        return mapper.readValue(response.body(), 
               mapper.getTypeFactory().constructCollectionType(List.class, Plat.class));
    }

    // Mission 2 : Envoyer la commande finale
    public void envoyerCommande(Commande commande) throws Exception {
        String json = mapper.writeValueAsString(commande);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/commander"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
