import java.util.List;
import java.util.Scanner;

public class ManagingStaffMenu {
     boolean exit;
     boolean exitOrder;
        User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
        ManagingStaff msf = new ManagingStaff(usr);           

    public static void main(String[] args) {

//        Map<String, String> test2 = Map.ofEntries(
//            entry("ID", "0"),
//            entry("Pass", "0"),
//            entry("Name","0"),
//            entry("Address","0"),
//            entry("Phone","0"),
//            entry("Role","0")
//        );
//        for (String i : test2.keySet()) {
//            System.out.println(i+"=>");
//            System.out.println(test2.get(i));
//          
//        }

//        for (int i = 0; i <list.size(); i++) {
//            for (int j = 0; j < list.get(i).size(); j++) {
//                System.out.println(list.get(i).get(j));                
//            }
//        }
            ManagingStaffMenu menu= new ManagingStaffMenu();
//                      menu.runMenu();

            
    }
    
    public void runMenu(){
        User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
        ManagingStaff msf = new ManagingStaff(usr);
        System.out.println(msf.getLoginid());
        System.out.println(msf.getPhone());          
        StaticFunction.printHeader();
        while (!exit) {
            printMenu();
            int choice = StaticFunction.getMenuChoice(10);
            performAction(choice);
        }        
    }

        private void printMenu() {
        StaticFunction.displayHeader("Please select a service");
        System.out.println("MANAGE ORDER");
        System.out.println("-------------------");
        System.out.println("1) Make an Order");
        System.out.println("2) Edit Order Details");
        System.out.println("3) View Order Details"); 
        System.out.println("MANAGE USER");
        System.out.println("-------------------");
        System.out.println("4) Register New User");
        System.out.println("5) Edit User Details");
        System.out.println("6) Delete User Account");
        System.out.println("10) Restore Deleted User Account");
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
        System.out.println("0) Exit Program");
    }

    private int getMenuChoice() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > 9) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > 9);
        return choice;
    }
    
    private void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                System.exit(0);
                break;
            case 1: 
                msf.addOrder();
               break;
            case 2:
                //makeADeposit();
                break;
            case 3:
                //makeAWithdrawal();
                break;
            case 4:
                msf.registerNewUser();
                //listBalances();
                break;
            case 5:
                msf.editUser();
                break;
            case 6:
                msf.deleteUser1();
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
            default:
                System.out.println("Unknown error has occured.");
        }
    }


    
    private String askQuestion(String question, List<String> answers) {
        String response = "";
        Scanner keyboard = new Scanner(System.in);
        boolean choices = ((answers == null) || answers.size() == 0) ? false : true;
        boolean firstRun = true;
        do {
            if (!firstRun) {
                System.out.println("Invalid selection. Please try again.");
            }
            System.out.print(question);
            if (choices) {
                System.out.print("(");
                for (int i = 0; i < answers.size() - 1; ++i) {
                    System.out.print(answers.get(i) + "/");
                }
                System.out.print(answers.get(answers.size() - 1));
                System.out.print("): ");
            }
            response = keyboard.nextLine();
            firstRun = false;
            if (!choices) {
                break;
            }
        } while (!answers.contains(response));
        return response;
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
            int choice = getMenuChoice();
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
