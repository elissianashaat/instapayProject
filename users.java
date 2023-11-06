public abstract class users {
        String userName;
        int dateOfBirth;
        int phoneNumber;
        String password;

        public users(String userName, int dateOfBirth, int phoneNumber, String password){
                this.userName = userName;
                this.dateOfBirth = dateOfBirth;
                this.phoneNumber = phoneNumber;
                this.password = password;
        }
        public abstract void signUp(userName, dateOfBirth, phoneNumber, password);
}
