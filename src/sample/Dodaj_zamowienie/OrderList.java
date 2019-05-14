package sample.Dodaj_zamowienie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderList implements Serializable {
    private ArrayList<Order> listaZamowien2;
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
        System.out.println(osoba);
        String s = "błąd";
        for (Order o:listaZamowien) {
            if (osoba.contains(o.getOsoba()))
            {
                s = o.getOsoba();
            }
        }return s;
    }

    public String porownajKod(String kod)
    {
        String s = "Błąd";
        for (Order o:listaZamowien) {
            if (kod.contains(Integer.toString(o.getKod())))
            {
                s = Integer.toString( o.getKod());
            }
        }return s;
    }

    public String porownajStrone(String strona)
    {
        String s = "Błąd";
        for (Order o:listaZamowien) {
            if (strona.contains(Integer.toString(o.getStrona())))
            {

                 s = Integer.toString( o.getStrona());
            }
        }return s;
    }

    public String porownajNaleznosc(String naleznosc)
    {
        String s = "Błąd";
        for (Order o:listaZamowien) {
            if (naleznosc.contains(Double.toString(o.getNależność())))
            {
                 s = Double.toString(o.getNależność());

            }
        }return s;
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
