
//import static ManagingStaff.x;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
public class User {
 public static Scanner x;
    
    public String[] toArray(){
        String[] array={loginid,password,name,address,phone,role};
        return array;
    }
    public void addOrder() {
      System.out.println("Order is added");
    }
    
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

    public User(String loginid, String password, String name, String address, String phone,String role) {
        this.loginid = loginid;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.role=role;
    }

    public User(List a) {
        this.loginid =(String) a.get(0);
        this.password = (String) a.get(1);
        this.name = (String) a.get(2);
        this.address = (String) a.get(3);
        this.phone = (String) a.get(4);
        this.role=(String) a.get(5);
    }    
    public void editProfile(){
        int counter=1;
        String[] col = {"ID","Password","Full Name","Address","Phone","Role"};
        try {                    
            int choice = 0;
            do{
            if(counter==1){
                System.out.printf("Name:\n");
                System.out.printf(StaticFunction.addLinebreaks(this.name, 50) + "\n\n");
                System.out.printf("Address:\n");
                System.out.printf(StaticFunction.addLinebreaks(this.address, 50)+"\n\n");
                System.out.printf("Phone Number:\n");
                System.out.printf(StaticFunction.addLinebreaks(this.phone, 50) + "\n\n");                
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
                                //editUserFile(col,this.loginid,"Password",newPass);
                                setPassword(newPass);
                                String[] array=toArray();
                                StaticFunction.updateFileLine(array, "User.txt");
                            }else{
                                System.out.println("Password does not match");
                            }
                            break;
                        case 1:
                            String newName=StaticFunction.getUserInput("Current Name ->"+this.name+"\nPlease enter new Name.\n");
                            //editUserFile(col,this.loginid,"Full Name",newName);
                            setName(newName);
                            String[] array=toArray();
                            //System.out.println(Arrays.toString(array));
                            StaticFunction.updateFileLine(array, "User.txt");                            
                            break;                            
                        case 2:
                            String newAddress=StaticFunction.getUserInput("Current Address ->"+this.address+"\nPlease enter new address.\n");
                            //editUserFile(col,this.loginid,"Address",newAddress);
                            setAddress(newAddress);
                            array=toArray();
                            StaticFunction.updateFileLine(array, "User.txt");                            
                            break;
                      case 3:
                            String newPhone=StaticFunction.getUserInput("Current Phone ->"+this.phone+"\nPlease enter new Phone Number.\n");                           
                            //editUserFile(col,this.loginid,"Phone",newPhone);
                            setPhone(newPhone);
                            array=toArray();
                            StaticFunction.updateFileLine(array, "User.txt");
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
             editProfile();
             System.out.println("Some error has occur.Please choose again");             
        }        
    }
        
    public String loginid;
    public String password;
    public String name;
    public String address;
    public String phone;
    public String role;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


    @Override
    public String toString()
    {
        return null;
    }

    
}
