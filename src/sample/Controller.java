package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;
import sample.Dodaj_zamowienie.*;

import java.io.IOException;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;


public class Controller {
    private static final long serialVersionUID = 1L;

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

    @FXML
    Button akceptacja_bt;
    @FXML
    Button cofnij_bt;
    @FXML
    Button Edytuj_kontroler;
    @FXML
    Button Zloz_zamowienie2;

    @FXML
    Label label;

    PersonList personList = new PersonList();
    OrderList orderList = new OrderList();
    Miesiac miesiac = new Miesiac();
    Sprawdzenie spr = new Sprawdzenie();

    public void Edytuj_zamowienie( ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample_Edytuj.fxml"));
        Scene tabScene = new Scene(root,1400,900);

        Stage windows = (Stage) ((Node) event.getSource()).getScene().getWindow();
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


    public void Historia_zamowien( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample_historia.fxml"));
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

    public void initialize() throws IOException, ClassNotFoundException {
        TextFields.bindAutoCompletion(osoba_tf, personList.getOsoby());

        orderList.odczyt();
        zamowienia_ta.setText(orderList.getListaZamowien().toString().substring(1).replace("]", "").replace(",",""));



        LocalDate a = LocalDate.now();
        String miesiacPL = miesiac.tlumacz(a.getMonthValue());
        label.setText("Lista zamówień na " + miesiacPL + ":");
    }

    public void Cofnij() throws IOException {
        Order order = new Order();
        order.setId(orderList.getListaZamowien().size()-1);
        orderList.removelistaZamowien();
        zamowienia_ta.setText(orderList.getListaZamowien().toString().substring(1).replace("]", "").replace(",",""));
        OrderList.zapis(orderList.getListaZamowien());
    }

    public void Akceptacja() throws IOException {
        String osoba = osoba_tf.getText();
        String kodS = kod_tf.getText();
        String stronaS = strona_tf.getText();
        String naleznoscS = naleznosc_tf.getText();

       if(spr.sprawdzenie(osoba,kodS,stronaS,naleznoscS))
       {
           int kod = parseInt(kodS);
           int strona = parseInt(stronaS);
           double naleznosc = Double.parseDouble(naleznoscS);
           Order order = new Order();
           order.Order(osoba, kod, strona, naleznosc);
           order.setId(orderList.getListaZamowien().size());
           System.out.println(order.getId());
           orderList.addlistaZamowien(order);
           zamowienia_ta.setText(orderList.getListaZamowien().toString().substring(1).replace("]", "").replace(",",""));
           OrderList.zapis(orderList.getListaZamowien());
       }


    }


}
