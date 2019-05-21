package sample.Dodaj_zamowienie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderList implements Serializable {

    private List<Order> listaZamowien;

    public OrderList() {
        listaZamowien = new ArrayList<>();


    }

    public void addlistaZamowien( Order order ) {
        listaZamowien.add(order);
    }

    public void removelistaZamowien() {
        listaZamowien.remove(listaZamowien.size() - 1);
    }

    public List<Order> getListaZamowien() {
        return listaZamowien;
    }

     public String porownajOsoby(String osoba)
    {
        System.out.println("nowa osoba: "+osoba);

        char[] charString = osoba.toCharArray();
        String stringFirst = String.valueOf(charString[0]);
        int firstInt=  Integer.parseInt(stringFirst);
        String s = "błąd";
        for (Order o:listaZamowien) {
            if (o.getId()==firstInt)
            {
                System.out.println("stara osoba: "+ o.getOsoba());
                s = o.getOsoba();
            }
        }return s;
    }

    public String porownajKod(String kod)
    {
        char[] charString = kod.toCharArray();
        String stringFirst = String.valueOf(charString[0]);
        int firstInt=  Integer.parseInt(stringFirst);
        String s = "Błąd";

        for (Order o:listaZamowien) {
            if (o.getId()==firstInt)
            {
                s = Integer.toString( o.getKod());
            }
        }return s;
    }

    public String porownajStrone(String strona)
    {
        char[] charString = strona.toCharArray();
        String stringFirst = String.valueOf(charString[0]);
        int firstInt=  Integer.parseInt(stringFirst);

        String s = "Błąd";
        for (Order o:listaZamowien) {
            if (o.getId()==firstInt)
            {

                 s = Integer.toString( o.getStrona());
            }
        }return s;
    }

    public String porownajNaleznosc(String naleznosc)
    {
        char[] charString = naleznosc.toCharArray();
        String stringFirst = String.valueOf(charString[0]);
        int firstInt=  Integer.parseInt(stringFirst);

        String s = "Błąd";
        for (Order o:listaZamowien) {
            if (o.getId()==firstInt)
            {
                 s = Double.toString(o.getNależność());

            }
        }return s;
    }

    public String porownajID(String ID)
    {

        char[] charString = ID.toCharArray();
        String stringFirst = String.valueOf(charString[0]);
        int firstInt=  Integer.parseInt(stringFirst);

        String s = "Błąd";
        for (Order o:listaZamowien) {
            if (o.getId()==firstInt)
            {
                s = Integer.toString(o.getId());

            }
        }return s;
    }


    public void edytuj(int id, String osoba, int kod, int strona, double naleznosc)
    {
        System.out.println("zmieniono "+id);
        for (Order o:listaZamowien)
        {
            if(o.getId()==id)
            {
                o.setOsoba(osoba);
                o.setKod(kod);
                o.setStrona(strona);
                o.setNależność(naleznosc);

            }

        }
    }

public int getCode(int id)
{

    int kod = 0;
    for (Order o:listaZamowien) {
        if (o.getId() == id) {
            kod = o.getKod();
        }
    }
    return kod;
}
    public static void zapis( java.util.List<Order> o ) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("ListaZamowienBierzacych.bin"));
        objectOutputStream.writeObject(o);
    }

    public void odczyt() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ListaZamowienBierzacych.bin"));
            java.util.List<Order> object = (java.util.List<Order>) objectInputStream.readObject();
            listaZamowien.addAll(object);
        } catch (FileNotFoundException e) {
            System.out.println("nie znaleziono pliku");
        } catch (ClassNotFoundException e) {
            System.out.println("nie znaleziono klasy");
        }

    }
}
