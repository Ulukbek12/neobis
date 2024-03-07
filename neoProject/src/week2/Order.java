package week2;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int LAST_ID = 100;
    private int order_id;//primary key
    private int customer_id; //Foreign key
    private List<BakeryItem> list;
    private double fullAmountOfOrder;
    private String status;

    public Order(){
        fullAmountOfOrder = 0.0;
        list = new ArrayList<>();
        order_id = LAST_ID++;
        status = "In progress";
    }
    public void addItem(BakeryItem item){
        list.add(item);
        fullAmountOfOrder += item.getPrice();
    }
    public void removeItem(BakeryItem item){
        list.remove(item);
        fullAmountOfOrder -= item.getPrice();
    }

    public int getId() {
        return order_id;
    }

    public void setId(int id) {
        this.order_id = id;
    }

    public List<BakeryItem> getList() {
        return list;
    }

    public void setList(List<BakeryItem> list) {
        this.list = list;
    }

    public double getFullAmountOfOrder() {
        return fullAmountOfOrder;
    }

    public void setFullAmountOfOrder(double fullAmountOfOrder) {
        this.fullAmountOfOrder = fullAmountOfOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + order_id +
                ", list=" + list +
                ", fullAmountOfOrder=" + fullAmountOfOrder +
                ", status='" + status + '\'' +
                '}';
    }
}