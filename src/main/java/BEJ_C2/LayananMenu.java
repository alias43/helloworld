package BEJ_C2;

public interface LayananMenu {
    void tambahMenu(String nama, Integer harga);
    void tampilMenu();
    int jumlahMenu();
    Menu menuDiIndex(Integer index);
}
