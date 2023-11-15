package SignUp;
import java.util.Random;


public class OTP {
    public  String generateOTP() {
        int length = 6;
        String numbers = "0123456789";
        Random random = new Random();
        String otp = "";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            otp += numbers.charAt(index);
        }

        return otp;
    }

}
