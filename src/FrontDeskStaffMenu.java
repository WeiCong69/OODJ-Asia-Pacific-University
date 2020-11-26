public class FrontDeskStaffMenu implements Menu {

    User usr=new User(Login.Username,Login.Password,Login.Name,Login.Address,Login.Phone,Login.role); 
    FrontDeskStaff fds = new FrontDeskStaff(usr);
    ManagingStaff ms = new ManagingStaff(usr);
    
    boolean exit;
    boolean exitOrder;
    
    public void runMenu(){
        StaticFunction.printHeader();
        while (!exit) {
            StaticFunction.removeEmptyOrder();
            StaticFunction.updateOrderStatus();
            printMenu();
            int choice = StaticFunction.getMenuChoice(7);
            performAction(choice);
        }        
    }
    
    public void printMenu() {
        System.out.println("Welcome to Front Desk Staff Menu");
        StaticFunction.displayHeader("Please select a service");
        System.out.println("MANAGE ORDER");
        System.out.println("-------------------");
        System.out.println("1) Make an Order");
        System.out.println("2) View Order Details");
        System.out.println("3)Edit Order & Parcels");        
        System.out.println("MANAGE USER");
        System.out.println("-------------------");
        System.out.println("4) Edit User Profile");
//        System.out.println("MANAGE PARCEL");
//        System.out.println("-------------------");        
//        System.out.println("-------------------"); 
        System.out.println("0) Exit Program");
    }
    
    public void performAction(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for using our application.");
                Login login=new Login();
                login.runLogin();
                break;
            case 1: 
                ms.addOrder();
               break;
            case 2:
                fds.viewOrderParcel();
                break;
            case 4:
                usr.editProfile();
                break;
            case 3:
                ms.viewOrderParcel();
                //fds.editParcel();
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
    
 
}
