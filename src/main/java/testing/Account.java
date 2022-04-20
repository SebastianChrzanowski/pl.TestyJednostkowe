package testing;

public class Account {
    public Account(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
        if(defaultDeliveryAddress != null){
            activate();
        }else {
            this.active=false;
        }
    }

    private String email;

    private boolean active;
    private Address defaultDeliveryAddress;


    public Account() {
        this.active = false;
    }

    public void activate(){
        this.active=true;
    }

    public  boolean isActive(){
        return this.active;
    }

    public Address getDefaultDeliveryAddress() {
        return defaultDeliveryAddress;
    }

    public void setDefaultDeliveryAddress(Address defaultDeliveryAddress) {
        this.defaultDeliveryAddress = defaultDeliveryAddress;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
