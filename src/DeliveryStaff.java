import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
    
    

public class DeliveryStaff {
    
    ArrayList<String> parcel = new ArrayList<>();
    ArrayList<String> feedback = new ArrayList<>();
    
    public void addFeedback(){
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        String ID = StaticFunction.randomnumbers();
        String subject = StaticFunction.getUserInput("Please enter the subject for the feedback");
        String content = StaticFunction.getUserInput("Enter the content for the feedback");
        String reply = null;
        
        do { 
            System.out.println("Please select the category of the feedback");
            System.out.println("1) System Bug");
            System.out.println("2) Parcel Related");
            System.out.println("3) Customer Related");            
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 4) {
                    System.out.println("Choice outside of range. Please chose the role again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }            
        } while (choice < 0 || choice > 4);
        
            FileWriter file = null;
            boolean found = false;            
            try{
            String temp;            
            File myfile = new File("Feedback.txt");
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter("Feedback.txt", true);            
            while (sc.hasNext() && !found){
                temp = sc.nextLine();
                String []tempArr = temp.split(",");
                if(ID.equals(tempArr[0])){
                    found = true;
                    while(ID.equals(tempArr[0])){
                        ID = StaticFunction.randomnumbers();                       
                    } 
                }  
            }
            // to write user details onto the text file.
                    Feedback fdk = new Feedback(ID,subject,content,reply);
                    PrintWriter pw = new PrintWriter(file);            
                    pw.printf(fdk.getId() + ",");
                    pw.printf(fdk.getSubject() + ",");
                    pw.printf(fdk.getContent() + ",");
                    pw.printf( Integer.toString(choice) + ",");
                    pw.println(fdk.getReply());
                    file.close();
                    pw.close();            
                } catch (IOException ex) {
             Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static void main(String[] args) {
        
    }
    
}
