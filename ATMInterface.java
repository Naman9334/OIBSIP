import java.util.Scanner;

public class ATMInterface {
    private double balance;
    private Scanner scanner;
    
    public ATMInterface() {
        balance = 0.0;
        scanner = new Scanner(System.in);
    }
    
    public void run() {
        boolean quit = false;
        
        while (!quit) {

            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println();
        }
        
        System.out.println("Thank you for using the ATM.");
    }
    
    private void checkBalance() {
        System.out.println("Your current balance is: Rs." + balance);
    }
    
    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of Rs." + amount + " successful.");
        }
         else 
         {
            System.out.println("Invalid amount. Deposit failed.");
         }
    }
    
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 
        
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal of Rs." + amount + " successful.");
            } 
             else
              {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }
        } 
        else
         {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }
    
    public static void main(String[]args) {
        ATMInterface atm = new ATMInterface();
        atm.run();
    }
}