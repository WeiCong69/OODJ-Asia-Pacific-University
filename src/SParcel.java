
import java.util.ArrayList;

public class SParcel extends Parcel{

    public SParcel(Integer id, String address, double weight, String deliverytype, String deliverysize) {
        super(id, address, weight, deliverytype, deliverysize);
    }
    
    public String parcelsize(String Size){
        String size = null;
        if (Size.equals("Small")){
            size = "Small Size";
        }else if (Size.equals("Large")){
            size = "Large Size";
        }
        return size;
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
    
    public static void main(String[] args) {
        
    }
    
}
