/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campuswallettransfer;

/**
 *
 * @author DAHIROC_CPE113
 */
public class CampusWallet {

    private String owner;
    private int balance;

    public CampusWallet(String owner, int balance) {
        this.owner = owner;

        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public CampusWallet(String owner) {
        this(owner, 0);
    }

    public boolean deposit(int amount) {
        if (amount <= 0) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    public boolean transferTo(CampusWallet recipient, int amount) {
        if (recipient == null || recipient == this
                || amount <= 0 || amount > this.balance) {
            return false;
        }

        this.balance -= amount;
        recipient.balance += amount;
        return true;
    }

    public int getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {

        CampusWallet aly = new CampusWallet("Aly", 100);
        CampusWallet ben = new CampusWallet("Ben");

        System.out.println("Aly's starting balance: "
                + aly.getBalance());
        System.out.println("Ben's starting balance: "
                + ben.getBalance());

        System.out.println("Aly transfers 35 credits to Ben: "
                + aly.transferTo(ben, 35));
        System.out.println("Aly's balance: "
                + aly.getBalance());
        System.out.println("Ben's balance: "
                + ben.getBalance());

        System.out.println("Aly transfers 70 credits to Ben: "
                + aly.transferTo(ben, 70));
        System.out.println("Aly's balance: "
                + aly.getBalance());
        System.out.println("Ben's balance: "
                + ben.getBalance());

        System.out.println("Aly transfers 10 credits to herself: "
                + aly.transferTo(aly, 10));
        System.out.println("Aly's balance: "
                + aly.getBalance());
        System.out.println("Ben's balance: "
                + ben.getBalance());

        System.out.println("Ben deposits 15 credits: "
                + ben.deposit(15));
        System.out.println("Aly's balance: "
                + aly.getBalance());
        System.out.println("Ben's balance: "
                + ben.getBalance());

        System.out.println("Aly transfers 65 credits to Ben: "
                + aly.transferTo(ben, 65));
        System.out.println("Aly's balance: "
                + aly.getBalance());
        System.out.println("Ben's balance: "
                + ben.getBalance());

        // Additional Test 1: Zero-credit transfer
        System.out.println("Aly transfers 0 credits to Ben: "
                + aly.transferTo(ben, 0));
        System.out.println("Aly's balance: "
                + aly.getBalance());
        System.out.println("Ben's balance: "
                + ben.getBalance());

        // Additional Test 2: Transfer to null
        System.out.println("Ben transfers 10 credits to null: "
                + ben.transferTo(null, 10));
        System.out.println("Ben's balance: "
                + ben.getBalance());

    }

}

// Activity 3 
// Q1. Why should the balance field be private? 
// The balance field should be private to protect the wallet 
// from unauthorized changes. Other classes should only modify 
// it through methods that validate transactions.

// Q2. Why use this() in the one-argument constructor? 
// The this() keyword calls another constructor in the same 
// class. It avoids repeating initialization code and allows 
// the wallet to start with a zero balance.

// Q3. Why must a failed transfer leave both balances unchanged? 
// A failed transfer must not change either balance because 
// no valid transaction has occurred. This prevents incorrect 
// deductions or additions and keeps both wallet balances 
// consistent.