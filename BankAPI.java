package BankAPI;

import java.util.Vector;

public class BankAPI {
    private Vector<bankAccount> bankAccounts=new Vector<bankAccount>();
    public boolean checkAccValid(Long bankAccount1){
        for (int i=0;i<bankAccounts.size();i++){
            if(bankAccount1==bankAccounts.get(i).getBankAccNumber()){
                return true;
            }
        }
        return false;
    }
    public boolean checkBalance(bankAccount bankAccount1,double Balance){
        for (int i=0;i<bankAccounts.size();i++){
            if(bankAccount1==bankAccounts.get(i)){
                if(bankAccounts.get(i).getBalance()>=Balance){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean updateBalance(bankAccount BankAccount,double Balance,char Char){
        for (int i=0;i<bankAccounts.size();i++){
            if(BankAccount.getBankAccNumber()==bankAccounts.get(i).getBankAccNumber()){

                if(Char=='-'){
                    if(checkBalance(bankAccounts.get(i),Balance)){
                        bankAccounts.get(i).setBalance(Balance,Char);
                        notify(Char);
                        return true;
                    }
                    else{
                        System.out.println("Insufficient Balance");
                        return false;
                    }

                }
                else{
                    bankAccounts.get(i).setBalance(Balance,Char);

                    notify(Char);
                    return true;
                }
            }
        }
        System.out.println("Unsuccessful Transaction");
        return false;
    }

    public void notify(char Char){
        if(Char=='-'){
            System.out.println("Bank has successfully withdrawn balance from your account");
        }
        else{
            System.out.println("Bank has successfully deposited balance into your account");
        }
    }

    public void setBankAccounts( Vector<bankAccount> BankAccount) {
        bankAccounts=BankAccount;
    }

    public Vector<bankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
