import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagingStaffMenu implements Menu {
     boolean exit;
     boolean exitOrder;
        User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
        ManagingStaff msf = new ManagingStaff(usr);           
    
    public void runMenu(){
        User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
        ManagingStaff msf = new ManagingStaff(usr);
//        System.out.println(msf.getLoginid());
//        System.out.println(msf.getPhone());          
        StaticFunction.printHeader();
        while (!exit) {
            printMenu();
            int choice = StaticFunction.getMenuChoice(13);
            performAction(choice);
        }        
    }

    public void printMenu() {
        StaticFunction.displayHeader("Please select a service");
        System.out.println("MANAGE ORDER");
        System.out.println("-------------------");
        System.out.println("1) Make an Order");
        System.out.println("2) View Order Details"); 
        System.out.println("MANAGE USER");
        System.out.println("-------------------");
        System.out.println("3) Register New User");
        System.out.println("4) Edit User Details");
        System.out.println("5) Delete User Account");
        System.out.println("6) Restore Deleted User Account");
        System.out.println("MANAGE FEEDBACK");
        System.out.println("-------------------");        
        System.out.println("7) View Feedback");
        System.out.println("8) Reply to Feedback");
        System.out.println("9) Delete Feedback");
        System.out.println("10) Restore Feedback");
        System.out.println("MANAGE PROFILE");
        System.out.println("-------------------"); 
        System.out.println("11) Edit Personal Profile");
        System.out.println("12) Restore User Account");
        System.out.println("REPORT");
        System.out.println("-------------------"); 
        System.out.println("13) View Monthly Report");
        System.out.println("0) Exit Program");
    }
    
    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                //System.exit(0);
                Login login=new Login();
                login.runLogin();
                break;
            case 1: 
                msf.addOrder();
               break;
            case 2:
                msf.viewOrderParcel();
                break;
            case 3:
                msf.registerNewUser();
                //listBalances();
                break;
            case 4:
                msf.editUser();
                break;
            case 5:
                msf.deleteUser1();
                break;
            case 6:
                break;
            case 7:
                msf.viewFeedback();
                break;
            case 8:
                msf.addReply();
                break;
            case 9:
                msf.deleteFeedback();
                break;
            case 10:
                msf.restoreFeedback();
                break;
            case 11:
                msf.editProfile();
                break;
            case 12:
                msf.restoreUser();
                break;
            case 13:
            {
                try {
                    msf.viewReport();
                } catch (ParseException ex) {
                    Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
            default:
                System.out.println("Unknown error has occured.");
        }
    }
    public void printOrderMenu(){
                   System.out.println("1) Add New Parcel");
                   System.out.println("2) View List of Parcels");
                   System.out.println("3) Edit Parcel details");
                   System.out.println("4) Remove Parcel");
                   System.out.println("0)Exit Order Menu"); 
    }

    public void runOrderMenu(){
        while (!exitOrder) {
            printOrderMenu();
            int choice = StaticFunction.getMenuChoice(4);
            performOrderAction(choice);
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
