import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Delete this as well
public class Hash {
    // This is the method header
    public static String hashPass(String password)
    {

        MessageDigest md = null;

        try {

            md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(password.getBytes());

            // Convert byte array into signum
            BigInteger sig = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hash = sig.toString(16);
            while (hash.length() < 32) { //
                hash = "0" + hash;
            }
            return hash;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } // close catch
    } // close method

    // Above is all the code for the method

} // close class