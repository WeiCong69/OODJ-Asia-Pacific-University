import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//kadhar babi
//kadhar anjing
public class ManagingStaff extends User{
    public static Scanner x;
    ArrayList<String> order = new ArrayList<>();
    ArrayList<String> parcel = new ArrayList<>();
    ArrayList<String> feedback = new ArrayList<>();
    
    public ManagingStaff(User a) {
//        this.name=a.name;
//        this.password=a.password;
//        this.name=a.name;
//        this.address=a.address;
//        this.phone=a.phone;
        super(a.loginid,a.password,a.name,a.address,a.phone);
    }

    public ArrayList<String> getOrder() {
        return order;
    }

    public ArrayList<String> getParcel() {
        return parcel;
    }

    public ArrayList<String> getFeedback() {
        return feedback;
    }

    public void setOrder(ArrayList<String> order) {
        this.order = order;
    }

    public void setParcel(ArrayList<String> parcel) {
        this.parcel = parcel;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }



    public void editUser(){
        
        List<List<String>> list=StaticFunction.getFileData("User.txt");
        StaticFunction.getSelectionList(list,0);
        int counter=1;
        int test=0;
        try {                    
            String choice = null;
            String choice1=null;
            String[] index={"Full Name","Address","Phone"};
            String[] col = {"ID","Password","Full Name","Address","Phone","Role"};
            do{
            if(counter==1){
                choice=StaticFunction.getUserInput("Please select a user");
                if(Integer.parseInt(choice)<list.size()){                          
                   counter++;
                }else{
                    continue;
                }
            }
            if(counter==2){
                   for (int i = 2,j=0; i < list.get(Integer.parseInt(choice)).size()-1; i++,j++) {
                       System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                   }                
                choice1=StaticFunction.getUserInput("Please select a component to be changed:");
                test= Integer.parseInt(choice1)+2;
                System.out.println(col.length);
                if(test<col.length){
                    String value=StaticFunction.getUserInput("Old information: "+index[Integer.parseInt(choice1)]+"= "+list.get(Integer.parseInt(choice)).get(test)+"\n");
                    String confirmation=StaticFunction.getUserInput("Are you sure you want to update this information?\n0.Yes\n1.No");
                    
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                        
                        editUserFile(col,list.get(Integer.parseInt(choice)).get(0), index[Integer.parseInt(choice1)], value);
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
        String confirmation=StaticFunction.getUserInput("Are you sure you want to delete this user"+list.get(Integer.parseInt(choice))+" ?\n0.Yes\n1.No");
            if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                System.out.println(list.get(Integer.parseInt(choice)).get(0).toString());
                deleteUser(list.get(Integer.parseInt(choice)).get(0).toString(),"User.txt");
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
        } else {
            System.out.println("Not valid selection");
            deleteFeedback();
        }
        String confirmation=StaticFunction.getUserInput("Are you sure you want to delete this feedback"+list.get(Integer.parseInt(choice))+" ?\n0.Yes\n1.No");
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
            }
    } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
     } 
    } 

