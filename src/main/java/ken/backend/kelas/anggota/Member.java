package ken.backend.kelas.anggota;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Member extends Customer implements Serializable {
    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    protected float points;
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

    public float usePoints(int amount) {
        float usedPoints = Math.min(amount, points);
        points -= usedPoints;
        return usedPoints;
    }
}