package sample;

import sample.Dodaj_zamowienie.OrderList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderListCode {
    private List<Integer> listaZamowienKody;


    public OrderListCode() {
        listaZamowienKody = new ArrayList<>();
    }

    public void inicialize() throws IOException, ClassNotFoundException {
        OrderList orderList = new OrderList();
        orderList.odczyt();

        for (int i = 0; i<orderList.getListaZamowien().size();i++)
        {
            listaZamowienKody.add(orderList.getCode(i+1));
        }
    }

    public List<Integer> getListaZamowienKody() {
        return listaZamowienKody;
    }
}
