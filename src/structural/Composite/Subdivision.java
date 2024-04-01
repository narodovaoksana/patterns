package structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Subdivision implements BankComponent {
    private String name;
    private List<BankComponent> components = new ArrayList<>();

    public Subdivision(String name) {
        this.name = name;
    }

    public void addComponent(BankComponent component) {
        components.add(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Підрозділ: " + name);
        for (BankComponent component : components) {
            component.displayInfo();
        }
    }
}
