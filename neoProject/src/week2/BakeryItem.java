package week2;

public class BakeryItem{
    private static int LAST_ID = 1;
    private int bakery_id;//Primary key
    private String name;
    private String type;
    private int quantity;
    private double price;

    public BakeryItem(String name, String type, int quantity, double price){
        bakery_id = LAST_ID++;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBakery_id() {
        return bakery_id;
    }

    public void setBakery_id(int bakery_id) {
        this.bakery_id = bakery_id;
    }

    @Override
    public String toString() {
        return "BakeryItem{" +
                "bakery_id=" + bakery_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}