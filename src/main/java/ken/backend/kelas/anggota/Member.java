package ken.backend.kelas.anggota;

import lombok.Getter;
import lombok.Setter;

public class Member extends Customer {
    @Getter
    private String name;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private int points;

    public Member(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.points = 0;
    }

    public void addPoints(double price) {
        int newPoints = (int) (price * 0.01);
        points += newPoints;
    }

    public int usePoints(int amount) {
        int usedPoints = Math.min(amount, points);
        points -= usedPoints;
        return usedPoints;
    }
}