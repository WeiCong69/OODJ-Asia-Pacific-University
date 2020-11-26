public class DeliveryStaffMenu implements Menu{
    
    User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone); 
    DeliveryStaff ds = new DeliveryStaff(usr); 
    
    boolean exit;
    boolean exitOrder;
    
    public void runMenu(){
            StaticFunction.removeEmptyOrder();
            StaticFunction.updateOrderStatus();
            StaticFunction.printHeader();
        while (!exit) {
            StaticFunction.removeEmptyOrder();
            StaticFunction.updateOrderStatus();
            printMenu();
            int choice = StaticFunction.getMenuChoice(6);
            performAction(choice);
        }        
    }
    
    public void printMenu() {
        //master code
        System.out.println("Welcome to Delivery Staff Menu");
        StaticFunction.displayHeader("Please select a service");
        System.out.println("MANAGE PARCEL");
        System.out.println("-------------------"); 
        System.out.println("1) Edit Parcel Status");
        System.out.println("2) View Parcel");
        System.out.println("MANAGE USER");
        System.out.println("-------------------");
        System.out.println("3) Edit User Profile");        
        System.out.println("MANAGE Feedback");
        System.out.println("-------------------"); 
        System.out.println("4) Add Feedback");
        System.out.println("5) View Feedback History");
        System.out.println("-------------------"); 
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
               ds.editParcel();
               break;
            case 2:
                ds.viewOrder();
                break;
            case 3:
                ds.editProfile();
                break;               
            case 4:
                ds.addFeedback();
                break;
            case 5:
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
