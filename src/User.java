
//import static ManagingStaff.x;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Scanner;
public class User {
 public static Scanner x;
   
    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getLoginid() {
        return loginid;
    }

    public User(String loginid, String password, String name, String address, String phone) {
        this.loginid = loginid;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public void editProfile(){
        int counter=1;
        String[] col = {"ID","Password","Full Name","Address","Phone","Role"};
        try {                    
            int choice = 0;
            do{
            if(counter==1){
                System.out.println("0. Update Password");
                System.out.println("1. Update Name");
                System.out.println("2. Update Address");
                System.out.println("3. Update Phone Number");
                System.out.println("4. Exit");
                choice=Integer.parseInt(StaticFunction.getUserInput("Please select a component"));
                if(choice>-1 || choice <5){
                    switch(choice){
                        case 0:
                            String oldPass=StaticFunction.getUserInput("PLease enter old password:");
                            if(oldPass.equals(this.password)){
                                String newPass=StaticFunction.getUserInput("Password Verified!Please key in new password");
                                editUserFile(col,this.loginid,"Password",newPass);
                                setPassword(newPass);
                            }else{
                                System.out.println("Password does not match");
                            }
                            break;
                        case 1:
                            String newName=StaticFunction.getUserInput("Current Name ->"+this.name+"\nPlease enter new Name.\n");
                            editUserFile(col,this.loginid,"Full Name",newName);
                            setName(newName);
                            break;                            
                        case 2:
                            String newAddress=StaticFunction.getUserInput("Current Address ->"+this.address+"\nPlease enter new address.\n");
                            editUserFile(col,this.loginid,"Address",newAddress);
                            setAddress(newAddress);
                            break;
                      case 3:
                            String newPhone=StaticFunction.getUserInput("Current Phone ->"+this.phone+"\nPlease enter new Phone Number.\n");                           
                            editUserFile(col,this.loginid,"Phone",newPhone);
                            setPhone(newPhone);
                            break;
                      case 4:
                            System.out.println("Edit Profile exit sucessfully");
                            return;
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
                    System.out.println("Some error has occur.Please choose again");
                    continue;
                }
            }                         
        }while(counter<2);
                           
        } catch (NumberFormatException e) {
            System.out.println(e);
        }        
    }
    
    public void editUserFile(String[] list,String id,String index,String newValue){
            LinkedHashMap<String, String> test2= new LinkedHashMap<String,String>();                
            String filepath = "User.txt";
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
                x.useDelimiter("[,\n]");
                while (x.hasNext()){
                    for(String i: list){
                        if(x.hasNext()){
                           test2.put(i,x.next());   
                        }
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
                                    System.out.println("switch case not working");
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
    public static String loginid;
    public static String password;
    public static String name;
    public static String address;
    public static String phone;


    @Override
    public String toString()
    {
        return null;
    }

    
}
