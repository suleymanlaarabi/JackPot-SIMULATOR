package suleyman.JackPot.services.Auth.Session;

public class Profile {
    private int id;
    private String username;
    private int money;

    public Profile(int id, String username, int money) {
        this.id = id;
        this.username = username;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public int getMoney() {
        return money;
    }

    public int getId() {
        return id;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
