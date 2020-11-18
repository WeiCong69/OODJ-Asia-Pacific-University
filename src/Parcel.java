abstract class Parcel {
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

    public Parcel(Integer orderid, Integer id, String address, double weight, String deliverytype, String deliverysize,String status) {
        this.orderid = orderid;
        this.id = id;
        this.address = address;
        this.weight = weight;
        this.deliverytype = deliverytype;
        this.deliverysize = deliverysize;
        this.status=status;
    }
    
    public Parcel(Integer id, String address, double weight, String deliverysize, String status, String deliverytype, Integer orderid) {
        this.id = id;
        this.address = address;
        this.weight = weight;
        this.deliverysize = deliverysize;
        this.status = status;
        this.deliverytype = deliverytype;
        this.orderid = orderid;
    }
    
    public abstract String parcelsize(String Size);
    
    public abstract double parcelprice(String Type, String Size, String Weight);

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }
    
    Integer id;
    String address;
    double weight;
    String deliverysize;
    String Price;
    String status;
    String deliverytype;
    Integer orderid;
    String assign;
    String date;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDeliverysize(String deliverysize) {
        this.deliverysize = deliverysize;
    }

    public String getDeliverysize() {
        return deliverysize;
    }
    
    public static void main(String[] args) {
    }
}
