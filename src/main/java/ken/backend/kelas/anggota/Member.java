package ken.backend.kelas.anggota;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Member extends Customer implements Serializable {
    @Getter
    protected String name;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private int points;
    @Getter
    @Setter
    private boolean active;

    public Member(String name, String phoneNumber, int id) {
        super(id);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.points = 0;
        this.active = true;
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