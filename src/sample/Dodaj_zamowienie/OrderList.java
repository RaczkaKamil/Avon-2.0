package sample.Dodaj_zamowienie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderList implements Serializable {
    private  ArrayList<Order> listaZamowien2;
    private List<Order> listaZamowien;

    public OrderList()
    {
        listaZamowien = new ArrayList<>();


    }

    public void addlistaZamowien(Order order)
    {
        listaZamowien.add(order);
    }

public void removelistaZamowien(){listaZamowien.remove(listaZamowien.size()-1);}
    public List<Order> getListaZamowien() {
        return listaZamowien;
    }

    public static void zapis(java.util.List<Order> o) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("ListaZamowienBierzacych.bin"));
        objectOutputStream.writeObject(o);
    }

    public   void odczyt() throws IOException, ClassNotFoundException {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ListaZamowienBierzacych.bin"));
            java.util.List<Order> object = ( java.util.List<Order>) objectInputStream.readObject();
            listaZamowien.addAll(object);
        } catch (FileNotFoundException e)
        {
            System.out.println("nie znaleziono pliku");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("nie znaleziono klasy");
        }

    }
}
