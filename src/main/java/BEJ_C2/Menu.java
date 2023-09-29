package BEJ_C2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Menu {
   @NonNull
    private String nama;
    private Optional<Integer> harga;
}
