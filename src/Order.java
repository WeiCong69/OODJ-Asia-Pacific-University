import java.util.ArrayList;

public class Order{

    private final ArrayList<SParcel> parcel; 
    private Integer id;
    private Integer custid;
    private double price;
    private String status;
    
    Order (ArrayList<SParcel> parcel) 
    { 
        this.parcel = parcel; 
    }
    
    public Integer getCustid() {
        return custid;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }


   
    @Override
    public String toString()
    {
        return null;
    }
               
    public ArrayList<SParcel> getTotalParcel(){
       return parcel;   
    }
    
    
}
