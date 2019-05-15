package sample;

import javafx.scene.control.Alert;

import static java.lang.Integer.parseInt;

public class Sprawdzenie {
    boolean gotowe = false;


    public boolean sprawdzenie( String osoba, String kod, String strona, String naleznosc ) {
        boolean t1 = false;
        boolean t2 = false;
        boolean t3 = false;
        boolean t4 = false;
        boolean tFinal = false;

        t1 = sprawdzenie1(osoba);
        t2 = sprawdzanie2(kod);
        t3 = sprawdzenie3(strona);
        t4 = sprawdzenie4(naleznosc);
        if (t1 && t2 && t3 && t4) {
            tFinal = true;
        }
        return tFinal;
    }

    public boolean sprawdzenie1( String osoba ) {
        boolean t = false;
        boolean ts = false;
        boolean s = false;

        if (osoba.isEmpty()) {
            displayWrongInputDialog("Wpisz osobe!");
        }

        if (!osoba.isEmpty()) {
            for (char c : osoba.toCharArray()) {
                if (ts = Character.isDigit(c)) {
                    displayWrongInputDialog(" Nie można wpisać cyfry do pola 'osoba'! ");
                }

            }
            if (!ts) {

                t = true;
            }
        }
        return t;
    }

    public boolean sprawdzanie2( String kod ) {
        boolean t = false;
        if (kod.isEmpty()) {
            displayWrongInputDialog("Wpisz kod!");
        } else {
            try {
                int x = parseInt(kod);
                if (kod.length() == 5) {
                    t = true;
                } else {
                    displayWrongInputDialog("Wpisany kod ma błędną długość!");
                }

            } catch (NumberFormatException e) {
                displayWrongInputDialog("W polu 'kod' nie można wpisać litery! ");
            }
        }

        return t;
    }

    public boolean sprawdzenie3( String strona ) {
        boolean t = false;
        if (strona.isEmpty()) {
            displayWrongInputDialog("Wpisz strone katalogu!");
        } else {
            try {
                int x = parseInt(strona);
                t = true;
            } catch (NumberFormatException e) {
                displayWrongInputDialog("W polu 'strona' nie można wpisać litery!");
            }

        }
        return t;
    }

    public boolean sprawdzenie4( String naleznosc ) {
        boolean t = false;
        if (naleznosc.isEmpty()) {
            displayWrongInputDialog("Wpisz należność finansową! ");
        } else {
            try {
                double z = Double.parseDouble(naleznosc);
                t = true;
            } catch (NumberFormatException e) {
                displayWrongInputDialog("W polu 'Należność' nie można wpisać litery!");
            }
        }
        return t;
    }

    private void displayWrongInputDialog( String warning ) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Złe dane wejściwe");
        alert.setHeaderText("Złe dane wejściowe");
        alert.setContentText(warning);
        alert.showAndWait();
    }
}
