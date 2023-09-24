package BEJ_C2;

public class BinarFoodMain {

    public static void main(String[] args) {
//        LayananMenu layanMenu = new LayananMenuImpl();
        TampilanUtama mainView = new TampilanUtama();

        mainView.menu.tambahMenu("nasi goreng", 12000);
        mainView.menu.tambahMenu("kwetiau", 10000);
        mainView.menu.tambahMenu("capcay", 15000);

//        layanMenu.tampilMenu();
        mainView.tampilMenu();


    }
}
