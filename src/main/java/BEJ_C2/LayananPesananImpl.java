package BEJ_C2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class LayananPesananImpl implements LayananPesanan{

    private HashMap<String, Pesanan> pesananMap = new HashMap<>();
    @Override
    public void tambahPesanan(String nama, Integer harga, Integer jumlah) {
        Pesanan itemPesanan = new Pesanan(nama, Optional.of(harga), jumlah);
        if (pesananMap.containsKey(itemPesanan.getNama())){
            Integer updateJumlah = (pesananMap.get(nama)).getJumlah() + jumlah;
            pesananMap.get(nama).setJumlah(updateJumlah);
        }
        else{
            pesananMap.put(itemPesanan.getNama(), itemPesanan);
        }
    }

    public void tampilPesanan() {
        //tampilkan daftar pesanan dengan stream
        System.out.format("%-17s %1s %7s %1s", " Menu ", "|", "Harga", "|\t" + "Jumlah\n");
        pesananMap.entrySet().stream().forEach(pesananItem -> {
            System.out.format("%-17s %1s %7s %1s", pesananItem.getKey(), "|", pesananItem.getValue().getHarga().orElse(0), "|\t" + pesananItem.getValue().getJumlah() + "\n");
        });
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
        for (Pesanan pesanan : pesananMap.values()) {
            total += pesanan.getHarga().orElse(0) * pesanan.getJumlah();
        }
        return total;
    }

}