    public void restoreUser(){         
        List<List<String>> list=StaticFunction.getFileData("DeletedUser.txt");
        StaticFunction.getSelectionList(list,0);
        System.out.println("Lis of Users in Recycle Bin");
        String choice=StaticFunction.getUserInput("Please select a user");
        if(Integer.parseInt(choice)==list.size()){
            return;
        }        
        String confirmation=StaticFunction.getUserInput("Are you sure you want to restore this user"+list.get(Integer.parseInt(choice))+" ?\n0.Yes\n1.No");
            if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                System.out.println(list.get(Integer.parseInt(choice)).get(0).toString());
                deleteUser(list.get(Integer.parseInt(choice)).get(0).toString(),"DeletedUser.txt");
                String[] params={list.get(Integer.parseInt(choice)).get(0).toString(),list.get(Integer.parseInt(choice)).get(1).toString(),list.get(Integer.parseInt(choice)).get(2).toString(),list.get(Integer.parseInt(choice)).get(3).toString(),list.get(Integer.parseInt(choice)).get(4).toString(),list.get(Integer.parseInt(choice)).get(5).toString()};
                StaticFunction.writeToFile(params,"User.txt");
            }
    }   
    
    public void restoreFeedback(){
        try{        
        List<List<String>> list=StaticFunction.getFileData("DeletedFeedback.txt");
        StaticFunction.getSelectionList(list,0);
        System.out.println("List of feedback in Recycle Bin");
        String choice=StaticFunction.getUserInput("Please select a feedback");
        if(Integer.parseInt(choice)==list.size()){
            return;
        } else {
            System.out.println("Not valid selection");
            restoreFeedback();
        }        
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
            }
    } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
     } 
    }
    
    public void registerNewUser(){
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        String Username = StaticFunction.getUserInput("Please Enter a new username. This will be used as login ID");
        String Password = StaticFunction.getUserInput("Enter new Password");
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
                if (choice < 0 || choice > 4) {
                    System.out.println("Choice outside of range. Please chose the role again.");
                    //registerNewUser();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }            
        } while (choice < 0 || choice > 4);
        
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
                String []tempArr = temp.split(",");
                if(Username.equals(tempArr[0])){
                    found = true;
                    System.out.println("Same username found");
                    while(Username.equals(tempArr[0])){
                        Username=StaticFunction.getUserInput("Please choose another username");                        
                    } 
                }  
            }
            // to write user details onto the text file.
                    User usr = new User(Username,Password,realName,Address,Phone);
                    PrintWriter pw = new PrintWriter(file);            
                    pw.printf(usr.getLoginid() + ",");
                    pw.printf(usr.getPassword() + ",");
                    pw.printf(usr.getName() + ",");
                    pw.printf(usr.getAddress() + ",");
                    pw.printf(usr.getPhone() + ",");
                    if (Integer.toString(choice).equals("1")){
                        pw.println("Managing Staff");
                    } else if (Integer.toString(choice).equals("2")){
                        pw.println("Delivery Staff");
                    } else if (Integer.toString(choice).equals("3")){
                        pw.println("Front Desk Staff");
                    }
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
    

    public void editUserFile(String[] list,String id,String index,String newValue){
            LinkedHashMap<String, String> test2= new LinkedHashMap<String,String>();                
            String filepath = "User.txt";
            String tempFile = "Temp.txt";
            File oldFile = new File (filepath);
            File newFile = new File (tempFile);           
            //testing. to be replaced with data viewed
            //String ID,Password,Name,Address,Phone,Role;
//            ID=Password=Name=Address=Phone=Role="";
            try {
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                x.useDelimiter("[,\n]");
                while (x.hasNext()){
                    for(String i: list){
                        test2.put(i,x.next());
                    }                    
                    if(test2.get("ID").equals(id)){
                        
                        System.out.println(test2.get("ID"));
                        switch(index){
                                case "Full Name":
                                    pw.printf(test2.get("ID") +","+ test2.get("Password") +","+ newValue +","+ test2.get("Address") + "," + test2.get("Phone") + ","+test2.get("Role") + "\n");                       
                                    break;
                                case "Address":
                                    pw.printf(test2.get("ID") +","+ test2.get("Password") +","+ test2.get("Full Name") +","+ newValue + "," + test2.get("Phone") + ","+test2.get("Role") + "\n");                       
                                   break;
                                case "Phone":
                                    pw.printf(test2.get("ID") +","+ test2.get("Password") +","+ test2.get("Full Name") +","+ test2.get("Address") + "," + newValue + ","+test2.get("Role") + "\n");                       
                                    break;
                                 case "Password":
                                    pw.printf(test2.get("ID") +","+ newValue +","+ test2.get("Full Name") +","+ test2.get("Address") + "," + test2.get("Phone") + ","+test2.get("Role") + "\n");                       
                                    break;
                                default:
                                    System.out.println("swithc case not working");
                                    pw.printf(test2.get("ID") +","+ test2.get("Password") +","+ test2.get("Full Name") +","+ test2.get("Address") + "," + test2.get("Phone") + ","+test2.get("Role") + "\n");                       
                        }                                    
                    }else{
                         pw.printf(test2.get("ID") +","+ test2.get("Password") +","+ test2.get("Full Name") +","+ test2.get("Address") + "," + test2.get("Phone") + ","+test2.get("Role") + "\n");                       
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
    
    public void editFeedbackFile(String[] list,String id,String index,String newValue){
            LinkedHashMap<String, String> test2= new LinkedHashMap<String,String>();                
            String filepath = "Feedback.txt";
            String tempFile = "Temp.txt";
            File oldFile = new File (filepath);
            File newFile = new File (tempFile);           
            //testing. to be replaced with data viewed
            //String ID,Password,Name,Address,Phone,Role;
//            ID=Password=Name=Address=Phone=Role="";
            try {
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                x.useDelimiter("[,\n]");
                while (x.hasNext()){
                    for(String i: list){
                        test2.put(i,x.next());
                    }                    
                    if(test2.get("ID").equals(id)){
                        switch(index){
                                case "1":
                                    pw.printf(test2.get("ID") +","+ test2.get("Subject") +","+ test2.get("Content") +","+ test2.get("Feedback Type") + "," + newValue + "," + test2.get("Delivery Staff") + "," + this.loginid + "\n");                       
                                break;
                                default:
                                    System.out.println("switch case not working");
                                    pw.printf(test2.get("ID") +","+ test2.get("Subject") +","+ test2.get("Content") +","+ test2.get("Feedback Type") + "," + test2.get("Reply") + "," + test2.get("Delivery Staff") + "," + test2.get("Managing Staff") + "\n");                       
                        }                                    
                    }else{
                         pw.printf(test2.get("ID") +","+ test2.get("Subject") +","+ test2.get("Content") +","+ test2.get("Feedback Type") + "," + test2.get("Reply") + "," + test2.get("Delivery Staff") + "," + test2.get("Managing Staff") + "\n");                       
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
    
    private void deleteUser(String id,String fileName){
                String filepath = fileName;
                String tempFile = "Temp.txt";
                
                File oldFile = new File (filepath);
                File newFile = new File (tempFile);
                           
                String ID = "";
                String Password = "";
                String Name = "";
                String Address = "";
                String Phone = "";  
                String Role = "";
                
        try {
                
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                x.useDelimiter("[,\n]");
                
                while (x.hasNext()){
                    ID = x.next();
                    Password = x.next();
                    Name = x.next();
                    Address = x.next();
                    Phone = x.next();
                    Role = x.next();
                    if(!ID.equals(id)){
                        pw.printf(ID + "," + Password + "," + Name + "," + Address + "," + Phone + "," + Role + "\n");
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
                x.useDelimiter("[,\n]");
                
                while (x.hasNext()){
                    ID = x.next();
                    Subject = x.next(); 
                    Content = x.next();
                    FeedbackType = x.next();
                    Reply = x.next();
                    Delivery = x.next();
                    Managing = x.next();
                    if(!ID.equals(id)){
                        pw.printf(ID + "," + Subject + "," + Content + "," + FeedbackType + "," + Reply + "," + Delivery +  "," + Managing + "\n");
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
        String username = Login.Username;
        System.out.println(username);
        Scanner keyboard = new Scanner(System.in);
        ManagingStaffMenu menu= new ManagingStaffMenu();         
        List<List<String>> list=StaticFunction.getFileData("Feedback.txt");
        StaticFunction.getSelectionList(list,1);
        String choice = StaticFunction.getUserInput("CHANGE THIS TO DONT ALLOW USER TO TYPE OTHER INPUT"); 
        String[] index={"Subject","Content","Feedback Category"};        
        for (int i = 1,j=0; i < list.get(Integer.parseInt(choice)).size()-1; i++,j++) {
            System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
}
        String continueEditing = StaticFunction.getUserInput("\nDo you wish to view another feedback?\n0.Yes\n1.No");
            if(continueEditing.equals("0") || continueEditing.equals("Yes")|| continueEditing.equals("Y")|| continueEditing.equals("yes")){
                viewFeedback();
}
    }
    
    public void addReply(){
        
        List<List<String>> list=StaticFunction.getFileData("Feedback.txt");
        StaticFunction.getSelectionList(list,1);
        int counter=1;
        int test=0;
        try {                    
            String choice = null;
            String choice1=null;
            String[] index={"Subject","Content","Feedback Category"};
            String[] col = {"ID","Subject","Content","Feedback Type"};
            do{
            if(counter==1){
                choice=StaticFunction.getUserInput("Please select a feedback to reply");
                if(Integer.parseInt(choice)<list.size()){                          
                   counter++;
                }else{
                    continue;
                }
            }
            if(counter==2){
                   for (int i = 4,j=0; i < list.get(Integer.parseInt(choice)).size(); i++,j++) {
                       System.out.println(j+". "+index[j]+"-> "+ list.get(Integer.parseInt(choice)).get(i));
                   }                
                choice1=StaticFunction.getUserInput("Please select a component to be changed:");
                test= Integer.parseInt(choice1)+2;
                System.out.println(col.length);
                if(test<col.length){
                    String value=StaticFunction.getUserInput("Old information: "+index[Integer.parseInt(choice1)]+"= "+list.get(Integer.parseInt(choice)).get(test)+"\n");
                    String confirmation=StaticFunction.getUserInput("Are you sure you want to update this information?\n0.Yes\n1.No");
                    
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                        editUserFile(col,list.get(Integer.parseInt(choice)).get(0), index[Integer.parseInt(choice1)], value);
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
    }
    public void editProfile(){
        int counter=1;
        String[] col = {"ID","Password","Full Name","Address","Phone","Role"};
        try {                    
            int choice = 0;
            String choice1=null;
            do{
            if(counter==1){
                System.out.println("0. Update Password");
                System.out.println("1. Update Name");
                System.out.println("2. Update Address");
                System.out.println("3. Update Phone Number");
                choice=Integer.parseInt(StaticFunction.getUserInput("Please select a component"));
                if(choice>0 || choice <3){
                    switch(choice){
                        case 0:
                            String oldPass=StaticFunction.getUserInput("PLease enter old password:");
                            if(oldPass.equals(this.password)){
                                String newPass=StaticFunction.getUserInput("Password Verified!Please key in new password");
                                editUserFile(col,this.loginid,"Password",newPass);                            
                            }
                            break;
                        case 1:
                            String newName=StaticFunction.getUserInput("Current Name ->"+this.name+"\nPlease enter new Name.\n");
                            editUserFile(col,this.loginid,"Full Name",newName);
                            break;                            
                        case 2:
                            String newAddress=StaticFunction.getUserInput("Current Address ->"+this.address+"\nPlease enter new address.\n");
                            editUserFile(col,this.loginid,"Address",newAddress);
                            break;
                      case 3:
                            String newPhone=StaticFunction.getUserInput("Current Phone ->"+this.phone+"\nPlease enter new Phone Number.\n");
                            editUserFile(col,this.loginid,"Phone",newPhone);
                            break;
                      default:
                          System.out.println("Some error has occur.Please choose again");
                          continue;
                    };
                    String confirmation=StaticFunction.getUserInput("Do you wish to continue updating your account details?\n0.Yes\n1.No");
                    if(confirmation.equals("0") || confirmation.equals("Yes")|| confirmation.equals("Y")|| confirmation.equals("yes")){
                        continue;
                    }else{
                        counter++;                        
                    }                    
                }else{
                    continue;
                }
            }                         
        }while(counter<2);
                           
        } catch (NumberFormatException e) {
            System.out.println(e);
        }        
    }
    
    public void addOrder(){
        try{
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        int choice1 = -1;
        String id = StaticFunction.randomnumbers();
        String Address = StaticFunction.getUserInput("Enter address");
        int Weight = Integer.parseInt(StaticFunction.getUserInput("Enter weight"));
        
        do { 
            System.out.println("Please select a delivery type:");
            System.out.println("1) By Air");
            System.out.println("2) By Land");            
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
            boolean found = false;            
            try{
            String temp;            
            File myfile = new File("Order.txt");
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter("Order.txt", true);            
            while (sc.hasNext() && !found){
                temp = sc.nextLine();
                String []tempArr = temp.split(",");
                if(id.equals(tempArr[0])){
                    found = true;
                    while(id.equals(tempArr[0])){
                        id = StaticFunction.randomnumbers();                        
                    } 
                }  
            }       
                    PrintWriter pw = new PrintWriter(file);
            
                    if (Integer.toString(deliverysize).equals("1")){
                        SParcel sp = new SParcel(Integer.parseInt(id),
                                Address,
                                Weight,
                                Integer.toString(deliverytype), 
                                Integer.toString(deliverysize));
                    
                        ArrayList<SParcel> parcel = new ArrayList<SParcel>();
                        parcel.add(sp);

                        Order order = new Order((ArrayList<SParcel>) parcel);

                        ArrayList<SParcel> TotalParcelInOrder = order.getTotalParcel();

                            for(Parcel bk : TotalParcelInOrder){
                                pw.printf(bk.id + ",");
                                pw.printf(bk.address + ",");
                                pw.printf(bk.weight + ",");
                                pw.printf(bk.parcelsize("Small") + ",");
                                if (bk.deliverytype.equals("1")){
                                    pw.println("International");
                                } else if (bk.deliverytype.equals("2")){
                                    pw.println("Domestic");
                                }
                        }
                    } else if (Integer.toString(deliverysize).equals("2")){
                        SParcel sp = new SParcel(Integer.parseInt(id),
                                Address,
                                Weight,
                                Integer.toString(deliverytype), 
                                Integer.toString(deliverysize));
                    
                        ArrayList<SParcel> parcel = new ArrayList<SParcel>();
                        parcel.add(sp);

                        Order order = new Order((ArrayList<SParcel>) parcel);

                        ArrayList<SParcel> TotalParcelInOrder = order.getTotalParcel();

                            for(Parcel bk : TotalParcelInOrder){
                                pw.printf(bk.id + ",");
                                pw.printf(bk.address + ",");
                                pw.printf(bk.weight + ",");
                                pw.printf(bk.parcelsize("Large") + ",");
                                if (bk.deliverytype.equals("1")){
                                    pw.println("International");
                                } else if (bk.deliverytype.equals("2")){
                                    pw.println("Domestic");
                                }
                        }
                    }
                    
                    file.close();
                    pw.close();
                    sc.close();
                } catch (IOException ex) {
             Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
                }      
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Numbers only please.");
                    addOrder();
                }
    }

    }
