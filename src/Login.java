import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

public class Login {
    
    boolean exit;
    boolean exitOrder;
    public static String Username;
    public static String Password;
    public static String Address;
    public static String Phone;
    public static String Name;
    
    public static void main(String[] args) {
        StaticFunction.removeEmptyOrder();
        Login login = new Login();
        login.runLogin();
       
    }

    
    public void runLogin(){
//        StaticFunction.printHeader();
//        System.out.println("-------------------");
//        Username = StaticFunction.getUserInput("Please enter username\n0) Reset Password\n1) Exit Application");
//        if (Username.equals("1")){
//            System.out.println("Thank you for using our application.");
//            System.exit(0);
//        } else if(Username.equals("0")){
//            JavaEmail je = new JavaEmail();
//             try {
//                 je.run();
//                 runLogin();
//             } catch (MessagingException ex) {
//                 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//             }
//        }
//        System.out.println("-------------------");
//        Password = StaticFunction.getUserInput("Please enter password");
//        String Managing = "Managing Staff";
//        String Delivery = "Delivery Staff";
//        String FrontDesk = "Front Desk Staff";
//        boolean found = false;
//        
//        try{
//        File myfile = new File("User.txt");
//        Scanner sc = new Scanner(myfile);
//        String temp;
//        
//        while(sc.hasNext() && !found){
//            temp = sc.nextLine();
//            String []tempArr = temp.split(","); //"," see from the file to seperate username and password to match with the textfield input
//            if(Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && Managing.equals(tempArr[5])){
//                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
//                System.out.println("Login Successfully. Welcome Back " + Login.Username);
//                found = true;
//                sc.close();
//                ManagingStaffMenu msm = new ManagingStaffMenu();
//                msm.runMenu();
//            }
//            else if (Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && Delivery.equals(tempArr[5])){
//                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
//                System.out.println("Login Successfully. Welcome Back " + Login.Username);
//                found = true;
//                sc.close();
//                DeliveryStaffMenu msm = new DeliveryStaffMenu();
//                msm.runMenu();
//            }
//            else if (Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && FrontDesk.equals(tempArr[5])){
//                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
//                System.out.println("Login Successfully. Welcome Back " + Login.Username);
//                found = true;
//                sc.close();
//                FrontDeskStaffMenu msm = new FrontDeskStaffMenu();
//                msm.runMenu();
//            }
//            
//        }
//        if (!found){ //if not found
//            System.out.println("Login unsuccessful. Please contact managing staff or try again!");
//            main(new String[0]);
//            }
//        }        
//        catch(FileNotFoundException ex){}       

//         StaticFunction.printHeader();
//        System.out.println("-------------------");
//        Username = StaticFunction.getUserInput("Please enter username\n0) Reset Password\n1) Exit Application");
//        if (Username.equals("1")){
//            System.out.println("Thank you for using our application.");
//            System.exit(0);
//        } else if(Username.equals("0")){
//            JavaEmail je = new JavaEmail();
//             try {
//                 je.run();
//                 runLogin();
//             } catch (MessagingException ex) {
//                 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//             }
//        }
//        System.out.println("-------------------");
//        Password = StaticFunction.getUserInput("Please enter password");
//        String Managing = "Managing Staff";
//        String Delivery = "Delivery Staff";
//        String FrontDesk = "Front Desk Staff";
//        boolean found = false;
//        
//        try{
//        File myfile = new File("User.txt");
//        Scanner sc = new Scanner(myfile);
//        String temp;
//        
//        while(sc.hasNext() && !found){
//            temp = sc.nextLine();
//            String []tempArr = temp.split(","); //"," see from the file to seperate username and password to match with the textfield input
//            if(Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && Managing.equals(tempArr[5])){
//                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
//                System.out.println("Login Successfully. Welcome Back " + Login.Username);
//                found = true;
//                sc.close();
//                ManagingStaffMenu msm = new ManagingStaffMenu();
//                msm.runMenu();
//            }
//            else if (Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && Delivery.equals(tempArr[5])){
//                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
//                System.out.println("Login Successfully. Welcome Back " + Login.Username);
//                found = true;
//                sc.close();
//                DeliveryStaffMenu msm = new DeliveryStaffMenu();
//                msm.runMenu();
//            }
//            else if (Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && FrontDesk.equals(tempArr[5])){
//                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
//                System.out.println("Login Successfully. Welcome Back " + Login.Username);
//                found = true;
//                sc.close();
//                FrontDeskStaffMenu msm = new FrontDeskStaffMenu();
//                msm.runMenu();
//            }
//            
//        }
//        if (!found){ //if not found
//            System.out.println("Login unsuccessful. Please contact managing staff or try again!");
//            main(new String[0]);
//            }
//        }        
//        catch(FileNotFoundException ex){}       
         StaticFunction.printHeader();
        System.out.println("-------------------");
        Username = StaticFunction.getUserInput("Please enter username\n0) Reset Password\n1) Exit Application");
        if (Username.equals("1")){
            System.out.println("Thank you for using our application.");
            System.exit(0);
        } else if(Username.equals("0")){
            JavaEmail je = new JavaEmail();
             try {
                 je.run();
                 runLogin();
             } catch (MessagingException ex) {
                 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        System.out.println("-------------------");
        Password = StaticFunction.getUserInput("Please enter password");
        String Managing = "Managing Staff";
        String Delivery = "Delivery Staff";
        String FrontDesk = "Front Desk Staff";
        boolean found = false;
        
        try{
        File myfile = new File("User.txt");
        Scanner sc = new Scanner(myfile);
        String temp;
        
        while(sc.hasNext() && !found){
            temp = sc.nextLine();
            String []tempArr = temp.split(","); //"," see from the file to seperate username and password to match with the textfield input
            if(Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && Managing.equals(tempArr[5])){
                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
                System.out.println("Login Successfully. Welcome Back " + Login.Username);
                found = true;
                sc.close();
                ManagingStaffMenu msm = new ManagingStaffMenu();
                msm.runMenu();
            }
            else if (Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && Delivery.equals(tempArr[5])){
                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
                System.out.println("Login Successfully. Welcome Back " + Login.Username);
                found = true;
                sc.close();
                DeliveryStaffMenu msm = new DeliveryStaffMenu();
                msm.runMenu();
            }
            else if (Username.equals(tempArr[0]) && Password.equals(tempArr[1]) && FrontDesk.equals(tempArr[5])){
                Name=tempArr[2];Address=tempArr[3];Phone=tempArr[4];
                System.out.println("Login Successfully. Welcome Back " + Login.Username);
                found = true;
                sc.close();
                FrontDeskStaffMenu msm = new FrontDeskStaffMenu();
                msm.runMenu();
            }
            
        }
        if (!found){ //if not found
            System.out.println("Login unsuccessful. Please contact managing staff or try again!");
            main(new String[0]);
            }
        }        
        catch(FileNotFoundException ex){}       

    }
 }
    
    