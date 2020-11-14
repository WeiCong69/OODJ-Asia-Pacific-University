import java.util.ArrayList;

public class FrontDeskStaff extends User {
    
    ArrayList<String> order = new ArrayList<>();
    ArrayList<String> parcel = new ArrayList<>();

    public FrontDeskStaff(User a) {
        super(a.loginid,a.password,a.name,a.address,a.phone);
    }
        
}
