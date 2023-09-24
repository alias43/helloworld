package BEJ_C2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TampilanUtama {
    String batas = "\n==============================\n";
    Scanner sc = new Scanner(System.in);
    LayananMenu menu = new LayananMenuImpl();
    LayananPesanan pesan = new LayananPesananImpl();
    void tampilMenu() {
        System.out.print(batas + "Selamat Datang di BinarFood" + batas);
        menu.tampilMenu();
        System.out.println("99. Konfirmasi Pembayaran");
        System.out.println("0.  Keluar");
        try {
            System.out.println("Masukkan Pilihan Anda:");
            int input = sc.nextInt();
            if (input < 0) {
                throw new CustomException();
            }
            if (input > menu.jumlahMenu() && input != 99) {
                throw new CustomException2();
            }
            validasiMenu(input);
        }
        catch (CustomException ce) {
            System.out.println("Masukkan tidak boleh kurang dari 0");
            sc.nextLine();
            tampilMenu();
        }
        catch (CustomException2 ce2){
            System.out.println("Opsi tidak tersedia! Silahkan pilih sesuai yang ada di menu");
            sc.nextLine();
            tampilMenu();
        }
        catch (InputMismatchException ime) {
            System.out.println("Masukkan harus berupa angka");
            sc.nextLine();
            tampilMenu();
        }
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
        try {
            System.out.println("Masukkan jumlah pesanan: ");
            int jumlahItem = sc.nextInt();
            if (jumlahItem < 0) {
                throw new CustomException();
            }
            validasiJumlahPesanan(item, jumlahItem);
        }
        catch (CustomException ce) {
            System.out.println("Jumlah pesanan tidak boleh kurang dari 0");
            sc.nextLine();
            jumlahPesanan(index);
        }
        catch (InputMismatchException ime) {
            System.out.println("Masukkan harus berupa angka");
            sc.nextLine();
            jumlahPesanan(index);
        }
    }
    void validasiJumlahPesanan(Menu item, Integer jumlahItem){
        System.out.println("ini: " + item.getNama() +"\t"+ item.getHarga() +"\t"+ jumlahItem);
        if (jumlahItem > 0){
            try {
                pesan.tambahPesanan(item.getNama(), item.getHarga(), jumlahItem);
                System.out.println("0. Lanjut ke Pembayaran");
                System.out.println("1. Kembali ke Menu");
                int input = sc.nextInt();
                if (input < 0 || input > 1){
                    throw new CustomException();
                }
                if (input == 0) {
                    tampilPesanan();
                }
                else {
                    tampilMenu();
                }
            }
            catch (CustomException ce) {
                System.out.println("Opsi tidak tersedia! Silahkan pilih opsi yang ada");
                sc.nextLine();
                validasiJumlahPesanan(item, 0);
            }
            catch (InputMismatchException ime) {
                System.out.println("Masukkan harus berupa angka");
                sc.nextLine();
                validasiJumlahPesanan(item, 0);
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
        try {
            int input = sc.nextInt();
            if (input < 0 || input > 2){
                throw new CustomException();
            }
            validasiPesanan(input);
        }
        catch (CustomException ce) {
            System.out.println("Opsi tidak tersedia! Silahkan pilih opsi yang ada");
            sc.nextLine();
            tampilPesanan();
        }
        catch (InputMismatchException ime) {
            System.out.println("Masukkan harus berupa angka");
            sc.nextLine();
            tampilPesanan();
        }
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
