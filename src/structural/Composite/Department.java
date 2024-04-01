package structural.Composite;

public class Department implements BankComponent {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Відділ: " + name);
    }}