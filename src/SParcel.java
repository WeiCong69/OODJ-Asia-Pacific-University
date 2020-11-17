
import java.util.ArrayList;

public class SParcel extends Parcel{

    public SParcel(Integer id, String address, double weight, String deliverysize, String status, String deliverytype, Integer orderid) {
        super(id, address, weight, deliverysize, status, deliverytype, orderid);
    }
    
    public SParcel(Integer orderid, Integer id, String address, double weight, String deliverytype, String deliverysize, String status) {
        super(orderid, id, address, weight, deliverytype, deliverysize, status);
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
    
    public String parcelprice(String Type, String Size, String Weight){
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
        return String.valueOf(Total);
    }

    public void setPricerates(double pricerates) {
        this.pricerates = pricerates;
    }

    public double getPricerates() {
        return pricerates;
    }
    
    private double pricerates;
    
    @Override
    public String toString()
    {
        return null;
    }
    

    
}
