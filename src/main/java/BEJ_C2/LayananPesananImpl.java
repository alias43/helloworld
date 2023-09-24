package BEJ_C2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class LayananPesananImpl implements LayananPesanan{

    private HashMap<String, Pesanan> pesananMap = new HashMap<>();
    @Override
    public void tambahPesanan(String nama, Integer harga, Integer jumlah) {
        Pesanan itemPesanan = new Pesanan(nama, harga, jumlah);
        if (pesananMap.containsKey(itemPesanan.getNama())){
            Integer updateJumlah = (pesananMap.get(nama)).getJumlah() + jumlah;
            pesananMap.get(nama).setJumlah(updateJumlah);
        }
        else{
            pesananMap.put(itemPesanan.getNama(), itemPesanan);
        }
    }

    public void tampilPesanan() {
        int i= 1;
        System.out.format("%-17s %1s %7s %1s", " Menu ", "|", "Harga", "|\t" + "Jumlah\n");
        for (HashMap.Entry<String, Pesanan> entry : pesananMap.entrySet()) {
            Pesanan pesanan = entry.getValue();
            System.out.format("%-17s %1s %7s %1s", i +". "+ pesanan.getNama(), "|", pesanan.getHarga(), "|\t" + pesanan.getJumlah() + "\n");
            i++;
        }
    }

    @Override
    public int totalBayar() {
        System.out.format("Total : Rp." + hitungTotalBayar() + "\n");
        return 0;
    }

    @Override
    public void printStruk(String namaFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write("====== Binar Food ======\n");
            for (HashMap.Entry<String, Pesanan> entry : pesananMap.entrySet()) {
                Pesanan pesanan = entry.getValue();
                String strukBaris = String.format("%-17s %1s %7s %7s", pesanan.getNama(), "|", pesanan.getHarga(), "|\t" + pesanan.getJumlah() + "\n");
                writer.write(strukBaris);
            }

            writer.write("Total : Rp." + hitungTotalBayar() + "\n");
            writer.write("=======================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int hitungTotalBayar(){
        int total = 0;
        for (HashMap.Entry<String, Pesanan> entry : pesananMap.entrySet()) {
            Pesanan pesanan = entry.getValue();
            total += (pesanan.getHarga() * pesanan.getJumlah());
        }
        return total;
    }

}
