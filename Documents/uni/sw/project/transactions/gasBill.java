public class gasBill extends Bill{
    @Override
    public void setBillAmount() {
        billAmount=300;
    }

    @Override
    public void billDetails() {
        System.out.println(getBillType() + "Gas Bill details = " + getBillAmount() +"L.E");
    }

}
