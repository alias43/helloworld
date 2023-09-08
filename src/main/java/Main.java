import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Menu> menuList = new ArrayList<>();
    public static ArrayList<OrderItem> orderList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int totalBill = 0;
    public static String breakLine = "====================";
    private static boolean condition;


    public static void main(String[] args) {
        // Menambahkan daftar menu dari file text
        String filePath = "src/main/resources/BinarFoodMenu.txt"; // Ganti dengan name file yang ingin Anda baca
        ListMenu.addMenuFromText(filePath, menuList);
        condition = true;

        while(condition){

            System.out.println(breakLine);
            System.out.println("Selamat datang di BinarFood");
            System.out.println(breakLine);
            ListMenu.showMenu(menuList);
            System.out.println("99. Konfirmasi dan Bayar");
            System.out.println("0. Keluar Aplikasi");

            // Menambahkan menu yang dipilih ke dalam collection
            System.out.print("\nPilih: ");
            int choice = scanner.nextInt();

            if(choice > 0 && choice <= 5){
                menuChoice(choice);
            }
            else if (choice == 99) {
                OrderItem.showOrderList(orderList);
            }
            else if (choice == 0) {
                System.out.println("Terima kasih telah mampir");
                condition = false;
            }
        }

        scanner.close();
    }

    public static void menuChoice(int choice){
        System.out.print("Jumlah: ");
        int qty = scanner.nextInt();
        OrderItem.addOrder(choice, qty, orderList);

        System.out.println("1. Kembali ke Menu");
        System.out.println("2. Konfirmasi dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        System.out.print("\nPilih: ");
        int option = scanner.nextInt();
        switch (option){
            case 1:
                break;
            case 2:
                OrderItem.showOrderList(orderList);
                System.out.println("\n1. Kembali ke Menu");
                System.out.println("0. Bayar");
                System.out.println("Pilih:");
                int input = scanner.nextInt();
                if(input==1){
                    break;
                } else {
                    totalBill = OrderItem.Bill(orderList);
                    notaTagihan();
                    Main.condition = false;
                }

                break;
            case 0:
                System.out.println("Terima Kasih");
                Main.condition = false;
                break;

        }

    }

    static void notaTagihan(){
        try {
            File file = new File("binarFood.txt");
            if(file.createNewFile()){
                System.out.println("New file is created");
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("=========================\nBinarFood\n=========================");
            buffer.write("Terima kasih sudah memesan di BinarFood\n\nDibawah ini adalah pesanan anda\n");
            for(int i=0; i < orderList.size(); i++){
                OrderItem item = orderList.get(i);
                buffer.write( item.getName()+ "\t\t" + item.getQuantity() + "\t\t" + (item.getPrice() * item.getQuantity()));
            }
            buffer.write("Total\t\t\t" + "\t\t"+ totalBill);
            buffer.flush();
            buffer.close();
            System.out.println("Terima Kasih");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}