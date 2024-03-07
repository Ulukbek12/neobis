package week2;

public class Delivery {
    private static int LAST_ID = 10000;
    private int delivery_id;//Primary key
    private int order_id;//Foreign key
    private String address;
    private String status;

    public Delivery(String address,String status){
        delivery_id = LAST_ID++;
        this.address = address;
        this.status = status;
    }
    public String getAddress(){
        return address;
    }
    public String getStatus(){
        return status;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + delivery_id +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
