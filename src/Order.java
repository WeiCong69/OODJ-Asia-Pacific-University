
import java.util.ArrayList;

public class Order {

    public Integer getCustid() {
        return custid;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<String> getParcelid() {
        return parcelid;
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

    public void setParcelid(ArrayList<String> parcelid) {
        this.parcelid = parcelid;
    }

    private Integer id;
    private Integer custid;
    private double price;
    private String status;
    ArrayList<String> parcelid = new ArrayList<>();
   
    @Override
    public String toString()
    {
        return null;
    }
    
    public static void main(String[] args) {
        
    }
    
}
