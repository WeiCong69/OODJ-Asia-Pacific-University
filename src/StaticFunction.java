import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StaticFunction {
    public static Scanner x;
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

public static List getIndiOrderData(String fileName, String id){
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
                if (items.get(7).equals(id)){
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

public static void getSelectionListOrder(List<List<String>> a,int index,int index2){        
    int exit=a.size();
    for (int i = 0; i <a.size(); i++) {
                System.out.println(i+". " + a.get(i).get(index) + " - " + a.get(i).get(index2));
    }
    System.out.println(exit+". Exit selection");
}

public static String getOrderSelection(List<List<String>> a,int index){
    return a.get(index).get(0);
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

public static void getIndiOrder(List<List<String>> a,int index, int index1, String id){        
    int exit=a.size();
    for (int i = 0; i <a.size(); i++) {
        if (a.get(i).get(7).equals(id)){
                System.out.println(i+". " + a.get(i).get(index) + " - " + a.get(i).get(index1));
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
                    pw.println(String.valueOf(write));
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

public static void updateOrderStatus(){
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
            for (int j = 0; j <i.getValue().size(); j++) {
                  SParcel obj = i.getValue().get(j);
                  //System.out.println(i.getValue().size());
                  if(obj.getStatus().equals("Pending") || obj.getStatus().equals("On Delivery") ){
                      break;
                  }else{
                      if(j==i.getValue().size()-1){
                          editOrderFile(obj.getOrderid(),"Delivered");
                      }
                  }                
            }
//            for(SParcel obj : i.getValue()){
//                  if(obj.getStatus().equals("Pending") || obj.getStatus().equals("on delivery") ){
//                      continue;
//                  }else{
//                      System.out.println("no");
//                  }
//              } 
//            if(i.getValue().stream().map(SParcel::getStatus).filter("Delivered"::equals).findFirst().isPresent()){
//                System.out.println("yes");
//            }
        }        
                   
    } catch (IOException ex) {
        System.out.println(ex.toString());
    }    
}

    public static void editOrderFile(int id,String status){    
            String filepath = "Order.txt";
            String tempFile = "Temp.txt";
            File oldFile = new File (filepath);
            File newFile = new File (tempFile);           
            try {
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                //x.useDelimiter("[,\n]");
                while (x.hasNext()){
                    String temp = x.next();
                    List<String> parcels = Arrays.asList(temp.split("\\s*,\\s*"));
                    //System.out.println(parcels.size());
                    if(Integer.parseInt(parcels.get(0))==id){
                       pw.printf(id+","+status+"\n");                                         
                    }else{
                       pw.printf(parcels.get(0)+","+parcels.get(1)+"\n");                                                                 
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

    public static String getDate(int when){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.MONTH, -when);
        dt = c.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy"); 
        return format1.format(dt);
    }

    public static void returnAssignedParcelsCount() {

    ArrayList<String> seussCountActivities = new ArrayList<String>() { {
        add("findow");
        add("Balloons");
        add("Elephants");
        add("Boom Bands");
        add("findow");
        add("Hakken-Kraks");
        add("Hakken-Kraks");
        add("Hakken-Kraks");
        add("Elephants");
    }};

    Map<String, Integer> seussCount = new HashMap<String,Integer>();
    for(String t: seussCountActivities) {
       Integer i = seussCount.get(t);
       if (i ==  null) {
           i = 0;
       }
       seussCount.put(t, i + 1);
    }
    for (Map.Entry<String, Integer> entry : seussCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }
}
   public static void updateFileLine(String[] params,String fileName){
                StringBuilder write = new StringBuilder();
                for (int i = 0; i < params.length; i++) {
                    if(i==0){
                       write.append(String.valueOf(params[i]));               
                    }else{
                       write.append(",");
                       write.append(String.valueOf(params[i]));               
                    }
                }
                String tempFile = "Temp.txt";
                File oldFile = new File (fileName);
                File newFile = new File (tempFile);           
                try {
                    FileWriter fw = new FileWriter(tempFile,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    x = new Scanner(new File (fileName));
                    while (x.hasNext()){                  
                        String temp = x.nextLine();
                        //System.out.println(temp);
                        List<String> parcels = Arrays.asList(temp.split("\\s*,\\s*"));
                        if(parcels.get(0).equals(params[0])){
                           pw.printf(String.valueOf(write)+"\n");                                         
                        }else{
    pw.printf(parcels.get(0)+","+parcels.get(1)+","+parcels.get(2)+","+parcels.get(3)+","+parcels.get(4)+","+parcels.get(5)+
            ","+parcels.get(6)+","+parcels.get(7)+","+parcels.get(8)+","+parcels.get(9)+"\n");                                                                 
                        }
                    }
                    x.close();
                    pw.flush();
                    pw.close();
                    oldFile.delete();
                    File dump = new File(fileName);
                    newFile.renameTo(dump);
                }catch(IOException e)
                {
                    System.out.println(e);
                    x.close();
                }
    }
   public static void deleteFileLine(String id,String fileName){
                String tempFile = "Temp.txt";
                File oldFile = new File (fileName);
                File newFile = new File (tempFile);           
                try {
                    FileWriter fw = new FileWriter(tempFile,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);
                    x = new Scanner(new File (fileName));
                    while (x.hasNext()){                  
                        String temp = x.nextLine();
                        System.out.println(temp);
                        List<String> parcels = Arrays.asList(temp.split("\\s*,\\s*"));
                        if(!parcels.get(0).equals(id)){
                            for(int i=0;i<parcels.size();i++){
                                if(i==0){
                                   pw.printf(parcels.get(i));
                                }else{
                                   pw.printf(",");
                                   pw.printf(parcels.get(i));               
                                }
                            }
                            pw.printf("\n");
                        }
                    }
                    x.close();
                    pw.flush();
                    pw.close();
                    oldFile.delete();
                    File dump = new File(fileName);
                    newFile.renameTo(dump);
                }catch(IOException e)
                {
                    System.out.println(e);
                    x.close();
                }
    }

   public static void removeEmptyOrder(){
//       List<List<String>> order=StaticFunction.getFileData("Order.txt");
//       List<String> orderID=new ArrayList<String>();
//       for(List<String> i: order){
//           orderID.add(i.get(0));
//       }
       List<List<String>> parcelFromFile=StaticFunction.getFileData("Parcel.txt");       
       List <SParcel> parcel = new ArrayList<SParcel>();       
       for(List<String> i: parcelFromFile){
           SParcel a=new SParcel(i);
           parcel.add(a);
       }
       //group by order id
       List<String> tobeRemoved=new ArrayList<String>();
       Map < Integer, List < SParcel >> orderidList = parcel.stream().collect(
        Collectors.groupingBy(SParcel::getOrderid));
        for(Map.Entry< Integer, List < SParcel >> i: orderidList.entrySet()){
                tobeRemoved.add(String.valueOf(i.getKey()));
        }
//                
////       for(List<String> i: order){
////           if(!orderID.contains(i.get(0))){
////                order.removeIf( name -> name.equals(i));                
////           }
////       }
//       orderID.removeAll(tobeRemoved);
           System.out.println(tobeRemoved);
//       System.out.println(order);
            String filepath = "Order.txt";
            String tempFile = "Temp.txt";
            File oldFile = new File (filepath);
            File newFile = new File (tempFile);           
            try {
                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                x = new Scanner(new File (filepath));
                //x.useDelimiter("[,\n]");
                while (x.hasNext()){
                    String temp = x.next();
                    List<String> parcels = Arrays.asList(temp.split("\\s*,\\s*"));
                    //System.out.println(parcels.size());
                    if(tobeRemoved.contains(parcels.get(0))){
                       pw.printf(parcels.get(0)+","+parcels.get(1)+"\n");                                                                 
                    }else{
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
   
   public static boolean checkEmailvalidity(String emailaddress){
    boolean check = true;
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$";
    check = emailaddress.matches(emailRegex);
    return check;
    }

}