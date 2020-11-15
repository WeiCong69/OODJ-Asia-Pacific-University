import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StaticFunction {
    //testing
    //sadljbasjdsba
    
    public static String getUserInput(String question){
        //get username from user
        Scanner keyboard = new Scanner(System.in);
        String input=null;
        System.out.println(question);        
        do {   
                input=keyboard.nextLine().toString();
                if (input == null || input.isEmpty()){
                    System.out.println("User input is not found!?!? Please key in again.");
                }      
        } while (input == null || input.isEmpty());
        
        return input;
    }
    
    public static void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|      Welcome to Kaddhar's         |");
        System.out.println("|        Courieer System            |");
        System.out.println("+-----------------------------------+");
    }
    
    public static void displayHeader(String message){
        System.out.println();
        int width = message.length() + 6;
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for(int i = 0; i < width; ++i){
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
        System.out.println("|   " + message + "   |");
        System.out.println(sb.toString());
    }
public static List getFileData(String fileName){
            FileWriter file = null;
            ArrayList<List<String>> tempArr = new ArrayList<List<String>>();            
            try{
            String temp;            
            File myfile = new File(fileName);
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter(fileName, true);
            while (sc.hasNext()){
                temp = sc.nextLine();
                List<String> items = Arrays.asList(temp.split("\\s*,\\s*"));
                tempArr.add(items);
            }
//                for (int i = 0; i < tempArr.size(); i++) {
//                    for (int j = 0; j < tempArr.get(i).size(); j++) {
//                        System.out.println(tempArr.get(i).get(j));
//                    }
//                }
//                for (int i = 0; i < tempArr.size(); i++) {
//                    System.out.println(tempArr.get(i));
//                }                                
                   sc.close();
                   file.close();
                      return tempArr;
                } catch (IOException ex) {
                    System.out.println(ex.toString());
         }

                return tempArr;
}

public static List getFeedbackFileData(String fileName){
            FileWriter file = null;
            ArrayList<List<String>> tempArr = new ArrayList<List<String>>();            
            try{
            String temp;            
            File myfile = new File(fileName);
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter(fileName, true);
            while (sc.hasNext()){
                temp = sc.nextLine();
                List<String> items = Arrays.asList(temp.split("\\s*,\\s*"));
                if (items.get(5).equals(Login.Username)){
                tempArr.add(items);
                }
            }                              
                   sc.close();
                   file.close();
                      return tempArr;
                } catch (IOException ex) {
                    System.out.println(ex.toString());
         }

                return tempArr;
}

public static List getNotReplyData(String fileName){
            FileWriter file = null;
            ArrayList<List<String>> tempArr = new ArrayList<List<String>>();            
            try{
            String temp;            
            File myfile = new File(fileName);
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter(fileName, true);
            while (sc.hasNext()){
                temp = sc.nextLine();
                List<String> items = Arrays.asList(temp.split("\\s*,\\s*"));
                if (items.get(4).equals("Waiting Reply")){
                tempArr.add(items);
                }
            }                              
                   sc.close();
                   file.close();
                      return tempArr;
                } catch (IOException ex) {
                    System.out.println(ex.toString());
         }

                return tempArr;
} 

public static void getSelectionList(List<List<String>> a,int index){        
    int exit=a.size();
    for (int i = 0; i <a.size(); i++) {
//            for (int j = 0; j < a.get(i).size(); j++) {
                System.out.println(i+". "+a.get(i).get(index));                
//            }
    }
    System.out.println(exit+". Exit selection");
} 
    
    public static String randomnumbers(){
        String val = "";
        Random ran = new Random();
        int n = ran.nextInt(1000000)+1;
        val = String.valueOf(n);
        return val;
    }
    
public static int getMenuChoice(int value) {
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if (choice < 0 || choice > value) {
                System.out.println("Choice outside of range. Please chose again.");
            }
        } while (choice < 0 || choice > value);
        return choice;
    }

