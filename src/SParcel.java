
import java.text.DecimalFormat;
import java.util.List;

public class SParcel extends Parcel{

    public SParcel(Integer id, String address, double weight, String deliverysize, String status, String deliverytype, Integer orderid) {
        super(id, address, weight, deliverysize, status, deliverytype, orderid);
        //follow text file
    }
    
    public SParcel(Integer orderid, Integer id, String address, double weight, String deliverytype, String deliverysize, String status) {
        super(orderid, id, address, weight, deliverytype, deliverysize, status);
    }
    
    //initialise Sparcel using list( according to text file)
    public SParcel(List<String> a) {        
        super(Integer.parseInt(a.get(0)),a.get(1),Double.parseDouble(a.get(2)),a.get(3),a.get(4),a.get(5),a.get(6),Integer.parseInt(a.get(7)),a.get(8),a.get(9));
    }
    
    public String parcelsize(String Size){
        String size1 = "";
        if (Size.equals("Small")){
            size1 = "Small Size";
        }else if (Size.equals("Large")){
            size1 = "Large Size";
        }
        return size1;
    }
    
    public double parcelprice(String Type, String Size, String Weight){
//        return null;
        double Total = 0;
        if (Type.equals("1") && Size.equals("Small")){
            Total = 2 * weight;
        }else if (Type.equals("1") && Size.equals("Large")){
            Total = 3 * weight;
        }else if (Type.equals("2") && Size.equals("Small")){
            Total = 1 * weight;
        }else if (Type.equals("2") && Size.equals("Large")){
            Total = 2 * weight;
        }
        return Total;
    }

    
    public void editParcel(String size,String price,String deliveryGuy,String date){
        int counter=0;
        DecimalFormat df = new DecimalFormat("#.00");
        do{
           System.out.printf("Address:\n");
           System.out.printf(StaticFunction.addLinebreaks(this.address, 50) + "\n\n");
           System.out.printf("Weight:\n");
           System.out.printf(StaticFunction.addLinebreaks(this.weight+"kg", 50)+"\n\n");
           System.out.printf("Parcel Size:\n");
           System.out.printf(StaticFunction.addLinebreaks(size, 50) + "\n\n");
           System.out.printf("Price:\n");
           System.out.printf("RM " + StaticFunction.addLinebreaks(price, 50) + "\n\n");
           System.out.printf("Parcel Status:\n");
           System.out.printf(StaticFunction.addLinebreaks(this.status, 50) + "\n\n");
           System.out.printf("Delivery Type:\n");
           System.out.printf(StaticFunction.addLinebreaks(this.deliverytype, 50) + "\n\n");
           System.out.printf("Assign to Delivery Staff:\n");
           System.out.printf(StaticFunction.addLinebreaks(deliveryGuy, 50) + "\n\n");
           int action = Integer.parseInt(StaticFunction.getUserInput("\nWhich components do you wish to edit?"
                   + "\n0.Edit Address"
                   + "\n1.Edit Weight"
                   + "\n2.Edit Parcel Size"
                   + "\n3.Edit Delivery Type"
                   + "\n4.Exit editting parcel"));
           switch(action){
               case 0:
                   String newAddress = StaticFunction.getUserInput("Please enter new address");
                   setAddress(newAddress);
                   String[] data={String.valueOf(this.id),this.address,String.valueOf(this.weight),size,price,this.status,this.deliverytype,String.valueOf(this.orderid),deliveryGuy,date};
                   StaticFunction.updateFileLine(data,"Parcel.txt");
                   break;
               case 1:
                    String newWeight = StaticFunction.getUserInput("Please enter new weight");
                    setWeight(Double.parseDouble(newWeight));
                    Double newPrice= parcelprice(convertDeliveryType(this.deliverytype),convertParcelSize(size),newWeight);
                    price=String.valueOf(df.format(newPrice));
                    String[] data1={String.valueOf(this.id),this.address,String.valueOf(this.weight),size,df.format(newPrice),this.status,this.deliverytype,String.valueOf(this.orderid),deliveryGuy,date};
                    StaticFunction.updateFileLine(data1,"Parcel.txt");                 
                    break;
               case 2:
                   String tempSize =null;   
                    int newSize = Integer.parseInt(StaticFunction.getUserInput("Please selct new size.\n0.Small\n1.Big"));
                    if(newSize>=0 && newSize<2){
                        if(newSize==0)tempSize="Small";
                        if(newSize==1)tempSize="Large";
                        newPrice= parcelprice(convertDeliveryType(this.deliverytype),convertParcelSize(tempSize),String.valueOf(this.weight));
                        price=String.valueOf(df.format(newPrice));
                        size=parcelsize(tempSize);
                        System.out.println(tempSize);
                        String[] data2={String.valueOf(this.id),this.address,String.valueOf(this.weight),size,price,this.status,this.deliverytype,String.valueOf(this.orderid),deliveryGuy,date};
                        StaticFunction.updateFileLine(data2,"Parcel.txt");                
                    }
                    break;
               case 3:
                    String tempType =null; 
                    int newType = Integer.parseInt(StaticFunction.getUserInput("Please selct new delivery type.\n1.International\n2.Dosmetic"));
                    if(newType>0 && newType<3){
                        if(newType==1)tempType="International";
                        if(newType==2)tempType="Domestic";                     
                        newPrice= parcelprice(String.valueOf(newType),convertParcelSize(size),String.valueOf(this.weight));
                        //System.out.println(newPrice);
                        price=String.valueOf(df.format(newPrice));
                        setDeliverytype(tempType);
                        String[] data3={String.valueOf(this.id),this.address,String.valueOf(this.weight),size,price,this.status,tempType,String.valueOf(this.orderid),deliveryGuy,date};
                        StaticFunction.updateFileLine(data3,"Parcel.txt");                     
                    }
                    break;
               case 4:
                   return;
               default:
                   System.out.println("Some error has occured. Please choose again");
                   continue;

           }
           String choice=StaticFunction.getUserInput("Changes made successfully. Do you wanna update another component?\n0.Yes\n1.No");
           if(choice.equals("0") || choice.equals("Yes")|| choice.equals("Y")|| choice.equals("yes")){
                continue;
           } else {
               return;
           }           
        }while(counter<1);
    }
    
    
    
    public String convertDeliveryType(String type){
        if(type.equals("International")){
            return "1";
        }else{
            return "2";
        }
    }
    public String convertParcelSize(String type){
        if(type.equals("Small Size")){
            return "Small";
        }else{
            return "Large";
        }
    }
    public String[] toArray(){
      String[] itemsArray ={
                            String.valueOf(this.id),this.address,String.valueOf(this.weight),this.Price,
                            this.deliverysize,this.status,
                            this.deliverytype,String.valueOf(this.orderid),
                            this.assign,this.date
                            };
      return itemsArray;
    }
}
