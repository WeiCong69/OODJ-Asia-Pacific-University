import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryStaff extends User{
    
    //testing
    public DeliveryStaff(User a) {
        super(a.loginid,a.password,a.name,a.address,a.phone);
    }
    
    ArrayList<String> parcel = new ArrayList<>();
    ArrayList<String> feedback = new ArrayList<>();
    
    public void addFeedback(){
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        String ID = StaticFunction.randomnumbers();
        String subject = StaticFunction.getUserInput("Please enter the subject for the feedback");
        String content = StaticFunction.getUserInput("Enter the content for the feedback");
        String reply = "Waiting Reply";
        
        do { 
            System.out.println("Please select the category of the feedback");
            System.out.println("1) System Bug");
            System.out.println("2) Parcel Related");
            System.out.println("3) Customer Related");            
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 3) {
                    System.out.println("Choice outside of range. Please chose the role again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }            
        } while (choice < 0 || choice > 3);
        
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
                    if (Integer.toString(choice).equals("1")){
                        pw.printf("System Bug" + ",");
                    } else if (Integer.toString(choice).equals("2")){
                        pw.printf("Parcel Related" + ",");
                    } else if (Integer.toString(choice).equals("3")){
                        pw.printf("Customer Related" + ",");
                    }
                    pw.printf(fdk.getReply() + ",");
                    pw.printf(Login.Username + ",");
                    pw.println("Nobody");
                    file.close();
                    pw.close();            
                } catch (IOException ex) {
             Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public void viewPersonalFeedback(){
        
        List<List<String>> list=StaticFunction.getFeedbackFileData("Feedback.txt");
        StaticFunction.getIndiFeedback(list,1);
        int counter=1;
        int test=0;
        try {                    
            String choice = null;
            String choice1=null;
//            String[] index={"Subject","Content","Feedback Type"};
            String[] col = {"ID","Subject","Content","Feedback Type","Reply","Delivery Staff","Managing Staff"};
            do{
            if(counter==1){
                choice=StaticFunction.getUserInput("Please select a feedback to view");
                if(Integer.parseInt(choice)<list.size()){                          
                   counter++;
                }else if(Integer.parseInt(choice)==list.size()){
                    DeliveryStaffMenu msm = new DeliveryStaffMenu();
                    msm.runMenu();
                }else {
                    viewPersonalFeedback();
                    break;
                }
            }
            if(counter==2){
                   for (int i = 1,j=0; i < list.get(Integer.parseInt(choice)).size()-1;) {
                        System.out.printf("Subject:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i), 50) + "\n\n");
                        System.out.printf("Content:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+1), 50) + "\n\n");
                        System.out.printf("Feedback Type:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+2), 50) + "\n\n");
                        System.out.printf("Reply:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+3), 50) + "\n\n");
                        System.out.printf("Reply By:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+5), 50) + "\n");
                        break;
//                       System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                   }
                   String continueEditing = StaticFunction.getUserInput("\nDo you wish to view another feedback?\n0.Yes\n1.No");
                    if(continueEditing.equals("0") || continueEditing.equals("Yes")|| continueEditing.equals("Y")|| continueEditing.equals("yes")){
                    viewPersonalFeedback();
                        counter++;
                    } else {
                        counter++;
                    }
            }
        }while(counter<3);
                           
        } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please select again!");
                viewPersonalFeedback();
        } 
    }
    
    public void viewOrder(){
        String halo = "";
        List<List<String>> list=StaticFunction.getFileData("Order.txt");
        StaticFunction.getSelectionListOrder(list,0,1);
        int counter=1;
        try {                    
            String choice = null;
            String choicee = null;
            String[] col = {"OrderId", "OrderStatus"};
            do{
            if(counter==1){
                choice=StaticFunction.getUserInput("Please select an order to view");
                if(Integer.parseInt(choice)<list.size()){                          
                   counter++;
                }else if(Integer.parseInt(choice)==list.size()){
                    DeliveryStaffMenu msm = new DeliveryStaffMenu();
                    msm.runMenu();
                }else {
                    viewOrder();
                }
                
                for (int i=0; i<list.size(); i++){
                    if (Integer.parseInt(choice) == i){    
                        halo = StaticFunction.getOrderSelection(list, i);
                    }
                }
                
            }
            
            List<List<String>> list1=StaticFunction.getIndiOrderData("Parcel.txt", halo);
            if(counter==2){
            StaticFunction.getIndiOrder(list1,0,1,halo);
                String[] col1 = {"ParcelID","Address","Weight","Size","Price","ParcelStatus","DeliveryType","OrderID","AssignTo","Date"};
                    choicee=StaticFunction.getUserInput("Please select a parcel related to the order to view");
                    if(Integer.parseInt(choicee)<list1.size()){                          
                       counter++;
                    }else if(Integer.parseInt(choicee)==list1.size()){
                        DeliveryStaffMenu msm = new DeliveryStaffMenu();
                        msm.runMenu();
                    }else {
                        viewOrder();
                    }
            }
            
            if(counter==3){
                   for (int i = 1; i < list1.get(Integer.parseInt(choicee)).size();) {
                        System.out.printf("Address:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i), 50) + "\n\n");
                        System.out.printf("Weight:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+1), 50) + " KG" +"\n\n");
                        System.out.printf("Parcel Size:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+2), 50) + "\n\n");
                        System.out.printf("Price:\n");
                        System.out.printf("RM " + StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+3), 50) + "\n\n");
                        System.out.printf("Parcel Status:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+4), 50) + "\n\n");
                        System.out.printf("Delivery Type:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+5), 50) + "\n\n");
                        System.out.printf("Assign to Delivery Staff:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+7), 50) + "\n\n");
                        System.out.printf("Date:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list1.get(Integer.parseInt(choicee)).get(i+8), 50) + "\n");
                        break;
//                       System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                   }
                   String continueEditing = StaticFunction.getUserInput("\nDo you want to view another order?\n0.Yes\n1.No");
                    if(continueEditing.equals("0") || continueEditing.equals("Yes")|| continueEditing.equals("Y")|| continueEditing.equals("yes")){
                        viewOrder();
                    } else if(continueEditing.equals("1") || continueEditing.equals("No")|| continueEditing.equals("N")|| continueEditing.equals("no")){
                        counter++;
                    } else {
                        counter++;
                    }
            }
        }while(counter<4);
                           
        } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please select again!");
                viewOrder();
        } 
    }
}
