package BEJ_C2;

import java.util.Scanner;

public class TampilanUtama {
    String batas = "\n==============================\n";
    Scanner sc = new Scanner(System.in);
    LayananMenu menu = new LayananMenuImpl();
    LayananPesanan pesan = new LayananPesananImpl();
    void tampilMenu(){
        System.out.print(batas + "Selamat Datang di BinarFood" + batas);
        menu.tampilMenu();
        System.out.println("99. Konfirmasi Pembayaran");
        System.out.println("0.  Keluar");

        System.out.println("Masukkan Pilihan Anda:");
        int input = sc.nextInt();
        validasiMenu(input);
    }

    void validasiMenu(Integer input){
        if (input == 99){
            tampilPesanan();
        }
        if (input == 0){
            keluar();
        }
        if (input > 0 && input <= menu.jumlahMenu()){
            jumlahPesanan(input);
        }
    }

    void jumlahPesanan(Integer index){
        Menu item = menu.menuDiIndex(index);
        System.out.format("%-17s %1s %7s%n", "Pilihan Anda\n" + item.getNama(), "|", item.getHarga());
        System.out.println("Masukkan jumlah pesanan: ");
        int jumlahItem = sc.nextInt();
        validasiJumlahPesanan(item, jumlahItem);
    }
    void validasiJumlahPesanan(Menu item, Integer jumlahItem){
        System.out.println("ini: " + item.getNama() +"\t"+ item.getHarga() +"\t"+ jumlahItem);
        if (jumlahItem > 0){
            pesan.tambahPesanan(item.getNama(), item.getHarga(), jumlahItem);
            System.out.println("0. Lanjut ke Pembayaran");
            System.out.println("1. Kembali ke Menu");
            int input = sc.nextInt();
            if (input == 0) {
                tampilPesanan();
            }
            else {
                tampilMenu();
            }
        }
        if (jumlahItem == 0){
            tampilMenu();
        }
    }

    void tampilPesanan(){
        pesan.tampilPesanan();
        pesan.totalBayar();
        System.out.println("1. Konfirmasi Pembayaran");
        System.out.println("2. Kembali ke Menu");
        System.out.println("0. Keluar");
        int input = sc.nextInt();
        validasiPesanan(input);

    }

    void validasiPesanan(int input){
        if (input == 1){
            pesan.printStruk("BinarFood.txt");
            keluar();
        }
        if (input == 2){
            tampilMenu();
        }
        if (input == 0){
            keluar();
        }
    }

    void keluar(){
        System.out.println("Terima Kasih sudah mengunjungi BinarFood");
        sc.close();
        System.exit(0);
    }
}
