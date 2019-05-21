package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Dodaj_zamowienie.OrderList;

import javax.swing.*;
import java.io.IOException;

public class Controller_zloz  {

    JLabel label;


    @FXML
    AnchorPane am;
    @FXML
    GridPane anchor;
    @FXML
    VBox Vbox1;
    @FXML
    Button Edytuj_zamowienie2;
    @FXML
    Button Dodaj_zamowienie2;
    @FXML
    TextArea zamowienia_ta1;
    @FXML
    TextField test;

    int n = 2000;
    OrderList or = new OrderList();
    OrderListCode orcode = new OrderListCode();
    int[] tab_int = new int[n];
    char[] c = new char[21];


    public void initialize() throws IOException, ClassNotFoundException {


        // JPanel p = new JPanel();
        //label = new JLabel("Key Listener!");
        // p.add(label);
        //add(p);
        //   addKeyListener(this);
        //  setSize(100, 100);
        // setFocusable(true);
        // setVisible(true);


        or.odczyt();
        this.n = or.getListaZamowien().size();
        System.out.println(tab_int.length);
        zamowienia_ta1.setText(or.getListaZamowien().toString().substring(1).replace("]", "").replace(",", ""));
        wygenerowaneKody();

    }

    public void wygenerowaneKody() throws IOException, ClassNotFoundException {
        ActionEvent event = new ActionEvent();
        orcode.inicialize();
        Button button[] = new Button[or.getListaZamowien().size()];
        TextField textFields[] = new TextField[or.getListaZamowien().size()];

        for (int i = 0; i < or.getListaZamowien().size(); i++) {
            button[i] = new Button("kopiuj");
            button[i].setUserData(i + 1);
            button[i].setOnAction(this::numChange);
            textFields[i] = new TextField(orcode.getListaZamowienKody().get(i).toString());

            anchor.add(textFields[i], 5, i);
            anchor.add(button[i], 10, i);

            tab_int[i] = Integer.parseInt(textFields[i].getText());


        }
    }


    @FXML
    private void numChange( ActionEvent event ) {
        Node node = (Node) event.getSource();
        int data = (Integer) node.getUserData();
        System.out.println(data);
        copy(data);
        node.setStyle("-fx-background-color: MediumSeaGreen");

    }

    private void copy( int b_id ) {
        String copyText = String.valueOf(tab_int[b_id - 1]);
        System.out.println(copyText);
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(copyText);
        clipboard.setContent(content);


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

    public void Edytuj_zamowienie( ActionEvent event ) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("sample_Edytuj.fxml"));
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
}

