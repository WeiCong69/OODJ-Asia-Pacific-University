import java.io.IOException;
import java.text.ParseException;
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
            StaticFunction.removeEmptyOrder();
            StaticFunction.updateOrderStatus();
            printMenu();
            int choice = StaticFunction.getMenuChoice(14);
            performAction(choice);
        }        
    }

    public void printMenu() {
        System.out.println("Welcome to Managing Staff Menu");
        StaticFunction.displayHeader("Please select a service");
        System.out.println("MANAGE ORDER");
        System.out.println("-------------------");
        System.out.println("1) Make an Order");
        System.out.println("2) View Order Details");
        System.out.println("3) Assign Parcels"); 
        System.out.println("MANAGE USER");
        System.out.println("-------------------");
        System.out.println("4) Register New User");
        System.out.println("5) Edit User Details");
        System.out.println("6) Delete User Account");
        System.out.println("7) Restore Deleted User Account");
        System.out.println("MANAGE FEEDBACK");
        System.out.println("-------------------");        
        System.out.println("8) View Feedback");
        System.out.println("9) Reply to Feedback");
        System.out.println("10) Delete Feedback");
        System.out.println("11) Restore Feedback");
        System.out.println("MANAGE PROFILE");
        System.out.println("-------------------"); 
        System.out.println("12) Edit Personal Profile");
//        System.out.println("12) Restore User Account");
        System.out.println("REPORT");
        System.out.println("-------------------"); 
        System.out.println("13) View Monthly Report");
        System.out.println("14) Export Data to Excel Sheet");
        System.out.println("0) Exit Program");
    }
    
    public void performAction(int choice) {
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
                msf.autoAssginParcel();
                break;                
            case 4:
                msf.registerNewUser();
                break;
            case 5:
                msf.editUser();
                break;
            case 6:
                msf.deleteUser1();
                break;
            case 7:
                msf.restoreUser();
                break;
            case 8:
                msf.viewFeedback();
                break;
            case 9:
                msf.addReply();
                break;
            case 10:
                msf.deleteFeedback();
                break;
            case 11:
                msf.restoreFeedback();
                break;
            case 12:
                msf.editProfile();
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
            case 14:
            {
                try {
                    msf.exportData();
                } catch (IOException ex) {
                    Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;                
                
            default:
                System.out.println("Unknown error has occured.");
        }
    }

}
