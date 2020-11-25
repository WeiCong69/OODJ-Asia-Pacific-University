import java.util.ArrayList;
import java.util.List;

public class FrontDeskStaff extends User {
    
    ArrayList<String> order = new ArrayList<>();
    List<SParcel> parcel = new ArrayList<SParcel>();

    public FrontDeskStaff(User a) {
        super(a.loginid,a.password,a.name,a.address,a.phone);
    }
    

}
