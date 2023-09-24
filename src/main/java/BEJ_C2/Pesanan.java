package BEJ_C2;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pesanan extends Menu {
    private Integer jumlah;

    Pesanan(String nama, Integer harga, Integer jumlah){
        super(nama, harga);
        this.jumlah = jumlah;
    }
}
