public class User {
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getLoginid() {
        return loginid;
    }

    public User(String loginid, String password, String name, String address, String phone) {
        this.loginid = loginid;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

//    public User() {
////        this.loginid = loginid;
////        this.password = password;
////        this.name = name;
////        this.address = address;
////        this.phone = phone;
//    }
    
    public static String loginid;
    public static String password;
    public static String name;
    public static String address;
    public static String phone;


    
    
    @Override
    public String toString()
    {
        return null;
    }

    
}
