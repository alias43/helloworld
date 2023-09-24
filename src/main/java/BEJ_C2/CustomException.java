package BEJ_C2;

import java.util.InputMismatchException;

public class CustomException extends InputMismatchException {

    CustomException(){

    }
    CustomException(String pesan){
        super("Terjadi Kesalahan akibat: "+pesan);

    }
}

class CustomException2 extends InputMismatchException {
    CustomException2(){

    }
    CustomException2(String pesan){
        super("Masukkan tidak sesuai");
    }
}
