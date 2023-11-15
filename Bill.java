package Transaction;

public abstract class Bill {
    String billType;
    double billAmount;

    public abstract void billDetails();

    public abstract void setBillAmount();

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillType() {
        return billType;
    }

    public double getBillAmount() {
        return billAmount;
}

}
