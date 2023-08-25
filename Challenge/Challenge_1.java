package Challenge;

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Challenge_1 {

    static Scanner sc = new Scanner(System.in);
    // array string untuk menyimpan daftar menu
    static String[] menu = {"Nasi Goreng" , "Mie Goreng" , "Nasi + Ayam" , "Es Teh Manis" , "Es Jeruk"};
    // array integer untuk menyimpan harga masing-masing menu
    static int[] hargaMenu = {15000 , 13000 , 18000 , 3000 , 5000};
    // array int untuk menyimpan jumlah pesanan tiap menu
    static int[] jumlah = new int[5];
   // var int untuk menyimpan total tagihan seluruh menu yang dipesan
    static int totalBayar;

    public static void main(String[] args) {
        tampilMenu();
        sc.close();
    }

    /*Menampilkan menu makanan beserta harganya ke console*/
    static void tampilMenu(){
        System.out.println("\n=========================\nSelamat datang di BinarFood\n=========================");

        System.out.println("\nMenu :");
        for(int i=0; i<menu.length; i++){
            System.out.format("%-17s %1s %7s", (i+1)+". "+menu[i], "|" ,hargaMenu[i]+"\n");
        }
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar Aplikasi");
        System.out.println("\nSilahkan masukkan pesanan anda:");
        pilihMenu();
    }

    /*Menerima dan memproses input menu yang dipilih user menggukan conditional if*/
    static void pilihMenu(){
        int menuID = sc.nextInt();
        if(menuID>0 && menuID<=menu.length){
            konfirmasiPesanan(menuID);
        }
        else if (menuID == 99) {
            konfirmasiBayar();
        }

        else if (menuID == 0){
            System.exit(0);
        } else {
            System.out.print("Input pesanan tidak valid. \nSilahkan masukkan kembali pesanan anda:");
            pilihMenu();
        }
    }

    /*Menampilkan teks konfirmasi untuk menu yang dipilih user*/
    static void konfirmasiPesanan(int menuID){
        System.out.println("\n=========================\nBerapa Pesanan Anda:\n=========================");

        System.out.format("%-17s %1s %7s" , menu[menuID-1] , "|" , hargaMenu[menuID-1]+"\n");
        System.out.println("(input 0 untuk kembali)");
        jumlahPesanan(menuID);
    }

    /*Menerima jumlah pesanan dari menu yang dipilih dan menampung nilainya ke
    * dalam array jumlah*/
    static void jumlahPesanan(int menuID){
        System.out.print("qty => ");
        int qty = sc.nextInt();

        if(qty == 0){
            tampilMenu();
        }
        else if (qty>0){
            jumlah[menuID-1]+=qty;
            System.out.println("Pesan Menu Lain: Y/T");
            char confirm = sc.next().charAt(0);
            if (confirm=='Y' || confirm=='y') {
                tampilMenu();
            } else {
                konfirmasiBayar();
            }
        } else {
            System.out.print("Input tidak valid. \nSilahkan masukkan kembali jumlah pesanan anda:");
            jumlahPesanan(menuID);
        }
    }

    /*Menampilkan total tagihan user untuk setiap menu yang dipesan*/
    static void konfirmasiBayar(){
        System.out.println("\n=========================\nKonfirmasi & Pembayaran:\n=========================");
        totalBayar=0;
        for(int i=0; i < menu.length; i++){
            if(jumlah[i] != 0){
                System.out.format("%-12s %5s %10s",menu[i] , jumlah[i] , (jumlah[i]*hargaMenu[i])+"\n");
                totalBayar += jumlah[i]*hargaMenu[i];
            }
        }
        System.out.println("----------------------------+");
        System.out.format("%-12s %5s %10s" ,"Total" , Arrays.stream(jumlah).sum() , totalBayar+"\n");

        System.out.println("1. Konfirmasi dan Bayar");
        System.out.println("2. Kembali ke menu utama");
        System.out.println("0. Keluar Aplikasi");
        int input = sc.nextInt();

        bayar(input);

    }

    /*Memproses menu pembayaran berdasarkan input user*/
    static void bayar(int input){
        switch (input) {
            case 1:
                notaTagihan();
                break;
            case 2:
                tampilMenu();
                break;
            case 0:
                System.exit(0);
        }
    }

    /*Menyimpan tagihan pesanan user ke dalam file txt*/
    static void notaTagihan(){
        try {
            File file = new File("binarFood.txt");
            if(file.createNewFile()){
                System.out.println("New file is created");
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("=========================\nBinarFood\n=========================");
            buffer.newLine();
            buffer.write("Terima kasih sudah memesan di BinarFood\n\nDibawah ini adalah pesanan anda\n");
            buffer.newLine();
            for(int i=0; i < menu.length; i++){
                if(jumlah[i] != 0){
                    buffer.write(menu[i] + "\t\t" + jumlah[i] + "\t\t" + (jumlah[i]*hargaMenu[i]));
                    buffer.newLine();
                }
            }
            buffer.write("Total\t\t\t" + Arrays.stream(jumlah).sum() +"\t\t"+ totalBayar);
            buffer.newLine();
            buffer.write("\nPembayaran: BinarCash");
            buffer.newLine();
            buffer.write("=========================\nSimpan struk ini sebagai\nbukti pembayaran\n=========================");
            buffer.newLine();
            buffer.flush();
            buffer.close();
            System.out.println("Terima Kasih");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
