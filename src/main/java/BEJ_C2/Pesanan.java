package BEJ_C2;

import lombok.*;

import java.util.Optional;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pesanan extends Menu {
    private Integer jumlah;

    public Pesanan(String nama, Optional<Integer> harga, Integer jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }
}
