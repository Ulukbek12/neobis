package week2;

public class Customer {
    private static int LAST_ID = 10;
    private int customer_id; //Primary key
    private int bakery_id;//foreign key
    private String name;
    private String phoneNumber;

    public Customer(String name, String phoneNumber){
        customer_id = LAST_ID++;
        this.name = name;
        this.phoneNumber = String.format("%s-%s-%s-%s-%s",phoneNumber.substring(0,4),
                phoneNumber.substring(4,7),phoneNumber.substring(7,9),phoneNumber.substring(9,11),
                phoneNumber.substring(11,13));
    }

    public int getId() {
        return customer_id;
    }

    public void setId(int id) {
        this.customer_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customer_id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
