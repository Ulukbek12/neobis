package week2;

public class Payment {
    private static int LAST_ID = 1000;
    private int payment_id;//Primary key
    private int order_id;//Foreign key
    private double amountOfPayment;
    private String methodPayment;

    public Payment(double amountOfPayment, String methodPayment){
        payment_id = LAST_ID++;
        this.amountOfPayment = amountOfPayment;
        this.methodPayment = methodPayment;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public double getAmountOfPayment(){
        return amountOfPayment;
    }
    public String getMethodPayment(){
        return methodPayment;
    }
    public void setAmountOfPayment(double amountOfPayment){
        this.amountOfPayment = amountOfPayment;
    }
    public void setMethodPayment(String methodPayment){
        this.methodPayment = methodPayment;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + payment_id +
                ", amountOfPayment=" + amountOfPayment +
                ", methodPayment='" + methodPayment + '\'' +
                '}';
    }
}
