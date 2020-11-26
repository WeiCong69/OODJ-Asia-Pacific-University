import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManagingStaff extends User{
    public String orderid = null;
    public int items = 1;
    public static Scanner x;
    
    public ManagingStaff(User a) {

        super(a.loginid,a.password,a.name,a.address,a.phone,a.role);
    }

    public void editUser(){       
        List<List<String>> list=StaticFunction.getFileData("User.txt");
        int counter=1;
        int test=0;
        try {                    
            String choice = null;
            String choice1=null;
            String[] index={"Full Name","Address","Phone"};
            String[] col = {"ID","Password","Full Name","Address","Phone","Role"};
            do{
            if(counter==1){
                StaticFunction.getSelectionList(list,0);
                choice=StaticFunction.getUserInput("Please select a user");
                if(Integer.parseInt(choice)<list.size()){                          
                   counter++;
                }else if(Integer.parseInt(choice)==list.size()){
                    return;
                }else{
                    continue;                    
                }
            }
            if(counter==2){
                
                for (int i = 2,j=0; i < list.get(Integer.parseInt(choice)).size()-1; i++,j++) {     
                     System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                }
                System.out.println("3. Exit from editting profile");
                choice1=StaticFunction.getUserInput("Please select a component to be changed:");
                if(Integer.parseInt(choice1)==3){
                    counter--;
                    continue;
                }
                User usr= new User(list.get(Integer.parseInt(choice)));
                test= Integer.parseInt(choice1)+2;
                System.out.println(col.length);
                if(test<col.length){
                    String value=StaticFunction.getUserInput("Old information: "+index[Integer.parseInt(choice1)]+"= "+list.get(Integer.parseInt(choice)).get(test)+"\n");
                    switch(choice1){
                        case "0":
                            usr.setName(value);
                            break;
                        case "1":
                            usr.setAddress(value);
                            break;
                        case "2":
                            usr.setPhone(value);
                            break;
                        default:
                            continue;
                    }
                    String confirmation=StaticFunction.getUserInput("Are you sure you want to update this information?\n0.Yes\n1.No");
                    
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                         String[] array=usr.toArray();
                         StaticFunction.updateFileLine(array, "User.txt");                
                        //editUserFile(col,list.get(Integer.parseInt(choice)).get(0), index[Integer.parseInt(choice1)], value);
                        String continueEditing=StaticFunction.getUserInput("Do you wish to continue editing details of this user?\n0.Yes\n1.No");
                        
                        if(continueEditing.equals("0") || continueEditing.equals("Yes")|| continueEditing.equals("Y")|| confirmation.equals("yes")){
                            list=StaticFunction.getFileData("User.txt");
                            continue;
                        }else{
                           counter++; 
                        }
                    }else{
                        counter++;                        
                    }
                }else{
                    continue;
                }                
            }                          
        }while(counter<3);
                           
        } catch (NumberFormatException e) {
            System.out.println(e);
        }        
       

//        System.out.println(list.get(Integer.parseInt(choice)).get(0));
//        System.out.println(index[Integer.parseInt(choice1)]);
//        System.out.println(value);
        //private void editUser(String[] list,String id,String index,String newValue){

    }

    public void deleteUser1(){         
        List<List<String>> list=StaticFunction.getFileData("User.txt");
        StaticFunction.getSelectionList(list,0);
        String choice=StaticFunction.getUserInput("Please select a user");
        if(Integer.parseInt(choice)==list.size()){
            return;
        }
        String confirmation=StaticFunction.getUserInput("Are you sure you want to delete this user("+list.get(Integer.parseInt(choice)).get(0)+") ?\n0.Yes\n1.No");
            if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                System.out.println(list.get(Integer.parseInt(choice)).get(0).toString());
                StaticFunction.deleteFileLine(list.get(Integer.parseInt(choice)).get(0).toString(),"User.txt");
                //deleteUser(list.get(Integer.parseInt(choice)).get(0).toString(),"User.txt");
                String[] params={list.get(Integer.parseInt(choice)).get(0).toString(),list.get(Integer.parseInt(choice)).get(1).toString(),list.get(Integer.parseInt(choice)).get(2).toString(),list.get(Integer.parseInt(choice)).get(3).toString(),list.get(Integer.parseInt(choice)).get(4).toString(),list.get(Integer.parseInt(choice)).get(5).toString()};
                StaticFunction.writeToFile(params,"DeletedUser.txt");
            }
    }
    
    public void deleteFeedback(){
        try{
        List<List<String>> list=StaticFunction.getFileData("Feedback.txt");
        StaticFunction.getSelectionList(list,1);
        String choice=StaticFunction.getUserInput("Please select a feedback");
        if(Integer.parseInt(choice)==list.size()){
            return;
        } else if (Integer.parseInt(choice)>list.size()){
            return;
        }
        String confirmation=StaticFunction.getUserInput("Are you sure you want to delete this feedback --> "+list.get(Integer.parseInt(choice)).get(1).toString()+" ?\n0.Yes\n1.No");
            if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                System.out.println(list.get(Integer.parseInt(choice)).get(0).toString());
                deleteFeedback1(list.get(Integer.parseInt(choice)).get(0).toString(),"Feedback.txt");
                String[] params={
                    list.get(Integer.parseInt(choice)).get(0).toString(),
                    list.get(Integer.parseInt(choice)).get(1).toString(),
                    list.get(Integer.parseInt(choice)).get(2).toString(),
                    list.get(Integer.parseInt(choice)).get(3).toString(),
                    list.get(Integer.parseInt(choice)).get(4).toString(),
                    list.get(Integer.parseInt(choice)).get(5).toString(),
                    list.get(Integer.parseInt(choice)).get(6).toString()};
                StaticFunction.writeToFile(params,"DeletedFeedback.txt");
            } else {
                deleteFeedback();
            }
    } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
     } 
    } 

    public void restoreUser(){         
        List<List<String>> list=StaticFunction.getFileData("DeletedUser.txt");
        System.out.println("\n");
        System.out.println("List of Users in Recycle Bin");
        StaticFunction.getSelectionList(list,0);
        String choice=StaticFunction.getUserInput("Please select a user");
        if(Integer.parseInt(choice)==list.size()){
            return;
        }        
        String confirmation=StaticFunction.getUserInput("Are you sure you want to restore this user("+list.get(Integer.parseInt(choice)).get(0)+" )?\n0.Yes\n1.No");
            if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                System.out.println(list.get(Integer.parseInt(choice)).get(0).toString());
                StaticFunction.deleteFileLine(list.get(Integer.parseInt(choice)).get(0).toString(),"DeletedUser.txt");
                //deleteUser(list.get(Integer.parseInt(choice)).get(0).toString(),"DeletedUser.txt");
                String[] params={list.get(Integer.parseInt(choice)).get(0).toString(),list.get(Integer.parseInt(choice)).get(1).toString(),list.get(Integer.parseInt(choice)).get(2).toString(),list.get(Integer.parseInt(choice)).get(3).toString(),list.get(Integer.parseInt(choice)).get(4).toString(),list.get(Integer.parseInt(choice)).get(5).toString()};
                StaticFunction.writeToFile(params,"User.txt");
            }
    }   
    
    public void restoreFeedback(){
        try{
            
        int counter = 1;
        String choice = null;
        
        List<List<String>> list=StaticFunction.getFileData("DeletedFeedback.txt");
        
        if (counter == 1){
        StaticFunction.getSelectionList(list,0);
        System.out.println("List of feedback in Recycle Bin");
        choice = StaticFunction.getUserInput("Please select a feedback");
            if(Integer.parseInt(choice)==list.size()){
                return;
            } else if(Integer.parseInt(choice)>list.size()){
                System.out.println("Not valid selection");
                restoreFeedback();
            } else if(Integer.parseInt(choice)>=0 && Integer.parseInt(choice)<list.size()){
                counter = 2;
            }
        }
        
        if (counter == 2){
        String confirmation=StaticFunction.getUserInput("Are you sure you want to restore this feedback"+list.get(Integer.parseInt(choice))+" ?\n0.Yes\n1.No");
            if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                System.out.println(list.get(Integer.parseInt(choice)).get(0).toString());
                deleteFeedback1(list.get(Integer.parseInt(choice)).get(0).toString(),"DeletedFeedback.txt");
                String[] params={
                    list.get(Integer.parseInt(choice)).get(0).toString(),
                    list.get(Integer.parseInt(choice)).get(1).toString(),
                    list.get(Integer.parseInt(choice)).get(2).toString(),
                    list.get(Integer.parseInt(choice)).get(3).toString(),
                    list.get(Integer.parseInt(choice)).get(4).toString(),
                    list.get(Integer.parseInt(choice)).get(5).toString(),
                    list.get(Integer.parseInt(choice)).get(6).toString()};
                StaticFunction.writeToFile(params,"Feedback.txt");
            } else {
                restoreFeedback();
            }
        }
     } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
     }
    }
    
    public void registerNewUser() {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        
        String Username = StaticFunction.getUserInput("Please Enter a new username. This will be used as login ID");
        String Password = StaticFunction.getUserInput("Enter new Password");
        
        Password = StaticFunction.getSecurePassword(Password);
        
        String realName = StaticFunction.getUserInput("Enter Full Name as per IC");
        String Address = StaticFunction.getUserInput("Enter new Address");
        String Phone = StaticFunction.getUserInput("Enter new Phone");

        //get username from user
        //get password from user       
        //get realName from user
        //get Address from user
        //get Phone from user
        //get role number from user
        do { 
            System.out.println("Please select a role for the new user:");
            System.out.println("1) Managing Staff");
            System.out.println("2) Delivery Staff");
            System.out.println("3) Front Desk Staff");            
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 3) {
                    System.out.println("Choice outside of range. Please chose the role again.");
                    //registerNewUser();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }            
        } while (choice < 0 || choice > 3);
        
        // to check if theres duplicated username. Make user reenter the username if duplicate is found.
            FileWriter file = null;
            boolean found = false;            
            try{
            String temp;            
            File myfile = new File("User.txt");
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter("User.txt", true);            
            while (sc.hasNext() && !found){
                temp = sc.nextLine();
                String []tempArr = temp.split("#####");
                if(Username.equals(tempArr[0])){
                    found = true;
                    System.out.println("Same username found");
                    while(Username.equals(tempArr[0])){
                        Username=StaticFunction.getUserInput("Please choose another username");                        
                    } 
                }  
            }
            // to write user details onto the text file.
                    if (Integer.toString(choice).equals("1")){
                        String role="Managing Staff";
                    } else if (Integer.toString(choice).equals("2")){
                        role="Delivery Staff";
                    } else if (Integer.toString(choice).equals("3")){
                        role="Front Desk Staff";
                    }            
                    User usr = new User(Username,Password,realName,Address,Phone,role);
                    PrintWriter pw = new PrintWriter(file);            
                    pw.printf(usr.getLoginid() + "#####");
                    pw.printf(usr.getPassword() + "#####");
                    pw.printf(usr.getName() + "#####");
                    pw.printf(usr.getAddress() + "#####");
                    pw.printf(usr.getPhone() + "#####");
                    pw.printf(usr.getRole()+"\n");
                    file.close();
                    pw.close();
                    sc.close();
                } catch (IOException ex) {
             Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
         }
            
//                System.out.println(Username);
//                System.out.println(Password);
//                System.out.println(choice);        
}
    

    public void editFeedbackFile(String[] list,String id,String index,String newValue){
            LinkedHashMap<String, String> test2= new LinkedHashMap<String,String>();                
            String filepath = "Feedback.txt";
            String tempFile = "Temp.txt";
            File oldFile = new File (filepath);
            File newFile = new File (tempFile);           
            //testing. to be replaced with data viewed
            //String ID,Password,Name,Address,Phone,Role;
            //ID=Password=Name=Address=Phone=Role="";
            try {
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                x.useDelimiter("[#####\n]");
                if(x.hasNext()){
                while (x.hasNext()){
                    for(String i: list){
                        test2.put(i,x.next());
                    }                    
                    if(test2.get("ID").equals(id)){
                        switch(index){
                                case "1":
                                    pw.printf(test2.get("ID") +"#####"+ test2.get("Subject") +"#####"+ test2.get("Content") +"#####"+ test2.get("Feedback Type") + "#####" + newValue + "#####" + test2.get("Delivery Staff") + "#####" + this.loginid + "\n");                       
                                break;
                                default:
                                    System.out.println("switch case not working");
                                    pw.printf(test2.get("ID") +"#####"+ test2.get("Subject") +"#####"+ test2.get("Content") +"#####"+ test2.get("Feedback Type") + "#####" + test2.get("Reply") + "#####" + test2.get("Delivery Staff") + "#####" + test2.get("Managing Staff") + "\n");                       
                        }                                    
                    }else{
                         pw.printf(test2.get("ID") +"#####"+ test2.get("Subject") +"#####"+ test2.get("Content") +"#####"+ test2.get("Feedback Type") + "#####" + test2.get("Reply") + "#####" + test2.get("Delivery Staff") + "#####" + test2.get("Managing Staff") + "\n");                       
                    }
                }
                }
                x.close();
                pw.flush();
                pw.close();
                oldFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);
            }catch(IOException e)
            {
                System.out.println(e);
                x.close();
//                oldFile.delete();
//                File dump = new File(filepath);
//                newFile.renameTo(dump);
            }
            System.out.println("Changes made successfully");
    }
         
    private void deleteFeedback1(String id,String fileName){
                String filepath = fileName;
                String tempFile = "Temp.txt";
                
                File oldFile = new File (filepath);
                File newFile = new File (tempFile);
                           
                String ID = "";
                String Subject = "";
                String Content = "";
                String FeedbackType = "";
                String Reply = "";  
                String Delivery = "";
                String Managing = "";
                
        try {
                
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                x.useDelimiter("[#####\n]");
                
                while (x.hasNext()){
                    ID = x.next();
                    Subject = x.next(); 
                    Content = x.next();
                    FeedbackType = x.next();
                    Reply = x.next();
                    Delivery = x.next();
                    Managing = x.next();
                    if(!ID.equals(id)){
                        pw.printf(ID + "#####" + Subject + "#####" + Content + "#####" + FeedbackType + "#####" + Reply + "#####" + Delivery +  "#####" + Managing + "\n");
                    }
                }
                x.close();
                pw.flush();
                pw.close();               
                oldFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);
            }catch(IOException e)
            {
                System.out.println(e);
                x.close();
                oldFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);
            }
       System.out.println("Changes made successfully");

    }    

    public void viewFeedback(){
        
        List<List<String>> list=StaticFunction.getFileData("Feedback.txt");
        StaticFunction.getSelectionList(list,1);
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
                    ManagingStaffMenu msm = new ManagingStaffMenu();
                    msm.runMenu();
                }else {
                    viewFeedback();
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
                        System.out.printf("Feedback By:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+4), 50) + "\n");
                        break;
//                       System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                   }
                   String continueEditing = StaticFunction.getUserInput("\nDo you wish to view another feedback?\n0.Yes\n1.No");
                    if(continueEditing.equals("0") || continueEditing.equals("Yes")|| continueEditing.equals("Y")|| continueEditing.equals("yes")){
                        counter++;
                        viewFeedback();
                    } else {
                        counter++;
                    }
            }
        }while(counter<3);
                           
        } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please select again!");
                viewFeedback();
        } 
    }
    
    public void addReply(){
        
        List<List<String>> list=StaticFunction.getNotReplyData("Feedback.txt");
        StaticFunction.getIndiReply(list,1);
        int counter=1;
        int test=0;
        try {                    
            String choice = null;
            String choice1=null;
//            String[] index={"Subject","Content","Feedback Type"};
            String[] col = {"ID","Subject","Content","Feedback Type","Reply","Delivery Staff","Managing Staff"};
            do{
            if(counter==1){
                choice=StaticFunction.getUserInput("Please select a feedback to reply");
                if(Integer.parseInt(choice)<list.size()){                          
                   counter++;
                }else if(Integer.parseInt(choice)==list.size()){
                    ManagingStaffMenu msm = new ManagingStaffMenu();
                    msm.runMenu();
                }else {
                    continue;
                }
            }
            if(counter==2){
                   for (int i = 1,j=0; i < list.get(Integer.parseInt(choice)).size()-1;) {
                        System.out.printf("Subject:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i), 50) + "\n\n");
                        System.out.printf("Content:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+1), 50) + "\n\n");
                        System.out.printf("Feedback Type:\n");
                        System.out.printf(StaticFunction.addLinebreaks(list.get(Integer.parseInt(choice)).get(i+2), 50) + "\n");
                        break;
//                       System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                   }
                choice1 = "1";
                test= Integer.parseInt(choice1)+2;
                if(test<col.length){
                    String value=StaticFunction.getUserInput("Please add a reply:");
                    String confirmation=StaticFunction.getUserInput("Are you sure you want to update this information?\n0.Yes\n1.No");
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                        editFeedbackFile(col,list.get(Integer.parseInt(choice)).get(0), choice1, value);
                        String continueEditing=StaticFunction.getUserInput("Do you wish to reply another feedback?\n0.Yes\n1.No");
                        if(continueEditing.equals("0") || continueEditing.equals("Yes")|| continueEditing.equals("Y")|| confirmation.equals("yes")){
                            addReply();
                            break;
//                            list=StaticFunction.getFileData("Feedback.txt");
//                            continue;
                        }else{
                           counter++; 
                        }
                    }else{
                        counter++;                        
                    }
                }else{
                    continue;
                }                
            }                          
        }while(counter<3);
                           
        } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please select again!");
                addReply();
        }  
    }
    
    public void addOrder(){
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat df2 = new DecimalFormat("#.00");
        try{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        Scanner keyboard = new Scanner(System.in);
        String assignto = null;
        int choice = -1;
        int choice1 = -1;
        if (items == 1){
        orderid = StaticFunction.randomnumbers();
        }
        String id = StaticFunction.randomnumbers();
        String Address = StaticFunction.getUserInput("Enter address");
        String CustName = StaticFunction.getUserInput("Enter customer name");
        double Weight = Double.valueOf(StaticFunction.getUserInput("Enter weight (KG)"));
        
        do { 
            System.out.println("Please select a delivery type:");
            System.out.println("1) International");
            System.out.println("2) Domestic");            
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.println("Choice outside of range. Please choose again.");
                    //registerNewUser();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }            
        } while (choice < 0 || choice > 2);
        
        do { 
            System.out.println("Please parcel size:");
            System.out.println("1) Small");
            System.out.println("2) Large");            
            try {
                choice1 = Integer.parseInt(keyboard.nextLine());
                if (choice1 < 0 || choice1 > 2) {
                    System.out.println("Choice outside of range. Please choose again.");
                    //registerNewUser();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }            
        } while (choice1 < 0 || choice1 > 2);
        
        int deliverytype = choice;
        int deliverysize = choice1;
        
        // to check if theres duplicated username. Make user reenter the username if duplicate is found.
            FileWriter file = null;
            FileWriter file1 = null;
            
            boolean found = false;
            boolean found1 = false;
            
            try{
            String temp;            
            File myfile = new File("Parcel.txt");
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter("Parcel.txt", true);

            String temp1;
            File myfile1 = new File("Order.txt");
            Scanner sc1 = new Scanner(myfile1);            
            file1 = new FileWriter("Order.txt", true); 
            
            while (sc.hasNext() && !found){
                temp = sc.nextLine();
                String []tempArr = temp.split("#####");
                if(id.equals(tempArr[0])){
                    found = true;
                    while(id.equals(tempArr[0])){
                        id = StaticFunction.randomnumbers();                        
                    } 
                }  
            } 
            
            while (sc1.hasNext() && !found1){
                temp1 = sc1.nextLine();
                String []tempArr1 = temp1.split("#####");
                if(orderid.equals(tempArr1[0])){
                    found1 = true;
                    while(id.equals(tempArr1[0])){
                        orderid = StaticFunction.randomnumbers();                        
                    } 
                }  
            } 
            
                    PrintWriter pw = new PrintWriter(file);
                    
                    PrintWriter pw1 = new PrintWriter(file1);
            
                    if (Integer.toString(deliverysize).equals("1")){
                        SParcel sp = new SParcel(
                                Integer.parseInt(id),
                                Address,
                                Double.valueOf(Weight),
                                Integer.toString(deliverysize),
                                "Pending",
                                Integer.toString(deliverytype),
                                Integer.parseInt(orderid));
                    
                        ArrayList<SParcel> parcel = new ArrayList<SParcel>();
                        parcel.add(sp);

                        Order order = new Order((ArrayList<SParcel>) parcel);

                        ArrayList<SParcel> TotalParcelInOrder = order.getTotalParcel();

                            for(Parcel bk : TotalParcelInOrder){
                                if (items == 1){
                                pw1.printf(bk.orderid + "#####");
                                pw1.println("Pending");
                                }
                                pw.printf(bk.id + "#####");
                                pw.printf(bk.address + "#####");
                                pw.printf(df.format(bk.weight) + "#####");
                                pw.printf(bk.parcelsize("Small") + "#####");
                                pw.printf(df2.format(bk.parcelprice(bk.deliverytype, "Small", String.valueOf(bk.weight))) + "#####");
                                pw.printf(bk.getStatus()+ "#####");
                                if (bk.deliverytype.equals("1")){
                                    pw.printf("International" + "#####");
                                } else if (bk.deliverytype.equals("2")){
                                    pw.printf("Domestic" + "#####");
                                }
                                pw.printf(bk.orderid + "#####");
                                pw.printf(assignto + "#####");
                                pw.println(dtf.format(now));
                                System.out.println("The price will be RM" + df2.format(bk.parcelprice(bk.deliverytype, "Small", String.valueOf(bk.weight))));
                        }
                    } else if (Integer.toString(deliverysize).equals("2")){
                        SParcel sp = new SParcel(
                                Integer.parseInt(id),
                                Address,
                                Double.valueOf(Weight),
                                Integer.toString(deliverysize),
                                "Pending",
                                Integer.toString(deliverytype),
                                Integer.parseInt(orderid));
                    
                        ArrayList<SParcel> parcel = new ArrayList<SParcel>();
                        parcel.add(sp);

                        Order order = new Order((ArrayList<SParcel>) parcel);

                        ArrayList<SParcel> TotalParcelInOrder = order.getTotalParcel();

                            for(Parcel bk : TotalParcelInOrder){
                                if (items == 1){
                                pw1.printf(bk.orderid + "#####");
                                pw1.println("Pending");
                                }
                                pw.printf(bk.id + "#####");
                                pw.printf(bk.address + "#####");
                                pw.printf(df.format(bk.weight) + "#####");
                                pw.printf(bk.parcelsize("Large") + "#####");
                                pw.printf(df2.format(bk.parcelprice(bk.deliverytype, "Large", String.valueOf(bk.weight))) + "#####");
                                pw.printf("Pending" + "#####");
                                if (bk.deliverytype.equals("1")){
                                    pw.printf("International" + "#####");
                                } else if (bk.deliverytype.equals("2")){
                                    pw.printf("Domestic" + "#####");
                                }
                                pw.printf(bk.orderid + "#####");
                                pw.printf(assignto + "#####");
                                pw.println(dtf.format(now));
                                System.out.println("The price will be RM" + df2.format(bk.parcelprice(bk.deliverytype, "Large", String.valueOf(bk.weight))));
                        }
                    }
                    file.close();
                    pw.close();
                    sc.close();
                    
                    file1.close();
                    pw1.close();
                    sc1.close();
                    
                    String confirmation=StaticFunction.getUserInput("Do you want to add another parcel to this order?\n0.Yes\n1.No\n2.New Order");
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
//                        System.out.println("working");
                        items = 2;
                        addOrder();
                    } else if(confirmation.equals("2") || confirmation.equals("new")|| confirmation.equals("new order")|| confirmation.equals("New Order")){
//                        System.out.println("working 1");
                        items = 1;
                        addOrder();
                    } else {
                        items = 1;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Numbers only please.");
                    addOrder();
        }
    }
    
    public void viewReport() throws ParseException{
        ManagingStaffMenu msm = new ManagingStaffMenu();
        List<List<String>> list=StaticFunction.getFileData("Parcel.txt");
//        StaticFunction.getSelectionList(list,0);
        System.out.println("1) 1 Month");
        System.out.println("2) 2 Month");
        System.out.println("3) 3 Month");
        System.out.println("4) 4 Month");
        System.out.println("5) 5 Month");
        System.out.println("6) 6 Month");
        System.out.println("7) Exit Selection");
        int counter=1;
        int test=0;
        try {                    
            String choice = "";
            String[] col = {"ParcelID","Address","Weight","Size","Price","ParcelStatus","DeliveryType","OrderID","AssignTo","Date"};
            do{
            if(counter==1){
                choice=StaticFunction.getUserInput("Please select the duration of the report");
                
                try {
                if (Integer.parseInt(choice) <= 0 || Integer.parseInt(choice) > 7) {
                    System.out.println("Choice outside of range. Please choose again.");
                } else if (Integer.parseInt(choice) == 7){
                    msm.runMenu();
                } else if (Integer.parseInt(choice) > 0 || Integer.parseInt(choice) < 7){
                    String fileName = "Parcel.txt";
                String filepath = fileName;
                String tempFile = "Temp.txt";
                
                File oldFile = new File (filepath);
                File newFile = new File (tempFile);
                           
                String ParcelID = "";
                String Address = "";
                String Weight = "";
                String Size = "";
                String Price = "";  
                String ParcelStatus = "";
                String DeliveryType = "";
                String OrderID = "";
                String AssignTo = "";
                String Date = "";
                String comparison = "";
                
            try {
                
                x = new Scanner(new File (filepath));
                
                double TotalPrice = 0;
                
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                int count5 = 0;
                int count6 = 0;
                int count7 = 0;
                
                x.useDelimiter("[#####\n]");
                
                while (x.hasNext()){
                    ParcelID = x.next();
                    Address = x.next(); 
                    Weight = x.next();
                    Size = x.next();
                    Price = x.next();
                    ParcelStatus = x.next();
                    DeliveryType = x.next();
                    OrderID = x.next();
                    AssignTo = x.next();
                    Date = x.next();
                    
                    for (int i=1; i<7; i++){
                    if(choice.equals(String.valueOf(i))){
                    Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(Date);
                    Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(StaticFunction.getDate(i));
                    System.out.println(d1);
                    System.out.println(d2);
                    
                        if (d1.compareTo(d2) > 0){
                            TotalPrice = TotalPrice + Double.parseDouble(Price);
                            if (DeliveryType.equals("International")){
                                count1 = count1 + 1;
                            }
                            if (DeliveryType.equals("Domestic")){
                                count2 = count2 + 1;
                            }
                            if (ParcelStatus.equals("Pending")){
                                count3 = count3 + 1;
                            }
                            if (ParcelStatus.equals("On Delivery")){
                                count4 = count4 + 1;
                            }
                            if (ParcelStatus.equals("Delivered")){
                                count5 = count5 + 1;
                            }
                            if (Size.equals("Small")){
                                count6 = count6 + 1;
                            }
                            if (Size.equals("Large")){
                                count7 = count7 + 1;
                            }
                        }
                    }
                  }
                }
                System.out.println("Total Earn RM " + TotalPrice);
                System.out.println("Total parcel for Domestic Delivery: " + count2);
                System.out.println("Total parcel for International Delivery: " + count1);
                System.out.println("Total parcel status in pending: " + count3);
                System.out.println("Total parcel status in On Delivery: " + count4);
                System.out.println("Total parcel status in Delivered: " + count5);
                System.out.println("Total small parcel size: " + count6);
                System.out.println("Total large parcel size: " + count7);
                x.close();
                    }catch(IOException e)
                    {
                        System.out.println(e);
                        x.close();
                    }
                    String confirmation=StaticFunction.getUserInput("Do you want to view another report?\n0.Yes\n1.No");
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
//                        System.out.println("working");
                        viewReport();
                    } else {
                        msm.runMenu();
                    }
                }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Numbers only please.");
                }
            }
            
            
        }while(counter<3);
                           
        } catch (NumberFormatException e) {
            System.out.println(e);
                System.out.println("Invalid selection. Please select again!");
                viewReport();
        } 
    }
    
    public void viewOrderParcel(){
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
                    ManagingStaffMenu msm = new ManagingStaffMenu();
                    msm.runMenu();
                }else {
                    viewOrderParcel();
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
                        ManagingStaffMenu msm = new ManagingStaffMenu();
                        msm.runMenu();
                    }else {
                        viewOrderParcel();
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
                counter++;
            }
            if(counter==4){
                   String action = StaticFunction.getUserInput("\nWhat do you wish to do?\n0.View other order\n1.Edit Parcel\n2.Delete Parcel\n3.Exit");
                    if(Integer.parseInt(action)==0){
                    viewOrderParcel();
                        counter++;
                    } else if(Integer.parseInt(action)==1){
                         SParcel parcel = new SParcel(
                            Integer.parseInt(list1.get(Integer.parseInt(choicee)).get(7)),
                            Integer.parseInt(list1.get(Integer.parseInt(choicee)).get(0)),
                            list1.get(Integer.parseInt(choicee)).get(1),
                            Double.parseDouble(list1.get(Integer.parseInt(choicee)).get(2)),
                            list1.get(Integer.parseInt(choicee)).get(6),
                            list1.get(Integer.parseInt(choicee)).get(3),
                            list1.get(Integer.parseInt(choicee)).get(5));
                         parcel.editParcel(list1.get(Integer.parseInt(choicee)).get(3),list1.get(Integer.parseInt(choicee)).get(4),list1.get(Integer.parseInt(choicee)).get(8),list1.get(Integer.parseInt(choicee)).get(9));
                                                   
                    }else if(Integer.parseInt(action)==2){
                        StaticFunction.deleteFileLine(list1.get(Integer.parseInt(choicee)).get(0),"Parcel.txt");
                        counter=2;
                        continue;
                    }else if(Integer.parseInt(action)==3){
                        return;
                    }else{
                        continue;
                    }                
            }
        }while(counter<5);
            
                           
        } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please select again!");
                viewOrderParcel();
        } 
    }

  public void autoAssginParcel(){
       List<List<String>> data=StaticFunction.getFileData("User.txt");
       List<String> dsf= new ArrayList<String>();
       for (int i = 0; i <data.size(); i++) {
          if(data.get(i).get(5).equals("Delivery Staff"))
              dsf.add(data.get(i).get(0));
       }
       int randomNum = ThreadLocalRandom.current().nextInt(0, dsf.size());
       System.out.println(dsf);
       System.out.println(randomNum);
       data=StaticFunction.getFileData("Parcel.txt");
       for (int i = 0; i <data.size(); i++) {
        if(data.get(i).get(8).equals("null")){
              if(randomNum>=dsf.size())randomNum=0;
              System.out.println(randomNum);              
              data.get(i).set(8,dsf.get(randomNum));
              System.out.println(data.get(i));
              String[] itemsArray = new String[data.get(i).size()];
              itemsArray = data.get(i).toArray(itemsArray);              
              StaticFunction.updateFileLine(itemsArray,"Parcel.txt");
              randomNum++;
        }
       }      
  }
  
  public void exportData() throws IOException{
    String action = StaticFunction.getUserInput("Select the data you wish to export.\n0.User Report\n1.Feedback Report\n2.Order Report\n3.Parcel Report.\n4.Exit");
    switch(action){
        case "0":
            StaticFunction.UserReport();
            break;
        case "1":
            StaticFunction.FeedbackReport();
            break;
        case "2":
            StaticFunction.OrderReport();
            break;
        case "3":
            StaticFunction.ParcelReport();
            break;
        case "4":
            return;
        default:
            System.out.println("Error(code:69) has ocurred.Please reselect yr option");
            exportData();
    }
    String confirmation=StaticFunction.getUserInput("Do you want to export another report?\n0.Yes\n1.No");
        if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
             exportData();
        } else {
            return;
        }    
  }
}

