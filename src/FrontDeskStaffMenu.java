public class FrontDeskStaffMenu implements Menu {

    User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
    FrontDeskStaff msf = new FrontDeskStaff(usr);    
    public static void main(String[] args) {
        FrontDeskStaffMenu menu= new FrontDeskStaffMenu();
        menu.runMenu();
    }
    
    boolean exit;
    boolean exitOrder;
    
    public void runMenu(){
        StaticFunction.printHeader();
        while (!exit) {
            printMenu();
            int choice = StaticFunction.getMenuChoice(6);
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
        System.out.println("3) Edit User Details");
        System.out.println("MANAGE PARCEL");
        System.out.println("-------------------");        
        System.out.println("4) Add Parcel");
        System.out.println("5) Delete Parcel");
        System.out.println("6) View Parcel");
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
                String val = StaticFunction.randomnumbers();
                System.out.println(val);
               break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                System.out.println("Thank you for using our application.");
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
