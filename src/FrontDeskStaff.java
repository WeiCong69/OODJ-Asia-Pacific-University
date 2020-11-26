import java.util.ArrayList;
import java.util.List;

public class FrontDeskStaff extends User {
    

    public FrontDeskStaff(User a) {
        super(a.loginid,a.password,a.name,a.address,a.phone);
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
                    FrontDeskStaffMenu msm = new FrontDeskStaffMenu();
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
                        FrontDeskStaffMenu msm = new FrontDeskStaffMenu();
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
                   String action = StaticFunction.getUserInput("\nWhat do you wish to do?\n0.View other order\n1.Edit Parcel\n2.Delete Parcel");
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
    


}
