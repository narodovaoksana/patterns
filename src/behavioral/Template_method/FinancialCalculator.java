package behavioral.Template_method;

public abstract class FinancialCalculator {
    // Шаблонний метод для розрахунку
    public final void calculate() {
        // Виконати розрахунок показника
        double result = performCalculation();

        // Відображення результату
        displayResult(result);
    }

    // Абстрактний метод для виконання розрахунку, який буде реалізований в підкласах
    protected abstract double performCalculation();

    // Метод для відображення результату
    protected void displayResult(double result) {
        System.out.println("Result: " + result);
    }
}
