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
        osoby.add("Pani Agnieszka");
        osoby.add("Magda kerfur");
        osoby.add("Magda Lidl");
        osoby.add("Pani Marta");
        osoby.add("Paulina");
        osoby.add("Karolina");
        osoby.add("Judyta");
        osoby.add("Kamil");

    }

    public List<String> getOsoby()
    {
        return osoby;
    }
}
