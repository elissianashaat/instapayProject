import BankAPI.*;
import SignUp.*;
import WalletAPI.*;
import Transaction.*;
import java.util.Scanner;
import java.util.Vector;
import static java.lang.System.exit;
import static java.lang.System.in;
public class Main {
    public static void main(String[] args) {
        BankAPI bankAPI=new BankAPI();
        WalletAPI walletAPI=new WalletAPI();
        Vector<User> users=new Vector<>();
        Vector<bankAccount> bankAccounts=new Vector<bankAccount>();
        Vector<walletAccount> walletAccounts=new Vector<walletAccount>();
        bankAccount BankAccount1=new bankAccount("CIB",5000,11111,"01003742936","Mohamed Ashraf");
        bankAccount BankAccount2=new bankAccount("Ahli Bank",7000,11112,"01003742937","Elissia Nashaat");
        bankAccount BankAccount3=new bankAccount("Misr Bank",8000,11113,"01003742938","Nada Yasser");
        bankAccount BankAccount4=new bankAccount("CIB",10000,11114,"01003742939","Youssef");
        walletAccount WalletAccount1=new walletAccount("Vodafone",3000,"01002756978","Ahmed");
        walletAccount WalletAccount2=new walletAccount("Etisalat",4000,"01002756979","Fatma");
        walletAccount WalletAccount3=new walletAccount("Orange",6000,"01002756987","Omar");
        walletAccount WalletAccount4=new walletAccount("Vodafone",11000,"01002756989","Mariam");
        bankAccounts.add(BankAccount1);
        bankAccounts.add(BankAccount2);
        bankAccounts.add(BankAccount3);
        bankAccounts.add(BankAccount4);
        walletAccounts.add(WalletAccount1);
        walletAccounts.add(WalletAccount2);
        walletAccounts.add(WalletAccount3);
        walletAccounts.add(WalletAccount4);
        bankAPI.setBankAccounts(bankAccounts);
        walletAPI.setWalletAccounts(walletAccounts);
        System.out.println("Welcome to Insta Pay");
        System.out.println("Don't have an account? Sign Up now!");
        System.out.println("What type of account would you like to sign up with?");
        System.out.println("Please enter 'bank account' to register with a bank account profile or 'wallet account' to register with a wallet profile");
        String type,Username,MobileNumber,Password,walletMobileNumber;
        long BankAccNumber;
        User user1 = null;
        User currentUser=null;
        OTP otp=new OTP();
        String OtP,checker;
        ProfileCreation profileCreation=new ProfileCreation();
        Scanner input=new Scanner(System.in);
        Scanner str=new Scanner(System.in);
        type= input.nextLine();
        if(!(type.equals("bank account")||type.equals("wallet account"))){
            while (!(type.equals("bank account")||type.equals("wallet account"))){
                System.out.println("Please enter a valid account type");
                type= input.nextLine();
            }
        }
        else if(type.equals("bank account")){
            user1=profileCreation.createAccount(type);
            user1.setType(type);
            System.out.println("Please enter your new username");
            Username=input.nextLine();
            user1.setUsername(Username);
            System.out.println("Please enter your new password");
            System.out.println("Note that: Password must be at least 8 characters,Password must contain at least one digit,Password must contain at least one uppercase letter,Password must contain at least one lowercase letter");
            Password=input.nextLine();
            user1.setPassword(Password);
            if(user1.PasswordValidation()){
                System.out.println("Password is verified");
            }
            else {
                System.out.println("Password is invalid Please enter a new password");
                while(!user1.PasswordValidation()){
                    Password= input.nextLine();
                    user1.setPassword(Password);
                }
            }
            System.out.println("Please enter your bank account number");
            BankAccNumber=input.nextLong();
            if(!bankAPI.checkAccValid(BankAccNumber)){
                System.out.println("Invalid bank account");
                while (!bankAPI.checkAccValid(BankAccNumber)){
                    System.out.println("Please enter another bank account number");
                    BankAccNumber= input.nextLong();
                }
            }
            else{
                System.out.println("Valid bank account number");
            }
            for (int i = 0; i < bankAccounts.size(); i++) {
                if(BankAccNumber==bankAccounts.get(i).getBankAccNumber()){
                    ((BankAccProfile) user1).setAccount(bankAccounts.get(i));
                    user1.setBalance(bankAccounts.get(i).getBalance(),'+');
                }
            }

            System.out.println("Please enter your Mobile Number");
            MobileNumber= str.nextLine();
            System.out.println("Please enter the OTP sent to your mobile number");
            OtP= otp.generateOTP();
            checker=input.nextLine();
            if(checker.equals(OtP)){
                user1.setMobileNumber(MobileNumber);
            }
            else{
                while (!checker.equals(OtP)){
                    System.out.println("Another otp was sent to you please enter it correctly");
                    OtP= otp.generateOTP();
                    checker=input.nextLine();
                }
                user1.setMobileNumber(MobileNumber);
            }
            currentUser=user1;
            users.add(user1);
        }
        else if (type.equals("wallet account")) {
            user1=profileCreation.createAccount(type);
            user1.setType(type);
            System.out.println("Please enter your Mobile Number");
            String WMobileNumber= str.nextLine();
            System.out.println("Please enter the OTP sent to your mobile number");
            OtP= otp.generateOTP();
            checker=str.nextLine();
            if(checker.equals(OtP)){
                user1.setMobileNumber(WMobileNumber);
            }
            else{
                while (!checker.equals(OtP)){
                    System.out.println("Another otp was sent to you please enter it correctly");
                    OtP= otp.generateOTP();
                    checker=str.nextLine();
                }
                user1.setMobileNumber(WMobileNumber);
            }
            System.out.println("Please enter your new username");
            Username=input.nextLine();
            user1.setUsername(Username);
            System.out.println("Please enter your new password");
            System.out.println("Note that: Password must be at least 8 characters,Password must contain at least one digit,Password must contain at least one uppercase letter,Password must contain at least one lowercase letter");
            Password=input.nextLine();
            user1.setPassword(Password);
            if(user1.PasswordValidation()){
                System.out.println("Password is verified");

            }
            else {
                System.out.println("Password is invalid Please enter a new password");
                while(!user1.PasswordValidation()){
                    Password= input.nextLine();
                    user1.setPassword(Password);
                }
            }
            System.out.println("Please enter your wallet account mobile number");
            walletMobileNumber= input.nextLine();
            if(!walletAPI.checkAccValid(walletMobileNumber)){
                System.out.println("Invalid mobile number");
                    while(!walletAPI.checkAccValid(walletMobileNumber)) {
                        System.out.println("Please enter a valid mobile number");
                        walletMobileNumber = input.nextLine();
                    }
            }
            else {
                System.out.println("Valid Mobile Number");
            }
            for (int i = 0; i < walletAccounts.size(); i++) {
                if(walletMobileNumber.equals(walletAccounts.get(i).getMobileNumber())){
                    ((WalletAccProfile)user1).setWalletAccount(walletAccounts.get(i));
                    user1.setBalance(walletAccounts.get(i).getBalance(),'+');
                }
            }
            currentUser=user1;
            users.add(user1);
        }
        while(true){
            Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter the number of operation you would like to proceed with:");
        System.out.println("0: Exit");
        System.out.println("1: Sign Up as a new user");
        System.out.println("2: Sign in to your account");
        System.out.println("3:Transfer Money to another instapay account");
        System.out.println("4: Transfer Money to another wallet account");
        System.out.println("5: Transfer Money to another bank account");
        System.out.println("6: Print your account details");
        System.out.println("7: Pay your bills");
        int choice;
        transactionsStrategy strategy=null;
        Bill bill=null;
        transaction Transaction=new transaction();
        choice=input.nextInt();
        switch(choice){
            case 1: {
                User newUser=null;
                System.out.println("What type of account would you like to sign up with?");
                System.out.println("Please enter 'bank account' to register with a bank account profile or 'wallet account' to register with a wallet profile");
                type= str.nextLine();
                if(!(type.equals("bank account")||type.equals("wallet account"))){
                    while (!(type.equals("bank account")||type.equals("wallet account"))){
                        System.out.println("Please enter a valid account type");
                        type= str.nextLine();
                    }
                }
                else if(type.equals("bank account")){
                    newUser=profileCreation.createAccount(type);
                    newUser.setType(type);
                    System.out.println("Please enter your new username");
                    Username=scanner.nextLine();
                    newUser.setUsername(Username);
                    System.out.println("Please enter your new password");
                    System.out.println("Note that: Password must be at least 8 characters,Password must contain at least one digit,Password must contain at least one uppercase letter,Password must contain at least one lowercase letter");
                    Password=scanner.nextLine();
                    newUser.setPassword(Password);
                    if(user1.PasswordValidation()){
                        System.out.println("Password is verified");
                    }
                    else {
                        System.out.println("Password is invalid Please enter a new password");
                        while(!user1.PasswordValidation()){
                            Password= scanner.nextLine();
                        }
                        newUser.setPassword(Password);
                    }
                    System.out.println("Please enter your bank account number");
                    BankAccNumber=scanner.nextLong();
                    if(!bankAPI.checkAccValid(BankAccNumber)){
                        System.out.println("Invalid bank account");
                        while (!bankAPI.checkAccValid(BankAccNumber)){
                            System.out.println("Please enter another bank account number");
                            BankAccNumber= scanner.nextLong();
                        }
                    }
                    else{
                        System.out.println("Valid bank account number");
                    }
                    for (int i = 0; i < bankAccounts.size(); i++) {
                        if(BankAccNumber==bankAccounts.get(i).getBankAccNumber()){
                            ((BankAccProfile) newUser).setAccount(bankAccounts.get(i));
                            newUser.setBalance(bankAccounts.get(i).getBalance(),'+');
                        }
                    }

                    System.out.println("Please enter your Mobile Number");
                    MobileNumber= scanner.nextLine();
                    System.out.println("Please enter the OTP sent to your mobile number");
                    OtP= otp.generateOTP();
                    checker=scanner.nextLine();
                    if(checker.equals(OtP)){
                        newUser.setMobileNumber(MobileNumber);
                    }
                    else{
                        while (!checker.equals(OtP)){
                            System.out.println("Another otp was sent to you please enter it correctly");
                            OtP= otp.generateOTP();
                            checker=scanner.nextLine();
                        }
                        newUser.setMobileNumber(MobileNumber);
                    }
                    currentUser=newUser;
                    users.add(newUser);
                }
                else if (type.equals("wallet account")) {
                    newUser=profileCreation.createAccount(type);
                    newUser.setType(type);
                    System.out.println("Please enter your Mobile Number");
                    String WMobileNumber= scanner.nextLine();
                    System.out.println("Please enter the OTP sent to your mobile number");
                    OtP= otp.generateOTP();
                    checker=scanner.nextLine();
                    if(checker.equals(OtP)){
                        newUser.setMobileNumber(WMobileNumber);
                    }
                    else{
                        while (!checker.equals(OtP)){
                            System.out.println("Another otp was sent to you please enter it correctly");
                            OtP= otp.generateOTP();
                            checker=scanner.nextLine();
                        }
                        newUser.setMobileNumber(WMobileNumber);
                    }
                    System.out.println("Please enter your new username");
                    Username=scanner.nextLine();
                    newUser.setUsername(Username);
                    System.out.println("Please enter your new password");
                    System.out.println("Note that: Password must be at least 8 characters,Password must contain at least one digit,Password must contain at least one uppercase letter,Password must contain at least one lowercase letter");
                    Password=scanner.nextLine();
                    newUser.setPassword(Password);
                    if(user1.PasswordValidation()){
                        System.out.println("Password is verified");

                    }
                    else {
                        System.out.println("Password is invalid Please enter a new password");
                        while(!user1.PasswordValidation()){
                            Password= scanner.nextLine();
                            newUser.setPassword(Password);
                        }
                    }
                    System.out.println("Please enter your wallet account mobile number");
                    walletMobileNumber= scanner.nextLine();
                    if(!walletAPI.checkAccValid(walletMobileNumber)){
                        System.out.println("Invalid mobile number");
                        while(!walletAPI.checkAccValid(walletMobileNumber)) {
                            System.out.println("Please enter a valid mobile number");
                            walletMobileNumber = scanner.nextLine();
                        }
                        System.out.println("Valid Mobile Number");
                    }
                    else {
                        System.out.println("Valid Mobile Number");
                    }
                    for (int i = 0; i < walletAccounts.size(); i++) {
                        if(walletMobileNumber.equals(walletAccounts.get(i).getMobileNumber())){
                            ((WalletAccProfile)newUser).setWalletAccount(walletAccounts.get(i));
                            newUser.setBalance(walletAccounts.get(i).getBalance(),'+');
                        }
                    }
                    currentUser=newUser;
                    users.add(newUser);
                }
                break;
            }
            case 2:{
                System.out.println("Please enter your Username");
                Username=scanner.nextLine();
                System.out.println("Please enter your Password");
                Password=scanner.nextLine();
                for (int i = 0; i < users.size(); i++) {
                    if(Username.equals(users.get(i).getUsername())&&Password.equals(users.get(i).getPassword())){
                        currentUser=users.get(i);
                        System.out.println("Welcome "+Username);
                        break;
                    }
                }
                if(currentUser==null){
                    System.out.println("Invalid Username or Password");
                }
                break;
            }
            case 3:{
                boolean check=false;
                strategy=new InstaPayTransfer();
                String Receiver;
                double amount;
                System.out.println("Please enter the mobile number of the receiver");
                Receiver=scanner.nextLine();
                System.out.println("Please enter the amount you would like to transfer");
                amount=scanner.nextDouble();
                strategy.setReciever(Receiver);
                strategy.setSender(currentUser);
                strategy.setPaymentAmount(amount);
                Transaction.setTransactions(strategy);
                System.out.println(users.get(1).getMobileNumber());
                System.out.println(Receiver);
                users=Transaction.transfer(users);

                break;
            }
            case 4:{
                boolean check=false;
                strategy=new WalletTransfer();
                String Receiver;
                double amount;
                System.out.println("Please enter the mobile number associated with the wallet account of the receiver");
                Receiver=scanner.nextLine();
                System.out.println("Please enter the amount you would like to transfer");
                amount=scanner.nextDouble();
                strategy.setSender(currentUser);
                strategy.setReciever(Receiver);
                strategy.setPaymentAmount(amount);
                Transaction.setTransactions(strategy);
                ((WalletTransfer)strategy).setWalletapi(walletAPI);
                users=Transaction.transfer(users);
                walletAPI=((WalletTransfer) strategy).getWalletapi();

                break;
            }
            case 5:{
                if(currentUser.getType().equals("wallet account")){
                    System.out.println("You can't transfer to a bank account using a wallet account profile");
                    break;
                }
                boolean check=false;
                strategy=new BankTransfer();
                String Receiver;
                double amount;
                System.out.println("Please enter the mobile number associated with the wallet account of the receiver");
                Receiver=scanner.nextLine();
                System.out.println("Please enter the amount you would like to transfer");
                amount=scanner.nextDouble();
                strategy.setSender(currentUser);
                strategy.setReciever(Receiver);
                strategy.setPaymentAmount(amount);
                Transaction.setTransactions(strategy);
                ((BankTransfer)strategy).setBankapi(bankAPI);
                users=Transaction.transfer(users);
                bankAPI=((BankTransfer) strategy).getBankapi();


                break;
            }
            case 6:{
                for (int i = 0; i < users.size(); i++) {
                    if(currentUser.getUsername().equals(users.get(i).getUsername())){
                        users.get(i).printDetails();
                        break;
                    }
                }
                break;
            }
            case 7:{
                String billType;
                double amount=0;
                System.out.println("Please enter the type of bill to be paid");
                billType=scanner.nextLine();
                if(billType.equals("water")){
                    bill=new waterBill();
                    ((waterBill)bill).setBillAmount();
                    amount=((waterBill)bill).getBillAmount();
                }
                else if (billType.equals("electricity")) {
                    bill=new electricityBill();
                    ((electricityBill)bill).setBillAmount();
                    amount=((electricityBill)bill).getBillAmount();
                } else if (billType.equals("gas")) {
                    bill=new gasBill();
                    ((gasBill)bill).setBillAmount();
                    amount=((gasBill)bill).getBillAmount();
                }
                for (int i = 0; i < users.size(); i++) {
                    if(users.get(i).getUsername().equals(currentUser.getUsername())){
                        if(users.get(i).getBalance()>=amount){
                        users.get(i).setBalance(amount, '-');
                        System.out.println("Bill paid successfully");
                        break;
                        }
                        else {
                            System.out.println("Insufficient Balance");
                            break;
                        }
                    }
                }
                break;
            }
            case 0:{
                exit(0);
            }
        }
    }
    }
}