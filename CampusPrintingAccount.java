/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campusprintingaccount;

/**
 *
 * @author DAHIROC_CPE113
 */
public class CampusPrintingAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        class PrintAccount {

            private String studentName;
            private int credits;

            public PrintAccount(String studentName, int credits) {
                this.studentName = studentName;

                if (credits < 0) {
                    this.credits = 0;
                } else {
                    this.credits = credits;
                }
            }

            public boolean addCredits(int amount) {
                if (amount <= 0) {
                    return false;
                }

                this.credits += amount;
                return true;
            }

            public boolean printPages(int pages) {
                if (pages <= 0 || pages > this.credits) {
                    return false;
                }

                this.credits -= pages;
                return true;
            }

            public int getCredits() {
                return this.credits;
            }
        }

        PrintAccount mia = new PrintAccount("Mia", 10);
        PrintAccount luis = new PrintAccount("Luis", -4);

        System.out.println("Mia's starting credits: "
                + mia.getCredits());
        System.out.println("Luis's starting credits: "
                + luis.getCredits());

        System.out.println("Mia prints 4 pages: "
                + mia.printPages(4));
        System.out.println("Mia's credits: "
                + mia.getCredits());

        System.out.println("Mia prints 7 pages: "
                + mia.printPages(7));
        System.out.println("Mia's credits: "
                + mia.getCredits());

        System.out.println("Mia adds -3 credits: "
                + mia.addCredits(-3));
        System.out.println("Mia's credits: "
                + mia.getCredits());

        System.out.println("Mia adds 4 credits: "
                + mia.addCredits(4));

        System.out.println("Mia's final credits: "
                + mia.getCredits());
        System.out.println("Luis's final credits: "
                + luis.getCredits());
    }

}

//Q&A
//I accepted the AI's suggestion to validate the page count and available credits before deducting anything. 
//I did not need to reject any suggestions because they followed the activity requirements.

    
    
 
