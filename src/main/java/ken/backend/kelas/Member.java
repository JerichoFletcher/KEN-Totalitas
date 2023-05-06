package ken.backend.kelas;

public class Member extends Customer {
    private String name;
    private String phoneNumber;
    private int points;

    public Member(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getPoints() {
        return points;
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