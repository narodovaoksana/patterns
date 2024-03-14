package Creational.Prototype;

import java.util.Objects;

public class Client implements Prototype {
    private final String name;
    private final int clientId;

    public Client(String name, int clientId) {
        this.name = name;
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Client client = (Client) o;
            return this.clientId == client.clientId && Objects.equals(this.name, client.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.clientId);
    }

    @Override
    public Prototype doClone() {
        return new Client(this.name, this.clientId);
    }

    public void displayInfo() {
        System.out.println("Client: " + name + ", ID: " + clientId);
    }
}