public static void getReplyList(List<List<String>> a,int index){        
    int exit=a.size();
    for (int i = 0; i <a.size(); i++) {
        if (a.get(i).get(4).equals("Waiting Reply")){
                System.out.println(i+". "+a.get(i).get(index));
        }
    }
    System.out.println(exit+". Exit selection");
} 

public static void getIndiFeedback(List<List<String>> a,int index){        
    int exit=a.size();
    for (int i = 0; i <a.size(); i++) {
        if (a.get(i).get(5).equals(Login.Username)){
                System.out.println(i+". "+a.get(i).get(index));
        }
    }
    System.out.println(exit+". Exit selection");
} 

public static void getIndiReply(List<List<String>> a,int index){        
    int exit=a.size();
    for (int i = 0; i <a.size(); i++) {
        if (a.get(i).get(4).equals("Waiting Reply")){
                System.out.println(i+". "+a.get(i).get(index));
        }
    }
    System.out.println(exit+". Exit selection");
} 

public static void writeToFile(String[] params,String FileName){
        StringBuilder write = new StringBuilder();
            for (int i = 0; i < params.length; i++) {
                if(i==0){
                   write.append(String.valueOf(params[i]));               
                }else{
                   write.append(",");
                   write.append(String.valueOf(params[i]));               
                }
            }
            System.out.println(write);
            FileWriter file = null;           
            try{           
            File myfile = new File(FileName);
            Scanner sc = new Scanner(myfile);            
            file = new FileWriter(FileName, true);            
            // to write user details onto the text file.
                    PrintWriter pw = new PrintWriter(file); 
                    pw.printf(String.valueOf(write));
                    file.close();
                    pw.close();
                    sc.close();
                } catch (IOException ex) {
             Logger.getLogger(ManagingStaffMenu.class.getName()).log(Level.SEVERE, null, ex);
                }     
    }

public static String addLinebreaks(String input, int maxLineLength) {
    StringTokenizer tok = new StringTokenizer(input, " ");
    StringBuilder output = new StringBuilder(input.length());
    int lineLen = 0;
    while (tok.hasMoreTokens()) {
        String word = tok.nextToken();

        if (lineLen + word.length() > maxLineLength) {
            output.append("\n");
            lineLen = 0;
        }
        output.append(" " + word);
        lineLen += word.length();
    }
    return output.toString();
}

public static void updataOrderStatus(){
    FileWriter file = null;  
    List <SParcel> parcel = new ArrayList<SParcel>();            
    try{
        String temp;            
        File myfile = new File("Parcel.txt");
        Scanner sc = new Scanner(myfile);            
        file = new FileWriter("Parcel.txt", true);
        while (sc.hasNext()){
            temp = sc.nextLine();
            List<String> items = Arrays.asList(temp.split("\\s*,\\s*"));
            //super(orderid =>7, id=>0, address=>1, weight=>2, deliverytype=>6, deliverysize=>3);
            parcel.add(new SParcel(
                        Integer.parseInt(items.get(7)),
                        Integer.parseInt(items.get(0)),
                        items.get(1),
                        Double.parseDouble(items.get(2)),
                        items.get(6),
                        items.get(3),
                        items.get(5)));                       
            }
        sc.close();
        file.close();
        Map < Integer, List < SParcel >> sortedParcel = parcel.stream().collect(
        Collectors.groupingBy(SParcel::getOrderid));
        for(Map.Entry< Integer, List < SParcel >> i: sortedParcel.entrySet()){
              for(SParcel obj : i.getValue()){
                System.out.println(i.getKey()+"=>"+obj.getStatus());  
              }            
        }        

                   
    } catch (IOException ex) {
        System.out.println(ex.toString());
    }    
}
   
    public static String getDate(int when){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.MONTH, -when);
        dt = c.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy"); 
        return format1.format(dt);
    }

}
