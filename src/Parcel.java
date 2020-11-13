public class Parcel {
    public String getAddress() {
        return address;
    }

    public double getWeight() {
        return weight;
    }

    public String getDeliverytype() {
        return deliverytype;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDeliverytype(String deliverytype) {
        this.deliverytype = deliverytype;
    }
    
    private Integer id;
    private String address;
    private double weight;
    private String deliverytype;
    
    public static void main(String[] args) {
        
    }
    
}
