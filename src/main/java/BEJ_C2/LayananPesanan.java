package BEJ_C2;

public interface LayananPesanan {
    void tambahPesanan(String nama, Integer harga, Integer jumlah);
    void tampilPesanan();
    int totalBayar();
    void printStruk(String namaFile);
}
