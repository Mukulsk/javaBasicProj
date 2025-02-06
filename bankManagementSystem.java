
import java.util.Scanner;
import java.util.HashMap;

    class BankAccount {
        private String accountNumber;
        private String accountHolderName;
        private double balance;

        public BankAccount(String accountNumber, String accountHolderName, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance =balance+ amount;
                System.out.println("Successfully deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrawn: $" + amount);
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }

        public void displayBalance() {
            System.out.println("Account Balance: $" + balance);
        }



        private static HashMap<String, BankAccount> accounts = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                System.out.println("\nBank Management System");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        createAccount();
                        break;
                    case 2:
                        depositAmount();
                        break;
                    case 3:
                        withdrawAmount();
                        break;
                    case 4:
                        checkBalance();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you for using our bank.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private static void createAccount() {
            System.out.print("Enter Account Number: ");
            String accNumber = scanner.nextLine();
            System.out.print("Enter Account Holder Name: ");
            String accHolder = scanner.nextLine();
            System.out.print("Enter Initial Balance: ");
            double balance = scanner.nextDouble();
            accounts.put(accNumber, new BankAccount(accNumber, accHolder, balance));
            System.out.println("Account created successfully!");
        }

        private static void depositAmount() {
            System.out.print("Enter Account Number: ");
            String accNumber = scanner.nextLine();
            if (accounts.containsKey(accNumber)) {
                System.out.print("Enter Amount to Deposit: ");
                double amount = scanner.nextDouble();
                accounts.get(accNumber).deposit(amount);
            } else {
                System.out.println("Account not found.");
            }
        }

        private static void withdrawAmount() {
            System.out.print("Enter Account Number: ");
            String accNumber = scanner.nextLine();
            if (accounts.containsKey(accNumber)) {
                System.out.print("Enter Amount to Withdraw: ");
                double amount = scanner.nextDouble();
                accounts.get(accNumber).withdraw(amount);
            } else {
                System.out.println("Account not found.");
            }
        }

        private static void checkBalance() {
            System.out.print("Enter Account Number: ");
            String accNumber = scanner.nextLine();
            if (accounts.containsKey(accNumber)) {
                accounts.get(accNumber).displayBalance();
            } else {
                System.out.println("Account not found.");
            }
        }
    }



