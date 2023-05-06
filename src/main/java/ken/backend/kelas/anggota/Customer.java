package ken.backend.kelas.anggota;
import lombok.*;

public class Customer {
    @Getter
    private int id;
    private static int nextId = 1;

    public Customer() {
        this.id = nextId;
        nextId++;
    }
}