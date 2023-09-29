package BEJ_C2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LayananMenuImpl implements LayananMenu {
    private List<Menu> menu = new ArrayList<>();
    @Override
    public void tambahMenu(String nama, Integer harga) {
        menu.add(new Menu(nama, Optional.of(harga)));
    }

    @Override
    public void tampilMenu() {

        //tampilkan menu dengan Stream API
        menu.stream().forEach(menuItem -> {
            System.out.format("%-17s %1s %7s%n", (menu.indexOf(menuItem) + 1) + ". " + menuItem.getNama(), "|", menuItem.getHarga().orElse(0));
        });

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
