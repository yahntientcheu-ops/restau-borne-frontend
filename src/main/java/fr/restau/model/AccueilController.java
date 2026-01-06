package fr.restau.model; // Adapte selon ton projet

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AccueilController {

    @FXML
    private Button btnCommencer;

    @FXML
    public void initialize() {
        btnCommencer.setOnAction(event -> {
            System.out.println("Bouton cliqué ! Passage au menu...");
            // C'est ici que ton collègue C ajoutera la logique de navigation
        });
    }

    public void handleCommencer(ActionEvent actionEvent) {
    }
}
