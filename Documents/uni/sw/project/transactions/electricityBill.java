public class electricityBill extends Bill{
    public void billDetails() {
        System.out.println(getBillType() + " Electricity Bill details = " + getBillAmount() +"L.E");
    }

    @Override
    public void setBillAmount() {
        billAmount=800;
    }
}
