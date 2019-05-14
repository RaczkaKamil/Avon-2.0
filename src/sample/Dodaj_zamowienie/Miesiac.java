package sample.Dodaj_zamowienie;

import java.util.ArrayList;
import java.util.List;

public class Miesiac {
    private List<String> miesiace;

    public Miesiac(){

        miesiace = new ArrayList<>();
miesiace.add("Styczen");
miesiace.add("Luty");
miesiace.add("Marzec");
miesiace.add("Kwiecien");
miesiace.add("Maj");
miesiace.add("Czerwiec");
miesiace.add("Lipiec");
miesiace.add("Sierpień");
miesiace.add("Wrzesień");
miesiace.add("Październik");
miesiace.add("Listopad");
miesiace.add("Grudzień");
miesiace.add("null");

    }

    public String tlumacz(int index)
    {

        return miesiace.get(index-1);
    }

}
