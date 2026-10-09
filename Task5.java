import java.util.*;

class BankAccount {
    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        BankAccount account = new BankAccount();

        for (int i = 0; i < n; i++) {
            String operation = sc.nextLine();

            String[] parts = operation.split(" ");
            String type = parts[0];
            int amount = Integer.parseInt(parts[1]);

            if (type.equalsIgnoreCase("Deposit")) {
                account.deposit(amount);
            } else if (type.equalsIgnoreCase("Withdraw")) {
                account.withdraw(amount);
            }
        }

        System.out.println(account.getBalance());
    }
}
