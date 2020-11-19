import java.util.ArrayList;
import java.util.List;

public class FrontDeskStaff extends User {
    
    ArrayList<String> order = new ArrayList<>();
    List<SParcel> parcel = new ArrayList<SParcel>();

    public FrontDeskStaff(User a) {
        super(a.loginid,a.password,a.name,a.address,a.phone);
    }
    
    public void viewDeliveredParcel(){
        int counter=0;        
        List<SParcel> assignedParcels=new ArrayList<SParcel>() ;
        String status=null;
        do{
         if(counter==0){
            List<List<String>> parcels=StaticFunction.getFileData("Parcel.txt"); 
            for (int i = 0; i <parcels.size(); i++) {
                if(parcels.get(i).get(8).equals(this.loginid) && parcels.get(i).get(5).equals("Delivered")){
                    SParcel a = new SParcel(parcels.get(i));
                    assignedParcels.add(a);
                }
            }
            if(assignedParcels.size()!=0){
                for (int i = 0; i < assignedParcels.size(); i++) {
                    System.out.println(i+"."+assignedParcels.get(i).getId()+"<-"+assignedParcels.get(i).getAddress()+"\tStatus:"+assignedParcels.get(i).getStatus());
                }                 
            }else{
                System.out.println("No parcels record found");
            }           
            System.out.println(assignedParcels.size()+". Exit");
            counter++;
         }
        if(counter==1){
               int choice=Integer.parseInt(StaticFunction.getUserInput("Please select a parcel"));
               if(choice<assignedParcels.size()){
                  System.out.printf("Address:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getAddress(), 50) + "\n\n");
                  System.out.printf("Weight:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getWeight()+"kg", 50)+"\n\n");
                  System.out.printf("Parcel Size:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getDeliverysize(), 50) + "\n\n");
                  System.out.printf("Price:\n");
                  System.out.printf("RM " + StaticFunction.addLinebreaks(assignedParcels.get(choice).getPrice(), 50) + "\n\n");
                  System.out.printf("Parcel Status:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getStatus(), 50) + "\n\n");
                  System.out.printf("Delivery Type:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getDeliverytype(), 50) + "\n\n"); 
                int action = Integer.parseInt(StaticFunction.getUserInput("\nUpdate this parcel status to:?"
                           + "\n0.On Delivery"
                           + "\n1.Delivered"
                           + "\n2.Pending"
                           + "\n3.Exit"));       
                if(action>=0 && action <4){
                      if(action==0)status="On Delivery";
                      else if(action==1){status="Delivered";}
                      else if(action==2){status="Pending";}
                      else if(action==3){assignedParcels.clear(); counter++;continue;}
                      else {status="Pending";}
                      assignedParcels.get(choice).setStatus(status);
                      String[] itemsArray = new String[10];
                      itemsArray = assignedParcels.get(choice).toArray();
                      StaticFunction.updateFileLine(itemsArray,"Parcel.txt");
                      String action2 =StaticFunction.getUserInput("\nDo you wish to continue editting parcel status?"
                           + "\n0.Yes"
                           + "\n1.No");
                        if(action2.equals("0") || action2.equals("Yes")|| action2.equals("Y")|| action2.equals("yes")){
                            assignedParcels.clear();
                            counter--;
                            continue;
                         }else{
                            counter++;
                            continue;
                        }                         
                }else{
                    System.out.println("Some error has occured.Please choose again");
                    counter--;
                    continue;
                }               
          }else if(choice==assignedParcels.size()){
                 assignedParcels.clear();
                 return;
          }else{
                 System.out.println("Some error has occured.Please choose again");
                 assignedParcels.clear();
                 continue;
          }             
    }                 
        }while(counter<2);         
    }
    public void viewPendingParcel(){
        int counter=0;        
        List<SParcel> assignedParcels=new ArrayList<SParcel>() ;
        String status=null;
        do{
         if(counter==0){
            List<List<String>> parcels=StaticFunction.getFileData("Parcel.txt"); 
            for (int i = 0; i <parcels.size(); i++) {
                if(parcels.get(i).get(8).equals(this.loginid) && !parcels.get(i).get(5).equals("Delivered")){
                    SParcel a = new SParcel(parcels.get(i));
                    assignedParcels.add(a);
                }
            }
            if(assignedParcels.size()!=0){
                for (int i = 0; i < assignedParcels.size(); i++) {
                    System.out.println(i+"."+assignedParcels.get(i).getId()+"<-"+assignedParcels.get(i).getAddress()+"\tStatus:"+assignedParcels.get(i).getStatus());
                }                 
            }else{
                System.out.println("No parcels record found");
            }           
            System.out.println(assignedParcels.size()+". Exit");
            counter++;
         }
        if(counter==1){
               int choice=Integer.parseInt(StaticFunction.getUserInput("Please select a parcel"));
               if(choice<assignedParcels.size()){
                  System.out.printf("Address:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getAddress(), 50) + "\n\n");
                  System.out.printf("Weight:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getWeight()+"kg", 50)+"\n\n");
                  System.out.printf("Parcel Size:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getDeliverysize(), 50) + "\n\n");
                  System.out.printf("Price:\n");
                  System.out.printf("RM " + StaticFunction.addLinebreaks(assignedParcels.get(choice).getPrice(), 50) + "\n\n");
                  System.out.printf("Parcel Status:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getStatus(), 50) + "\n\n");
                  System.out.printf("Delivery Type:\n");
                  System.out.printf(StaticFunction.addLinebreaks(assignedParcels.get(choice).getDeliverytype(), 50) + "\n\n"); 
                int action = Integer.parseInt(StaticFunction.getUserInput("\nUpdate this parcel status to:?"
                           + "\n0.On Delivery"
                           + "\n1.Delivered"
                           + "\n2.Pending"
                           + "\n3.Exit"));       
                if(action>=0 && action <4){
                      if(action==0)status="On Delivery";
                      else if(action==1){status="Delivered";}
                      else if(action==2){status="Pending";}
                      else if(action==3){assignedParcels.clear(); counter++;continue;}
                      else {status="Pending";}
                      assignedParcels.get(choice).setStatus(status);
                      String[] itemsArray = new String[10];
                      itemsArray = assignedParcels.get(choice).toArray();
                      StaticFunction.updateFileLine(itemsArray,"Parcel.txt");
                      String action2 =StaticFunction.getUserInput("\nDo you wish to continue editting parcel status?"
                           + "\n0.Yes"
                           + "\n1.No");
                        if(action2.equals("0") || action2.equals("Yes")|| action2.equals("Y")|| action2.equals("yes")){
                            assignedParcels.clear();
                            counter--;
                            continue;
                         }else{
                            counter++;
                            continue;
                        }                         
                }else{
                    System.out.println("Some error has occured.Please choose again");
                    counter--;
                    continue;
                }               
          }else if(choice==assignedParcels.size()){
                 assignedParcels.clear();
                 return;
          }else{
                 System.out.println("Some error has occured.Please choose again");
                 assignedParcels.clear();
                 continue;
          }             
    }       
            
          
        }while(counter<2);         
    }
    public void editParcel(){ 
     try {
       int choice=Integer.parseInt(StaticFunction.getUserInput("Please Select a category."
                + "\n0.Pending Parcles"
                + "\n1.Delivered Parcels"
                + "\n2.Exit"));
       if(choice>-1 && choice<3){
           if(choice==0)viewPendingParcel();
           if(choice==1)viewDeliveredParcel();
           if(choice==2)return;
       }else{
           editParcel();
       }
     } catch (NumberFormatException e) {
         System.out.println("Invalid selection. Numbers only please.");
     }        
        
    }
}
