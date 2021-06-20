package id.ac.budiluhur.absensifrontend;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.io.InputStream;
import java.util.Properties;

public class ArgonHashing  {

    //private static final PasswordEncoder INSTANCE = new ArgonHashing();
    private static String hashCode = "$argon2i$v=19$m=65536,t=10,p=5";
    private static String propPath = System.getProperty("user.dir");

    /**
     * handle encoding process
     *
     * @param inputPassword
     * @return
     */
    public static String hash(String inputPassword){
        String tempNewPassword;
        Argon2 argon2 = Argon2Factory.create();
        InputStream input = null;
        Properties prop = new Properties();

        tempNewPassword = argon2.hash(10, 65536, 5, inputPassword);



        final String newPassword = tempNewPassword.substring(hashCode.length());

        return newPassword;
    }

    /**
     * handle decoding process
     *
     * @param inputString
     * @param hashString
     * @return
     */
    public static boolean verify(String inputString, String hashString){
        Argon2 argon2 = Argon2Factory.create();
        char[] inputChars = inputString.toCharArray();
        InputStream input = null;
        Properties prop = new Properties();
        boolean verified = false;


//        }

        verified = argon2.verify(hashCode+hashString,inputChars);
        argon2.wipeArray(inputChars);

        return verified;
    }


}
