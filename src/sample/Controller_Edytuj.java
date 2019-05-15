package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
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
    Button Zmien;
    @FXML
    Button Usun;

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

    @FXML
    TextArea zamowienia_ta;


    OrderList or = new OrderList();
    Sprawdzenie spr = new Sprawdzenie();

    public void initialize() throws IOException, ClassNotFoundException {

        or.odczyt();
        Wybor();
        zamowienia_ta.setText(or.getListaZamowien().toString().substring(1).replace("]", "").replace(",",""));

    }

    public void Wybor() {
        Wybor.getItems().clear();
        for (int i = 0; i < or.getListaZamowien().size(); i++) {
            Wybor.getItems().addAll(or.getListaZamowien().get(i).toString());
        }

    }

    public void wprowadzanie()
    {

       osoba_tf.setText(or.porownajOsoby(Wybor.getSelectionModel().getSelectedItem() ));
        kod_tf.setText(or.porownajKod(Wybor.getSelectionModel().getSelectedItem()));
        strona_tf.setText(or.porownajStrone(Wybor.getSelectionModel().getSelectedItem()));
        naleznosc_tf.setText(or.porownajNaleznosc(Wybor.getSelectionModel().getSelectedItem()));
    }

    public void zmiana() throws IOException, ClassNotFoundException {
        if(spr.sprawdzenie(osoba_tf.getText(),kod_tf.getText(),strona_tf.getText(),naleznosc_tf.getText()))
        {
            or.edytuj(Integer.parseInt(or.porownajID(Wybor.getSelectionModel().getSelectedItem())),osoba_tf.getText(),Integer.parseInt(kod_tf.getText()),Integer.parseInt(strona_tf.getText()),Double.parseDouble(naleznosc_tf.getText()));
            OrderList.zapis(or.getListaZamowien());
            zamowienia_ta.setText(or.getListaZamowien().toString().substring(1).replace("]", "").replace(",",""));
            czyszczenie();
        }
    }

    public void czyszczenie()
    {
        Wybor();
        osoba_tf.setText("");
        kod_tf.setText("");
        strona_tf.setText("");
        naleznosc_tf.setText("");
    }

    public void usuwanie()
    {

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
