package fr.restau.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

    public class Categorie {

        @FXML
        private Button btnEntrees, btnPlats, btnDesserts, btnBoissons, btnVegetarien;

        /**
         * Cette méthode unique gère tous les clics de catégorie.
         * Elle récupère le texte du bouton pour savoir quoi afficher ensuite.
         */
        @FXML
        private void handleCategory(ActionEvent event) {
            // 1. Récupérer le bouton qui a été cliqué
            Button sourceButton = (Button) event.getSource();
            String categorieSelectionnee = sourceButton.getText();

            System.out.println("Catégorie choisie : " + categorieSelectionnee);

            // 2. Charger l'écran Catalogue
            chargerCatalogue(categorieSelectionnee);
        }

        private void chargerCatalogue(String categorie) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/catalogue.fxml"));
                Parent root = loader.load();

                // ICI : On pourra passer la catégorie au contrôleur du catalogue plus tard
                // CatalogueController controller = loader.getController();
                // controller.setFilter(categorie);

                Stage stage = (Stage) btnEntrees.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        private void handleRetour(ActionEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/accueil.fxml"));
                Stage stage = (Stage) btnEntrees.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }