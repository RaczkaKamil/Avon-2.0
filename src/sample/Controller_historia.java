package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_historia {



    public void Dodaj_zamowienie( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tabScene = new Scene(root, 1400, 900);

        Stage windows = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        windows.setScene(tabScene);
        windows.setX(251);
        windows.setY(35);
        windows.show();
    }

    public void Edytuj_zamowienie( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample_Edytuj.fxml"));
        Scene tabScene = new Scene(root, 1400, 900);

        Stage windows = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        windows.setScene(tabScene);
        windows.setX(251);
        windows.setY(35);
        windows.show();

    }

    public void Zloz_zamowienie( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample_zloz.fxml"));
        Scene tabScene = new Scene(root, 1400, 900);

        Stage windows = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        windows.setScene(tabScene);
        windows.setX(251);
        windows.setY(35);
        windows.show();

    }

    public void Lista_klientow( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample_lista.fxml"));
        Scene tabScene = new Scene(root, 1400, 900);

        Stage windows = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        windows.setScene(tabScene);
        windows.setX(251);
        windows.setY(35);
        windows.show();

    }
}