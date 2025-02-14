import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }

    double round(double value, int places) { // Здесь лучше переименовать метод с использованием глагола get.
        double scaLe = Math.pow(10, places); // Здесь лучше назвать переменную scale, а то нет таких слов sca Le :)
        return Math.round(value * scaLe) / scaLe;
    }

    void calculateDeposit(){ // Здесь лучше переименовать метод с использованием глагола set.
        int amount;
        int period;
        int action;

        Scanner scanner = new Scanner(System.in); // Здесь по code style лучше отделить через enter
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt(); // Здесь отделить
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();// Здесь отделить
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double outAmount = 0;

        if (action == 1) outAmount = calculateSimplePercent(amount, 0.06, period); // Здесь лучше использовать формат if(){}
        else if (action == 2) {
            outAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
        }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}
