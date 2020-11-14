import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryStaffMenu {
    
    User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
        DeliveryStaff ds = new DeliveryStaff(usr); 

    public static void main(String[] args) {
        DeliveryStaffMenu menu= new DeliveryStaffMenu();
        menu.runMenu();
    }
    
    boolean exit;
    boolean exitOrder;
    
    public void runMenu(){
        StaticFunction.printHeader();
        while (!exit) {
            printMenu();
            int choice = StaticFunction.getMenuChoice(4);
            performAction(choice);
        }        
    }
    
    private void printMenu() {
        StaticFunction.displayHeader("Please select a service");
        System.out.println("MANAGE PARCEL");
        System.out.println("-------------------"); 
        System.out.println("1) Edit Parcel Status");
        System.out.println("2) View Parcel");
        System.out.println("MANAGE Feedback");
        System.out.println("-------------------"); 
        System.out.println("3) Add Feedback");
        System.out.println("4) View Feedback History");
        System.out.println("-------------------"); 
        System.out.println("0) Exit Program");
    }
    
    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1: 
               break;
            case 2:
                break;
            case 3:
                ds.addFeedback();
                break;
            case 4:
                ds.viewPersonalFeedback();
                break;
            default:
                System.out.println("Please enter the numbers in this menu only");
        }
    }
    
    public void performOrderAction(int choice){
        switch (choice) {
            case 0:
                exitOrder=false;
                runMenu();
                break;
            case 1: 
                System.out.println("1");
               break;
            case 2:
                System.out.println("2");
                //makeADeposit();
                break;
            case 3:
                System.out.println("3");
                //makeAWithdrawal();
                break;
            case 4:
                System.out.println("4");
                //listBalances();
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
    }
    
    
}
