package Challenge_2;

import java.util.*;

public class Pesanan {
    private ArrayList<PesananItem> itemsPesanan;

    public Pesanan() {
        itemsPesanan = new ArrayList<>();
    }

    public void tambahItem(Menu menu, int jumlah) {
        PesananItem pesananItem = new PesananItem(menu, jumlah);
        itemsPesanan.add(pesananItem);
    }

    public ArrayList<PesananItem> getItemPesanan() {
        return itemsPesanan;
    }

    public int hitungTotal() {
        int total = 0;
        for (PesananItem pesananItem : itemsPesanan) {
            total += pesananItem.getMenu().getHarga() * pesananItem.getJumlah();
        }
        return total;
    }
}