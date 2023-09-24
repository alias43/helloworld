import static org.junit.jupiter.api.Assertions.*;

import BEJ_C2.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LayananMenuImplTest {

    private LayananMenu layananMenu;

    @BeforeEach
    public void setUp() {
        layananMenu = new LayananMenuImpl();
    }

    @Test
    public void testTambahMenu() {
        layananMenu.tambahMenu("Nasi Goreng", 25000);
        assertEquals(1, layananMenu.jumlahMenu());
    }

    @Test
    public void testTampilMenu() {
        layananMenu.tambahMenu("Mie Ayam", 20000);
        layananMenu.tambahMenu("Soto Ayam", 18000);

        // Menggunakan metode intercept untuk menangkap output yang ditampilkan ke konsol
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        layananMenu.tampilMenu();

        String expectedOutput = "1. Mie Ayam      |   20000\n2. Soto Ayam     |   18000\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testJumlahMenu() {
        layananMenu.tambahMenu("Nasi Goreng", 25000);
        layananMenu.tambahMenu("Mie Ayam", 20000);

        assertEquals(2, layananMenu.jumlahMenu());
    }

    @Test
    public void testMenuDiIndex() {
        layananMenu.tambahMenu("Nasi Goreng", 25000);
        layananMenu.tambahMenu("Mie Ayam", 20000);

        Menu menu = layananMenu.menuDiIndex(0);
        assertEquals("Nasi Goreng", menu.getNama());
    }
}

class LayananPesananImplTest {

    private LayananPesanan layananPesanan;

    @BeforeEach
    public void setUp() {
        layananPesanan = new LayananPesananImpl();
    }

    @Test
    public void testTampilPesanan() {
        layananPesanan.tambahPesanan("Nasi Goreng", 25000, 2);
        layananPesanan.tambahPesanan("Mie Ayam", 20000, 3);

        // Menggunakan metode intercept untuk menangkap output yang ditampilkan ke konsol
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        layananPesanan.tampilPesanan();

        String expectedOutput = " Menu             |  Harga|\tJumlah\n" +
                "1. Nasi Goreng    |  25000|\t2\n" +
                "2. Mie Ayam       |  20000|\t3\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testHitungTotalBayar() {
        layananPesanan.tambahPesanan("Nasi Goreng", 25000, 2);
        layananPesanan.tambahPesanan("Mie Ayam", 20000, 3);

        assertEquals(95000, layananPesanan.totalBayar());
    }
}

