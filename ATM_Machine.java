
import java.util.*;

class ATM {
    float balance;
    int PIN;

    public void setPin() {
        System.out.println("***********Generate your pin***********");
        System.out.print("Enter 4 digit pin:");
        Scanner sc = new Scanner(System.in);
        int pinGenerate = sc.nextInt();

        System.out.print("enter your conform pin again:");
        int comformPin = sc.nextInt();

        if (pinGenerate == comformPin) {
            PIN = comformPin;
            System.out.println("your pin is generated successfully");
            enterPin();
        } else {
            System.out.println("Plz check above password are must be same");
        }
    }

    public void enterPin(){
        System.out.println("To make transaction enter your pin:");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();

        if(enteredPin == PIN){
            menu();
        } else{
            System.out.println("Invalid pin, Try again");
            enterPin();
        }
    }

    public void menu() {
        System.out.println("Enter your choice");
        System.out.println("1. Check A/C balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Deposit money");
        System.out.println("4. Apply for loan");
        System.out.println("5. Exit");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if(opt == 1){
            checkBalance();
        }else if(opt == 2){
            withdraw();
        }else if(opt == 3){
            deposit();
        } else if(opt == 4){
            applyLoan();
        } else if(opt == 5){
           return;
        } else{
            System.out.println("input valid choice");
        }
    }

    public void checkBalance() {
        System.out.println("Balance :" + balance);
        menu();
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw");
        Scanner sc = new Scanner(System.in);
        float enteredBal = sc.nextFloat();

        if (enteredBal > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= enteredBal;
            System.out.println("Money withdraw successful");
        }
        menu();
    }

    public void deposit() {
        System.out.println("Enter amount to Deposit");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        balance += amount;
        System.out.println("Deposit money successful");
        menu();
    }

    public void applyLoan(){
        System.out.println("Enter the amount you wish to take loan");
        Scanner sc = new Scanner(System.in);
        int loan = sc.nextInt();
        System.out.println("How many years do you want to take this loan?");
        int year = sc.nextInt();

        float finalAmount = loan + (loan*8*year)/100;
        System.out.println("Final value after 2 years with 8 percent interest is:" + finalAmount);

        System.out.println("If you want to confirm this loan enter 1 otherwise enter 0");
        int confirm = sc.nextInt();

        if(confirm == 1){
            System.out.println("Apply this loan successfully");
        } else if(confirm == 0){
            System.out.println("Thank you");
        } else{
            System.out.println("Please enter valid input");
        }
        menu();
    }

}

public class ATM_Machine {
    public static void main(String args[]) {
        ATM atm = new ATM();
        atm.setPin();
    }
}