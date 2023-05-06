package ken.backend.kelas;

public class Customer {
    private int id;
    private static int nextId = 1;

    public Customer() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }
}