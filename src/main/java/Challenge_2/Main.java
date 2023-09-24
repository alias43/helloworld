package Challenge_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static String batas = "=========================";

    private static final List<Menu> daftarMenu = new ArrayList<>(Arrays.asList(
            new Menu("Nasi Goreng", 15000),
            new Menu("Mie Goreng", 13000),
            new Menu("Nasi + Ayam", 18000),
            new Menu("Es Teh Manis", 3000),
            new Menu("Es Jeruk", 5000)
    ));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pesanan pesanan = new Pesanan();

        ListMenu listMenu = new ListMenu();
        listMenu.showMenu();

        while (true) {
            tampilMenu();
            int pilihan = sc.nextInt();

            if (pilihan == 0) {
                break;
            } else if (pilihan == 99) {
                konfirmasiDanBayar(pesanan, sc);
                break;
            } else if (pilihan > 0 && pilihan <= daftarMenu.size()) {
                Menu menu = daftarMenu.get(pilihan - 1);
                System.out.print("Jumlah pesanan: ");
                int jumlah = sc.nextInt();
                if (jumlah > 0) {
                    pesanan.tambahItem(menu, jumlah);
                    System.out.println("Item telah ditambahkan ke pesanan Anda.");
                } else {
                    System.out.println("Jumlah tidak valid. Harap masukkan jumlah yang valid.");
                }
            } else {
                System.out.println("Pilihan tidak valid. Harap masukkan item menu yang valid.");
            }
        }

        sc.close();
    }

    private static void tampilMenu() {
        System.out.println("\n"+batas);
        System.out.println("Selamat datang di BinarFood");
        System.out.println(batas);
        System.out.println("\nMenu :");

        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu menu = daftarMenu.get(i);
            System.out.format("%-17s %1s %7s%n", (i + 1) + ". " + menu.getNama(), "|", menu.getHarga());
        }

        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        System.out.println("\nSilakan masukkan pesanan Anda:");
    }

    private static void konfirmasiDanBayar(Pesanan pesanan, Scanner sc) {
        System.out.println("\n"+batas);
        System.out.println("Konfirmasi & Pembayaran:");
        System.out.println(batas);

        for (PesananItem pesananItem : pesanan.getItemPesanan()) {
            Menu menu = pesananItem.getMenu();
            int jumlah = pesananItem.getJumlah();
            System.out.format("%-12s %5s %10s%n", menu.getNama(), jumlah, menu.getHarga() * jumlah);
        }

        int total = pesanan.hitungTotal();
        System.out.println("----------------------------+");
        System.out.format("%-12s %5s %10s%n", "Total", "", total);

        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar Aplikasi");

        int input = sc.nextInt();

        switch (input) {
            case 1:
                simpanStruk(pesanan);
                System.out.println("Terima Kasih");
                break;
            case 2:
                break;
            case 0:
                System.exit(0);
        }
    }

    private static void simpanStruk(Pesanan pesanan) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("binarFood.txt"))) {
            writer.write(batas);
            writer.write("BinarFood");
            writer.write("Terima kasih sudah memesan di BinarFood");
            writer.write("Dibawah ini adalah pesanan anda");
            for (PesananItem pesananItem : pesanan.getItemPesanan()) {
                Menu menu = pesananItem.getMenu();
                int jumlah = pesananItem.getJumlah();
                writer.write(menu.getNama() + "\t\t" + jumlah + "\t\t" + menu.getHarga() * jumlah);
                writer.newLine();
            }

            writer.write("Total\t\t\t" + pesanan.hitungTotal());
            writer.write("Pembayaran: BinarCash");
            writer.write("=========================");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan.");
            e.printStackTrace();
        }
    }
}

