package Challenge_2;

public class Menu {
    private String nama;
    private Integer harga;

    public Menu(String nama, Integer harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}
