package Challenge_2;

public class PesananItem {
    private Menu menu;
    private int jumlah;

    public PesananItem(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }
}