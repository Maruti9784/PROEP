package dcri.qa.proep.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Base64;

public class TOTPGenerator {
	
	private static final String HMAC_ALGORITHM = "HmacSHA1";
    private static final int DIGITS = 6;
    private static final int TIME_STEP_SECONDS = 30;

public static void main(String[] args) {
	
	 String secret = "KK4F2iS5DpnzDjADFUfgdZ9PTOTdqxuSm3HRmBIvskf5Ln2uCHyh8kDXcwYf5ZqodXGuPEUKMVrJuV4fUMCbk6uZiCtXkYEb4xktqgS"; // Replace with your secret key
        long currentTime = Instant.now().getEpochSecond();
        String totp = generateTOTP(secret, currentTime);
        System.out.println("Current TOTP: " + totp);
    }
 
    public static String generateTOTP(String secret, long currentTime) {
        try {
            //byte[] keyBytes = Base64.getDecoder().decode(secret);
            byte[] keyBytes = "KK4F2iS5DpnzDjADFUfgdZ9PdqxuSm3HRmBIvskf5Ln2uCHyh8kDXcwYf5ZqodXGuPEUKMVrJuV4fUMCbk6uZiCtXkYEb4xktqgS".getBytes();
            byte[] counter = ByteBuffer.allocate(8).putLong(currentTime / TIME_STEP_SECONDS).array();
 
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, HMAC_ALGORITHM);
            Mac mac = Mac.getInstance(HMAC_ALGORITHM);
            mac.init(keySpec);
 
            byte[] hash = mac.doFinal(counter);
 
            // Dynamically truncate the hash
            int offset = hash[hash.length - 1] & 0xF;
            int binary = ((hash[offset] & 0x7F) << 24)
                    | ((hash[offset + 1] & 0xFF) << 16)
                    | ((hash[offset + 2] & 0xFF) << 8)
                    | (hash[offset + 3] & 0xFF);
 
            int otp = binary % (int) Math.pow(10, DIGITS);
 
            // Zero pad the OTP to make it 6 digits
            return String.format("%0" + DIGITS + "d", otp);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
	
	
}


}
