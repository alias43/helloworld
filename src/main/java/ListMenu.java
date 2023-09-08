import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListMenu {

    public static String format = "%-17s %1s %7s%n";

    public static void addMenuFromText(String filePath, ArrayList<Menu> menuList){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t"); // Pisahkan name dan price dengan tab

                if (parts.length == 2) {
                    String name = parts[0].trim();
                    int price = Integer.parseInt(parts[1].trim());

                    // Buat objek Menu dan tambahkan ke dalam ArrayList
                    Menu menu = new Menu(name, price);
                    menuList.add(menu);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Ada masalah dengan file txt");
        }
    }

    public static void showMenu(ArrayList<Menu> menuList){
        System.out.println("Menu:");

        try {
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i);
                System.out.format(format, (i + 1) + ". " + menu.getName(), "|", menu.getPrice());
            }
        }catch (NullPointerException npe){
            System.out.println("Tidak ada menu untuk ditampilkan");
        }

    }

}
