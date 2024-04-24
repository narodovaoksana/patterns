package behavioral.Mediator;

public class Client {
    private String name;
    private double creditRating;
    private String address;
    private String phoneNumber;

    public Client(String name, double creditRating, String address, String phoneNumber) {
        this.name = name;
        this.creditRating = creditRating;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public double getCreditRating() {
        return creditRating;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
