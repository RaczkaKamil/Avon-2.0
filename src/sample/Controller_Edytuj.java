package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Dodaj_zamowienie.OrderList;

import java.io.IOException;

public class Controller_Edytuj {

    @FXML
    Button Dodaj_zamowienie2;
    @FXML
    Button wprowadz;

    @FXML
    ComboBox<String> Wybor;

    @FXML
    TextField osoba_tf;
    @FXML
    TextField kod_tf;
    @FXML
    TextField strona_tf;
    @FXML
    TextField naleznosc_tf;


    OrderList or = new OrderList();

    public void initialize() throws IOException, ClassNotFoundException {

        or.odczyt();
        Wybor();

    }

    public void Wybor() {
        for (int i = 0; i < or.getListaZamowien().size(); i++) {
            Wybor.getItems().addAll(or.getListaZamowien().get(i).toString());
        }

    }

    public void wprowadzanie()
    {
        System.out.println(Wybor.getSelectionModel().getSelectedItem());
       osoba_tf.setText(or.porownajOsoby(Wybor.getSelectionModel().getSelectedItem() ));
        kod_tf.setText(or.porownajKod(Wybor.getSelectionModel().getSelectedItem()));
        strona_tf.setText(or.porownajStrone(Wybor.getSelectionModel().getSelectedItem()));
        naleznosc_tf.setText(or.porownajNaleznosc(Wybor.getSelectionModel().getSelectedItem()));
    }

    public void Dodaj_zamowienie( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tabScene = new Scene(root, 1400, 900);

        Stage windows = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
        windows.setScene(tabScene);
        windows.setX(251);
        windows.setY(35);
        windows.show();

    }
}
