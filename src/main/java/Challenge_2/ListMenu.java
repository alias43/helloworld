package Challenge_2;

import java.util.ArrayList;

public class ListMenu {
    private ArrayList<Menu> listMenu;
    String breakLine = "====================";
    String format = "%-17s %1s %7s%n";

    void addMenu(Menu menu){

        listMenu.add(menu);
    }

    void showMenu(){
        System.out.println(breakLine);
        System.out.println("Selamat datang di BinarFood");
        System.out.println(breakLine);
        System.out.println("\nMenu:");

        try {
            for (int i = 0; i < listMenu.size(); i++) {
                Menu menu = listMenu.get(i);
                System.out.format(format, (i + 1) + ". " + menu.getNama(), "|", menu.getHarga());
            }
        }catch (NullPointerException npe){
            System.out.println("Tidak ada menu untuk ditampilkan");
        }

    }
}
