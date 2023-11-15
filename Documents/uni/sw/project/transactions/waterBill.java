
public class waterBill extends Bill{
    @Override
    public void billDetails() {
        System.out.println(getBillType() + "Water Bill details = " + getBillAmount() +"L.E");
    }

    @Override
    public void setBillAmount() {
        billAmount=100;
    }
}
