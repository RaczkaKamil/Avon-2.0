package sample.Dodaj_zamowienie;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<String> osoby;

    public PersonList()
    {
        osoby = new ArrayList<>();
        osoby.add("Mama Kamila");
        osoby.add("Mama Judyty");
        osoby.add("Pani Ela");
    }

    public List<String> getOsoby()
    {
        return osoby;
    }
}
