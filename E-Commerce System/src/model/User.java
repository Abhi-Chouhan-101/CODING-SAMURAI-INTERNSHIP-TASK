package model;

public class User {

    private String name;

    private String email;

    private String password;

    private String address;

    public User(String name,String email,String password,String address){
        this.name = name;
        this.email = email;
        this.password   = password;
        this.address  = address;
    }

    public  User (){

    }

    public void setName(String name){
        this.name = name;
    }

    public  void setEmail(String email)
    {
        this.email = email;
    }

    public  void setPassword(String password)
    {
        this.password = password;
    }
    public  void setAddress(String address)
    {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "[User: " + name + ", Email: " + email + ", Address: " + address + "]";
    }

}
