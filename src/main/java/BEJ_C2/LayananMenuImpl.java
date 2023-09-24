package BEJ_C2;

import java.util.ArrayList;
import java.util.List;

public class LayananMenuImpl implements LayananMenu {
    private List<Menu> menu = new ArrayList<>();
    @Override
    public void tambahMenu(String nama, Integer harga) {
        menu.add(new Menu(nama, harga));
    }

    @Override
    public void tampilMenu() {
        for (int i = 0; i < this.menu.size(); i++) {
            Menu menuAtIndex = this.menu.get(i);
            System.out.format("%-17s %1s %7s%n", (i + 1) + ". " + menuAtIndex.getNama(), "|", menuAtIndex.getHarga());
        }
    }

    @Override
    public int jumlahMenu() {
        return menu.size();
    }

    @Override
    public Menu menuDiIndex(Integer index) {
        return menu.get(index - 1);
    }


}
