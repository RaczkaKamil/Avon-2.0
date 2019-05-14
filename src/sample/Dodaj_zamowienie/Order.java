package sample.Dodaj_zamowienie;

import java.io.*;

public class Order implements Serializable {
    String osoba;
    int kod;
    int strona;
    double należność;
    int id=1;

    private static final long serialVersionUID = 1L;

    public void Order(String osoba, int kod, int strona, double należność){
        this.osoba=osoba;
        this.kod=kod;
        this.strona = strona;
        this.należność=należność;


    }

    public void setId(int i)
    {
        this.id = this.id+i;
    }

    public String getOsoba()
    {
        return osoba;
    }

    public void setOsoba(String osoba)
    {
        this.osoba=osoba;
    }

    public int getKod() {
        return kod;
    }

    public void setKod( int kod ) {
        this.kod = kod;
    }

    public int getStrona() {
        return strona;
    }

    public void setStrona( int strona ) {
        this.strona = strona;
    }

    public double getNależność() {
        return należność;
    }

    public void setNależność( double należność ) {
        this.należność = należność;
    }

    @Override
    public String toString() {
        return  id+". "+  osoba + "  " +
                "kod: " + kod +
                ", strona: " + strona +
                ", należność: " + należność+ " zł" + '\n'
                ;
    }



}
